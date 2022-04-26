package br.com.projetosaula.springprojetoturmas.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Professor // extends Pessoa
{
	// atributos
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	// professor tem um relacionamento de um para um com Pessoa e pede pra juntar a coluna turma_id
	@OneToOne
	@JoinColumn(name = "turma_id") // um professor para uma turma
	private Turma turma;
	
	@OneToOne
	@JoinColumn(name="pessoa_id")
	private Pessoa pessoa; // atributo pessoa_id no banco
	
	
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Professor() {}


}
