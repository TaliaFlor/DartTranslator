package enums;

public enum Type {

    INT("int", "int"),
    DOUBLE("double", "double"),
    NUM("num", "double"),
    STRING("string", "String"),
    BOOLEAN("boolean", "boolean"),
    VAR("var", "Object");


    private final String tipo;       // Tipo da variável em Dart
    private final String tipoJava;  // Tipo correspondente em Java


    Type(String tipo, String tipoJava) {
        this.tipo = tipo;
        this.tipoJava = tipoJava;
    }


    public String get() {
        return tipo;
    }

    public String java() {
        return tipoJava;
    }

}
