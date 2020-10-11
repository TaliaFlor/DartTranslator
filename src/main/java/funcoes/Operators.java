package funcoes;

import enums.Operator;

public class Operators {

	private Object defineOperadores(String str) {
		if (str.contains("+")) {
			return Operator.SOMA;
		} else if (str.contains("-")) {
			return Operator.SUBTRACAO;
		} else if (str.contains("*")) {
			return Operator.MULTIPLICACAO;
		} else if (str.contains("/")) {
			return Operator.DIVISAO;
		}
		return null;
	}

	private Object defineCondicionais(String str) {
		if (str.contains(">")) {
			return Operator.MAIOR_QUE;
		} else if (str.contains("<")) {
			return Operator.MENOR_QUE;
		} else if (str.contains(">=")) {
			return Operator.MAIOR_IGUAL;
		} else if (str.contains("<=")) {
			return Operator.MENOR_IGUAL;
		}
		return null;

	}

}
