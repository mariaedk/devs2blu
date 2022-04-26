package br.com.projetosaula.springprojetoturmas.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

// superclasse -> conceito de herança
@Entity
public class Pessoa 
{
	@Id // é uma chave primária
	@GeneratedValue(strategy = GenerationType.IDENTITY) // informação gerada pelo banco, vai ter uma sequência
	private Integer id; // usar o integer pois é um objeto, pode comparar com null e spring boot pede um tipo "Objeto"
	
	private String nome;
	private int idade;
	private String endereco;
	private String sexo;
	
	@OneToOne
	private Aluno aluno;
	
	public Pessoa() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

}
