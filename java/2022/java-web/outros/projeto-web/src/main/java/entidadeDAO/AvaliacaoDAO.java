package entidadeDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List; 
import entidades.Avaliacao;
import interfaces.InterfaceDAO;
import util.Conexao;

public class AvaliacaoDAO implements InterfaceDAO<Avaliacao>
{

	@Override
	public boolean executaSalvarBD(Avaliacao x) {
		Connection con = Conexao.conectar();

		String sql =  "insert into avaliacao(cd_aluno, cd_disciplina, nr_avaliacao, vlr_nota) "
					+ "values(?,?,?,?)";

		try 
		{
			PreparedStatement stm = con.prepareStatement(sql);
			
			stm.setInt(1, x.getCodigoAluno());
			stm.setInt(2, x.getCodigoDisciplina());
			stm.setInt(3, x.getNumeroAvaliacao());
			stm.setDouble(4, x.getValorNota());
			
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

	public boolean salvaAvaliacaoBD(Avaliacao a)
	{
		if (!executaSalvarBD(a))
		{
			System.out.println("ERRO!");
			return false;
		}
		
		System.out.println("AVALIACAO EFETUADA COM SUCESSO");
		return true;
	}
	
	@Override
	public boolean executaUpdateBD(Avaliacao x) {
		String sql = "update avaliacao set cd_aluno = ?, cd_disciplina = ?, nr_avaliacao = ?,"
				   + "vlr_nota = ? where cd_aluno = ? AND cd_disciplina = ? AND nr_avaliacao = ?" ;
		
		PreparedStatement stm;
		try 
		{
			stm = Conexao.conectar().prepareStatement(sql);
			stm.setInt(1, x.getCodigoAluno());
			stm.setInt(2, x.getCodigoDisciplina());
			stm.setInt(3, x.getNumeroAvaliacao());
			stm.setDouble(4, x.getValorNota());
			stm.setInt(5, x.getCodigoAluno());
			stm.setInt(6, x.getCodigoDisciplina());
			stm.setInt(7, x.getNumeroAvaliacao());
			
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

	public boolean alteraDadosAvaliacaoBD()
	{
		// retorna um objeto de aluno buscado pelo id
		Avaliacao avaliacao = new AvaliacaoDAO().retornaUmObjetoBDPorTresID(1,1,2);
		avaliacao.setValorNota(8.3);
		
		if (!executaUpdateBD(avaliacao))
		{
			System.out.println("OS DADOS DA AVALIACAO N?O FORAM ALTERADOS. FALHA");
			return false;
		}
		
		System.out.println("DADOS ALTERADOS SALVOS COM SUCESSO NO BANCO DE DADOS.");
		return true;
	}
	
	@Override
	public boolean executaExcluirBD(Avaliacao x) {
		String sql = "delete from avaliacao where cd_disciplina = ? AND cd_aluno = ? AND nr_avaliacao = ?";
		try 
		{
			PreparedStatement stm = Conexao.conectar().prepareStatement(sql);
			// consultando na coluna ID do banco o valor de id do carro recebido
			stm.setInt(1, x.getCodigoDisciplina());
			stm.setInt(2, x.getCodigoAluno());
			stm.setInt(3, x.getNumeroAvaliacao());
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

	public boolean excluiAvaliacaoBD(int cd_aluno, int cd_disciplina, double nr_avaliacao)
	{
		Avaliacao avaliacao = new AvaliacaoDAO().retornaUmObjetoBDPorTresID(cd_aluno, cd_disciplina, nr_avaliacao);
		
		if (new AvaliacaoDAO().executaExcluirBD(avaliacao)) 
		{
			System.out.println("AVALIACAO EXCLU?DA COM SUCESSO.");
			return true;
		}
		else
		{
			System.out.println("FALHA NA EXCLUS?O DA AVALIACAO.");
			return false;
		}
	}
	
	public Avaliacao retornaUmObjetoBDPorTresID(int cd_aluno, int cd_disciplina, double nr_avaliacao) 
	{
		Avaliacao avaliacao = null;
		
		String sql = "select * from avaliacao where cd_aluno = " + cd_aluno + " and cd_disciplina = " + cd_disciplina + " and nr_avaliacao = " + nr_avaliacao;
		try 
		{
			PreparedStatement stm = Conexao.conectar().prepareStatement(sql);

			ResultSet rs = stm.executeQuery();

			if (rs.next()) 
			{
				avaliacao = new Avaliacao(rs.getInt("cd_aluno"),
									rs.getInt("cd_disciplina"),
								  	rs.getInt("nr_avaliacao"),
								  	rs.getDouble("vlr_nota"));
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
		
		return avaliacao;
	}

	@Override
	public List<Avaliacao> retornarTodosBD() {
		List<Avaliacao> avaliacoes = new ArrayList<>();
		
		String sql = "select * from avaliacao";
		
		try 
		{
			PreparedStatement stm = Conexao.conectar().prepareStatement(sql);
			ResultSet rs = stm.executeQuery();

			while (rs.next())
			{
				avaliacoes.add(new Avaliacao(rs.getInt("cd_aluno"),
						rs.getInt("cd_disciplina"),
					  	rs.getInt("nr_avaliacao"),
					  	rs.getDouble("vlr_nota")));
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
		return avaliacoes;
	}
	
	public void retornaTodasAvaliacoesBD()
	{
		List<Avaliacao> avaliacoes = new AvaliacaoDAO().retornarTodosBD();
		
		for (Avaliacao a : avaliacoes)
		{
			System.out.println(a.getCodigoAluno());
			System.out.println(a.getCodigoDisciplina());
			System.out.println(a.getNumeroAvaliacao());
			System.out.println(a.getValorNota());
			System.out.println("+=+=+=+=+=+=");
		}
	}

}
