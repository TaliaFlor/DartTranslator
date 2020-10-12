package io;

import arquivo.EscreverArquivo;
import interfaces.DartHandler;
import util.Util;

public class OutputHandler implements DartHandler {
    public void escreverOutput(String linha) {
        if (linha == null || linha.trim().isEmpty()) {
            return;
        }
        if (!linha.startsWith("print(")) {
            return;
        }

        linha = linha.replace("print", "").replace(";", "").replace("(", "").replace(")", "");
        Object output = null;

        if (linha.startsWith("'")) {
            output = linha.replace("'", "\"");
        } else if (nomesPorTipo.containsKey(linha)) {
            Util util = new Util();
            output = util.getVariavel(linha);
        } else {
            output = linha;
        }
        EscreverArquivo escrever = new EscreverArquivo();
        escrever.addLinha("System.out.println(" + output + ");");

    }
}
