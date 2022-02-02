package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao
{
	static final String url = "jdbc:mysql://localhost:3306/escola";
	static final String user = "root";
	static final String password = "admin";

	public static Connection conectar() 
	{
		Connection con = null;
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
		} 
		catch (SQLException | ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		return con;
	}
	
	
	static void testeConexao()
	{
		if (Conexao.conectar() != null) 
		{
			System.out.println("Conectado.");
		}
		else
		{
			System.out.println("Erro.");
		}
	}

	public static void closeConexao()
	{
		try 
		{
			Conexao.conectar().close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
