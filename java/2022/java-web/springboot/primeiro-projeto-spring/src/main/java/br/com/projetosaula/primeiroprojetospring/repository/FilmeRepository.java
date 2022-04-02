package br.com.projetosaula.primeiroprojetospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.projetosaula.primeiroprojetospring.entity.Filme;

// extendendo uma especificação da JPA, em termos de execução
// ele te da uma implementação em base naquilo q vc forneceu pra ele

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long>
{
	// reconhece automaticamente que eu quero pegar um titulo
	// cria sql automático
	// cria um  sql com base nos campos do banco de dados em tempo de execucao
	
	// findBy -> entende que é pra usar um sql de consulta
	// ao anotar colunas, ele consegue identificar que existe uma coluna chamada genero
	// o getByID ja existe no JpaRepository
	// conceito de interface com banco -> camada que cria um serviço, a interface com a tabela e o banco de dados -> injenção por interface
	
	public Filme findByGenero(String genero);
}
