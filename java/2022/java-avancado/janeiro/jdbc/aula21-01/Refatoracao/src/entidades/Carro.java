package entidades;

public class Carro 
{
	private int id;
	private String placa;
	private String modelo;
	private String marca;
	
//	principio da sobrecarga: métodos com o mesmo nome mas parametros diferentes
	
	public Carro() 
	{
		
	}
	
	public Carro(String placa, String modelo, String marca)
	{
		this.placa = placa;
		this.modelo = modelo;
		this.marca = marca;
	}
	
	public Carro(int id, String placa, String modelo, String marca) 
	{
		this.id = id;
		this.placa = placa;
		this.modelo = modelo;
		this.marca = marca;
	}

	//	getters e setters
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
	
}
