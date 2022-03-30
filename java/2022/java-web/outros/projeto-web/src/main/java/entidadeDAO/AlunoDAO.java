package entidadeDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import entidades.Aluno;
import interfaces.InterfaceDAO;
import util.Conexao;

public class AlunoDAO implements InterfaceDAO<Aluno>
{

//	monta e executa a query que irá salvar o aluno no banco de dados
	@Override
	public boolean executaSalvarBD(Aluno x)
	{
		Connection con = Conexao.conectar();

		String sql =  "insert into aluno(nm_aluno, nm_mae, nm_pai, dt_nascimento, media_aluno, fl_situacao_aluno) "
					+ "values(?,?,?,?,?,?)";

		try 
		{
			PreparedStatement stm = con.prepareStatement(sql);
			
			stm.setString(1, x.getNomeAluno());
			stm.setString(2, x.getNomeMae());
			stm.setString(3, x.getNomePai());
			stm.setObject(4, x.getDataNasc());
			stm.setDouble(5, x.getMediaAluno());
			stm.setString(6, String.valueOf(x.getSituacaoAluno()));
			
			stm.execute();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			Conexao.closeConexao();
		}
		
		return true;
	}

//	chama e complementa o método "executaSalvarBD"
	public boolean salvaAlunoBD(Aluno aluno)
	{
		if (!executaSalvarBD(aluno))
		{
			System.out.println("ALUNO NÃO FOI SALVO NO BANCO DE DADOS");
			return false;
		}
		
		System.out.println("ALUNO SALVO COM SUCESSO NO BANCO DE DADOS.");
		return true;
	}

	
//	monta e executa a query que ira dar update em dados de um aluno no banco de dados 
	@Override
	public boolean executaUpdateBD(Aluno x) 
	{
		String sql = "update aluno set nm_aluno = ?, nm_mae = ?, nm_pai = ?,"
				   + "dt_nascimento = ?, media_aluno = ?, fl_situacao_aluno = ? "
				   + "where cd_aluno = ?" ;
		
		PreparedStatement stm;
		try 
		{
			stm = Conexao.conectar().prepareStatement(sql);
			stm.setString(1, x.getNomeAluno());
			stm.setString(2, x.getNomeMae());
			stm.setString(3, x.getNomePai());
			stm.setObject(4, x.getDataNasc());
			stm.setDouble(5, x.getMediaAluno());
			stm.setString(6, String.valueOf(x.getSituacaoAluno()));
			stm.setInt(7, x.getCodigoAluno());
			stm.execute();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			Conexao.closeConexao();
		}
		
		return true;
	}

//	chama e complementa o método "executaUpdateBD"
	public boolean alteraDadosAlunoBD()
	{
		// retorna um objeto de aluno buscado pelo id
		Aluno aluno = new AlunoDAO().retornaUmObjetoBD(5);
		aluno.setNomeAluno("Bruna");
		
		if (!executaUpdateBD(aluno))
		{
			System.out.println("OS DADOS DO ALUNO NÃO FORAM ALTERADOS. FALHA");
			return false;
		}
		
		System.out.println("DADOS ALTERADOS SALVOS COM SUCESSO NO BANCO DE DADOS.");
		return true;
	}
	
	
//	 excluir pelo objeto
	@Override
	public boolean executaExcluirBD(Aluno x) {
		String sql = "delete from aluno where cd_aluno = ?";
		try 
		{
			PreparedStatement stm = Conexao.conectar().prepareStatement(sql);
			// consultando na coluna ID do banco o valor de id do carro recebido
			stm.setInt(1, x.getCodigoAluno());
			stm.execute();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			Conexao.closeConexao();
		}
		return true;
	}
	
//	chama e complementa o método "executaExcluirBD"
	public boolean excluiAlunoBD(int id)
	{
		Aluno aluno = new AlunoDAO().retornaUmObjetoBD(id);
		
		if (new AlunoDAO().executaExcluirBD(aluno)) 
		{
			System.out.println("ALUNO EXCLUÍDO COM SUCESSO.");
			return true;
		}
		else
		{
			System.out.println("FALHA NA EXCLUSÃO DO ALUNO.");
			return false;
		}
	}

	
//	retorna um objeto pelo seu ID
	public Aluno retornaUmObjetoBD(int id) 
	{
		Aluno aluno = null;
		
		String sql = "select * from aluno where cd_aluno = " + id;
		try 
		{
			PreparedStatement stm = Conexao.conectar().prepareStatement(sql);

			ResultSet rs = stm.executeQuery();

			if (rs.next()) 
			{
				aluno = new Aluno(rs.getInt("cd_aluno"),
								  rs.getString("nm_aluno"),
							  	  rs.getString("nm_mae"),
								  rs.getString("nm_pai"),
								  rs.getObject("dt_nascimento", LocalDate.class),
								  rs.getString("fl_situacao_aluno"),
								  rs.getDouble("media_aluno"));
			}
		}
		
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		finally
		{
			Conexao.closeConexao();
		}
		
		return aluno;
	}

	
//	retorna todos os alunos que estao no banco de dados
	@Override
	public List<Aluno> retornarTodosBD() 
	{
		List<Aluno> alunos = new ArrayList<>();
		
		String sql = "select * from aluno";
		
		try 
		{
			PreparedStatement stm = Conexao.conectar().prepareStatement(sql);
			ResultSet rs = stm.executeQuery();

			while (rs.next())
			{
				alunos.add(new Aluno(rs.getInt("cd_aluno"),
									 rs.getString("nm_aluno"),
								  	 rs.getString("nm_mae"),
									 rs.getString("nm_pai"),
									 rs.getObject("dt_nascimento", LocalDate.class),
									 rs.getString("fl_situacao_aluno"),
									 rs.getDouble("media_aluno")));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			Conexao.closeConexao();
		}
		return alunos;
	}
		
	public void retornaTodosAlunosBD()
	{
		List<Aluno> alunos = new AlunoDAO().retornarTodosBD();
		
		for (Aluno a : alunos)
		{
			System.out.println("Código do aluno: " + a.getCodigoAluno());
			System.out.println("Nome do aluno: " + a.getNomeAluno());
			System.out.println("Nome da mãe do aluno: " + a.getNomeMae());
			System.out.println("Nome do pai do aluno: " + a.getNomePai());
			System.out.println("Data de nascimento: " + a.getDataNasc());
		}
	}
}
