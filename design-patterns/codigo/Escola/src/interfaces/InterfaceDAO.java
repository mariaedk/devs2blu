package interfaces;

import java.util.List;

public interface InterfaceDAO<X>
{
	public boolean executaSalvarBD(X x); // passando um objeto tipo T que será do tipo T (genérico)

	public boolean executaUpdateBD(X x);	
	
	public boolean executaExcluirBD(X x);

	public List<X> retornarTodosBD();
}
