package entidades;

import java.util.Scanner;

/**
 * @author maria
 */

public class Disciplina 
{
	private int codigoDisciplina;
	private String nomeDisciplina;
	private String nomeProfessor;
	private int qtdAvaliacoes;

	public Disciplina()
	{
		
	}
	
	public Disciplina(String nomeDisciplina, String nomeProfessor, int qtdAvaliacoes) 
	{
		this.nomeDisciplina = nomeDisciplina;
		this.nomeProfessor = nomeProfessor;
		this.qtdAvaliacoes = qtdAvaliacoes;
	}
	
	public Disciplina(int codigoDisciplina, String nomeDisciplina, String nomeProfessor, int qtdAvaliacoes) 
	{
		this.codigoDisciplina = codigoDisciplina;
		this.nomeDisciplina = nomeDisciplina;
		this.nomeProfessor = nomeProfessor;
		this.qtdAvaliacoes = qtdAvaliacoes;
	}
	//	getters e setters
	public int getCodigoDisciplina() {
		return codigoDisciplina;
	}
	public void setCodigoDisciplina(int codigoDisciplina) {
		this.codigoDisciplina = codigoDisciplina;
	}
	public String getNomeDisciplina() {
		return nomeDisciplina;
	}
	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}
	public String getNomeProfessor() {
		return nomeProfessor;
	}
	public void setNomeProfessor(String nomeProfessor) {
		this.nomeProfessor = nomeProfessor;
	}
	public int getQtdAvaliacoes() {
		return qtdAvaliacoes;
	}
	public void setQtdAvaliacoes(int qtdAvaliacoes) {
		this.qtdAvaliacoes = qtdAvaliacoes;
	}

	public Disciplina criaDisciplina()
	{
		Scanner teclado = new Scanner(System.in);

		
		System.out.println("Nome da disciplina: ");
		String nomeDisc = teclado.nextLine();
		
		System.out.println("Nome do professor: ");
		String nomeProf = teclado.nextLine();

		System.out.println("Quantidade de avaliaçãoes: ");
		int qtdAv = teclado.nextInt();
		
		teclado.close();
		
		Disciplina disciplina = new Disciplina(nomeDisc, nomeProf, qtdAv);
		
		return disciplina;
	}

}

