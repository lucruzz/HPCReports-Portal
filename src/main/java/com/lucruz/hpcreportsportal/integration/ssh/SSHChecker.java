package com.lucruz.hpcreportsportal.integration.ssh;

import com.lucruz.hpcreportsportal.model.RelatorioStatus;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Component
public class SSHChecker {

    public RelatorioStatus verificar (String IP){

        String destinoSSH = "root@" + IP;

        ProcessBuilder processBuilder = new ProcessBuilder(
                "ssh",
                "-o", "BatchMode=yes",
                "-o", "ConnectTimeout=5",
                "-o", "StrictHostKeyChecking=yes",
                destinoSSH,
                "test",
                "-d",
                "/tmp/root"

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
}
