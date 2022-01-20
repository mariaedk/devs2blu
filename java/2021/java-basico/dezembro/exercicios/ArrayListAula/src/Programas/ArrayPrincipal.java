package Programas;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayPrincipal 
{

	public static void main(String[] args)
	{
		ArrayList<String> carros = new ArrayList<>();
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Qtd carros: ");
		int qtdCarros = teclado.nextInt();
		
		String marca = "";
		
		for (int i = 0; i < qtdCarros; i++)
		{
			System.out.print("Carro nº" + (i + 1)+ ": ");
			marca = teclado.next().toUpperCase();
			carros.add(marca);
		}
		
		System.out.println(carros);
		
		
		/*
		carros.add("Mazda");
		carros.add("Mercedes");
		carros.add("BMW");
		carros.add("Toyota");
		carros.add("Honda");
		
		
		System.out.println(carros);
		
		if (carros.isEmpty())
		{
			System.out.println("Vazio");
		}
		else
		{
			System.out.println("Contém registros");
		}
		
		boolean isMazda = carros.contains("Mazda");
		System.out.println(isMazda);

		System.out.println(carros.get(0));
		
		
		// troca as posições 1 e 2 de lugar
		
		int posicao = 1;
		int posicao2 = 2;
		
		String marcaAuxiliar = "", marcaAuxiliar2 = "";
		
		marcaAuxiliar = carros.get(posicao);
		marcaAuxiliar2 = carros.get(posicao2);
		
		carros.set(posicao, marcaAuxiliar2);
		carros.set(posicao2, marcaAuxiliar);
		
		System.out.println(carros);
		
		// pegar a posição de um objeto
		System.out.println(carros.indexOf("BMW"));
		
		// remover veículo c posicao
		carros.remove(posicao2);
		
		System.out.println(carros);
		
		
		// remover veiculo c nome
		carros.remove("Toyota");
		System.out.println(carros);
		*/
	}

}
