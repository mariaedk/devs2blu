package ConstrutorAula;

public class AlunoMain {
	public static void main(String[] args) {
		Aluno aluno = new Aluno(8, 8, 8, 8);
		
		double media = aluno.calculaMedia();
		System.out.println(media);
	}
}
