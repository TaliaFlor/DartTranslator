import arquivo.EscreverArquivo;
import arquivo.LerArquivo;
import funcoes.DeclaraVariavel;
import interfaces.DartHandler;
import io.OutputHandler;

import java.io.FileNotFoundException;

public class DartReader implements DartHandler {


    public static void main(String[] args) {


       LerArquivo file = new LerArquivo();


       file.lerArquivo();
		OutputHandler saida = new OutputHandler();
		DeclaraVariavel variavel = new DeclaraVariavel();
		EscreverArquivo escrever = new EscreverArquivo();

		for (String linha : linhas) {
			linha = linha.trim();
			if(linha == null || linha.trim().isEmpty() || linha.startsWith("import") || linha.startsWith("void")) {
				continue;

			}

			if(linha.startsWith("print(")){
				saida.escreverOutput(linha);

			}else if(linha.startsWith("int") || linha.startsWith("double") || linha.startsWith("num") ||
					linha.startsWith("boolean") || linha.startsWith("string") || linha.startsWith("var")){
				variavel.definicaoDeVariavel(linha);
			}else{
				escrever.addLinha(linha);
			}


		}

		escrever.escreverArquivo();



    }
}
