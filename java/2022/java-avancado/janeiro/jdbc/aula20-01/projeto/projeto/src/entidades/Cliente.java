package entidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import uteis.ConexaoBancoDados;

public class Cliente 
{
//	atributos
	private String nome;
	private LocalDate dataNascimento;
	private String cpf;
	private String nomeMunicipio;
	
//	construtor
	public Cliente(String nome, LocalDate dataNascimento, String cpf, String nomeMunicipio)
	{
		this.setNome(nome);
		this.setDataNascimento(dataNascimento);
		this.setCpf(cpf);
		this.setNomeMunicipio(nomeMunicipio);
	}

//	getters e setters
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNomeMunicipio() {
		return nomeMunicipio;
	}
	public void setNomeMunicipio(String nomeMunicipio) {
		this.nomeMunicipio = nomeMunicipio;
	}
	
	public boolean inserirClienteBD() 
	{
		Connection conexao = ConexaoBancoDados.getConexao();

		String sql =  "INSERT INTO cliente(nm_cliente, dt_nascimento, nr_cpf, nm_municipio) values(?,?,?,?)";
		
		// tratar exce??o
		try 
		{
			// cria um objeto de prepared Statement
			PreparedStatement stm = conexao.prepareStatement(sql);

			stm.setString(1, this.getNome());
			stm.setObject(2, this.getDataNascimento());
			stm.setString(3, this.getCpf());
			stm.setString(4, this.getNomeMunicipio());
			
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
