package VeiculoConstrutor;

public class VeiculosMain 
{
	public static void main(String[] args) 
	{
		Automovel automovel =  new Automovel(80, 36, "ALTA", "DIESEL");
		automovel.listarDados();
		
		Moto moto =  new Moto(70, 4, "M�DIA", "GASOLINA");
		moto.listarDados();

	}
}
