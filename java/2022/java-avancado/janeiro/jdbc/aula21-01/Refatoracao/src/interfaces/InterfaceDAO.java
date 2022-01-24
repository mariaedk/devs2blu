package interfaces;
import java.util.List;

//	ideia de abstra��o 
//  <T> => Generics
// caso eu tenha que aplicar a mesma interface para carro ou cliente, por exemplo
// posso usar o generics <T> para abstrair os tipos de dados que eu teria que usar especificamente
// dentro de cada m�todo no qual a interface ser� implementada o tipo de dado
// T ser� especificado

public interface InterfaceDAO<T>
{
	public boolean salvar(T t); // passando um objeto tipo T que ser� do tipo T (gen�rico)

	public boolean update(T t);	
	
	public boolean excluir(int id);

	public T retornarUm(int id);

	public List<T> retornarTodos();
	
}
