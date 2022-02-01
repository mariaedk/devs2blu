package entidadeDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import classes.Aluno;
import interfaces.InterfaceDAO;
import util.Conexao;

public class AlunoDAO implements InterfaceDAO<Aluno>
{

	@Override
	public boolean salvar(Aluno x) {
		Connection con = Conexao.conectar();
		
		String sql = "insert into(nm_aluno, nm_mae, nm_pai, dt_nascimento, media_aluno, fl_situacao_aluno) values (?,?,?,?,?,?)";
		
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

	@Override
	public boolean update(Aluno x)
	{
		String sql = "update aluno set nm_aluno = ?, nm_mae = ?, nm_pai = ?, dt_nascimento = ?, media_aluno = ?, fl_situacao_aluno = ?, where id = ?";
		
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

	@Override
	// exclui pelo objeto
	public boolean excluir(Aluno a) {
		String sql = "delete from aluno where cd_aluno = ?";
		try 
		{
			PreparedStatement stm = Conexao.conectar().prepareStatement(sql);
			stm.setInt(1, a.getCodigoAluno());
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

	@Override
	public Aluno retornarUm(int id) {
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
								  rs.getDate("dt_nascimento"),
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

	@Override
	public List<Aluno> retornarTodos() {
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
									 rs.getDate("dt_nascimento"),
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
	
}
