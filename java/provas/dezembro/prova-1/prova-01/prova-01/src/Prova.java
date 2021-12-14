import java.text.DecimalFormat;
import java.util.Scanner;

public class Prova 
{
	public static void main(String[] args) 
	{
		Scanner teclado = new Scanner(System.in);
		DecimalFormat formatador = new DecimalFormat("R$ #,##0.00");
		
		
		int qtdMotoristas, numeroCarteira, numeroMultas,
			tipoMulta, multasLeves = 0, multasMedias = 0,
			multasGraves = 0, multasGravissimas = 0;
		
		double valorTotalMultasMotorista = 0;
		double valorTotalMultas = 0;
		
		do
		{
			System.out.print("Informe a quantidade de motoristas: (0 para sair do programa) ");
			qtdMotoristas = teclado.nextInt();
			
			for (int i = 0; i < qtdMotoristas; i++) 
			{
				System.out.println("===========================");
				System.out.print("N� carteira: ");
				numeroCarteira = teclado.nextInt();
				
				System.out.print("N�mero de multas: ");
				numeroMultas = teclado.nextInt();
				
				System.out.println("====== QUADRO INFORMATIVO ======");
				System.out.println("DIGITE: "
									+ "\n1 - PARA LEVE;"
									+ "\n2 - PARA M�DIA;"
									+ "\n3 - PARA GRAVE;"
									+ "\n4 - PARA GRAV�SSIMA");
				
				for (int j = 0; j < numeroMultas; j++) 
				{
					System.out.println("NATUREZA DA MULTA: ");
					tipoMulta = teclado.nextInt();
					
					switch(tipoMulta)
					{
						case 1:
							multasLeves++;
							valorTotalMultasMotorista += 88;
							break;
						case 2:
							multasMedias++;
							valorTotalMultasMotorista += 130;
							break;
						case 3:
							multasGraves++;
							valorTotalMultasMotorista += 195;
							break;
						case 4:
							multasGravissimas++;
							valorTotalMultasMotorista += 293;
							break;
					}
				}
				
				System.out.println("====== TABELA DE CONFER�NCIA ======");
				System.out.println("NATUREZA   |   PONTUA��O   |   VALOR R$");
				System.out.println("----------------------------------------");
				System.out.println("LEVE       |   3 PONTOS    |   88,00");
				System.out.println("M�DIA      |   4 PONTOS    |   130,00");
				System.out.println("GRAVE      |   5 PONTOS    |   195,00");
				System.out.println("GRAV�SSIMA |   7 PONTOS    |   293,00");
				System.out.println("========================================");
				System.out.println();
				System.out.println("N� CARTEIRA: " + numeroCarteira);
				System.out.println("====== SEU QUADRO ======");
				System.out.println("MULTAS LEVES: " + multasLeves);
				System.out.println("MULTAS M�DIAS: " + multasMedias);
				System.out.println("MULTAS GRAVES: " + multasGraves);
				System.out.println("MULTAS GRAV�SSIMAS: " + multasGravissimas);
				System.out.println();
				System.out.println("TOTAL DE PONTOS: " + ((multasLeves * 3) + (multasMedias * 4)
						+ (multasGraves * 5) + (multasGravissimas * 7)));
				System.out.println("VALOR TOTAL EM MULTAS: " + formatador.format(valorTotalMultasMotorista));

				valorTotalMultas += valorTotalMultasMotorista;
				numeroCarteira = 0;
				multasLeves = 0;
				multasMedias = 0;
				multasGraves = 0;
				multasGravissimas = 0;
				valorTotalMultasMotorista = 0;
			}

			
		} while(qtdMotoristas != 0);
		System.out.println("SOMA TOTAL DE TODAS AS MULTAS: " + formatador.format(valorTotalMultas));
		System.out.println("SAIU DO PROGRAMA.");
		teclado.close();
		
	}
}
