package EncapsulamentoModel;

public class Livro {
	/**
	 * Classe utilizada para representar o Livro.
	 */
	
		/* atributos privados se tornam encapsulados. N�o ficam mais vis�veis 
	   	para outras classes.
	    Nessa situa��o o acesso aos mesmo se d� atrav�s dos m�todos
	    Get e Set criados para esses atributos
	    */
	    private String titulo;
	    private String autor;

	    // usando o m�todo toString() para listar os dados dos atributos da classe
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
