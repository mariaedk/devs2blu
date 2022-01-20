package Classes;

public class Pessoa
{
	private String nome;
	private int idade;
	
	public Pessoa(String nome, int idade) {
		this.setIdade(idade);
		this.setNome(nome);
	}

	public String getNome()
{
		return nome;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public int getIdade() 
	{
		return idade;
	}

	public void setIdade(int idade) 
	{
		this.idade = idade;
	}
	
	public String imprimirDados()
	{
		return "Nome:" + this.getNome() + "\nIdade:" + this.getIdade();
	}
	
	@Override
	public String toString()
	{
		return "Pessoa [nome=" + nome + ", idade=" + idade + "]";
	}
	
}
