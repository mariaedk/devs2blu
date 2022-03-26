package br.com.projetosaula.meusfilmes.beans;

import java.io.Serializable;

public class Filme implements Serializable
{
	// cria um hash da classe, vai ter uma identificação
	// é representado por um long (L)
	// pode ser 1L para qualquer classe, ele vai comparar o serialVersion e todas as outras caracteristicas para validar
	private static final long serialVersionUID = 1L;
	
	// int =!= integer (integer é uma classe -> objeto)
	// int = tipo primitivo, nunca vai ser nulo
	private int id;
	private String titulo;
	private String genero;
	private int restricao;
	private boolean favorito;
	
	// construtor vazio
	public Filme()
	{}
	
	// construtor com parametros
	public Filme(int id, String titulo, String genero, int restricao, boolean favorito)
	{
		this.setId(id);
		this.setTitulo(titulo);
		this.setGenero(genero);
		this.setRestricao(restricao);
		this.setFavorito(favorito);
	}

	// getters/setters
	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getTitulo() 
	{
		return titulo;
	}

	public void setTitulo(String titulo) 
	{
		this.titulo = titulo;
	}

	public String getGenero()
	{
		return genero;
	}

	public void setGenero(String genero) 
	{
		this.genero = genero;
	}

	public int getRestricao() 
	{
		return restricao;
	}

	public void setRestricao(int restricao)
	{
		this.restricao = restricao;
	}

	public boolean isFavorito() 
	{
		return favorito;
	}

	public void setFavorito(boolean favorito) 
	{
		this.favorito = favorito;
	}
	
	
	
	
}
