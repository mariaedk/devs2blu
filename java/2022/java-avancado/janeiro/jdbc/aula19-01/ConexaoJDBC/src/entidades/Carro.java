package entidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import uteis.Conexao;

public class Carro 
{
	
	// criando a entidade carro e seus atributos que tem tamb?m no banco de dados
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
	public boolean salvarCarroBd() 
	{
		Connection con = Conexao.getConexao();
		
		// n?o precisa do ID pois ele ? um serial, auto incrementa
		String sql =  "insert into carro(nr_placa, nm_marca, nm_modelo) values(?,?,?)";
		
		// tratar exce??o
		try 
		{
			// cria um objeto de prepared Statement
			PreparedStatement stm = con.prepareStatement(sql);
			// adiciona em nr_placa (key 1), o this.placa
			// adiciona em nm_marca (key 2), o this.marca
			// adiciona em nm_modelo(key 3), o this.modelo
			// esses n?meros 1,2 e 3, correspondem aos values(?,?,?), em sequ?ncia
			stm.setString(1, this.placa);
			stm.setString(2, this.marca);
			stm.setString(3, this.modelo);
			
//			comando execute finaliza a transa??o no banco
			stm.execute();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return true;
	}
}
