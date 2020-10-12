package funcoes;

import arquivo.EscreverArquivo;
import enums.Type;
import interfaces.DartHandler;
import io.InputHandler;
import util.Util;

public class DeclaraVariavel implements DartHandler {
	
	private final EscreverArquivo escrever = new EscreverArquivo();
	
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
			else if(line.contains("stdin.readLineSync()")) {
				InputHandler input = new InputHandler();
				
			    escrever.addLinha("String "+ nome + " = " + input.lerInput(partes[1], Type.STRING));
			    return;
				
				
			}
			else {
				Util util = new Util();
				valor = (String) util.getVariavel(nome);
			}
			nomesPorTipo.put(nome, Type.STRING);
			strings.put(nome, valor);
			escrever.addLinha("String " + nome + " = " + valor);
		}else if(line.startsWith("int")) {
			line = line.replace("int", "").replace(";", "").replace(" ","");
			String [] partes = line.split("=");
			String nome = partes[0];
			Integer valor = null;
			
			if(line.contains("stdin.readLineSync()")) {
				InputHandler input = new InputHandler();
				EscreverArquivo escrever = new EscreverArquivo();
			    escrever.addLinha("int "+ nome + " = " + input.lerInput(partes[1], Type.INT));
			    return;
				
			}
			else if(nomesPorTipo.containsKey(nome)){
				Util util = new Util();
				valor = (Integer) util.getVariavel(nome);
			}
			else {
				valor = Integer.valueOf(partes[1]);
			}
			nomesPorTipo.put(nome, Type.INT);
			ints.put(nome, valor);
			escrever.addLinha("int " + nome + " = " + valor);
		}else if(line.startsWith("double") || line.startsWith("num")) {
			line = line.replace("double", "").replace("num", "").replace(";", "").replace(" ","");
			String [] partes = line.split("=");
			String nome = partes[0];
			Double valor = null;
			
			if(line.contains("stdin.readLineSync()")) {
				InputHandler input = new InputHandler();
				EscreverArquivo escrever = new EscreverArquivo();
			    escrever.addLinha("double "+nome + " = " + input.lerInput(partes[1], Type.DOUBLE));
			    return;
				
			}
			else if(nomesPorTipo.containsKey(nome)){
				Util util = new Util();
				valor = (Double) util.getVariavel(nome);
			}
			else {
				valor = Double.valueOf(partes[1]);
			}
			nomesPorTipo.put(nome, Type.DOUBLE);
			doubles.put(nome, valor);
			
			escrever.addLinha("double " + nome + " = " + valor);
		}else if(line.startsWith("boolean")) {
			line = line.replace("boolean", "").replace(";", "").replace(" ","");
			String [] partes = line.split("=");
			String nome = partes[0];
			Boolean valor = null;
			
			if(line.contains("stdin.readLineSync()")) {
				InputHandler input = new InputHandler();
				EscreverArquivo escrever = new EscreverArquivo();
			    escrever.addLinha("boolean "+nome + " = " + input.lerInput(partes[1], Type.BOOLEAN));
			    return;
				
			}
			else if(nomesPorTipo.containsKey(nome)){
				Util util = new Util();
				valor = (Boolean) util.getVariavel(nome);
			}
			else {
				valor = Boolean.valueOf(partes[1]);
			}
			nomesPorTipo.put(nome, Type.BOOLEAN);
			booleans.put(nome, valor);
			
			escrever.addLinha("boolean " + nome + " = " + valor);
			
		}else if (line.contains("var")) {
			line = line.replace("var", "").replace(";", "").replace(" ","");
			String[] partes = line.split("=");
			String nome = partes[0];
			Object valor = "";
//			if(line.contains("stdin.readLineSync()")) {
//				InputHandler input = new InputHandler();
//				EscreverArquivo escrever = new EscreverArquivo();
//			    escrever.addLinha(nome + " = " + input.lerInput(partes[1], Type.VAR));
//			    return;
//				
//			}
			if(partes.length == 1){
				/*nomesPorTipo.put(nome,Type.VAR);
				escrever.addLinha("Object "+nome+ ";");
				 */
				nomesPorTipo.put(nome,Type.DOUBLE);
				escrever.addLinha("double "+ nome + ";");
				return;
			}
			if (partes[1].contains("double")) {
//				double value = 0;
//				doubles.put(partes[1], value);
				if(line.contains("stdin.readLineSync()")) {
					InputHandler input = new InputHandler();
					EscreverArquivo escrever = new EscreverArquivo();
				    escrever.addLinha("double "+nome + " = " + input.lerInput(partes[1], Type.DOUBLE));
				    return;
					
				}
			} else if (partes[1].contains("int")) {
//				int value = 0;
//				ints.put(partes[1], value);
				if(line.contains("stdin.readLineSync()")) {
					InputHandler input = new InputHandler();
					EscreverArquivo escrever = new EscreverArquivo();
				    escrever.addLinha("int "+nome + " = " + input.lerInput(partes[1], Type.INT));
				    return;
					
				}
			
		} else if (partes[1].contains("string")) {
//			int value = 0;
//			ints.put(partes[1], value);
			if(line.contains("stdin.readLineSync()")) {
				InputHandler input = new InputHandler();
				EscreverArquivo escrever = new EscreverArquivo();
			    escrever.addLinha("String "+nome + " = " + input.lerInput(partes[1], Type.STRING));
			    return;
				
			}
		
		} else if (partes[1].contains("boolean")) {
//			int value = 0;
//			ints.put(partes[1], value);
			if(line.contains("stdin.readLineSync()")) {
				InputHandler input = new InputHandler();
				EscreverArquivo escrever = new EscreverArquivo();
			    escrever.addLinha("boolean "+nome + " = " + input.lerInput(partes[1], Type.BOOLEAN));
			    return;
				
			}
		}
			else {
//				String value = null;
//				strings.put(partes[1], value);
				if(partes[1].startsWith("'") && partes[1].endsWith("'")) {
					valor = partes[1].replace("'", "");
					nomesPorTipo.put(nome, Type.STRING);
					strings.put(nome, (String) valor);
					escrever.addLinha("String " + nome + " = " + valor);
				}
				else if(partes[1].equals("true") || partes[1].equals("false")) {
					valor = partes[1];
					nomesPorTipo.put(nome, Type.BOOLEAN);
					booleans.put(nome, (Boolean) valor);
					escrever.addLinha("boolean " + nome + " = " + valor);
				}
				else {
					valor = partes[1];
					nomesPorTipo.put(nome, Type.DOUBLE);
					doubles.put(nome, (Double) valor);
					escrever.addLinha("double " + nome + " = " + valor);
				}
				
			}




		}else{
			/*line = line.replace(";", "").replace(" ","");
			String[] partes = line.split("=");
			String nome = partes[0];
			Object valor = "";
			Util util = new Util();

			if(nomesPorTipo.containsKey(nome)){
				Type tipo = nomesPorTipo.get(nome);
				valor = util.getVariavel(nome);


			}*/
		}
	}
}
