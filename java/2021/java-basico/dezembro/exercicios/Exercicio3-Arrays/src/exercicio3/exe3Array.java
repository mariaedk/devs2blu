package exercicio3;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class exe3Array
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
		
		// compara um numero com o numero da frente. se o da frente for maior, trocam de lugar.
		for (int i = 0; i < salarios.length; i++)   
		{  
			for (int j = i + 1; j < salarios.length; j++)   
			{  
				double temporaria = 0;  
				if (salarios[i] < salarios[j])   
				{  
					temporaria = salarios[i]; // pega o valor que está antes e guarda em temporaria
					salarios[i] = salarios[j]; // troca os valores de lugar
					salarios[j] = temporaria;  
				}
			}
		}
		
		
		for (int i = 0; i < nomes.length; i++) 
		{
			System.out.println("CÓDIGO    NOME    SALARIO");
			System.out.println(codigos[i] + "         " + nomes[i] + "         " + formatador.format(salarios[i]));
			System.out.println();
		}
		System.out.println("Total em salários: " + formatador.format(somaSalarios));
		System.out.println("Três maiores salários: " + formatador.format(salarios[0]) + ", " 
							+ formatador.format(salarios[1]) + ", " + formatador.format(salarios[2]));
		
		teclado.close();
	}

}
