import java.text.DecimalFormat;
import java.util.Scanner;

/*
3. Fa?a um programa que apresente o menu de op??es a seguir, que permita ao usu?rio 
   escolher a op??o desejada, receba os dados necess?rios para executar a opera??o e 
   mostre o resultado. 
   Verificar a possibilidade de op??o inv?lida e n?o se preocupar com as restri??es, 
   como sal?rio inv?lido.  

		Menu de op??es:  

		1. Novo sal?rio
		2. F?rias
		3. D?cimo terceiro
		4. Sair  
		Digite a op??o desejada :

   Na Op??o 1: Receber o sal?rio de um funcion?rio, calcular e mostrar o novo sal?rio usando as 
               regras a seguir:  
		
		Sal?rios			% aumento
		Inferior a R$ 350,00		15%
		De R$ 350,00 a R$ 600,00	10%
		Acima de R$ 600,00		 5%
		
   Na op??o 2: Receber o sal?rio de um funcion?rio, calcular e mostrar o valor de suas f?rias. 
               Sabe-se que as f?rias equivalem ao seu sal?rio acrescido de l/3 do sal?rio atual.  

   Na op??o 3: Receber o sal?rio de um funcion?rio e o n?mero de meses de trabalho na empresa, 
               no m?ximo 12, calcular e mostrar o valor do d?cimo terceiro. 
               Sabe-se que o d?cimo terceiro equivale ao seu sal?rio multiplicado pelo n?mero de 
               meses de trabalho dividido por 12.  

   Na op??o 4: sair do programa.  
 */


public class Exe03 
{
	public static void main(String[] args)
	{
		Scanner teclado = new Scanner(System.in);
		DecimalFormat formatador = new DecimalFormat("R$ #,##0.00");
		
		int opcao, meses;
		double salario;
		double ferias, decimoTerceiro;
		
		System.out.println("		Menu de op??es:  \r\n"
				+ "\r\n"
				+ "		1. Novo sal?rio\r\n"
				+ "		2. F?rias\r\n"
				+ "		3. D?cimo terceiro\r\n"
				+ "		4. Sair  ");
		System.out.println();
		
		do
		{
			System.out.print("Digite sua op??o: ");
			opcao = teclado.nextInt();
			
			switch(opcao)
			{

				case 1:
					System.out.print("Informe seu sal?rio: ");
					salario = teclado.nextDouble();
					if (salario < 350)
					{
						salario = salario * 1.15;
					}
					else if (salario <= 600)
					{
						salario = salario * 1.10;
					}
					else if (salario > 600)
					{
						salario = salario * 1.05;
					}
					System.out.println("Novo sal?rio: " + formatador.format(salario));
					break;
					
				case 2:
					System.out.print("Informe seu sal?rio: ");
					salario = teclado.nextDouble();
					ferias = salario + (salario/3);
					System.out.println("Valor das suas f?rias: " + formatador.format(ferias));
					break;
					
				case 3:
					System.out.print("Informe seu sal?rio: ");
					salario = teclado.nextDouble();
					System.out.println("N?mero de meses: ");
					do
					{
						meses = teclado.nextInt();
					} while (meses > 12);
					
					decimoTerceiro = (salario * meses) / 12;
					System.out.println("D?cimo terceiro: " + formatador.format(decimoTerceiro));
					break;
					
				case 4:
					break;
					
				default:
					System.out.println("Op??o errada! Apenas 1 2 3 ou 4.");
					break;
			}
			
		} while (opcao != 4);
		System.out.println("==============================================================");
		teclado.close();
	}
}
