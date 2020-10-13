package io;

import file.WriterManager;

/**
 * <p>
 * Classe responsávelpor lidar com a tradução da saída de dados (Comandos de saída)
 * </p>
 */
public class OutputHandler {
    private static final String EMPTY_STRING = "";
    private static final String ASPAS_SIMPLES = "'";
    private static final String ASPAS_DUPLAS = "\"";


    /**
     * <p>
     * Traduz a saída de dados de volta para o usuário
     * </p>
     *
     * @param linha linha a ser traduzida
     */
    public static void print(String linha) {
        linha = limparLinha(linha);
        WriterManager.addLinha("System.out.println(" + getOutput(linha) + ");");
    }


    // ======= MÉTODOS AUXILIARES =======

    /**
     * <p>
     * Limpa a linha de caracteres e informações desnecessárias
     * </p>
     *
     * @param linha linha a ser limpa
     * @return linha limpa
     */
    private static String limparLinha(String linha) {
        return linha.replace("print", EMPTY_STRING)
                .replace(";", EMPTY_STRING)
                .replace("(", EMPTY_STRING)
                .replace(")", EMPTY_STRING);
    }

    /**
     * <p>
     * Extrai a mensagem a ser exibida
     * </p>
     *
     * @param linha linha que contém a mensagem
     * @return a mensagem a ser exibida
     */
    private static Object getOutput(String linha) {
        Object output;
        if (linha.startsWith(ASPAS_SIMPLES)) {
            output = linha.replace(ASPAS_SIMPLES, ASPAS_DUPLAS);
        } else {
            output = linha;
        }
        return output;
    }

}
