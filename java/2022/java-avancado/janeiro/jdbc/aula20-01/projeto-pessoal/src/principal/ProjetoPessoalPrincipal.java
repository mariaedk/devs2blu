package principal;

import java.util.Scanner;

import entidades.Cliente;
import uteis.ConexaoBancoDados;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ProjetoPessoalPrincipal 
{

	public static void main(String[] args) 
	{
//		testeConexao();
		DateTimeFormatter formatadorData = DateTimeFormatter.ofPattern("d/MM/yyyy");
		
		Scanner teclado = new Scanner(System.in);
		System.out.println("Nome do cliente: ");
		String nome = teclado.nextLine();
		
		System.out.println("Data de nascimento: ");
		String dataNascString = teclado.next();
		
//		converter de String para LocalDate
		LocalDate dataNasc = LocalDate.parse(dataNascString, formatadorData);
		
		System.out.println("N�mero cpf: ");
		String cpf = teclado.next();
		
		System.out.println("Nome do munic�pio em que reside: ");
		String municipio = teclado.next();
		
//		System.out.println(nome);
//		System.out.println(dataNascString);
//		System.out.println(dataNasc);
//		System.out.println(cpf);
//		System.out.println(municipio);
			
		Cliente cliente = new Cliente(nome, dataNasc, cpf, municipio);
		
		System.out.println(cliente.getNome());
		System.out.println(cliente.getCpf());
		System.out.println(cliente.getDataNascimento());
		System.out.println(cliente.getNomeMunicipio());
		
		if (cliente.salvarClienteBD())
		{
			System.out.println("Cliente salvo com sucesso!");
		}
		
		// TODO: VERIFICAR O SALVAMENTO DE DADOS... "�NDICE DA COLUNA EST� FORA DO INTERVALO"
		// PROVAVELMENTE NO SCRIPT DE CLIENTE NA HORA DE INSERIR DADOS
		
		teclado.close();
	}
	
	static void testeConexao()
	{
		if (ConexaoBancoDados.getConexao() != null)
		{
			System.out.println("Conex�o sucedida.");
		}
		else
		{
			System.out.println("Erro ao estabelecer conex�o com o Banco de Dados.");
		}		
	}
}
