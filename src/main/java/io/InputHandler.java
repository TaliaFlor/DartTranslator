package io;

import java.util.Scanner;

import arquivo.EscreverArquivo;
import enums.Type;
import interfaces.DartHandler;

public class InputHandler implements DartHandler {
	
	public String lerInput(String str, Type tipo) {
		if(!str.contains("stdin.readLineSync()")) {
			return "";
		}
		EscreverArquivo escrever = new EscreverArquivo();
		escrever.addImport("java.util.Scanner");
		escrever.addLinha("Scanner in = new Scanner(System.in);");
		String in = "";
		if(tipo == Type.INT) {
			in = "in.nextInt();";
		}
		else if(tipo == Type.DOUBLE || tipo == Type.NUM) {
			in = "in.nextDouble();";
		}
		else if(tipo == Type.BOOLEAN) {
			in = "in.nextBoolean();";
		}
		else if(tipo == Type.STRING || tipo == Type.VAR) {
			in = "in.nextLine();";
		}
		return in;
	}
}
