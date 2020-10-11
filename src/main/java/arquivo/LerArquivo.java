package arquivo;

import interfaces.DartHandler;

import java.io.*;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LerArquivo implements Serializable, DartHandler {

    public void lerArquivo() {

        try {
            File fr = new File("C://Users/m_vit/OneDrive/Documentos/Tradutor de Dart/tradutor-dart-java/src/main/resources/Calculadora.dart");
            //System.out.println(fr.exists());
            BufferedReader br = new BufferedReader(new FileReader(fr));

             linhas.addAll(br.lines().collect(Collectors.toList()));

             //linhas.forEach(linha -> System.out.println(linha));

            br.close();
        } catch (IOException ex) {
        }

    }
}