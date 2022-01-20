package ConstrutorAula;

public class Aluno {
	private float nota1;
	private float nota2;
	private float nota3;
	private float nota4;
	public STATUS situacao;
	
	public Aluno(float nota1, float nota2, float nota3, float nota4)
	{
		this.setNota1(nota1);
		this.setNota2(nota2);
		this.setNota3(nota3);
		this.setNota4(nota4);
	}
	
	public enum STATUS
	{
		APROVADO, 
		REPROVADO
	}
	
	public float getNota1() {
		return nota1;
	}
	public void setNota1(float nota1) {
		this.nota1 = nota1;
	}
	public float getNota2() {
		return nota2;
	}
	public void setNota2(float nota2) {
		this.nota2 = nota2;
	}
	public float getNota3() {
		return nota3;
	}
	public void setNota3(float nota3) {
		this.nota3 = nota3;
	}
	public float getNota4() {
		return nota4;
	}
	public void setNota4(float nota4) {
		this.nota4 = nota4;
	}
	public double calculaMedia()
	{
		double mediaAluno = (this.getNota1() + this.getNota2() + this.getNota3() + this.getNota4()) / 4;
		return mediaAluno;
	}
}
