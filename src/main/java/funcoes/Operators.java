package funcoes;

import enums.MathOperator;
import enums.LogicOperator;

public class Operators {

	public MathOperator defineOperadores(String str) {
		if (str.contains("+")) {
			return MathOperator.SOMA;
		} else if (str.contains("-")) {
			return MathOperator.SUBTRACAO;
		} else if (str.contains("*")) {
			return MathOperator.MULTIPLICACAO;
		} else if (str.contains("/")) {
			return MathOperator.DIVISAO;
		}
		return null;
	}

	public LogicOperator defineCondicionais(String str) {
		if (str.contains(">")) {
			return LogicOperator.MAIOR_QUE;
		} else if (str.contains("<")) {
			return LogicOperator.MENOR_QUE;
		} else if (str.contains(">=")) {
			return LogicOperator.MAIOR_IGUAL;
		} else if (str.contains("<=")) {
			return LogicOperator.MENOR_IGUAL;
		}else if(str.contains("==")){
			return LogicOperator.IGUAL;
		}else if(str.contains("!=")){
			return LogicOperator.DIFERENTE;
		}
		return null;

	}





}
