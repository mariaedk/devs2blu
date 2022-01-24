package uteis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao 
{
	static final String url = "jdbc:postgresql://localhost:5432/postgres";
	static final String user = "postgres";
	static final String password = "admin";
	
	public static Connection getConexao()
	{
		Connection con = null;
		try 
		{
			Class.forName("org.postgresql.Driver");
			
			con = DriverManager.getConnection(url, user, password);
		} 
		catch (SQLException | ClassNotFoundException ex)
		{
			ex.printStackTrace();
		}
		return con;
	}

	// método para fechar conexão com o banco de dados
	public static void closeConexao()
	{
		try 
		{
			Conexao.getConexao().close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}