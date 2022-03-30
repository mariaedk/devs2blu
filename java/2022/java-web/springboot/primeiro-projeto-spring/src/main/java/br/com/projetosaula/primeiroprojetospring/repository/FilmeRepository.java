package br.com.projetosaula.primeiroprojetospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projetosaula.primeiroprojetospring.entity.Filme;

public interface FilmeRepository extends JpaRepository<Filme, Long>
{
	// reconhece automaticamente que eu quero pegar um titulo
	// cria sql automático
	public Filme findByTitulo(String titulo);
	
}
