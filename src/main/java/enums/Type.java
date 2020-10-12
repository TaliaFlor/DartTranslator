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


    /**
     * <p>
     * Retorna o tipo da váriavel em Dart
     * </p>
     *
     * @return o tipo da variável em dart
     */
    public String dart() {
        return dart;
    }

    /**
     * <p>
     * Retorna o tipo equivalente da variável em Java
     * </p>
     *
     * @return o tipo equivalente em Java
     */
    public String java() {
        return java;
    }

}
