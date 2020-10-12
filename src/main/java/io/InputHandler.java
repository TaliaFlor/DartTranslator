package io;

import file.Writer;
import dados.DadosContainer;
import enums.Type;

public class InputHandler implements DadosContainer {

    private static boolean scannerInicializado = false;


    public static String input(String str, Type tipo) {
        if (!str.contains("stdin.readLineSync()")) {
            return "";
        }

        Writer.addImport("java.util.Scanner");

        if (!scannerInicializado) {
            Writer.addLinha("Scanner in = new Scanner(System.in);");
            scannerInicializado = true;
        }

        return getInput(tipo);
    }

    private static String getInput(Type tipo) {
        switch (tipo) {
            case INT:
                return "in.nextInt();";
            case NUM:
            case DOUBLE:
                return "in.nextDouble();";
            case BOOLEAN:
                return "in.nextBoolean();";
            default:
                return "in.nextLine();";
        }
    }

}
