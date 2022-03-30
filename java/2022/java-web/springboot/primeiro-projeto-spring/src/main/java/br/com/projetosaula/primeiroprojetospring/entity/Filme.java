package br.com.projetosaula.primeiroprojetospring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity //(name = "tbfilme") -> criaria a tabela com o nome tbfilme
public class Filme 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment
	private Long id;
	
	@Column // (unique = true) -> faria com que fosse único
	private String titulo;
	
	@Column // coluna do banco
	private String genero;
	
	@Column
	private int restricao;
	
	@Column
	private int favorito;
	
	public Filme() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getRestricao() {
		return restricao;
	}

	public void setRestricao(int restricao) {
		this.restricao = restricao;
	}

	public int getFavorito() {
		return favorito;
	}

	public void setFavorito(int favorito) {
		this.favorito = favorito;
	}
	
	

}
