package util;

import enums.Type;
import interfaces.DartHandler;

public class Util implements DartHandler {

    public Object getVariavel(String nomeVariavel) {
        if (!nomesPorTipo.containsKey(nomeVariavel)) {
            return null;
        }
        Type tipo = nomesPorTipo.get(nomeVariavel);
        Object valor = null;
        if (tipo == Type.INT) {
            valor = ints.get(nomeVariavel);
        } else if (tipo == Type.BOOLEAN) {
            valor = booleans.get(nomeVariavel);
        } else if (tipo == Type.DOUBLE || tipo == Type.NUM) {
            valor = doubles.get(nomeVariavel);
        } else if (tipo == Type.STRING) {
            valor = strings.get(nomeVariavel);
        } else if (tipo == Type.VAR) {
            valor = objects.get(nomeVariavel);
        }
        return valor;
    }


}
