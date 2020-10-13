package util;

import enums.Type;

/**
 * <p>
 * Possui métodos utilitários que podem ser usados em toda a aplicação
 * </p>
 */
public class Util {
    private static final String TRUE = "true";
    private static final String FALSE = "false";

    private static final String ASPAS_SIMPLES = "'";


    /**
     * <p>
     * Indica se dado valor é um int
     * </p>
     *
     * @param line a linha a ser avaliada
     * @return se é um int ou não
     */
    public static boolean isInt(String line) {
        return line.startsWith(Type.INT.dart()) || line.contains(Type.INT.dart());
    }

    /**
     * <p>
     * Indica se dado valor é um double
     * </p>
     *
     * @param line a linha a ser avaliada
     * @return se é um double ou não
     */
    public static boolean isDouble(String line) {
        return line.startsWith(Type.DOUBLE.dart()) || line.contains(Type.DOUBLE.dart());
    }

    /**
     * <p>
     * Indica se dado valor é do tipo num
     * </p>
     *
     * @param line a linha a ser avaliada
     * @return se é um num ou não
     */
    public static boolean isNum(String line) {
        return line.startsWith(Type.NUM.dart()) || line.contains(Type.NUM.dart());
    }

    /**
     * <p>
     * Indica se dado valor é um boolean
     * </p>
     *
     * @param line a linha a ser avaliada
     * @return se é um boolean ou não
     */
    public static boolean isBoolean(String line) {
        return line.startsWith(Type.BOOLEAN.dart()) || line.contains(Type.BOOLEAN.dart())
                || line.equals(TRUE) || line.equals(FALSE);
    }

    /**
     * <p>
     * Indica se dado valor é uma string
     * </p>
     *
     * @param line a linha a ser avaliada
     * @return se é uma string ou não
     */
    public static boolean isString(String line) {
        return line.startsWith(Type.STRING.dart()) || line.contains(Type.STRING.dart())
                || line.startsWith(ASPAS_SIMPLES);
    }

    /**
     * <p>
     * Indica se dado valor é do tipo var
     * </p>
     *
     * @param line a linha a ser avaliada
     * @return se é um var ou não
     */
    public static boolean isVar(String line) {
        return line.startsWith(Type.VAR.dart()) || line.contains(Type.VAR.dart());
    }

}
