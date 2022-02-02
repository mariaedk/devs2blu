package interfaces;

import java.util.List;

public interface InterfaceDAO<X>
{
	public boolean executaSalvarBD(X x); // passando um objeto tipo T que ser� do tipo T (gen�rico)

	public boolean executaUpdateBD(X x);	
	
	public boolean executaExcluirBD(X x);

	public X retornaUmObjetoBD(int id);

	public List<X> retornarTodosBD();
}
