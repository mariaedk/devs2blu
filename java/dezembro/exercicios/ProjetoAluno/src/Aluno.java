
public class Aluno {
	private String nome;
	private int idade;
	private float mediaAluno;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public float getMediaAluno() {
		return mediaAluno;
	}

	public void setMediaAluno(float mediaAluno) {
		this.mediaAluno = mediaAluno;
	}

	public void listarAluno()
	{
		System.out.println("Nome:" + nome);
		System.out.println("Idade:" + idade);
	}
}
