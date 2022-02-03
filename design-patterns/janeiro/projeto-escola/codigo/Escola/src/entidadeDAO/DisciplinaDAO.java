package entidadeDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import entidades.Aluno;
import entidades.Disciplina;
import interfaces.InterfaceDAO;
import util.Conexao;

public class DisciplinaDAO implements InterfaceDAO<Disciplina>
{

	/*
	 * CREATE TABLE Disciplina (
    cd_disciplina integer auto_increment,
    nm_disciplina varchar(40) NOT NULL,
    nm_professor varchar(40) NOT NULL,
    qtd_avaliacoes int NOT NULL,
    PRIMARY KEY (cd_disciplina)
);
	 */
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
			System.out.println("DISCIPLINA N�O FOI SALVA COM SUCESSO");
			return false;
		}
		
		System.out.println("DISCIPLINA SALVA COM SUCESSO");
		return true;
	}
	
	
	@Override
	public boolean executaUpdateBD(Disciplina x) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean executaExcluirBD(Disciplina x) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Disciplina retornaUmObjetoBD(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Disciplina> retornarTodosBD() {
		// TODO Auto-generated method stub
		return null;
	}

}
