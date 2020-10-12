package enums;

/**
 * <p>
 * Representa os tipos de dados em Dart e seus equivalentes em Java
 * </p>
 */
public enum Type {

    INT("int", "int"),
    DOUBLE("double", "double"),
    NUM("num", "double"),
    STRING("string", "String"),
    BOOLEAN("boolean", "boolean"),
    VAR("var", "Object");


    private final String dart;  // Tipo da variável em Dart
    private final String java;  // Tipo correspondente em Java


    Type(String dart, String java) {
        this.dart = dart;
        this.java = java;
    }


    public String dart() {
        return dart;
    }

    public String java() {
        return java;
    }

}
