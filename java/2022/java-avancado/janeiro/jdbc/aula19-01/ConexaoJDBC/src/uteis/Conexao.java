package uteis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao 
{
	// setando atributos com a url, usuário e senha do bd
	static final String url = "jdbc:postgresql://localhost:5432/postgres";
	static final String user = "postgres";
	static final String password = "admin";
	
	public static Connection getConexao()
	{
		Connection con = null;
		try 
		{
//			tem que estar dentro de um método
			Class.forName("org.postgresql.Driver");
			
			con = DriverManager.getConnection(url, user, password);
		} 
		catch (SQLException | ClassNotFoundException ex)
		{
			ex.printStackTrace();
		}
		return con;
	}
}
