package funcoes;

import interfaces.DartHandler;

public class DeclaraVariavel implements DartHandler {

	public void definicaoDeVariavel(String line) {
		if (line == null || line.trim().isEmpty()) {
			return;
		}
		if(line.startsWith("string")) {
			line = line.replace("string", "");
			line = line.replace("", "");
		}
		if (line.contains("var")) {
			String[] nome = line.split(" ");
			if (line.contains("double")) {
				double value = 0;
				doubles.put(nome[1], value);
			} else if (line.contains("int")) {
				int value = 0;
				ints.put(nome[1], value);
			} else {
				String value = null;
				strings.put(nome[1], value);
			}
		} else if (line.contains("num")) {
			String[] nome = line.split(" ");
			double value = 0;
			doubles.put(nome[1], value);
		} else if (line.contains("bool")) {
			String[] nome = line.split(" ");
			boolean value = false;
			booleans.put(nome[1], value);
		}
	}
}
