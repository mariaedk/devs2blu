import java.text.DecimalFormat;
import java.util.Scanner;

public class Desafio 
{

	public static void main(String[] args) 
	{
		/*
		 * Pergunta do desafio: Qual ? a op??o mais adequada de intera??o:
		 * usar for ou usar while?
		 * 
		 * Resposta: Para este desafio em espec?fico, o while, pois n?o sabemos quantas vezes 
		 * o usu?rio vai querer usar a calculadora
		 * */
		
		Scanner teclado = new Scanner(System.in);
		DecimalFormat formatador = new DecimalFormat("#.##");
		
		int opcao = 0;
		double resto = 0, resultado = 0;
		
		do 
		{
			System.out.println("-+-+-+-+ MENU -+-+-+-+");
			System.out.println("1 - Somar");
			System.out.println("2 - Subtrair");
			System.out.println("3 - Multiplicar");
			System.out.println("4 - Dividir");
			System.out.println("9 - Sair");
			
			opcao = teclado.nextInt();
			
			if (opcao == 9)
			{
				break;
			}
			
			System.out.print("Primeiro n?mero: ");
			double numero1 = teclado.nextDouble();
			
			System.out.print("Segundo n?mero: ");
			double numero2 = teclado.nextDouble();
			
			switch(opcao)
			{
				case 1:
					resultado = numero1 + numero2;
					break;
					
				case 2:
					resultado = numero1 - numero2;
					break;
				
				case 3:
					resultado = numero1 * numero2;
					break;
					
				case 4:
					if (numero2 == 0)
					{
						do
						{
							System.out.println("Divisor ? igual a 0. Inv?lido. Digite novamente:");	
							numero2 = teclado.nextDouble();
							
						} while (numero2 == 0);
					}
					
					resultado = numero1 / numero2;
					
					// Fun??o math.floor arredonda para "baixo"
					if (resultado > Math.floor(resultado))
					{
						resto = numero1 % numero2;
					}
					break;
					
				case 9:
					break;
			}
			
			System.out.print("RESULTADO: " + formatador.format(resultado));
			if (opcao == 4)
			{
				System.out.println();
				System.out.println("RESTO DA DIVIS?O: " + resto);
			}
			System.out.println();
			
		} while (opcao != 9);
		
		System.out.println("Saiu do programa.");
		teclado.close();
	}
}
