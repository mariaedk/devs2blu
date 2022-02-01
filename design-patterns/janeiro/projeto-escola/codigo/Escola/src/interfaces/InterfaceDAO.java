package interfaces;

import java.util.List;

public interface InterfaceDAO<X>
{
	public boolean salvar(X x); // passando um objeto tipo T que ser� do tipo T (gen�rico)

	public boolean update(X x);	
	
	public boolean excluir(X x);

	public X retornarUm(int id);

	public List<X> retornarTodos();
}
