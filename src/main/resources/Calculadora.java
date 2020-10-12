import java.util.Scanner;
public class Calculadora {
public static void main(String[] args) {

System.out.println("Escolha um número:");
Scanner in = new Scanner(System.in);
double a = in.nextDouble();
System.out.println("Escolha outro número:");
double b = in.nextDouble();
System.out.println("Soma - 1");
System.out.println("Subtração - 2");
System.out.println("Divisão - 3");
System.out.println("Multiplicação - 4");
int op = in.nextInt();

double result;
if(op == 1){
result = a + b;
}else if(op == 2){
result = a - b;
}else if(op == 3){
result = a / b;
} else if(op == 4){
result = a * b;
}

System.out.println("O resultado é: " + result);
}
}
