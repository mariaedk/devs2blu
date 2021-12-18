package Exercicio;

import java.util.Scanner;

public class AgendaPrincipal
{
	public static void main(String[] args)
	{
		Scanner teclado = new Scanner(System.in);
		
		int opcao = 0;
		
		do
		{
			menuPrincipal();
			System.out.print("Informe a opção: ");
			opcao = teclado.nextInt();
			
			
			
		} while (opcao != 9);
	}
	
	public static void menuPrincipal()
	{
		System.out.println("=+=+=+=+=+=+=+=+=+ MENU PRINCIPAL =+=+=+=+=+=+=+=+=+");
		System.out.println(" 1 - INCLUIR \n2 - ALTERAR \n3 - EXCLUIR \n4 - CONSULTAR");
	}
}
