package principal;

import java.util.List;

import entidades.Carro;
import entidadesDao.CarroDAO;

public class RefatoracaoMain 
{
	
	public static void main(String[] args)
	{	
		// criei um objeto do tipo carro.
		// criei um objeto anonimo do tipo carroDAO e chamei o m?todo atribuiinformacoesCarro
		// esse m?todo retorna um carro. Logo estou colocando um objeto do tipo carro dentro de outro do tipo carro
//		Carro carro = new CarroDAO().atribuiInformacoesCarro();
		
		// criei outro objeto anonimo do tipo DAO para salvar o carro dando como parametro
		// o carro acima
//		new CarroDAO().salvarCarroBD(carro);       
		
//		excluirPorObjeto();
//		new CarroDAO().chamaUpdate();          funcionou
		
//		new CarroDAO().excluirPorObjeto();     funcionou
		
//		new CarroDAO().chamaExcluir();         funcionou
		
//		new CarroDAO().chamaRetornaTodos();    funcionou
	}
	
	static void chamaRetornaTodos()
	{
		List<Carro> carros = new CarroDAO().retornarTodos();
		
		for (Carro c : carros)
		{
			System.out.println(c.getId());
			System.out.println(c.getPlaca());
			System.out.println(c.getMarca());
			System.out.println(c.getModelo());
		}
	}
		
	static void chamaUpdate()
	{
		Carro carro = new CarroDAO().retornarUm(9);
		carro.setModelo("charrete");
		if (new CarroDAO().update(carro))
		{
			System.out.println("Carro alterado com sucesso.");
		}
	}
	
	static void excluirPorObjeto() 
	{
		Carro carro = new CarroDAO().retornarUm(7);
		
		if (new CarroDAO().excluir(carro)) 
		{
			System.out.println("carro excluido com sucesso");
		}
	}
	
	static void chamaExcluir()
	{
		if (new CarroDAO().excluir(6)) 
		{
			System.out.println("carro excluido com sucesso");
		}
	}

	static void chamaSalvar() 
	{
		CarroDAO dao = new CarroDAO();

		Carro carro = new Carro();
		carro.setPlaca("abc124");
		carro.setModelo("Fusca");
		carro.setMarca("volks");

		if (new CarroDAO().salvar(carro)) 
		{
			System.out.println("Carro salvo com sucesso");
		}

		Carro carro2 = new Carro("def2345", "Kombi", "Volks");
		if (dao.salvar(carro2)) 
		{
			System.out.println("Carro salvo com sucesso");
		}
	}
}

