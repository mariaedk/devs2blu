package uteis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBancoDados 
{
	static final String url = "jdbc:postgresql://localhost:5432/postgres";
	static final String user = "postgres";
	static final String password = "admin";
	
	public static Connection getConexao()
	{
		Connection conexao = null;
		
		try 
		{
			Class.forName("org.postgresql.Driver");
			conexao = DriverManager.getConnection(url, user, password);
		} 
		catch (SQLException | ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		return conexao;
	}
}
