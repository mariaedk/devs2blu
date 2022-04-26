package br.com.projetosaula.anotacoes.controller;

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

import br.com.projetosaula.anotacoes.data.dto.CategoriaDTO;
import br.com.projetosaula.anotacoes.service.CategoriaService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/categorias")
public class CategoriaController
{
	@Autowired
	CategoriaService categoriaService;
	
	@GetMapping
	public List<CategoriaDTO> getAll()
	{
		return categoriaService.getAll();
	}
	
	@GetMapping("/{id}")
	public CategoriaDTO getById(@PathVariable("id") Integer id) throws Exception
	{
		return categoriaService.getById(id);
	}
	
	@PostMapping
	public ResponseEntity<CategoriaDTO> save(@RequestBody CategoriaDTO categoria)
	{
		return new ResponseEntity<CategoriaDTO>(categoriaService.save(categoria), HttpStatus.CREATED);
	}
	
	@DeleteMapping
	public boolean delete(@PathVariable Integer idCategoria)
	{
		return categoriaService.delete(idCategoria);
	}
	
	@PostMapping("/toggleAtivo")
	public boolean toggleAtivo(@RequestBody Integer idCategoria)
	{
		return categoriaService.toggle(idCategoria);
	}
}
