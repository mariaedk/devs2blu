
public class InterfaceExe 
{
	
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
