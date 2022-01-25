package principal;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ContatoDAO 
{
	
	// connection
	EntityManagerFactory emf;
	// prepared statement
	EntityManager em;
	
	public ContatoDAO()
	{
		// jpapu guarda a conex�o
		// chama m�todo static para ter somente uma conex�o
		// static faz com que n�o precise instanciar
		emf = Persistence.createEntityManagerFactory("JPAPU");
		em = emf.createEntityManager();
	}
	
	public void salvarContato(Contato contato)
	{
		// abrir conex�o
		em.getTransaction().begin();
		
		em.persist(contato);
		
		em.getTransaction().commit();
		
		em.close();
	}
	
	public Contato recebeUmContato(Long id)
	{
		return em.find(Contato.class, id);
	}
	
	public void exibeUmContato()
	{
		Contato contato = new ContatoDAO().recebeUmContato(2L);
		System.out.println("Nome: " + contato.getNome());
		System.out.println("Email: " + contato.getEmail());
		System.out.println("Celular: " + contato.getCelular());
		
	}
	
	public boolean realizarUpdate(Contato contato)
	{
		// pesquisar
//		Contato contatoVindoDoBanco = em.find(Contato.class, contato.getId());
//		contatoVindoDoBanco.setNome(contato.getNome());
//		contatoVindoDoBanco.setEmail(contato.getEmail());
//		contatoVindoDoBanco.setCelular(contato.getCelular());
		
		em.getTransaction().begin();
		em.merge(contato);
		em.getTransaction().commit();
		em.close();
		
		// nao usado transa��o pois estamos apenas buscando dados
		
		return true;
	}
	
	public void chamarUpdate()
	{
		Contato contato = new ContatoDAO().recebeUmContato(1L);
		contato.setCelular("47 8234382");
		new ContatoDAO().realizarUpdate(contato);
		
		if (new ContatoDAO().realizarUpdate(contato))
		{
			System.out.println("ALTERADO O CONTATO.");
		}
	}
	
}
