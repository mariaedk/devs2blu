
public class Alimentacao 
{

	public static void main(String[] args) 
	{
		Animal animal = new Boi();
		
		System.out.println("BOI FEZ " + animal.emitirSom());
		System.out.println("TIPO DE ALIMENTO DO BOI: " + animal.tipoAlimento());
		
		
	}
}
