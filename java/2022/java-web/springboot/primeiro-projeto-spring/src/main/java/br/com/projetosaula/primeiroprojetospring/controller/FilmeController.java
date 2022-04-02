package br.com.projetosaula.primeiroprojetospring.controller;

import java.util.List;

// CRUD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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
	
	// http://localhost:8080/filmes/Avatar
	// puxa um arquivo json do Avatar
	
	@GetMapping("/{id}")
	// validate -> verifica se o parametro, objeto é valido, se há algum erro
	public Filme getFilmeById(@PathVariable("id") Long id) throws Exception
	{ 
		
		Filme filme = filmeRepository.findById(id).orElseThrow(() -> new Exception("Filme Não Encontrado com o Id " + id));
		
		return filme;
	}
	
	// annotation é um recurso que decora a classe e esse decorator tem um significado de execução
	// o controller -> vai fazer as requisições, ele é o servidor
	
	// CREATE
	// POST
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED) // quando salvar, vai responder 201 -> "Created".
	public boolean saveFilme(@RequestBody Filme filme) throws Exception
	{
		// caso seja um post de um filme sem dados...
		if (filme == null) 
		{
			return false;
		}
		
		// se não..
		filmeRepository.save(filme);
		return true;
	}
	
	// UPDATE
	@PutMapping
	@ResponseStatus(code = HttpStatus.OK) // quando salvar, vai atualizar
	public boolean editFilme(@RequestBody Filme filme) throws Exception
	{
		if (filme.getId() == null)
		{
			throw new Exception("Registro sem ID!");
		}
		
		filmeRepository.findById(filme.getId()).orElseThrow(
								 () -> new Exception("Registro não encontrado!"));
								// () -> lambda function (função criada em tempo de execução)
		
		// se não..
		filmeRepository.save(filme);
		return true;
	}
	
	// DELETE
	@DeleteMapping
	@ResponseStatus(code = HttpStatus.OK) // ok -> é pra saber que o comando foi executado corretamente
	public boolean deleteFilme(@RequestBody Long id) throws Exception
	{
		filmeRepository.findById(id).orElseThrow(
		() -> new Exception("Registro não encontrado!"));
		filmeRepository.deleteById(id);
		return true;
	}
	
	
}
