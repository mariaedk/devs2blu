package arrayAula;

public class MeuArray
{

	public static void main(String[] args) 
	{
		int[] listaNumeros = new int[10];
		
		for (int i = 0; i < 10; i++)
		{
			listaNumeros[i] = i;
		}
		
		// lista o offset do objeto (formatado que o objeto está na memória)
		System.out.println(listaNumeros);

		for (int i = 0; i < 10; i++)
		{
			System.out.println(listaNumeros[i]);
		}
		
		// tamanho array
		System.out.println(listaNumeros.length);
		
		
	}

}
