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

    private static final String EMPTY_STRING = "";


    /**
     * <p>
     * Defini uma variável de acordo co seu tipo
     * </p>
     *
     * @param line linha que contém a variável
     */
    public static void definirVariavel(String line) {
        Type tipo;
        if (Util.isInt(line)) {
            tipo = Type.INT;
        } else if (Util.isDouble(line) || Util.isNum(line)) {
            tipo = Type.DOUBLE;
        } else if (Util.isBoolean(line)) {
            tipo = Type.BOOLEAN;
        } else if (Util.isString(line)) {
            tipo = Type.STRING;
        } else {
            tipo = Type.VAR;
        }
        setVariavel(line, tipo);
    }


    // ===== MÉTODOS AUXILIARES =====

    /**
     * <p>
     * Adiciona uma linha que recebe um valor atribuido
     * </p>
     *
     * @param nome  o nome da variável
     * @param valor o valor atribuido a variável
     * @param tipo  o tipo da variável
     */
    private static void addAtribuicao(String nome, Object valor, Type tipo) {
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
        addAtribuicao(nome, valor, tipo);
    }

    /**
     * <p>
     * Divide a linha em duas partes: a primeira é o nome da variável e a segunda é seu valor
     * </p>
     *
     * @param line a linha a ser dividida
     * @return as partes da variável divididas
     */
    private static String[] getPartes(String line) {
        for (Type tipo : Type.values()) {
            line = line.replaceFirst(tipo.dart(), EMPTY_STRING);
        }

        return line.replace(";", EMPTY_STRING)
                .replace(" ", EMPTY_STRING)
                .replace("'", "\"")
                .split("=");
    }

    /**
     * <p>
     * Retorna o tipo verdadeiro da variável. Para ser usado com variáveis do tipo VAR
     * </p>
     *
     * @param line a linha que contém a variável
     * @return o tipo da variável
     */
    private static Type getTrueType(String line) {
        Type type;
        if (Util.isInt(line)) {
            type = Type.INT;
        } else if (Util.isDouble(line) || Util.isNum(line)) {
            type = Type.DOUBLE;
        } else if (Util.isBoolean(line)) {
            type = Type.BOOLEAN;
        } else {
            type = Type.STRING;
        }
        return type;
    }

    /**
     * <p>
     * Seta a variável em memória e reserva a sua linha de declaração para ser escrita
     * </p>
     *
     * @param line a linha que contém a variável
     * @param tipo o tipo da variável
     */
    private static void setVariavel(String line, Type tipo) {
        String[] partes = getPartes(line);
        String nome = partes[0];

        if (partes.length == 1) {   // Variável que contém apenas declaração, mas nenhuma atribuição na linha lida
            tipos.put(nome, tipo);
            WriterManager.addLinha(tipo.java() + " " + nome + " = null;");
            return;
        }

        if (tipo == Type.VAR) {
            tipo = getTrueType(partes[1]);
        }

        if (partes[1].contains("stdin.readLineSync()")) {   // Adiciona linha que recebe o input do usuário
            addAtribuicao(nome, InputHandler.input(tipo), tipo);
            return;
        }

        Object valor;
        if (tipos.containsKey(partes[1])) {
            valor = valores.get(partes[1]);
        } else {
            valor = partes[1];
        }

        setVarInfo(nome, valor, tipo);
    }

}
