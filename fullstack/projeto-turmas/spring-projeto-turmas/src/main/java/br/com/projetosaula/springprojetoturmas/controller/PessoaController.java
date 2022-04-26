package br.com.projetosaula.springprojetoturmas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetosaula.springprojetoturmas.entity.Pessoa;
import br.com.projetosaula.springprojetoturmas.repository.PessoaRepository;


@CrossOrigin("*") // acessar requisições de qualquer lugar
@RestController // diz que é um controller
@RequestMapping("/api/pessoa") 
public class PessoaController 
{
	// interface que extende outra interface(jpa)
	// em tempo de execução ele disponibiliza uma interface com base nos parâmetros que a gente passa
	// faz uma mediação entre o banco e o back-end
	@Autowired // injeta a implementação (só quando chamar ele implementa a interface)
	PessoaRepository pessoaRepository;
	// quando acessar, vai carregar este método:
	@GetMapping
	public List<Pessoa> getAll()
	{
		// para pegar este método, precisa de um repository
		return pessoaRepository.findAll();
	}
	
	// annotation é um recurso que decora a classe e esse decorator tem um significado de execução
	// o controller -> vai fazer as requisições, ele é o servidor
	
	@PostMapping
	public ResponseEntity<Pessoa> addPessoa(@RequestBody Pessoa pessoa) // @RequestBody -> vai pegar no corpo da requisição, o objeto Pessoa
	{
		// interface com o banco
		// devolve o objeto pessoa com o id dela
		Pessoa pessoaResponse = pessoaRepository.save(pessoa);
		 
		// status 200 (tudo ok) e no corpo vai retornar a entidade que acabou de ser persistida
		return new ResponseEntity<Pessoa>(pessoaResponse, HttpStatus.CREATED);
	}
}
