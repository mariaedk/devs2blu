package principal;

import util.Conexao;

public class MenuPrincipal 
{

	public static void main(String[] args) 
	{
//		testeConexao();
		
	}
	
	static void testeConexao()
	{
		if (Conexao.conectar() != null) 
		{
			System.out.println("Conectado.");
		}
		else
		{
			System.out.println("Erro.");
		}
	}
}
