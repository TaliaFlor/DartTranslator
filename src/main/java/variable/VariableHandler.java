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
        if (Util.isInt(line)) {
            String[] partes = getPartes(line, Type.INT);
            String nome = partes[0];

            if (partes[1].contains(USER_INPUT)) {
                addInput(nome, Type.INT);
                return;
            }

            int valor;
            if (tipos.containsKey(nome)) {
                valor = (Integer) valores.get(nome);
            } else {
                valor = Integer.parseInt(partes[1]);
            }

            setVarInfo(nome, valor, Type.INT);
        } else if (Util.isDouble(line) || Util.isNum(line)) {
            String[] partes = getPartes(line.replace(Type.NUM.dart(), EMPTY_STRING), Type.DOUBLE);
            String nome = partes[0];

            if (partes[1].contains(USER_INPUT)) {
                addInput(nome, Type.DOUBLE);
                return;
            }

            double valor;
            if (tipos.containsKey(nome)) {
                valor = (Double) valores.get(nome);
            } else {
                valor = Double.parseDouble(partes[1]);
            }

            setVarInfo(nome, valor, Type.DOUBLE);
        } else if (Util.isBoolean(line)) {
            String[] partes = getPartes(line, Type.BOOLEAN);
            String nome = partes[0];

            if (partes[1].contains(USER_INPUT)) {
                addInput(nome, Type.BOOLEAN);
                return;
            }

            boolean valor;
            if (tipos.containsKey(nome)) {
                valor = (Boolean) valores.get(nome);
            } else {
                valor = Boolean.parseBoolean(partes[1]);
            }

            setVarInfo(nome, valor, Type.BOOLEAN);
        } else if (Util.isString(line)) {
            String[] partes = getPartes(line, Type.STRING);
            String nome = partes[0];

            if (partes[1].contains(USER_INPUT)) {
                addInput(nome, Type.STRING);
                return;
            }

            String valor;
            if (tipos.containsKey(nome)) {
                valor = (String) valores.get(nome);
            } else {
                valor = partes[1];
            }

            setVarInfo(nome, valor, Type.STRING);
        } else if (Util.isVar(line)) {
            String[] partes = getPartes(line, Type.VAR);
            String nome = partes[0];

            if (partes.length == 1) {
                tipos.put(nome, Type.VAR);
                WriterManager.addLinha(Type.VAR.java() + " " + nome + PONTO_E_VIRGULA);
                return;
            }

            if (partes[1].contains(USER_INPUT)) {    // Se a linha está recebendo input do usuário
                userInput(nome, partes[1]);
            } else {    // Se a linha recebe o valor diretamente
                valorDireto(nome, partes[1]);
            }
        }
    }


    // ===== MÉTODOS AUXILIARES =====

    /**
     * <p>
     * Adiciona linha que recebe o input do usuário
     * </p>
     *
     * @param nome o nome da variável
     * @param tipo o tipo da variável
     */
    private static void addInput(String nome, Type tipo) {
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
     * Seta o nome, o tipo e o valor da variável nos lugares necessários,
     * além de adicionar a linha do comando para se escrita
     * </p>
     *
     * @param nome  o nome da variável
     * @param valor o valor da variável
     * @param tipo  o tipo da variável
     */
    private static void setVarInfo(String nome, Object valor, Type tipo) {
        tipos.put(nome, tipo);
        valores.put(nome, valor);
        addLinha(nome, valor, tipo);
    }

    /**
     * <p>
     * Divide a linha em duas partes: a primeira é o nome da variável e a segunda é seu valor
     * </p>
     *
     * @param line a linha a ser dividida
     * @param tipo o tipo da variável
     * @return as partes da variável divididas
     */
    private static String[] getPartes(String line, Type tipo) {
        return line.replace(tipo.dart(), EMPTY_STRING)
                .replace(Type.VAR.dart(), EMPTY_STRING)
                .replace(PONTO_E_VIRGULA, EMPTY_STRING)
                .replace(WHITE_SPACE, EMPTY_STRING)
                .replace(ASPAS_SIMPLES, ASPAS_DUPLAS)
                .split(IGUAL);
    }

    /**
     * <p>
     * A linha recebe o valor diretamente
     * </p>
     *
     * @param nome  o nome da variável
     * @param valor o valor que deve ser atribuido
     */
    private static void valorDireto(String nome, String valor) {
        Type tipo;
        if (Util.isString(valor)) {
            tipo = Type.STRING;
        } else if (Util.isBoolean(valor)) {
            tipo = Type.BOOLEAN;
        } else {
            tipo = Type.DOUBLE;
        }
        setVarInfo(nome, valor, tipo);
    }

    /**
     * <p>
     * A linha recebe o valor a partir do input de um usuário
     * </p>
     *
     * @param nome  o nome da variável
     * @param valor o valor que deve ser atribuido
     */
    private static void userInput(String nome, String valor) {
        Type tipo;
        if (Util.isInt(valor)) {
            tipo = Type.INT;
        } else if (Util.isDouble(valor) || Util.isNum(valor)) {
            tipo = Type.DOUBLE;
        } else if (Util.isBoolean(valor)) {
            tipo = Type.BOOLEAN;
        } else {
            tipo = Type.STRING;
        }
        addInput(nome, tipo);
    }

}
