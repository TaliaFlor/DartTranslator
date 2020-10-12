import file.ReaderManager;
import file.WriterManager;
import translator.TranslatorManager;

/**
 * <p>
 * Classe principal do projeto, responsável por rodar os métodos que fazem a leitura, tradução e escrita dos dados
 * </p>
 */
public class DartReader {

    public static void main(String[] args) {
        ReaderManager.lerArquivo();
        TranslatorManager.traduzirLinhas();
        WriterManager.escreverArquivo();
    }

}
