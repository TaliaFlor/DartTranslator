package arquivo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import interfaces.DartHandler;

public class EscreverArquivo implements DartHandler {
    private static List<String> imports = new ArrayList<>();
    private static List<String> linhas = new ArrayList<>();

    private String nomeArquivo = "Calculadora.java";
    private String path = "C://Users/m_vit/OneDrive/Documentos/Tradutor de Dart/tradutor-dart-java/src/main/resources/" + nomeArquivo;

    public void escreverArquivo() {
        File arquivoJava = new File(path);
        String classe = "public class Calculadora{";
        String _main = "public static void main(String[] args){";
        String fechaColchetes = "}";
        try {
            BufferedWriter limpar = new BufferedWriter(new FileWriter(arquivoJava));
            limpar.write("");
            limpar.close();

            BufferedWriter br = new BufferedWriter(new FileWriter(arquivoJava, true));

            for (String imp : imports) {
                br.write(imp);
                br.newLine();
            }
            br.write(classe);
            br.newLine();
            br.write(_main);
            br.newLine();
            for (String linha : linhas) {
                br.write(linha);
                br.newLine();
            }
            br.write(fechaColchetes);
            br.newLine();



            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado no caminho: " + path);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void addImport(String imp) {
        String input = "import " + imp + ";";
        if (!imports.contains(input)) {
            imports.add(input);
        }

    }

    public void addLinha(String linha) {
        linhas.add(linha);
    }
}








