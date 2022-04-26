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
import org.springframework.web.bind.annotation.RestController;

import br.com.projetosaula.springprojetoturmas.entity.Pessoa;
import br.com.projetosaula.springprojetoturmas.entity.Professor;
import br.com.projetosaula.springprojetoturmas.repository.PessoaRepository;
import br.com.projetosaula.springprojetoturmas.repository.ProfessorRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/professor")
public class ProfessorController 
{
	@Autowired
	ProfessorRepository professorRepository;
	@Autowired
	PessoaRepository pessoaRepository;
	
	// GET
	@GetMapping
	public List<Professor> getAll()
	{
		return professorRepository.findAll();
	}
	
	// POST
	@PostMapping
	public ResponseEntity<Professor> addProfessor(@RequestBody Professor professor) throws Exception
	{
		// se um objeto sem id esta sendo enviado, significa que ele tem que ser criado, não existe na base
		if (professor.getPessoa().getId() == null)
		{
			Pessoa pessoaProfessor = pessoaRepository.save(professor.getPessoa());
			professor.setPessoa(pessoaProfessor);
		}
		else
		{
			Pessoa pessoaVerificacao = pessoaRepository.findById(professor.getPessoa().getId()).orElseThrow(() -> new Exception("Pessoa não existe"));
			professor.setPessoa(pessoaVerificacao);
		}
		return new ResponseEntity<Professor>(professorRepository.save(professor), HttpStatus.CREATED);
	}
}
