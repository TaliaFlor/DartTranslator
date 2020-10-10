package interfaces;

import enums.Type;

import java.util.HashMap;
import java.util.Map;

public interface DartHandler {

    /**
     * <p>
     * Contém o nome e o tipo de todas as variáveis de todos os tipos
     * </p>
     */
    Map<String, Type> nomesPorTipo = new HashMap<>();

    // Contém o nome da variável e seu valor de acordo com o seu tipo
    Map<String, Integer> ints = new HashMap<>();
    Map<String, Double> doubles = new HashMap<>();
    Map<String, Boolean> booleans = new HashMap<>();
    Map<String, String> strings = new HashMap<>();


    void readLine(String line);

}
