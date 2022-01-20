package exercicio1;

import java.util.Scanner;

public class exeArray
{

	public static void main(String[] args) 
	{
		Scanner teclado = new Scanner(System.in);
		
		int[] codigos = new int[10];
		String[] nomes = new String[10];
		
		for (int i = 0; i < 10; i++) 
		{
			System.out.print("Nome: ");
			nomes[i] = teclado.next();
			codigos[i] = i + 1;
		}
		
		for (int i = 0; i < nomes.length; i++) {
			System.out.println("CÓDIGO    NOME");
			System.out.println(codigos[i] + "         " + nomes[i]);
			System.out.println();
		}
	}

}
