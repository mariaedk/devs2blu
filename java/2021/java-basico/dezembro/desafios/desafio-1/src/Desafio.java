import java.util.Scanner;

public class Desafio 
{

	public static void main(String[] args) 
	{
		
		Scanner teclado =  new Scanner(System.in);
		int opcao = 0;
		
		do
		{
			System.out.println("Escolha uma das op??es abaixo:");
			System.out.println("1,2,3,4,9");
			opcao = teclado.nextInt();

			switch(opcao)
			{
				case 1:
					System.out.println("Incluir");
					break;
				case 2:
					System.out.println("Alterar");
					break;
				case 3:
					System.out.println("Excluir");
					break;
				case 4:
					System.out.println("Consultar");
					break;
				case 9:
					break;
				default:
					System.out.println("Inv?lido");
			}			
		} while (opcao != 9);
		System.out.println("Saiu do programa.");
		teclado.close();
	}
}
