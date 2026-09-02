package com.lucruz.hpcreportsportal.integration.ssh;

import com.lucruz.hpcreportsportal.model.RelatorioStatus;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

@Component
public class SSHChecker {

    public RelatorioStatus verificar (String IP, String clustername){

        String destinoSSH = "root@" + IP;
        String inicio = this.montaDataInicio();
        String fim = this.montaDataFim();
        String nomeRelatorio = clustername + "_" + inicio + "_" + fim + ".tar.gz";

        String documentoPDF = "/tmp/root/" + nomeRelatorio;

        IO.println(documentoPDF);

        ProcessBuilder processBuilder = new ProcessBuilder(
                "ssh",
                "-o", "BatchMode=yes",
                "-o", "ConnectTimeout=5",
                "-o", "StrictHostKeyChecking=yes",
                destinoSSH,
                "test",
                "-f",
                documentoPDF

        );

        processBuilder.redirectOutput(ProcessBuilder.Redirect.DISCARD);
        processBuilder.redirectError(ProcessBuilder.Redirect.DISCARD);

        try {
            Process process = processBuilder.start();

            boolean terminou = process.waitFor(
                    10,
                    TimeUnit.SECONDS
            );

            if (!terminou) {
                process.destroyForcibly();
                return RelatorioStatus.ERRO_CONEXAO;
            }

            return switch (process.exitValue()) {
                case 0 -> RelatorioStatus.DISPONIVEL;
                case 1 -> RelatorioStatus.NAO_ENCONTRADO;
                default -> RelatorioStatus.ERRO_CONEXAO;
            };

        } catch (IOException exception) {
            return RelatorioStatus.ERRO_CONEXAO;

        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
            return RelatorioStatus.ERRO_CONEXAO;
        }
    }

    public String montaDataInicio() {
        // pego a data atual e subtraio um mês
        LocalDate dataMesAnterior = LocalDate.now().minusMonths(1).withDayOfMonth(1);

        // defino o formato desejado (DD-MM-YYYY)
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        return dataMesAnterior.format(formatador);
    }

    public String montaDataFim() {
        // pego a data atual e defino o dia 1 do mês corrente
        LocalDate primeiroDia = LocalDate.now().withDayOfMonth(1);

        // defino o formato desejado (DD-MM-YYYY)
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        return primeiroDia.format(formatador);
    }
}
