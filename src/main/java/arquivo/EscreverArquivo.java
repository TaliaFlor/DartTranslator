package arquivo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import interfaces.DartHandler;

public class EscreverArquivo  implements DartHandler {
	private static List<String> imports = new ArrayList<>();
	private static List<String> linhas = new ArrayList<>();
	
	public void escreverArquivo() {
		File arquivoJava = new File("C:\\Users\\operador\\git\\DartReader\\src\\main\\resources\\Calculadora.java");
		String classe = "public class Calculadora{";
		String _main = "public static void main(String[] args){";
		String fechaColchetes = "}";
		try {
			BufferedWriter br = new BufferedWriter(new FileWriter(arquivoJava, true));
			for(String imp: imports) {
				br.write(imp);
				br.newLine();
			}
			br.write(classe);
			br.newLine();
			br.write(_main);
			br.newLine();
			for(String linha: linhas) {
				br.write(linha);
				br.newLine();
			}
			br.write(fechaColchetes);
			br.newLine();
			br.write(fechaColchetes);
			br.newLine();
			
			
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addImport(String imp) {
		imports.add("import " + imp + ";");
	}
	public void addLinha(String linha) {
		linhas.add(linha);
	}
}








