package principal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Livro 
{
	@Id
	// faz com que a JPA gerencie a geração de valores únicos (id)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLivro;
	
	@Column(length = 25)
	private String nomeLivro;
	
	@Column(length = 100)
	private String descLivro;
	
	// getters e setters
	public Long getIdLivro() {
		return idLivro;
	}
	public void setIdLivro(Long idLivro) {
		this.idLivro = idLivro;
	}
	public String getNomeLivro() {
		return nomeLivro;
	}
	public void setNomeLivro(String nomeLivro) {
		this.nomeLivro = nomeLivro;
	}
	public String getDescLivro() {
		return descLivro;
	}
	public void setDescLivro(String descLivro) {
		this.descLivro = descLivro;
	}
	
	
	
}
