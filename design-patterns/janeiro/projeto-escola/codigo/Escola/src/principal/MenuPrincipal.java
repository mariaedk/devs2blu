package principal;

import classes.Aluno;
import util.Conexao;

public class MenuPrincipal 
{

	public static void main(String[] args) 
	{
//		testeConexao();
//		Aluno aluno = new Aluno();
//		if (aluno.incluirAluno())
//		{
//			System.out.println("Aluno inclu�do com sucesso.");
//		}
//		else
//		{
//			System.out.println("Erro ao incluir o aluno.");
//		}
//		
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
