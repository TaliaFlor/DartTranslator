import 'dart:io';

void main() {
	print('Escolha um número:');
  var a = double.parse(stdin.readLineSync());
	print('Escolha outro número:');
  var b = double.parse(stdin.readLineSync());
  print('Soma - 1');
  print('Subtração - 2');
  print('Divisão - 3');
  print('Multiplicação - 4');
  var op = int.parse(stdin.readLineSync());
  
  var result;
  if(op == 1){
    result = a + b;
  }else if(op == 2){
    result = a - b;
  }else if(op == 3){
    result = a / b;
  } else if(op == 4){
    result = a * b;
  }
  
  print('O resultado é: ' + result);
}