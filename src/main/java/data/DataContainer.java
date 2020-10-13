package data;

import enums.Type;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * Guarda os dados da tradução em Runtime e os disponibiliza para o uso das outras classes
 * </p>
 */
public interface DataContainer {

    /**
     * <p>
     * Contém todas as linhas do arquivo .dart de entrada
     * </p>
     */
    List<String> linhas = new ArrayList<>();

    /**
     * <p>
     * Contém os tipos das variáveis
     * </p>
     */
    Map<String, Type> tipos = new HashMap<>();

    /**
     * Contém os valores das variáveis independentemente do tipo
     */
    Map<String, Object> valores = new HashMap<>();

}
