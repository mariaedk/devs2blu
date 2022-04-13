package br.com.projetosaula.springprojetoturmas.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Aluno // extends Pessoa ->  nao herda mais os atributos de Pessoa, vai incorporar como atributo na classe
{
	// atributos
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	// relacionamento um para um com a tabela turma
	@OneToOne
	@JoinColumn(name = "turma_id") // um aluno vai estar em uma turma
	private Turma turma;           // ele sabe que é a tabela Turma pois a classe Turma está mapeada como Turma
	
	@OneToOne
	@JoinColumn(name = "pessoa_id")
	private Pessoa pessoa; // atributo pessoa_id no banco
	
	private int ano;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	// getters e setters
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}


	public Aluno() {}
}
