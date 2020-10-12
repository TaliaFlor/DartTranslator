import dados.DadosContainer;
import file.Reader;
import file.Writer;
import io.OutputHandler;
import variavel.VariableHandler;

public class DartReader implements DadosContainer {

    public static void main(String[] args) {
        Reader.lerArquivo();

        for (String linha : linhas) {
            linha = linha.trim();

            if (linha.isEmpty()) {
                Writer.pularLinha();
            }
            if (linha.startsWith("import") || linha.startsWith("void")) {
                continue;
            }

            if (linha.startsWith("print(")) {
                OutputHandler.print(linha);
            } else if (isVariavel(linha)) {
                VariableHandler.definirVariavel(linha);
            } else {
                Writer.addLinha(linha);
            }
        }

        Writer.escreverArquivo();
    }


    private static boolean isVariavel(String linha) {
        return linha.startsWith("int") || linha.startsWith("double") || linha.startsWith("num") ||
                linha.startsWith("boolean") || linha.startsWith("string") || linha.startsWith("var");
    }

}
