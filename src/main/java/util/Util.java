package util;

import data.DataContainer;
import enums.Type;

/**
 * <p>
 * Possui métodos utilitários que podem ser usados em toda a aplicação
 * </p>
 */
public class Util implements DataContainer {

    /**
     * <p>
     * Retorna o valor da variável
     * </p>
     *
     * @param nome o nome da variável
     * @return o valor da variável
     */
    public static Object getValor(String nome) {
        Type tipo = nomesPorTipo.get(nome);
        return getValor(nome, tipo);
    }


    // ======= MÉTODOS AUXILIARES =======

    private static Object getValor(String nome, Type tipo) {
        switch (tipo) {
            case INT:
                return ints.get(nome);
            case NUM:
            case DOUBLE:
                return doubles.get(nome);
            case BOOLEAN:
                return booleans.get(nome);
            case STRING:
                return strings.get(nome);
            case VAR:
                return objects.get(nome);
            default:
                return null;
        }
    }

}
