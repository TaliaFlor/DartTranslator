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
     * Contém o nome e o tipo de todas as variáveis de todos os tipos
     * </p>
     */
    Map<String, Type> nomesPorTipo = new HashMap<>();


    // Contém os nomes das variáveis e seus valores de acordo com seus tipos
    Map<String, Integer> ints = new HashMap<>();
    Map<String, Double> doubles = new HashMap<>();
    Map<String, Boolean> booleans = new HashMap<>();
    Map<String, String> strings = new HashMap<>();
    Map<String, Object> objects = new HashMap<>();

}
