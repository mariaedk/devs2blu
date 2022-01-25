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
		// jpapu guarda a conexão
		// chama método static para ter somente uma conexão
		// static faz com que não precise instanciar
		emf = Persistence.createEntityManagerFactory("JPAPU");
		em = emf.createEntityManager();
	}
	
	public void salvarContato(Contato contato)
	{
		// abrir conexão
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
		
		// nao usado transação pois estamos apenas buscando dados
		
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
