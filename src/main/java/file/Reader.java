package file;

import dados.DadosContainer;

import java.io.*;
import java.util.stream.Collectors;

public class Reader implements DadosContainer {

    // TODO relativizar path

    private static final String nomeArquivo = "Calculadora.dart";
    private static final String path = "C://Users/m_vit/OneDrive/Documentos/Tradutor de Dart/tradutor-dart-java/src/main/resources/" + nomeArquivo;

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