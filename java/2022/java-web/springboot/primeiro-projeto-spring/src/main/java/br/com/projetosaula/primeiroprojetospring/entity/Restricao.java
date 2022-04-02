package br.com.projetosaula.primeiroprojetospring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Restricao 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment
	private Long id;
	
	@Column(unique = true)
	private String descricao;
	
	private int idade;

	public Restricao()
	{}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
	

}
