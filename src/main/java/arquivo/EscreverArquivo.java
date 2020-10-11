package arquivo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import interfaces.DartHandler;

public class EscreverArquivo  implements DartHandler {

	public void escreverArquivo(String line) {
		File arquivoJava = new File("C:\\Users\\operador\\git\\DartReader\\src\\main\\resources\\Calculadora.java");
		
		try {
			BufferedWriter br = new BufferedWriter(new FileWriter(arquivoJava, true));
			br.write(line);
			br.newLine();
			
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
