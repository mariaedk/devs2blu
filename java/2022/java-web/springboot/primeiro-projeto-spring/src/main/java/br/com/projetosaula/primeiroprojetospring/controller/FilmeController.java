package br.com.projetosaula.primeiroprojetospring.controller;

import java.util.List;

import javax.websocket.server.PathParam;

// CRUD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.projetosaula.primeiroprojetospring.entity.Filme;
import br.com.projetosaula.primeiroprojetospring.repository.FilmeRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/filmes")
public class FilmeController {
	
	@Autowired // injetou a interface pra o spring fazer o gerenciamento
	FilmeRepository filmeRepository;

	public FilmeController() {}
	
	@GetMapping
	public List<Filme> getList()
	{
		// em http://localhost:8080/filmes imprimiu Hello World na tela
		
		// vai retornar a entidade que foi passada (uma lista)
		return filmeRepository.findAll();
		
	}
	
	@GetMapping("/{titulo}")
	// validate -> verifica se o parametro, objeto é valido, se há algum erro
	public Filme getFilmeById(@PathVariable("titulo") String titulo)
	{ 
		return filmeRepository.findByTitulo(titulo);
	}
	
	

}
