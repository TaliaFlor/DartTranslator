package variavel;

import dados.DadosContainer;
import enums.Type;
import file.Writer;
import io.InputHandler;
import util.Util;

import static enums.Type.*;

public class VariableHandler implements DadosContainer {

    private static final String EMPTY_STRING = "";
    private static final String WHITE_SPACE = " ";
    private static final String ASPAS_SIMPLES = "'";
    private static final String PONTO_E_VIRGULA = ";";
    private static final String IGUAL = "=";
    private static final String ASPAS_DUPLAS = "\"";


    public static void definirVariavel(String line) {
        if (line.startsWith(STRING.get())) {
            line = limpaString(line, STRING);
            String[] partes = line.split(IGUAL);
            String nome = partes[0];
            String valor;
            
            if (partes[1].contains("stdin.readLineSync()")) {
                Writer.addLinha("String " + nome + " = " + InputHandler.input(partes[1], STRING));
            } else {
                valor = (String) Util.getValor(nome);
                nomesPorTipo.put(nome, STRING);
                strings.put(nome, valor);
                Writer.addLinha("String " + nome + " = " + valor);
            }
        } else if (line.startsWith(INT.get())) {
            line = limpaString(line, Type.INT);
            String[] partes = line.split(IGUAL);
            String nome = partes[0];
            Integer valor;

            if (line.contains("stdin.readLineSync()")) {
                Writer.addLinha("int " + nome + " = " + InputHandler.input(partes[1], Type.INT));
                return;
            } else if (nomesPorTipo.containsKey(nome)) {
                valor = (Integer) Util.getValor(nome);
            } else {
                valor = Integer.valueOf(partes[1]);
            }
            
            nomesPorTipo.put(nome, Type.INT);
            ints.put(nome, valor);
            Writer.addLinha("int " + nome + " = " + valor);
        } else if (line.startsWith(DOUBLE.get()) || line.startsWith(NUM.get())) {
            line = limpaString(line, DOUBLE);
            line = limpaString(line, Type.NUM);
            String[] partes = line.split(IGUAL);
            String nome = partes[0];
            Double valor;

            if (line.contains("stdin.readLineSync()")) {
                Writer.addLinha("double " + nome + " = " + InputHandler.input(partes[1], DOUBLE));
                return;
            } else if (nomesPorTipo.containsKey(nome)) {
                valor = (Double) Util.getValor(nome);
            } else {
                valor = Double.valueOf(partes[1]);
            }
            
            nomesPorTipo.put(nome, DOUBLE);
            doubles.put(nome, valor);
            Writer.addLinha("double " + nome + " = " + valor);
        } else if (line.startsWith(BOOLEAN.get())) {
            line = limpaString(line, Type.BOOLEAN);
            String[] partes = line.split(IGUAL);
            String nome = partes[0];
            Boolean valor;

            if (line.contains("stdin.readLineSync()")) {
                Writer.addLinha("boolean " + nome + " = " + InputHandler.input(partes[1], Type.BOOLEAN));
                return;
            } else if (nomesPorTipo.containsKey(nome)) {
                valor = (Boolean) Util.getValor(nome);
            } else {
                valor = Boolean.valueOf(partes[1]);
            }
            
            nomesPorTipo.put(nome, Type.BOOLEAN);
            booleans.put(nome, valor);
            Writer.addLinha("boolean " + nome + " = " + valor);
        } else if (line.contains(VAR.get())) {
            line = limpaString(line, Type.VAR);
            String[] partes = line.split(IGUAL);
            String nome = partes[0];
            Object valor;

            if (partes.length == 1) {
				/*nomesPorTipo.put(nome,Type.VAR);
				escrever.addLinha("Object "+nome+ ";");
				 */
                nomesPorTipo.put(nome, DOUBLE);
                Writer.addLinha("double " + nome + PONTO_E_VIRGULA);
                return;
            }

            if (partes[1].contains(DOUBLE.get())) {
                if (line.contains("stdin.readLineSync()")) {
                    Writer.addLinha("double " + nome + " = " + InputHandler.input(partes[1], DOUBLE));
                }
            } else if (partes[1].contains(INT.get())) {
                if (line.contains("stdin.readLineSync()")) {
                    Writer.addLinha("int " + nome + " = " + InputHandler.input(partes[1], Type.INT));
                }
            } else if (partes[1].contains(STRING.get())) {
                if (line.contains("stdin.readLineSync()")) {
                    Writer.addLinha("String " + nome + " = " + InputHandler.input(partes[1], STRING));
                }
            } else if (partes[1].contains(BOOLEAN.get())) {
                if (line.contains("stdin.readLineSync()")) {
                    Writer.addLinha("boolean " + nome + " = " + InputHandler.input(partes[1], Type.BOOLEAN));
                }
            } else {
                if (partes[1].startsWith(ASPAS_SIMPLES)) {
                    valor = partes[1].replace(ASPAS_SIMPLES, ASPAS_DUPLAS);
                    nomesPorTipo.put(nome, STRING);
                    strings.put(nome, (String) valor);
                    Writer.addLinha("String " + nome + " = " + valor);
                } else if (partes[1].equals("true") || partes[1].equals("false")) {
                    valor = partes[1];
                    nomesPorTipo.put(nome, Type.BOOLEAN);
                    booleans.put(nome, (Boolean) valor);
                    Writer.addLinha("boolean " + nome + " = " + valor);
                } else {
                    valor = partes[1];
                    nomesPorTipo.put(nome, DOUBLE);
                    doubles.put(nome, (Double) valor);
                    Writer.addLinha("double " + nome + " = " + valor);
                }
            }
        } else {
			/*line = line.replace(";", EMPTY_STRING).replace(" ",EMPTY_STRING);
			String[] partes = line.split("=");
			String nome = partes[0];
			Object valor = EMPTY_STRING;
			Util util = new Util();

			if(nomesPorTipo.containsKey(nome)){
				Type tipo = nomesPorTipo.get(nome);
				valor = util.getVariavel(nome);


			}*/
        }
    }


    // ===== MÉTODOS AUXILIARES =====

    private static String limpaString(String line, Type tipo) {
        return line.replace(tipo.get(), EMPTY_STRING)
                .replace(PONTO_E_VIRGULA, EMPTY_STRING)
                .replace(WHITE_SPACE, EMPTY_STRING)
                .replace(ASPAS_SIMPLES, ASPAS_DUPLAS);
    }

}
