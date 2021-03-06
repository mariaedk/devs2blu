package principal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import entidades.Cliente;
import entidades.Produto;
import uteis.ConexaoBancoDados;

public class ProjetoPessoalPrincipal 
{

	public static void main(String[] args) 
	{
		Cliente cliente = criaCliente();
		salvaClienteBD(cliente);
		
		Produto produto = criarProduto();
		salvaProdutoBD(produto);
		
	}
	
//	m?todos para o cliente
	public static Cliente criaCliente()
	{	
		Scanner teclado = new Scanner(System.in);
		
		// l? informa??es
		System.out.println("Nome do cliente: ");
		String nome = teclado.nextLine();
		
		System.out.println("Data de nascimento: ");
		String dataNascString = teclado.next();
		
		System.out.println("N?mero cpf: ");
		String cpf = teclado.next();
		
		System.out.println("Nome do munic?pio em que reside: ");
		String municipio = teclado.next();
		
//		cria objeto de cliente
		Cliente cliente = new Cliente(nome, formataDataNascCliente(dataNascString), cpf, municipio);
		
		teclado.close();
		return cliente;
	}
	
	public static LocalDate formataDataNascCliente(String dataNascString)
	{
//		cria um formatador para que a data seja enviada ao banco de dados com um formato que ele entenda 
		DateTimeFormatter formatadorData = DateTimeFormatter.ofPattern("d/MM/yyyy");
		
//		converter de String para LocalDate
		LocalDate dataNasc = LocalDate.parse(dataNascString, formatadorData);
		
		return dataNasc;
	}
	
	public static boolean salvaClienteBD(Cliente cliente)
	{
		
		if (cliente.inserirClienteBD())
		{
			System.err.println("Cliente salvo com sucesso!");
			return true;
		}
		else
		{
			System.out.println("O cliente n?o foi salvo. Erro.");
			return false;
		}	
	}

//	m?todos para o produto
	
	public static Produto criarProduto()
	{
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Nome do produto: ");
		String nomeProduto = teclado.nextLine();
		
		System.out.println("Descri??o do produto: ");
		String descProduto = teclado.nextLine();
		
		System.out.println("Quantidade em estoque: ");
		short qtdEstoque = teclado.nextShort();
		
		Produto produto = new Produto(nomeProduto, descProduto, qtdEstoque);
		
		teclado.close();
		return produto;
	}

	public static boolean salvaProdutoBD(Produto produto)
	{
		if (produto.inserirProdutoBD())
		{
			System.err.println("Produto salvo com sucesso!");
			return true;
		}
		else
		{
			System.out.println("O produto n?o foi salvo. Erro.");
			return false;
		}
	}

//	teste de conex?o
	static void testeConexao()
	{
		if (ConexaoBancoDados.getConexao() != null)
		{
			System.out.println("Conex?o sucedida.");
		}
		else
		{
			System.out.println("Erro ao estabelecer conex?o com o Banco de Dados.");
		}		
	}
}
