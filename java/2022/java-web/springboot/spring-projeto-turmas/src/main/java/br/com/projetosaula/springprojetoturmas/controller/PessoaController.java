package br.com.projetosaula.springprojetoturmas.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.projetosaula.springprojetoturmas.entity.Pessoa;
import br.com.projetosaula.springprojetoturmas.repository.PessoaRepository;


@CrossOrigin("*") // acesso de qualquer lugar
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
}
