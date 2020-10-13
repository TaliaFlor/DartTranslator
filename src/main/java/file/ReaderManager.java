package file;

import data.DataContainer;

import java.io.*;
import java.util.stream.Collectors;

/**
 * <p>
 * Classe responsável pela leitura do arquivo a ser traduzido
 * </p>
 */
public class ReaderManager implements DataContainer {
    private static final String nomeArquivo = "Calculadora.dart";
    private static final String path = "src/main/resources/" + nomeArquivo;

    /**
     * <p>
     * Lê um arquivo Dart e salva suas linhas na memória
     * </p>
     */
    public static void lerArquivo() {
        try {
            File file = new File(path);
            BufferedReader reader = new BufferedReader(new FileReader(file));

            linhas.addAll(reader.lines().collect(Collectors.toList()));

            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado no caminho: " + path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}