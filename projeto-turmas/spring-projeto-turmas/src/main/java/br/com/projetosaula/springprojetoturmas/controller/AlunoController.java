package br.com.projetosaula.springprojetoturmas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetosaula.springprojetoturmas.entity.Aluno;
import br.com.projetosaula.springprojetoturmas.entity.Pessoa;
import br.com.projetosaula.springprojetoturmas.repository.AlunoRepository;
import br.com.projetosaula.springprojetoturmas.repository.PessoaRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/aluno")
public class AlunoController 
{
	@Autowired
	AlunoRepository alunoRepository;
	
	@Autowired
	PessoaRepository pessoaRepository;
	
	@GetMapping // quando tiver uma requisição get vai pegar este método
	public List<Aluno> getAll()
	{
		return alunoRepository.findAll();
	}
	
	public ResponseEntity<Aluno> getById(@PathVariable Integer id) throws Exception
	{
		Aluno aluno = alunoRepository.findById(id).orElseThrow(() -> new Exception("Id aluno não encontrado"));
		return new ResponseEntity<Aluno>(aluno, HttpStatus.OK);
	}
	
	
	@PostMapping
	public ResponseEntity<Aluno> addAluno(@RequestBody Aluno aluno)
	{
		// para salvar o aluno, é necessário que haja uma pessoa no banco de dados, pois precisa do id dela
		// retorna o objeto aluno COM pessoa Id e coloca dentro de pessoaAluno
		Pessoa pessoaAluno = pessoaRepository.save(aluno.getPessoa());
		aluno.setPessoa(pessoaAluno);
		// salva o aluno COM pessoa Id
		Aluno alunoResponse = alunoRepository.save(aluno);
		
		return new ResponseEntity<Aluno>(alunoResponse, HttpStatus.CREATED);
	}
	
	@DeleteMapping
	public boolean delAluno(@RequestBody Integer id) throws Exception
	{
		// valida se aluno existe
		Aluno aluno = alunoRepository.findById(id).orElseThrow(() -> new Exception("Id Aluno não encontrado"));
		Pessoa pessoa = pessoaRepository.findById(aluno.getPessoa().getId()).orElseThrow(() -> new Exception("Id pessoa não encontrado"));
		
		alunoRepository.delete(aluno);
		pessoaRepository.delete(pessoa);
		
		return true;
	}
}
