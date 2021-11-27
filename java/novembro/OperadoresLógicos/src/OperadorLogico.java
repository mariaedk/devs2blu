
// 26/11/21 - Maria Eduarda Krutzsch
public class OperadorLogico 
{

	public static void main(String[] args) 
	{

		int numero1, numero2, numero3, numero4;
		
		numero1 = 10;
		numero2 = 20;
		numero3 = 10;
		numero4 = 10;
		
		if (numero1 == numero2)
		{
			System.out.println("Iguais");
		}
		
		if ((numero1 == numero2) && (numero3 == numero4))
		{
			System.out.println("Iguais");
		}
		
		if ((numero1 == numero2) || (numero3 == numero4))
		{
			System.out.println("Alguém é Igual");
		}
	}

}
