package excecoes;

import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class TratarExcecao 
{
	/**
	 * 
	 * @author maria
	 */
	
	public static void main(String[] args)
	{
		
		//exemploExcecao();
		//System.out.println("---------");
		//imprimirCarros();
		//coletaDadosPessoais();
		
		try
		{
			digitaDadosPessoaisRecursivo();
		}
		// tratando a exce��o que foi lan�ada no m�todo digitaDadosPessoaisRecursivo
		catch (IllegalArgumentException e)
		{
			System.out.println(e.getMessage());
		}
		catch (InputMismatchException im)
		{
			System.out.println(im.getMessage());
		}

	}
	
	private static void imprimirCarros()
	{
		String[] vagas = {"Fusca", "Kombi", "Brasilia"};
		try
		{
			System.out.println(vagas[4]);
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Fim do programa.");
		}
	}
	
	// static para n�o precisar instanciar, estou acessando o m�todo do conceito da classe
	private static void exemploExcecao()
	{
		try
		{
			int x = 10;
			int y = 0;
			int z = x / y;
		}
		catch (Exception e)
		{
			System.out.println("O valor n�o pode ser dividido por 0");
			System.out.println("Erro: " + e.getMessage() + " / " + e.getClass());
		}
	}
	
	static void digitaNomeTratandoExcecaoLancada()
	{
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Nome: ");
		String nome = teclado.next();
		
		int idade;
		
		while (true)
		{	
			
			try
			{
				System.out.println("Idade: ");
				idade = new Scanner(System.in).nextInt();

				break;
			}
			
			catch (InputMismatchException im)
			{
				System.err.println("Idade inv�lida.");
			}
		}	
	}

	/*
	 * CRIAR UMA ROTINA DE ENTRADA DE DADOS PARA INSERIR O NOME E A IDADE DE UMA PESSOA
	 * TRATAR AS EXCECOES QUE PODEM OCORRER NA CONVERSAO DOS DADOS
	 * 
	 */
	static void digitaDadosPessoaisRecursivo()
	{
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Nome: ");
		String nome = teclado.next();
		
		int idade;
		
		while (true)
		{	
			
			try
			{
				System.out.println("Idade: ");
				idade = new Scanner(System.in).nextInt();
				
				if (idade < 0)
				{
					throw new IllegalArgumentException("Idade n�o pode ser negativa");
				}
				// apenas lan�ando a exce��o
				if (idade > 130)
				{
					throw new InputMismatchException("Idade inv�lida.");
				}

				break;
			}
			
			catch (InputMismatchException im)
			{
				System.err.println("Idade inv�lida.");
			}
			catch (Exception e)
			{
				System.err.println("Entrada inv�lida de dados. Por favor, verifique e insira novamente.");
			}
		}
	}
	
	// exemplo do professor, n�o usado neste programa
	private static int validaConversaoIdade() throws  NumberFormatException
	{
	    String idade = JOptionPane.showInputDialog("Informe idade");
	  
		return Integer.parseInt(idade); 			 
	}
		
	
	private static void validaException()
	{
		try 
		{
			validaIdade(10);
		} 
		
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	private static void validaIdade(int idade) throws Exception
	{
		if (idade < 17)
		{
			throw new Exception("Menor de idade");
		}
	}
}
