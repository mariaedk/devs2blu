package EncapsulamentoModel;

public class Livro {
	/**
	 * Classe utilizada para representar o Livro.
	 */
	
		/* atributos privados se tornam encapsulados. Não ficam mais visíveis 
	   	para outras classes.
	    Nessa situação o acesso aos mesmo se dá através dos métodos
	    Get e Set criados para esses atributos
	    */
	    private String titulo;
	    private String autor;

	    // usando o método toString() para listar os dados dos atributos da classe
	    @Override
		public String toString() {
			return "Livro [titulo=" + titulo + ", autor=" + autor + "]";
		}
	    
	    /* Getters e Setters dos atributos desta classe */
	    public String getAutor() {
	        return autor;
	    }

		public void setAutor(String autor) {
	        this.autor = autor;
	    }

	    public String getTitulo() {
	        return titulo;
	    }

	    public void setTitulo(String titulo) {
	        this.titulo = titulo;
	    }
}
