package funcoes;

import interfaces.DartHandler;

public class DeclaraVariavel implements DartHandler {

	public void definicaoDeVariavel(String line) {
		if (line == null || line.trim().isEmpty()) {
			return;
		}
		if(line.startsWith("string")) {
			line = line.replace("string", "").replace(";", "").replace(" ","");
			String [] partes = line.split("=");
			String nome = partes[0];
			String valor = "";
			if(partes[1].startsWith("'") && partes[1].endsWith("'")) {
				valor = partes[1].replace("'", "");
				
			
			}
			// TODO caso seja variável
			//TODO caso seja input
			//TODO colocar no map
		}else if(line.startsWith("int")) {
			line = line.replace("int", "").replace(";", "").replace(" ","");
			String [] partes = line.split("=");
			String nome = partes[0];
			String valor = "";
			// TODO caso seja variável
			//TODO caso seja input
			//TODO colocar no map
		}else if(line.startsWith("double") || line.startsWith("num")) {
			line = line.replace("double", "").replace("num", "").replace(";", "").replace(" ","");
			String [] partes = line.split("=");
			String nome = partes[0];
			String valor = "";
			// TODO caso seja variável
			//TODO caso seja input
			//TODO colocar no map
		}else if(line.startsWith("boolean")) {
			line = line.replace("boolean", "").replace(";", "").replace(" ","");
			String [] partes = line.split("=");
			String nome = partes[0];
			String valor = "";
			// TODO caso seja variável
			//TODO caso seja input
			//TODO colocar no map
		}else if (line.contains("var")) {
			line = line.replace("var", "").replace(";", "").replace(" ","");
			String[] partes = line.split("=");
			String nome = partes[0];
			String valor = "";
			// TODO caso seja variável
			//TODO caso seja input
			//TODO colocar no map
//			if (line.contains("double")) {
//				double value = 0;
//				doubles.put(partes[1], value);
//			} else if (line.contains("int")) {
//				int value = 0;
//				ints.put(partes[1], value);
//			} else {
//				String value = null;
//				strings.put(partes[1], value);
//			}
		}
	}
}
