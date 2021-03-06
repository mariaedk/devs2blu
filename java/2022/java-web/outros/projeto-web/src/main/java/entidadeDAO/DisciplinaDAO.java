package entidadeDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entidades.Disciplina;
import interfaces.InterfaceDAO;
import util.Conexao;

public class DisciplinaDAO implements InterfaceDAO<Disciplina>
{

	@Override
	public boolean executaSalvarBD(Disciplina x) {
		Connection con = Conexao.conectar();

		String sql =  "insert into disciplina(nm_disciplina, nm_professor, qtd_avaliacoes) "
					+ "values(?,?,?)";

		try 
		{
			PreparedStatement stm = con.prepareStatement(sql);
			
			stm.setString(1, x.getNomeDisciplina());
			stm.setString(2, x.getNomeProfessor());
			stm.setInt(3, x.getQtdAvaliacoes());
			
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

	public boolean salvaDisciplinaBD(Disciplina d)
	{
		if (!executaSalvarBD(d))
		{
			System.out.println("DISCIPLINA N?O FOI SALVA COM SUCESSO");
			return false;
		}
		
		System.out.println("DISCIPLINA SALVA COM SUCESSO");
		return true;
	}
	
	@Override
	public boolean executaUpdateBD(Disciplina x) {
		String sql = "update disciplina set nm_disciplina = ?, nm_professor = ?,"
				   + "qtd_avaliacoes = ? where cd_disciplina = ?" ;
		
		PreparedStatement stm;
		try 
		{
			stm = Conexao.conectar().prepareStatement(sql);
			stm.setString(1, x.getNomeDisciplina());
			stm.setString(2, x.getNomeProfessor());
			stm.setObject(3, x.getQtdAvaliacoes());
			stm.setInt(4, x.getCodigoDisciplina());
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

	public boolean alteraDadosDisciplinaBD()
	{
		// retorna um objeto de aluno buscado pelo id
		Disciplina disciplina = new DisciplinaDAO().retornaUmObjetoBD(1);
		disciplina.setNomeDisciplina("Int. a programa??o");
		
		if (!executaUpdateBD(disciplina))
		{
			System.out.println("OS DADOS DA DISCIPLINA N?O FORAM ALTERADOS. FALHA");
			return false;
		}
		
		System.out.println("DADOS ALTERADOS SALVOS COM SUCESSO NO BANCO DE DADOS.");
		return true;
	}
	
	@Override
	public boolean executaExcluirBD(Disciplina x) {
		String sql = "delete from disciplina where cd_disciplina = ?";
		try 
		{
			PreparedStatement stm = Conexao.conectar().prepareStatement(sql);
			// consultando na coluna ID do banco o valor de id do carro recebido
			stm.setInt(1, x.getCodigoDisciplina());
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

	public boolean excluiDisciplinaBD(int id)
	{
		Disciplina disciplina = new DisciplinaDAO().retornaUmObjetoBD(id);
		
		if (new DisciplinaDAO().executaExcluirBD(disciplina)) 
		{
			System.out.println("DISCIPLINA EXCLU?DA COM SUCESSO.");
			return true;
		}
		else
		{
			System.out.println("FALHA NA EXCLUS?O DA DISCIPLINA.");
			return false;
		}
	}
	
	public Disciplina retornaUmObjetoBD(int id) {
		
		Disciplina disciplina = null;
		
		String sql = "select * from disciplina where cd_disciplina = " + id;
		try 
		{
			PreparedStatement stm = Conexao.conectar().prepareStatement(sql);

			ResultSet rs = stm.executeQuery();

			if (rs.next()) 
			{
				disciplina = new Disciplina(rs.getInt("cd_disciplina"),
								  rs.getString("nm_disciplina"),
							  	  rs.getString("nm_professor"),
								  rs.getInt("qtd_avaliacoes"));
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
		
		return disciplina;
		
	}

	@Override
	public List<Disciplina> retornarTodosBD() {
		List<Disciplina> disciplinas = new ArrayList<>();
		
		String sql = "select * from disciplina";
		
		try 
		{
			PreparedStatement stm = Conexao.conectar().prepareStatement(sql);
			ResultSet rs = stm.executeQuery();

			while (rs.next())
			{
				disciplinas.add(new Disciplina(rs.getInt("cd_disciplina"),
											  rs.getString("nm_disciplina"),
										  	  rs.getString("nm_professor"),
											  rs.getInt("qtd_avaliacoes")));
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
		return disciplinas;
	}

	public void retornaTodasDisciplinasBD()
	{
		List<Disciplina> disciplinas = new DisciplinaDAO().retornarTodosBD();
		
		for (Disciplina d : disciplinas)
		{
			System.out.println(d.getCodigoDisciplina());
			System.out.println(d.getNomeDisciplina());
			System.out.println(d.getNomeProfessor());
			System.out.println(d.getQtdAvaliacoes());
			System.out.println("+=+=+=+=+=+=");
		}
	}
}
