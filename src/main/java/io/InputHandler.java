package io;

import java.util.Scanner;

import arquivo.EscreverArquivo;
import enums.Type;
import interfaces.DartHandler;

public class InputHandler implements DartHandler {
	private static boolean scanner = false;

	public String lerInput(String str, Type tipo) {
		if(!str.contains("stdin.readLineSync()")) {
			return "";
		}
		EscreverArquivo escrever = new EscreverArquivo();
		escrever.addImport("java.util.Scanner");
		if(!scanner) {
			escrever.addLinha("Scanner in = new Scanner(System.in);");
			scanner = true;
		}
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
