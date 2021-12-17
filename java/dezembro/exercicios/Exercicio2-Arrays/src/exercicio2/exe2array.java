package exercicio2;

import java.text.DecimalFormat;
import java.util.Scanner;

public class exe2Array
{

	public static void main(String[] args) 
	{
		Scanner teclado = new Scanner(System.in);
		DecimalFormat formatador = new DecimalFormat("R$ #,##0.00");
		
		double somaSalarios = 0;
		
		int[] codigos = new int[10];
		String[] nomes = new String[10];
		double[] salarios = new double[10];
		
		for (int i = 0; i < 10; i++) 
		{
			System.out.print("Nome: ");
			nomes[i] = teclado.next();
			System.out.print("Salário: ");
			salarios[i] = teclado.nextDouble();
			somaSalarios += salarios[i];
			codigos[i] = i + 1;
		}
		
		for (int i = 0; i < nomes.length; i++) 
		{
			System.out.println("CÓDIGO    NOME    SALARIO");
			System.out.println(codigos[i] + "         " + nomes[i] + "         " + formatador.format(salarios[i]));
			System.out.println();
		}
		System.out.println("Total em salários: " + formatador.format(somaSalarios));
		teclado.close();
	}

}
