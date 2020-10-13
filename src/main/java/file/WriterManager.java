package file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Classe responsável pela escrita das linhas traduzidas
 * </p>
 */
public class WriterManager {
    private static final String nomeArquivo = "Calculadora.java";
    private static final String path = "src/main/resources/" + nomeArquivo;

    private static final String CLASSE = "public class Calculadora {";
    private static final String MAIN = "public static void main(String[] args) {";
    private static final String FECHA_CHAVES = "}";

    private static final List<String> imports = new ArrayList<>();
    private static final List<String> linhas = new ArrayList<>();


    /**
     * <p>
     * Pula uma linha
     * </p>
     */
    public static void pularLinha() {
        addLinha("\n");
    }

    /**
     * <p>
     * Adiciona uma linha Java para ser escrita num arquivo .java
     * </p>
     *
     * @param linha linha que deve ser escrita
     */
    public static void addLinha(String linha) {
        linhas.add(linha);
    }

    /**
     * <p>
     * Adiciona um import Java para ser escrito num arquivo .java
     * </p>
     *
     * @param imp o import a ser adicionado
     */
    public static void addImport(String imp) {
        String input = "import " + imp + ";";
        if (!imports.contains(input)) {
            imports.add(input);
        }
    }

    /**
     * <p>
     * Escreve os dados traduzidos num arquivo .java
     * </p>
     */
    public static void escreverArquivo() {
        File file = new File(path);
        try {
            limpar(file);
            escrever(file);

            System.out.println("Arquivo escrito no path: " + path);
        } catch (FileNotFoundException e) {
            System.out.println("O seguinte path é inválido para a escrita do arquivo: " + path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // ==== MÉTODOS AUXILIARES =====

    /**
     * <p>
     * Limpa o arquivo
     * </p>
     *
     * @param file o arquivo a ser limpo
     * @throws IOException caso um erro de I/O ocorra
     */
    private static void limpar(File file) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write("");
        writer.close();
    }

    /**
     * <p>
     * Escreve uma linha no arquivo
     * </p>
     *
     * @param writer o BufferedWriter que escreverá a linha
     * @param linha  a linha que deve ser escrita
     * @throws IOException caso um erro de I/O ocorra
     */
    private static void linha(BufferedWriter writer, String linha) throws IOException {
        if (!linha.equals("\n")) {
            writer.write(linha);
        }
        writer.newLine();
    }

    /**
     * <p>
     * Escreve os dados de uma lista
     * </p>
     *
     * @param writer o BufferedWriter que escreverá os dados
     * @param list   a lista com as linhas que devem ser escritas
     * @throws IOException caso um erro de I/O ocorra
     */
    private static void lista(BufferedWriter writer, List<String> list) throws IOException {
        for (String item : list) {
            linha(writer, item);
        }
    }

    /**
     * <p>
     * Escreve os dados no arquivo na ordem correta
     * </p>
     *
     * @param file o arquivo onde os dados serão escritos
     * @throws IOException caso um erro de I/O ocorra
     */
    private static void escrever(File file) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));

        lista(writer, imports);
        linha(writer, CLASSE);
        linha(writer, MAIN);
        lista(writer, linhas);
        linha(writer, FECHA_CHAVES);

        writer.close();
    }

}








