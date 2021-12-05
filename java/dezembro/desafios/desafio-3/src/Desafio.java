import java.util.Scanner;

public class Desafio 
{
	// Desenvolva um programa que permita imprimir a tabuada de qualquer número
	public static void main(String[] args) 
	{
		Scanner teclado = new Scanner(System.in);
		int numero = 0;
		System.out.print("Informe um número: ");
		numero = teclado.nextInt();
		
		long multiplicacao;
		for (int i = 0; i <= 10; i++)
		{
			multiplicacao = numero * i;
			System.out.println(numero + " x " + i + " = " + multiplicacao);
		}
		teclado.close();
	}
}
