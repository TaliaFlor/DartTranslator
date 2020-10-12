package variable;

import data.DataContainer;
import enums.Type;
import file.WriterManager;
import io.InputHandler;
import util.Util;

import static enums.Type.*;

/**
 * <p>
 * Classe reponsável por traduzir a definição das variáveis
 * </p>
 */
public class VariableHandler implements DataContainer {

    private static final String USER_INPUT = "stdin.readLineSync()";

    private static final String EMPTY_STRING = "";
    private static final String WHITE_SPACE = " ";
    private static final String ASPAS_SIMPLES = "'";
    private static final String PONTO_E_VIRGULA = ";";
    private static final String IGUAL = "=";
    private static final String ASPAS_DUPLAS = "\"";


    /**
     * <p>
     * Defini uma variável
     * </p>
     *
     * @param line linha que contém a variável
     */
    public static void definirVariavel(String line) {
        if (line.startsWith(STRING.dart())) {
            line = limpaString(line, STRING);
            String[] partes = line.split(IGUAL);
            String nome = partes[0];
            String valor;

            if (partes[1].contains(USER_INPUT)) {
                WriterManager.addLinha(STRING.java() + " " + nome + " = " + InputHandler.input(STRING));
            } else {
                valor = (String) Util.getValor(nome);
                nomesPorTipo.put(nome, STRING);
                strings.put(nome, valor);
                WriterManager.addLinha(STRING.java() + " " + nome + " = " + valor);
            }
        } else if (line.startsWith(INT.dart())) {
            line = limpaString(line, INT);
            String[] partes = line.split(IGUAL);
            String nome = partes[0];
            Integer valor;

            if (line.contains(USER_INPUT)) {
                WriterManager.addLinha(INT.java() + " " + nome + " = " + InputHandler.input(INT));
                return;
            } else if (nomesPorTipo.containsKey(nome)) {
                valor = (Integer) Util.getValor(nome);
            } else {
                valor = Integer.valueOf(partes[1]);
            }

            nomesPorTipo.put(nome, INT);
            ints.put(nome, valor);
            WriterManager.addLinha(INT.java() + " " + nome + " = " + valor);
        } else if (line.startsWith(DOUBLE.dart()) || line.startsWith(NUM.dart())) {
            line = limpaString(line, DOUBLE);
            line = limpaString(line, Type.NUM);
            String[] partes = line.split(IGUAL);
            String nome = partes[0];
            Double valor;

            if (line.contains(USER_INPUT)) {
                WriterManager.addLinha(DOUBLE.java() + " " + nome + " = " + InputHandler.input(DOUBLE));
                return;
            } else if (nomesPorTipo.containsKey(nome)) {
                valor = (Double) Util.getValor(nome);
            } else {
                valor = Double.valueOf(partes[1]);
            }

            nomesPorTipo.put(nome, DOUBLE);
            doubles.put(nome, valor);
            WriterManager.addLinha(DOUBLE.java() + " " + nome + " = " + valor);
        } else if (line.startsWith(BOOLEAN.dart())) {
            line = limpaString(line, BOOLEAN);
            String[] partes = line.split(IGUAL);
            String nome = partes[0];
            Boolean valor;

            if (line.contains(USER_INPUT)) {
                WriterManager.addLinha(BOOLEAN.java() + " " + nome + " = " + InputHandler.input(BOOLEAN));
                return;
            } else if (nomesPorTipo.containsKey(nome)) {
                valor = (Boolean) Util.getValor(nome);
            } else {
                valor = Boolean.valueOf(partes[1]);
            }

            nomesPorTipo.put(nome, BOOLEAN);
            booleans.put(nome, valor);
            WriterManager.addLinha(BOOLEAN.java() + " " + nome + " = " + valor);
        } else if (line.contains(VAR.dart())) {
            line = limpaString(line, Type.VAR);
            String[] partes = line.split(IGUAL);
            String nome = partes[0];
            Object valor;

            if (partes.length == 1) {
				/*nomesPorTipo.put(nome,Type.VAR);
				escrever.addLinha("Object "+nome+ ";");
				 */
                nomesPorTipo.put(nome, DOUBLE);
                WriterManager.addLinha(DOUBLE.java() + " " + nome + PONTO_E_VIRGULA);
                return;
            }

            if (partes[1].contains(DOUBLE.dart())) {
                if (line.contains(USER_INPUT)) {
                    WriterManager.addLinha(DOUBLE.java() + " " + nome + " = " + InputHandler.input(DOUBLE));
                }
            } else if (partes[1].contains(INT.dart())) {
                if (line.contains(USER_INPUT)) {
                    WriterManager.addLinha(INT.java() + " " + nome + " = " + InputHandler.input(INT));
                }
            } else if (partes[1].contains(STRING.dart())) {
                if (line.contains(USER_INPUT)) {
                    WriterManager.addLinha(STRING.java() + " " + nome + " = " + InputHandler.input(STRING));
                }
            } else if (partes[1].contains(BOOLEAN.dart())) {
                if (line.contains(USER_INPUT)) {
                    WriterManager.addLinha(BOOLEAN.java() + " " + nome + " = " + InputHandler.input(BOOLEAN));
                }
            } else {
                if (partes[1].startsWith(ASPAS_SIMPLES)) {
                    valor = partes[1].replace(ASPAS_SIMPLES, ASPAS_DUPLAS);
                    nomesPorTipo.put(nome, STRING);
                    strings.put(nome, (String) valor);
                    WriterManager.addLinha(STRING.java() + " " + nome + " = " + valor);
                } else if (partes[1].equals("true") || partes[1].equals("false")) {
                    valor = partes[1];
                    nomesPorTipo.put(nome, BOOLEAN);
                    booleans.put(nome, (Boolean) valor);
                    WriterManager.addLinha(BOOLEAN.java() + " " + nome + " = " + valor);
                } else {
                    valor = partes[1];
                    nomesPorTipo.put(nome, DOUBLE);
                    doubles.put(nome, (Double) valor);
                    WriterManager.addLinha(DOUBLE.java() + " " + nome + " = " + valor);
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
        return line.replace(tipo.dart(), EMPTY_STRING)
                .replace(PONTO_E_VIRGULA, EMPTY_STRING)
                .replace(WHITE_SPACE, EMPTY_STRING)
                .replace(ASPAS_SIMPLES, ASPAS_DUPLAS);
    }

}
