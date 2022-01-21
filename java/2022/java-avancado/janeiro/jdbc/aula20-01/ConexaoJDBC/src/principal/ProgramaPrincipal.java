package principal;

import java.util.List;

import entidades.Carro;
import uteis.Conexao;

public class ProgramaPrincipal {

	public static void main(String[] args)
	{
//		consultaTodosCarros();
//		deletarCarro();
//		consultaTodosCarros();
//		
//		criarCarro();
		alterarCarro();
	}
	
	static void alterarCarro()
	{
		Carro carro = new Carro().consultarCarroPeloId(5);
		carro.setPlaca("abc1234");
		carro.setMarca("POPULAR");
		if (carro.alterarCarroBd())
		{
			System.out.println("Carro alterado com sucesso.");
		}
	}
	
	static void deletarCarro()
	{
		Carro carro = new Carro();
		if (carro.deletarCarroBd(4))
		{
			System.out.println("Sucesso!");
		}
	}
	
	static void consultaTodosCarros()
	{
		List<Carro> listaCarro = new Carro().consultarTodosCarros();
		
		for (Carro carro : listaCarro) 
		{
			carro.mostrarInformacoesCarro(carro);
		}
		
	}
	
	
	static void criarCarro()
	{
		// instanciando carro e setando atributos
		Carro carro = new Carro();
		carro.setPlaca("fwe8324");
		carro.setMarca("Volks");
		carro.setModelo("Fusca branco");
		if (carro.salvarCarroBd())
		{
			System.out.println("Carro salvo com sucesso!");
		}
	}
	
	static void consultaCarro()
	{
//		Carro carro = new Carro();
//		carro.consultarCarroPeloId(1);
		
		Carro carro = new Carro().consultarCarroPeloId(2);
		System.out.println(carro.getPlaca());
	}
	
	static void testeConexao()
	{
		if (Conexao.getConexao() != null)
		{
			System.out.println("Conexão sucedida.");
		}
		else
		{
			System.out.println("Erro ao estabelecer conexão com o Banco de Dados.");
		}		
	}
}
