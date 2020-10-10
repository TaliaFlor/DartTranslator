package io;

import enums.Type;
import interfaces.DartHandler;

import java.util.Map;

public class OutputHandler implements DartHandler {

//    print('Escolha um número:');
//    'Escolha um número:'

//    print(1);
//    1

//    print(true);
//    true

//    print(variavel1);
//    variavel1

    private static final String EMPTY_STRING = "";

    private static final String PRINT = "print";
    private static final String PONTO_E_VIRGULA = ";";
    private static final String PARENTESES_ESQUERDO = "(";
    private static final String PARENTESES_DIREITO = ")";

    private static final String ASPAS_SIMPLES = "'";

//    private static final String SINAL_DE_SOMA = "+";


    @Override
    public void readLine(String line) {
        if (!linhaValida(line)) {
            return;
        }

        String output = limpaLinha(line);
        Object valor = defineOutput(output);

        print(valor);

//        if (output.startsWith(ASPAS_SIMPLES) && output.contains(SINAL_DE_SOMA)) {
//            String[] outputs = output.split(SINAL_DE_SOMA);
//            Object[] valores = new Object[outputs.length];
//            for (int i = 0; i < outputs.length; i++) {
//                String out = outputs[i];
//                valores[i] = defineOutput(out);
//            }
//            String string = (String) defineOutput(outputs[0]);
//            Object valor =
//        }

//          print('O resultado é: ' + result);
    }

    /**
     * <p>
     * Define o valor da saída
     * </p>
     *
     * @param output output de maneira não tratada
     * @return o valor da saída de dados
     */
    private Object defineOutput(String output) {
        if (output.startsWith(ASPAS_SIMPLES) && output.endsWith(ASPAS_SIMPLES)) {   // Caso seja string
            return output.replaceAll(ASPAS_SIMPLES, EMPTY_STRING);
        } else if (nomesPorTipo.containsKey(output)) {   // Caso seja uma variável
            return getValor(output);
        } else {    // Caso seja algum tipo de número
            return output;
        }
    }

    /**
     * <p>
     * Retorna o valor da variável
     * </p>
     *
     * @param nome o nome da variável
     * @return o valor da variável
     */
    private Object getValor(String nome) {
        Type tipo = nomesPorTipo.get(nome);
        switch (tipo) {
            case INT:
                return getValueFromMap(ints, nome);
            case DOUBLE:
            case NUM:
                return getValueFromMap(doubles, nome);
            case BOOLEAN:
                return getValueFromMap(booleans, nome);
            case STRING:
                return getValueFromMap(strings, nome);
            default:
                return null;
        }
    }

    /**
     * <p>
     * Pega o valor da variável do mapa passado
     * </p>
     *
     * @param map  mapa que contém a variável
     * @param nome o nome da variável
     * @return o valor da variável
     */
    private Object getValueFromMap(Map<String, ?> map, String nome) {
        return map.get(nome);
    }

    /**
     * <p>
     * Printa a informação desejada
     * </p>
     *
     * @param msg a mensagem a ser mostrada na tela
     */
    private void print(Object msg) {
        if (msg == null) {
            return;
        }

        System.out.println(msg);
    }

//    /**
//     * <p>
//     * Printa a informação desejada
//     * </p>
//     *
//     * @param mensagens as mensagens a serem mostradas na tela
//     */
//    private void print(Object... mensagens) {
//        if (mensagens == null) {
//            return;
//        }
//
//        for (Object msg : mensagens) {
//            System.out.println(msg);
//        }
//    }

    /**
     * <p>
     * Determina se a linha é valida para a operação
     * </p>
     *
     * @param line linha a ser analizada
     * @return se a linha é válida ou não
     */
    private boolean linhaValida(String line) {
        if (line == null || line.trim().isEmpty()) {
            return false;
        }

        return line.startsWith(PRINT);
    }

    /**
     * <p>
     * Remove atributos desnecessários para a operação na linha e deixa apenas o output que deve ser exibido
     * </p>
     *
     * @param line linha a ser limpa
     * @return output que deve ser exibido na tela
     */
    private String limpaLinha(String line) {
        return line.replace(PRINT, EMPTY_STRING)
                .replace(PONTO_E_VIRGULA, EMPTY_STRING)
                .replace(PARENTESES_ESQUERDO, EMPTY_STRING)
                .replace(PARENTESES_DIREITO, EMPTY_STRING);
    }

}
