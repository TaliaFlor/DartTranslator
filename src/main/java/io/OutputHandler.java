package io;

import file.Writer;
import dados.DadosContainer;
import util.Util;

public class OutputHandler implements DadosContainer {

    public static void print(String linha) {
        String emptyString = "";

        linha = linha.replace("print", emptyString)
                .replace(";", emptyString)
                .replace("(", emptyString)
                .replace(")", emptyString);

        Object output;
        if (linha.startsWith("'")) {
            output = linha.replace("'", "\"");
        } else if (nomesPorTipo.containsKey(linha)) {
            output = Util.getValor(linha);
        } else {
            output = linha;
        }

        Writer.addLinha("System.out.println(" + output + ");");
    }
}
