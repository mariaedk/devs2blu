package br.com.projetosaula.springprojetoturmas.entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Turma 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String periodo;
	private int maxAlunos;
	
	// existe um relacionamento entre turma e aluno.
	// cria um one to many.
	// precisa de um mapeamento. diz qual a coluna para fazer um join
	// inner join -> tem que existir nos dois
	
	@OneToMany(mappedBy = "turma") // vai mapear os alunos pela turma
	private List<Aluno> alunos;
	
	@OneToOne
	@JoinColumn(name = "professor_id")
	private Professor professor;
	
	public Turma() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public int getMaxAlunos() {
		return maxAlunos;
	}

	public void setMaxAlunos(int maxAlunos) {
		this.maxAlunos = maxAlunos;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos)
	{
		// se a lista que estou tentando inserir for menor ou igual(qtd de alunos dentro dela) a quantidade que a turma permite, posso inserir
		if (alunos.size() <= getMaxAlunos())
		{
			this.alunos = alunos;
		}
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public void addAluno(Aluno aluno)
	{
		// se a qtd de alunos for menor do que a quantidade máxima permitida, posso inserir mais um aluno
		if (getAlunos().size() < getMaxAlunos())
		{
			getAlunos().add(aluno);
		}
	}

}
