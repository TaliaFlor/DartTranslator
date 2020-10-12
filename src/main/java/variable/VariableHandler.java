package variable;

import data.DataContainer;
import enums.Type;
import file.WriterManager;
import io.InputHandler;
import util.Util;

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
        if (line.startsWith(Type.STRING.dart())) {
            line = limpaString(line, Type.STRING);
            String[] partes = line.split(IGUAL);
            String nome = partes[0];
            String valor;

            if (partes[1].contains(USER_INPUT)) {
                valor = InputHandler.input(Type.STRING);
            } else if (nomesPorTipo.containsKey(nome)) {
                valor = (String) Util.getValor(nome);
            } else {
                valor = partes[1];
            }

            nomesPorTipo.put(nome, Type.STRING);
            strings.put(nome, valor);
            WriterManager.addLinha(Type.STRING.java() + " " + nome + " = " + valor);
        } else if (line.startsWith(Type.INT.dart())) {
            line = limpaString(line, Type.INT);
            String[] partes = line.split(IGUAL);
            String nome = partes[0];
            Integer valor;

            if (line.contains(USER_INPUT)) {
                WriterManager.addLinha(Type.INT.java() + " " + nome + " = " + InputHandler.input(Type.INT));
                return;
            } else if (nomesPorTipo.containsKey(nome)) {
                valor = (Integer) Util.getValor(nome);
            } else {
                valor = Integer.valueOf(partes[1]);
            }

            nomesPorTipo.put(nome, Type.INT);
            ints.put(nome, valor);
            WriterManager.addLinha(Type.INT.java() + " " + nome + " = " + valor);
        } else if (line.startsWith(Type.DOUBLE.dart()) || line.startsWith(Type.NUM.dart())) {
            line = limpaString(line, Type.DOUBLE);
            line = limpaString(line, Type.NUM);
            String[] partes = line.split(IGUAL);
            String nome = partes[0];
            Double valor;

            if (line.contains(USER_INPUT)) {
                WriterManager.addLinha(Type.DOUBLE.java() + " " + nome + " = " + InputHandler.input(Type.DOUBLE));
                return;
            } else if (nomesPorTipo.containsKey(nome)) {
                valor = (Double) Util.getValor(nome);
            } else {
                valor = Double.valueOf(partes[1]);
            }

            nomesPorTipo.put(nome, Type.DOUBLE);
            doubles.put(nome, valor);
            WriterManager.addLinha(Type.DOUBLE.java() + " " + nome + " = " + valor);
        } else if (line.startsWith(Type.BOOLEAN.dart())) {
            line = limpaString(line, Type.BOOLEAN);
            String[] partes = line.split(IGUAL);
            String nome = partes[0];
            Boolean valor;

            if (line.contains(USER_INPUT)) {
                WriterManager.addLinha(Type.BOOLEAN.java() + " " + nome + " = " + InputHandler.input(Type.BOOLEAN));
                return;
            } else if (nomesPorTipo.containsKey(nome)) {
                valor = (Boolean) Util.getValor(nome);
            } else {
                valor = Boolean.valueOf(partes[1]);
            }

            nomesPorTipo.put(nome, Type.BOOLEAN);
            booleans.put(nome, valor);
            WriterManager.addLinha(Type.BOOLEAN.java() + " " + nome + " = " + valor);
        } else if (line.contains(Type.VAR.dart())) {
            line = limpaString(line, Type.VAR);
            String[] partes = line.split(IGUAL);
            String nome = partes[0];

            if (partes.length == 1) {
				/*nomesPorTipo.put(nome,Type.Type.VAR);
				escrever.addLinha("Object "+nome+ ";");
				 */
                nomesPorTipo.put(nome, Type.DOUBLE);
                WriterManager.addLinha(Type.DOUBLE.java() + " " + nome + PONTO_E_VIRGULA);
                return;
            }

            if (line.contains(USER_INPUT)) {    // Se a linha está recebendo input do usuário
                Type tipo;
                if (partes[1].contains(Type.INT.dart())) {
                    tipo = Type.INT;
                } else if (partes[1].contains(Type.DOUBLE.dart()) || partes[1].contains(Type.NUM.dart())) {
                    tipo = Type.DOUBLE;
                } else if (partes[1].contains(Type.BOOLEAN.dart())) {
                    tipo = Type.BOOLEAN;
                } else {
                    tipo = Type.STRING;
                }
                userInput(nome, tipo);
            } else {    // Se a linha recebe o valor diretamente
                Type tipo;
                if (isString(partes[1])) {
                    tipo = Type.STRING;
                } else if (isBoolean(partes[1])) {
                    tipo = Type.BOOLEAN;
                } else {
                    tipo = Type.DOUBLE;
                }
                setVarInfo(nome, partes[1], tipo);
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

    /**
     * <p>
     * Indica se dado valor é uma string
     * </p>
     *
     * @param value o valor a ser avaliado
     * @return se é uma string ou não
     */
    private static boolean isString(String value) {
        return value.startsWith(ASPAS_SIMPLES);
    }

    /**
     * <p>
     * Indica se dado valor é um boolean
     * </p>
     *
     * @param value o valor a ser avaliado
     * @return se é um boolean ou não
     */
    private static boolean isBoolean(String value) {
        return value.equals("true") || value.equals("false");
    }

    /**
     * <p>
     * Adiciona linha que recebe o input do usuário
     * </p>
     *
     * @param nome o nome da variável
     * @param tipo o tipo da variável
     */
    private static void userInput(String nome, Type tipo) {
        addLinha(nome, InputHandler.input(tipo), tipo);
    }

    /**
     * <p>
     * Adiciona uma linha que recebe um valor atribuido
     * </p>
     *
     * @param nome  o nome da variável
     * @param valor o valor atribuido a variável
     * @param tipo  o tipo da variável
     */
    private static void addLinha(String nome, Object valor, Type tipo) {
        WriterManager.addLinha(tipo.java() + " " + nome + " = " + valor);
    }

    /**
     * <p>
     * Remove os caracteres desnecessários da String
     * </p>
     *
     * @param line a linha a ser limpa
     * @param tipo o tipo da variável
     * @return a linha limpa de informações desnecessárias
     */
    private static String limpaString(String line, Type tipo) {
        return line.replace(tipo.dart(), EMPTY_STRING)
                .replace(PONTO_E_VIRGULA, EMPTY_STRING)
                .replace(WHITE_SPACE, EMPTY_STRING)
                .replace(ASPAS_SIMPLES, ASPAS_DUPLAS);
    }

    /**
     * <p>
     * Seta o nome, o tipo e o valor da variável nos lugares necessários,
     * além de adicionar a linha do comando para se escrita
     * </p>
     *
     * @param nome  o nome da variável
     * @param valor o valor da variável
     * @param tipo  o tipo da variável
     */
    private static void setVarInfo(String nome, Object valor, Type tipo) {
        nomesPorTipo.put(nome, tipo);
        setValorNoMap(nome, valor, tipo);
        addLinha(nome, valor, tipo);
    }

    /**
     * <p>
     * Seta o nome o o valor da variável no seu map específico de acordo com o seu tipo
     * </p>
     *
     * @param nome  o nome da variável
     * @param valor o valor da variável
     * @param tipo  o tipo da variável
     */
    private static void setValorNoMap(String nome, Object valor, Type tipo) {
        switch (tipo) {
            case DOUBLE:
                doubles.put(nome, (Double) valor);
                break;
            case BOOLEAN:
                booleans.put(nome, (Boolean) valor);
                break;
            case STRING:
                strings.put(nome, (String) valor);
                break;
        }
    }

}
