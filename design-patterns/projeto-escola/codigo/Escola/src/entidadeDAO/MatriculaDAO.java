package entidadeDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import entidades.Matricula;
import interfaces.InterfaceDAO;
import util.Conexao;

public class MatriculaDAO implements InterfaceDAO<Matricula>
{
	/*
    CREATE TABLE Matricula (
    cd_aluno integer NOT NULL,
    cd_disciplina integer NOT NULL,
    dt_matricula Date NOT NULL,
    fl_status_matricula char(01) NOT NULL,
    PRIMARY KEY (cd_aluno, cd_disciplina)
	 */

	@Override
	public boolean executaSalvarBD(Matricula x) 
	{
		Connection con = Conexao.conectar();

		String sql =  "insert into matricula(cd_aluno, cd_disciplina, dt_matricula, fl_status_matricula) "
					+ "values(?,?,?,?)";

		try 
		{
			PreparedStatement stm = con.prepareStatement(sql);
			
			stm.setInt(1, x.getCodigoAluno());
			stm.setInt(2, x.getCodigoDisciplina());
			stm.setObject(3, x.getDataMatricula());
			stm.setString(4, String.valueOf(x.getStatusMatricula()));
			
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

	public boolean salvaMatriculaBD(Matricula m)
	{
		if (!executaSalvarBD(m))
		{
			System.out.println("ERRO!");
			return false;
		}
		
		System.out.println("MATRÍCULA EFETUADA COM SUCESSO");
		return true;
	}
	
	@Override
	public boolean executaUpdateBD(Matricula x) {
		String sql = "update matricula set cd_aluno = ?, cd_disciplina = ?, dt_matricula = ?,"
				   + "fl_status_matricula = ? where cd_aluno = ? AND cd_disciplina = ?" ;
		
		PreparedStatement stm;
		try 
		{
			stm = Conexao.conectar().prepareStatement(sql);
			stm.setInt(1, x.getCodigoAluno());
			stm.setInt(2, x.getCodigoDisciplina());
			stm.setObject(3, x.getDataMatricula());
			stm.setString(4, String.valueOf(x.getStatusMatricula()));
			stm.setInt(5, x.getCodigoAluno());
			stm.setInt(6, x.getCodigoDisciplina());
			
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

	public boolean alteraDadosMatriculaBD()
	{
		// retorna um objeto de aluno buscado pelo id
		Matricula matricula = new MatriculaDAO().retornaUmObjetoBDPorDoisID(1,1);
		matricula.setStatusMatricula("F");
		
		if (!executaUpdateBD(matricula))
		{
			System.out.println("OS DADOS DA MATRICULA NÃO FORAM ALTERADOS. FALHA");
			return false;
		}
		
		System.out.println("DADOS ALTERADOS SALVOS COM SUCESSO NO BANCO DE DADOS.");
		return true;
	}
	
	@Override
	public boolean executaExcluirBD(Matricula x) {
		String sql = "delete from matricula where cd_disciplina = ? AND cd_aluno = ?";
		try 
		{
			PreparedStatement stm = Conexao.conectar().prepareStatement(sql);
			// consultando na coluna ID do banco o valor de id do carro recebido
			stm.setInt(1, x.getCodigoDisciplina());
			stm.setInt(2, x.getCodigoAluno());
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

	public boolean excluiMatriculaBD(int cd_aluno, int cd_disciplina)
	{
		Matricula matricula = new MatriculaDAO().retornaUmObjetoBDPorDoisID(cd_aluno, cd_disciplina);
		
		if (new MatriculaDAO().executaExcluirBD(matricula)) 
		{
			System.out.println("MATRICULA EXCLUÍDA COM SUCESSO.");
			return true;
		}
		else
		{
			System.out.println("FALHA NA EXCLUSÃO DA MATRICULA.");
			return false;
		}
	}
	
	public Matricula retornaUmObjetoBDPorDoisID(int cd_aluno, int cd_disciplina) 
	{
		Matricula matricula = null;
		
		String sql = "select * from matricula where cd_aluno = " + cd_aluno + " AND cd_disciplina = " + cd_disciplina;
		try 
		{
			PreparedStatement stm = Conexao.conectar().prepareStatement(sql);

			ResultSet rs = stm.executeQuery();

			if (rs.next()) 
			{
				matricula = new Matricula(rs.getInt("cd_aluno"),
									rs.getInt("cd_disciplina"),
								  	rs.getObject("dt_matricula", LocalDate.class),
								  	rs.getString("fl_status_matricula"));
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
		
		return matricula;
	}

	@Override
	public List<Matricula> retornarTodosBD() {
		List<Matricula> matriculas = new ArrayList<>();
		
		String sql = "select * from matricula";
		
		try 
		{
			PreparedStatement stm = Conexao.conectar().prepareStatement(sql);
			ResultSet rs = stm.executeQuery();

			while (rs.next())
			{
				matriculas.add(new Matricula(rs.getInt("cd_aluno"),
						rs.getInt("cd_disciplina"),
					  	rs.getObject("dt_matricula", LocalDate.class),
					  	rs.getString("fl_status_matricula")));
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
		return matriculas;
	}
	
	public void retornaTodasMatriculasBD()
	{
		List<Matricula> matriculas = new MatriculaDAO().retornarTodosBD();
		
		for (Matricula m : matriculas)
		{
			System.out.println(m.getCodigoAluno());
			System.out.println(m.getCodigoDisciplina());
			System.out.println(m.getDataMatricula());
			System.out.println(m.getStatusMatricula());
			System.out.println("+=+=+=+=+=+=");
		}
	}
}
