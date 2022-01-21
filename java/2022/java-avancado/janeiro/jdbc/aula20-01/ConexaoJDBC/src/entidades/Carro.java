package entidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import uteis.Conexao;

public class Carro 
{
	
	// criando a entidade carro e seus atributos que tem também no banco de dados
	private int id;
	private String placa;
	private String modelo;
	private String marca;
	
	// getters e setters
	public int getId() 
	{
		return id;
	}
	public void setId(int id) 
	{
		this.id = id;
	}
	public String getPlaca() 
	{
		return placa;
	}
	public void setPlaca(String placa) 
	{
		this.placa = placa;
	}
	public String getModelo()
	{
		return modelo;
	}
	public void setModelo(String modelo)
	{
		this.modelo = modelo;
	}
	public String getMarca() 
	{
		return marca;
	}
	public void setMarca(String marca)
	{
		this.marca = marca;
	}
	
	// salva carro
	public boolean salvarCarroBd() 
	{
		Connection con = Conexao.getConexao();
		
		// não precisa do ID pois ele é um serial, auto incrementa
		String sql =  "insert into carro(nr_placa, nm_marca, nm_modelo) values(?,?,?)";
		
		// tratar exceção
		try 
		{
			// cria um objeto de prepared Statement
			PreparedStatement stm = con.prepareStatement(sql);
			// adiciona em nr_placa (key 1), o this.placa
			// adiciona em nm_marca (key 2), o this.marca
			// adiciona em nm_modelo(key 3), o this.modelo
			// esses números 1,2 e 3, correspondem aos values(?,?,?), em sequência
			stm.setString(1, this.placa);
			stm.setString(2, this.marca);
			stm.setString(3, this.modelo);
			
//			comando execute finaliza a transação no banco
			stm.execute();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return true;
	}
	
	// monta uma string de consulta que retorna somente um item
	// vai filtrar pelo id, ou seja, solicita os dados de um ID que será
	// passado como parametro
	public Carro consultarCarroPeloId(int id)
	{
		// criou um objeto carro
		// o método retorna dados de um carro selecionado por seu id
		// assim, com o objeto de carro criado, pegamos os dados que retornam do banco
		// e setamos neste novo objeto de carro, os dados retornados.
		// por fim, retornamos um objeto de carro com todos os dados do banco setados neste objeto.
		Carro carro = new Carro();
		String sql = "select * from carro where id = " + id;
		try 
		{
//			mesma coisa que:
//			Connection con = Conexao.getConexao();
//			PreparedStatement stm = con.prepareStatement(sql);
			
			PreparedStatement stm = Conexao.getConexao().prepareStatement(sql);
			
			// classe que recebe dados
			ResultSet rs = stm.executeQuery();
			if (rs.next()) // no executeQuery, vai avançar para a proxima linha. Se tem uma proxima linha, vai posicionar o cursor ali e trazer os dados
			{
				// significa que retornou true (booleano)
				carro.setId(rs.getInt("id"));
				carro.setPlaca(rs.getString("nr_placa"));
				carro.setMarca(rs.getString("nm_marca"));
				carro.setModelo(rs.getString("nm_modelo"));
			}
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return carro;
	}
	
	public List<Carro> consultarTodosCarros()
	{
		List<Carro> carros = new ArrayList<>();
		
		String sql = "select * from carro";
		
		try 
		{
			PreparedStatement stm = Conexao.getConexao().prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			
			// cada linha traz um objeto carro
			while (rs.next())
			{
				Carro carro = new Carro();
				carro.setId(rs.getInt("id"));
				carro.setPlaca(rs.getString("nr_placa"));
				carro.setMarca(rs.getString("nm_marca"));
				carro.setModelo(rs.getString("nm_modelo"));
				
				// tenho um objeto carro com os atributos setados, então adiciono na lista
				carros.add(carro);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return carros;
	}

	public void mostrarInformacoesCarro(Carro carro)
	{
		System.out.println("Id: " + carro.getId());
		System.out.println("Placa: " + carro.getPlaca());
		System.out.println("Modeo: " + carro.getModelo());
		System.out.println("Marca: " + carro.getMarca());
	}

	public boolean deletarCarroBd(int id)
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
		
		return true;
	}
	
	public boolean alterarCarroBd()
	{

		String sql = "update carro set nr_placa = ?, nm_marca = ?, nm_modelo = ? where id = ?";
		
		PreparedStatement stm;
		try 
		{
			stm = Conexao.getConexao().prepareStatement(sql);
			stm.setString(1, this.placa);
			stm.setString(2, this.marca);
			stm.setString(3, this.modelo);
			stm.setInt(4, this.id);
			stm.execute();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		
		return true;
	}
}
