
public class InterfaceExe 
{
	/*
		Crie uma interface para a classe Veículo que sirva ás classes filhas Automóvel e Moto.
		Essa interface deve abstrair três métodos, á saber:
		1. Acelerar;
		2. Abastecer;
		3. Frear; 
		
	 */
	
	public static void main(String[] args) 
	{
		Automóvel automovel = new Automóvel();
		
		System.out.println(automovel.abastecer());
		System.out.println(automovel.acelerar());
		System.out.println(automovel.frear());
		
		Moto moto = new Moto();
		
		System.out.println(moto.abastecer());
		System.out.println(moto.acelerar());
		System.out.println(moto.frear());
	}
}
