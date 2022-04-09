package br.com.projetosaula.springprojetoturmas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.projetosaula.springprojetoturmas.entity.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer>
{
	
}
