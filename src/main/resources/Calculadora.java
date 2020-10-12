import java.util.Scanner;
public class Calculadora{
public static void main(String[] args){
System.out.println("Escolha um n�mero:");
Scanner in = new Scanner(System.in);
double a = in.nextDouble();
System.out.println("Escolha outro n�mero:");
double b = in.nextDouble();
System.out.println("Soma - 1");
System.out.println("Subtra��o - 2");
System.out.println("Divis�o - 3");
System.out.println("Multiplica��o - 4");
int op = in.nextInt();
if(op == 1){
result = a + b;
}else if(op == 2){
result = a - b;
}else if(op == 3){
result = a / b;
} else if(op == 4){
result = a * b;
}
System.out.println("O resultado �: " + result);
}
}
}
