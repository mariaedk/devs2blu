
public class InterfaceExe 
{
	/*
		Crie uma interface para a classe Ve�culo que sirva �s classes filhas Autom�vel e Moto.
		Essa interface deve abstrair tr�s m�todos, � saber:
		1. Acelerar;
		2. Abastecer;
		3. Frear; 
		
	 */
	
	public static void main(String[] args) 
	{
		Autom�vel automovel = new Autom�vel();
		
		System.out.println(automovel.abastecer());
		System.out.println(automovel.acelerar());
		System.out.println(automovel.frear());
		
		Moto moto = new Moto();
		
		System.out.println(moto.abastecer());
		System.out.println(moto.acelerar());
		System.out.println(moto.frear());
	}
}
