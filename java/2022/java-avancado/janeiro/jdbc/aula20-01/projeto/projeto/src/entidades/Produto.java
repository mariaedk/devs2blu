package entidades;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import uteis.ConexaoBancoDados;

public class Produto 
{
//	atributos
	private String nome;
	private String dscProduto;
	private short qtdEstoque;
	
	public Produto(String nome, String dscProduto, short qtdEstoque)
	{
		this.setNome(nome);
		this.setDscProduto(dscProduto);
		this.setQtdEstoque(qtdEstoque);
	}

//	getters e setters
	public String getNome() 
	{
		return nome;
	}
	
	public void setNome(String nome) 
	{
		this.nome = nome;
	}
	
	public String getDscProduto() 
	{
		return dscProduto;
	}
	
	public void setDscProduto(String dscProduto) 
	{
		this.dscProduto = dscProduto;
	}
	
	public int getQtdEstoque()
	{
		return qtdEstoque;
	}
	
	public void setQtdEstoque(short qtdEstoque)
	{
		this.qtdEstoque = qtdEstoque;
	}
	
//	m?todos
	
	public boolean inserirProdutoBD()
	{
		String sqlQuery = "insert into produto(nm_produto, dsc_produto, qtd_estoque) values(?,?,?)";
		try 
		{
			PreparedStatement ps = ConexaoBancoDados.getConexao().prepareStatement(sqlQuery);
			
			ps.setString(1, this.getNome());
			ps.setString(2, this.getDscProduto());
			ps.setInt(3, this.getQtdEstoque());
			
			ps.execute();
		}
		
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return true;
	}
	
}
