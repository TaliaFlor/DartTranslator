import arquivo.EscreverArquivo;
import arquivo.LerArquivo;

import java.io.FileNotFoundException;

public class DartReader {


    public static void main(String[] args) throws FileNotFoundException {


//        LerArquivo file = new LerArquivo();
//
//        file.lerArquivo();
    	EscreverArquivo novo = new EscreverArquivo();
    	novo.escreverArquivo("teste de escrita");
    	novo.escreverArquivo("teste de escrita2");
    	novo.escreverArquivo("teste de escrita3");

    }
}
