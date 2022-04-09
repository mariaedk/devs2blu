package br.com.projetosaula.springprojetoturmas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.projetosaula.springprojetoturmas.entity.Aluno;

// Repositório para a entidade Aluno, do tipo Aluno e com o tipo Integer
// Um repositório por entidade
@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer>
{
	
}
