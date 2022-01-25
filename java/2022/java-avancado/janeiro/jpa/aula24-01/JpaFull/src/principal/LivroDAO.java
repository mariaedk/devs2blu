package principal;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class LivroDAO 
{
	EntityManagerFactory emf;
	EntityManager em;
	
	public LivroDAO()
	{
		emf = Persistence.createEntityManagerFactory("JPAPU");
		em = emf.createEntityManager();
	}
	
	public void salvarLivro(Livro livro)
	{
		em.getTransaction().begin();
		
		em.persist(livro);
		
		em.getTransaction().commit();
		
		em.close();
	}
	
	public Livro criaLivro()
	{
		Livro livro = new Livro();
		Scanner teclado = new Scanner(System.in);
		System.out.println("Nome do livro: ");
		String nomeLivro = teclado.nextLine();
		
		System.out.println("Descrição do livro: ");
		String descLivro = teclado.nextLine();
		
		livro.setNomeLivro(nomeLivro);
		livro.setDescLivro(descLivro);
		
		teclado.close();
		
		return livro;
	}
	
}
