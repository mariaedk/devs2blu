package Classes;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal 
{

	public static void main(String[] args)
	{
		Pessoa pessoa = new Pessoa("JOSÉ", 25);	
		ArrayList<Pessoa> listaPessoas = new ArrayList<>();
		Scanner teclado = new Scanner(System.in);
		
		listaPessoas.add(pessoa);
		System.out.println(pessoa.toString());
		System.out.println(pessoa.imprimirDados());
		
		for (int i = 0; i < 2; i++)
		{
			System.out.print("Nome:");
			String nome = teclado.next();
			
			System.out.print("Idade:");
			int idade = teclado.nextInt();
			
			Pessoa p = new Pessoa(nome, idade);
			listaPessoas.add(p);
		}
		
		for (Pessoa p : listaPessoas)
		{
			System.out.println(p.imprimirDados());
		} 
		teclado.close();
	}

}
