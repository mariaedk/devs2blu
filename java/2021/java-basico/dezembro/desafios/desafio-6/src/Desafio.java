import java.util.Scanner;

public class Desafio {
	
	/* 
	 * Desenvolva um programa em que o usu?rio informa at? 10 nrs
	 * No final do programa voc? devera informar qual ? o menor numero e o qual ? o maior numero 
	 *  */
	
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		int numero = 0, menorNumero = Integer.MAX_VALUE, maiorNumero = Integer.MIN_VALUE;
		System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
		
		for (int i = 0; i < 10; i++) 
		{
			System.out.print("Informe o n?mero " + (i + 1) + ": ");
			numero = teclado.nextInt();
			
			if (numero > maiorNumero)
			{
				maiorNumero = numero;
			}
			if (numero < menorNumero)
			{
				menorNumero = numero;
			}
		}
		System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
		System.out.println("Menor n?mero: " + menorNumero);
		System.out.println("Maior n?mero: " + maiorNumero);
		teclado.close();
	}

}
