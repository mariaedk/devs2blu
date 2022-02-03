package entidadeDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import entidades.Aluno;
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
					+ "values(?,?,?,?,?,?)";

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
			System.out.println("MATRÍCULA EFETUADA COM SUCESSO");
			return false;
		}
		
		System.out.println("ERRO: MATRÍCULA FALHOU");
		return true;
	}
	
	@Override
	public boolean executaUpdateBD(Matricula x) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean executaExcluirBD(Matricula x) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Matricula retornaUmObjetoBD(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Matricula> retornarTodosBD() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
