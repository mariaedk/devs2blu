package principal;
import java.util.Scanner;
import exceptions.DigitoIncorretoException;
import exceptions.IdadeNegativaException;

public class MinhasExcecoes {

	public static void main(String[] args) {

		try 
		{
//			lerIdade();
//			lerDigitoAlgarismos();
			int algarismo = lerDigitoAlgarismos();
			validaDigitoEmArray(algarismo);
			
		} 
//		catch (IdadeNegativaException ie) 
//		{
//			ie.printStackTrace();
//		}
//		catch (DigitoIncorretoException di)
//		{
//			System.out.println(di.getMessage());
//		}
		catch (DigitoIncorretoException di)
		{
			System.out.println(di.getMessage());
		}
	}
	
	static int lerDigitoAlgarismos()
	{
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Digite um n?mero: ");
		int algarismo = teclado.nextInt();
		
		teclado.close();
		
		return algarismo;
	}
	
	static boolean verificaDigitoEmArray(int algarismo)
	{
		
		int[] algarismos = {0,1,2,3,4,5,6,7,8,9};	
		boolean isValid = false;
		for (int i = 0; i < algarismos.length; i++)
		{
			if (algarismos[i] == algarismo)
			{
				isValid = true;
				break;
			}
		}
		return isValid;
	}
	
	static void validaDigitoEmArray(int algarismo) throws DigitoIncorretoException
	{
		boolean isDigitValid = verificaDigitoEmArray(algarismo);
		
		if (!isDigitValid)
		{
			throw new DigitoIncorretoException("O n?mero deve estar entre 0 e 9");
		}
	}
	
	static void lerIdade() throws IdadeNegativaException
	{
		Scanner teclado = new Scanner(System.in);
		System.out.println("Informe a idade: ");
		int idade = teclado.nextInt();
		
		teclado.close();
		if (idade < 0)
		{
			throw new IdadeNegativaException("Idade n?o pode ser menor do que 0.");
		}
	}
}
