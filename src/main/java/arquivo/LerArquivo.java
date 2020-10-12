package arquivo;

import interfaces.DartHandler;

import java.io.*;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LerArquivo implements DartHandler {

    private String nomeArquivo = "Calculadora.dart";
    private String path = "C://Users/m_vit/OneDrive/Documentos/Tradutor de Dart/tradutor-dart-java/src/main/resources/" + nomeArquivo;

    public void lerArquivo() {

        try {
            File fr = new File(path);
            //System.out.println(fr.exists());
            BufferedReader br = new BufferedReader(new FileReader(fr));

            linhas.addAll(br.lines().collect(Collectors.toList()));

            //linhas.forEach(linha -> System.out.println(linha));

            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado no caminho: " + path);
        } catch (IOException ex) {

        }

    }
}