import java.text.DecimalFormat;
import java.util.Scanner;

/* 
1. Fa?a um programa que receba o valor de um carro e mostre uma tabela 
   com os seguintes dados: pre?o final, quantidade de parcelas e valor da parcela. 
   Considere o seguinte:

   O pre?o final para compra ? vista tem um desconto de 20%;
   Se for a prazo, a quantidades de parcelas pode ser: 
      6, 12, 18, 24, 30, 36, 42, 48, 54 e 60.
		
   Os percentuais de acr?scimo seguem a tabela a seguir.  
			valorCarro = valorCarro * (((qtdParcelas / 2)/100) + 1)
	Parcelas	Acr?scimo
	6		3%
	12		6%
	18		9%
	24		12%
	30		15%
	36		18%
	42		21%
	48		24%
	54		27%
	60		30%
*/
public class Exe01 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		DecimalFormat formatador = new DecimalFormat("R$ #,##0.00");

		int opcao;
		
		do 
		{
			
			System.out.println("Digite o valor do carro: ");
			double valorCarro = teclado.nextDouble();
			
			System.out.println("Selecione a forma de pagamento: ");
			System.out.println("1 - ? vista, 2 - ? prazo, 3 - Sair do programa");
			opcao = teclado.nextInt();
			
			int qtdParcelas;
			double valorParcela;

			switch(opcao)
			{
				case 1:
					valorCarro = valorCarro * 0.8;
					System.out.println("==============================");
					System.out.println("Valor final: " + formatador.format(valorCarro));
					System.out.println("==============================");
					break;
				case 2:
					System.out.println("A quantidades de parcelas pode ser: 6, 12, 18, 24, 30, 36, 42, 48, 54 e 60.");
					System.out.println("Digite a quantidade de parcelas que deseja: ");
					qtdParcelas = teclado.nextInt();
					valorCarro = valorCarro * (((double)(qtdParcelas / 2)/100) + 1);
					valorParcela = valorCarro / qtdParcelas;
					System.out.println("==============================");
					System.out.println("Valor final: " + formatador.format(valorCarro));
					System.out.println("Qtd parcelas selecionadas: " + qtdParcelas);
					System.out.println("Valor da parcela: " + formatador.format(valorParcela));
					System.out.println("==============================");
					break;
			}
			
			valorCarro = 0;
			
		} while (opcao != 3);
		
		teclado.close();
	}
	
}
