package entidadesDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entidades.Carro;
import interfaces.InterfaceDAO;
import uteis.Conexao;

public class CarroDAO implements InterfaceDAO<Carro>
{

	@Override
	public boolean salvar(Carro t) 
	{
		Connection con = Conexao.getConexao();

		String sql =  "insert into carro(nr_placa, nm_marca, nm_modelo) values(?,?,?)";

		try 
		{
			PreparedStatement stm = con.prepareStatement(sql);
			
			stm.setString(1, t.getPlaca());
			stm.setString(2, t.getMarca());
			stm.setString(3, t.getModelo());
			
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
	
	public Carro atribuiInformacoesCarro()
	{
		Carro carro = new Carro();
		
		carro.setPlaca("dsi9842");
		carro.setMarca("nyjmtd");
		carro.setModelo("wemrdiwe");
		
		return carro;
	}

	public boolean salvarCarroBD(Carro carro)
	{
		if (salvar(carro))
		{
			System.out.println("Carro salvo!");
			return true;
		}
		else
		{
			System.out.println("Carro n?o salvo!");
			return false;
		}
	}

	@Override
	public boolean update(Carro t) 
	{
		String sql = "update carro set nr_placa = ?, nm_marca = ?, nm_modelo = ? where id = ?";
		
		PreparedStatement stm;
		try 
		{
			stm = Conexao.getConexao().prepareStatement(sql);
			stm.setString(1, t.getPlaca());
			stm.setString(2, t.getMarca());
			stm.setString(3, t.getModelo());
			stm.setInt(4, t.getId());
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
	
	// exclui pelo id
	@Override
	public boolean excluir(int id)
	{
		String sql = "delete from carro where id =" + id;
		try 
		{
			PreparedStatement stm = Conexao.getConexao().prepareStatement(sql);

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
	
	// exclui pelo objeto
	public boolean excluir (Carro t)
	{
		String sql = "delete from carro where id =?";
		try 
		{
			PreparedStatement stm = Conexao.getConexao().prepareStatement(sql);
			// consultando na coluna ID do banco o valor de id do carro recebido
			stm.setInt(1, t.getId());
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
	public Carro retornarUm(int id)
	{
		Carro carro = null;
		
		String sql = "select * from carro where id = " + id;
		try 
		{
			PreparedStatement stm = Conexao.getConexao().prepareStatement(sql);

			ResultSet rs = stm.executeQuery();
			if (rs.next()) 
			{
				carro = new Carro(rs.getInt("id"), 
								  rs.getString("nr_placa"), 
								  rs.getString("nm_modelo"), 
								  rs.getString("nm_marca"));
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
		
		return carro;
	}

	@Override
	public List<Carro> retornarTodos() 
	{
		List<Carro> carros = new ArrayList<>();
		
		String sql = "select * from carro";
		
		try 
		{
			PreparedStatement stm = Conexao.getConexao().prepareStatement(sql);
			ResultSet rs = stm.executeQuery();

			while (rs.next())
			{
//				Carro carro = new Carro();
//				carro.setId(rs.getInt("id"));
//				carro.setPlaca(rs.getString("nr_placa"));
//				carro.setMarca(rs.getString("nm_marca"));
//				carro.setModelo(rs.getString("nm_modelo"));
				carros.add(new Carro(rs.getInt("id"), rs.getString("nr_placa"), 
									 rs.getString("nm_modelo"), rs.getString("nm_marca")));
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
		return carros;
	}

	

	
	
//	tentativa de chamar os m?todos criados no Main pelo CarroDAO
	public void chamaUpdate()
	{
		Carro carro = new CarroDAO().retornarUm(11);
		carro.setModelo("charrete");
		if (new CarroDAO().update(carro))
		{
			System.out.println("Carro alterado com sucesso.");
		}
	}

	public void excluirPorObjeto() 
	{
		Carro carro = new CarroDAO().retornarUm(11);
		
		if (new CarroDAO().excluir(carro)) 
		{
			System.out.println("carro excluido com sucesso");
		}
	}

	public void chamaExcluir()
	{
		if (new CarroDAO().excluir(14)) 
		{
			System.out.println("carro excluido com sucesso");
		}
	}
	
	public void chamaRetornaTodos()
	{
		List<Carro> carros = new CarroDAO().retornarTodos();
		
		for (Carro c : carros)
		{
			System.out.println(c.getId());
			System.out.println(c.getPlaca());
			System.out.println(c.getMarca());
			System.out.println(c.getModelo());
		}
	}
}
