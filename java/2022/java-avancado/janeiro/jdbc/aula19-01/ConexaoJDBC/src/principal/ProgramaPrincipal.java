package principal;

import entidades.Carro;
import uteis.Conexao;

public class ProgramaPrincipal {

	public static void main(String[] args)
	{
		// instanciando carro e setando atributos
		Carro carro = new Carro();
		carro.setPlaca("abc1234");
		carro.setMarca("Volks");
		carro.setModelo("Fusca");
		if (carro.salvarCarroBd())
		{
			System.out.println("Carro salvo com sucesso!");
		}
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
