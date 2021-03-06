import java.text.DecimalFormat;
import java.util.Scanner;

/*
 Uma ag?ncia banc?ria possui v?rios clientes que podem fazer investimentos 
   com rendimentos mensais, conforme a tabela a seguir:

    Tipo	Descri??o		Rendimento mensal
     1		Poupan?a		    1.5%
     2		Poupan?a plus		2.0%
     3		Fundos de renda		4.0%
			
   Fa?a um programa que leia o c?digo do cliente, o tipo da conta e o valor investido 
   e que calcule e mostre o rendimento mensal de acordo com o tipo do investimento. 
   Ao final do programa mostre o total de juros pagos. 
   A leitura terminar? quando o c?digo do cliente digitado for menor ou igual a 0.

 */
public class Exe02 {
	public static void main(String[] args) {
		
		int codigoCliente, tipoConta;
		double valorInvestido, rendimentoMensal = 0;
		
		Scanner teclado = new Scanner(System.in);
		DecimalFormat formatador = new DecimalFormat("R$ #,##0.00");
		
		System.out.println("============= Sistema banc?rio =============");
		
		do
		{
			
			System.out.println("Tabela informativa:");
			System.out.println("-----------------------------------------");
			System.out.println("Tipo	        Descri??o	Rendimento mensal");
			System.out.println(" 1		Poupan?a		1,5%");
			System.out.println(" 2		Poupan?a plus		2.0%");
			System.out.println(" 3		Fundos de renda		4.0%");
			System.out.println("-----------------------------------------");
			
			System.out.println("Seu c?digo de cliente (0 para encerrar o programa): ");
			codigoCliente = teclado.nextInt();
			
			System.out.println("Tipo de conta: ");
			tipoConta = teclado.nextInt();
			
			System.out.println("Valor investido: ");
			valorInvestido = teclado.nextDouble();
			
			switch(tipoConta)
			{
			 	case 1:
			 		rendimentoMensal = valorInvestido * 1.5;
			 		System.out.println("Tipo de rendimento mensal: Poupan?a (1.5%) -- " + formatador.format(rendimentoMensal));
			 		break;
			 	case 2:
			 		rendimentoMensal = valorInvestido * 2.0;
			 		System.out.println("Tipo de rendimento mensal: Poupan?a plus (2.0%) -- " + formatador.format(rendimentoMensal));
			 		break;
			 	case 3:
			 		rendimentoMensal = valorInvestido * 4.0;
			 		System.out.println("Tipo de rendimento mensal: Fundos de renda (4.0%) -- " + formatador.format(rendimentoMensal));
			 		break;
			}
			System.out.println("Total de juros pagos: " + formatador.format(rendimentoMensal - valorInvestido));
		} while (codigoCliente <= 0);
		teclado.close();
	}
}
