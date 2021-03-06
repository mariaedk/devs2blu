import java.text.DecimalFormat;
import java.util.Scanner;

public class RevisaoProva 
{
	public static void main(String[] args) 
	{
		Scanner teclado = new Scanner(System.in);
		DecimalFormat formatador = new DecimalFormat("#.##");
		
		// Declara??o de vari?veis
		float mediaAluno = 0, melhorMediaGeral = Float.MIN_VALUE, piorMediaGeral = Float.MAX_VALUE, 
			  notaAluno = 0;
		String nomeAluno = "";
		
		System.out.println("-+-+-+-+ Sistema da Escola Futuro -+-+-+-+");
		
		System.out.print("Informe a quantidade de alunos: ");
		int quantidadeAlunos = teclado.nextInt();
		
		System.out.print("Informe a quantidade de notas: ");
		int quantidadeNotas = teclado.nextInt();
		
		System.out.println("-----------------------------");
		
		for (int i = 0; i < quantidadeAlunos; i++) {
			System.out.print("Nome do aluno: ");
			nomeAluno = teclado.next();
			
			for (int j = 0; j < quantidadeNotas; j++) {
				System.out.print("Informe a nota " + (j + 1) + " do(a) aluno(a) " + nomeAluno + ": ");
				notaAluno = teclado.nextFloat();
				
				mediaAluno += notaAluno;
			}
			
			mediaAluno = mediaAluno / quantidadeNotas;
			
			System.out.println("Nome: " + nomeAluno);
			System.out.println("M?dia: " + formatador.format(mediaAluno));
			
			if (mediaAluno >= 7.5)
			{
				System.out.println("Situa??o: Aprovado.");
			}
			else if (mediaAluno >= 6)
			{
				System.out.println("Situa??o: Em recupera??o.");
			}
			else
			{
				System.out.println("Situa??o: Reprovado.");
			}
			
			if (mediaAluno > melhorMediaGeral)
			{
				melhorMediaGeral = mediaAluno;
			}
			if (mediaAluno < piorMediaGeral)
			{
				piorMediaGeral = mediaAluno;
			}
			
			System.out.println("-----------------------------");
			mediaAluno = 0;
		}
		
		System.out.println("Melhor m?dia: " + formatador.format(melhorMediaGeral));
		System.out.println("Pior m?dia: " + formatador.format(piorMediaGeral));
		teclado.close();
	}
}
