import java.util.Scanner;

public class Desafio 
{

	public static void main(String[] args) 
	{
		// Desenvolva um programa que permita informar a quantidade de itens vendidos
		// Em seguida, pe?a o c?digo, descri??o, valor unit?rio e quantidade vendida.
		// Para cada item, imprimir os dados, calcular o valor total do item e ao final 
		// 	do programa imprimir o valor total da nota
		
		Scanner teclado = new Scanner(System.in);
	
		System.out.print("Quantidade de itens vendidos: ");
		int qtdItensVendidos = teclado.nextInt();
		
		double  valorTotal = 0;
		for (int i = 0; i < qtdItensVendidos; i++)
		{
			System.out.println("============================");
			System.out.print("C?digo do item: ");
			int codigo = teclado.nextInt();
			
			System.out.print("Descri??o do item: ");
			String descricao = teclado.next();
			
			System.out.print("Quantidade do item: ");
			int qtdItem = teclado.nextInt();
			
			System.out.print("Valor unit?rio do item: ");
			double valorUnitarioItem = teclado.nextDouble();
			
			System.out.println("============================");
			System.out.println("C?digo: " + codigo);
			System.out.println("Descri??o: " + descricao);
			System.out.println("Quantidade: " + qtdItem);
			System.out.println("Valor unit?rio do item: " + valorUnitarioItem);
			System.out.println("Valor total dos items: " + valorUnitarioItem * qtdItem);
			
			valorTotal += qtdItem * valorUnitarioItem;
		}
		
		System.out.println();
		System.out.println("============================");
		System.out.println("Valor total da nota: " + valorTotal);
		teclado.close();
	}

}
