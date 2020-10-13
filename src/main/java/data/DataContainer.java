package data;

import java.util.ArrayList;
import java.util.List;

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

}
