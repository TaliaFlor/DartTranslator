package funcoes;

import enums.Type;
import enums.Operator;
import interfaces.DartHandler;

import java.util.Map;

public class Operators  {


		 private Object defineOperadores(String str) {
			 if (str.containsKey("+")) {
				 return SOMA;
			 }else if  (str.containsKey("-")) {
				 return SUBTRACAO;
			 }else if (str.containsKey("*")) {
				 return MULTIPLICACAO;
			 }else if (str.containsKey("/")) {
			 	 return DIVISAO
		 }

			 private Object defineCondicionais(String str) {
				 if (str.containsKey(">")) {
					 return MAIOR_QUE;
				 }else if  (str.containsKey("<")) {
					 return MENOR_QUE;
				 }else if (str.containsKey(">=")) {
					 return MAIOR_IGUAL;
				 }else if (str.containsKey("<=")) {
					 return MENOR_IGUAL
				 }
    
}
