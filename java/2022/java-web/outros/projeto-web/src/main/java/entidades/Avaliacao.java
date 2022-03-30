package entidades;
import java.util.Scanner;

/**
 * @author maria
 */

public class Avaliacao
{
	// atributos
	private int codigoDisciplina;
	private int codigoAluno;
	private int numeroAvaliacao;
	private double valorNota;
	
	public Avaliacao()
	{
		
	}
	
	public Avaliacao(int codigoDisciplina, int codigoAluno, int numeroAvaliacao, double valorNota) 
	{
		this.setCodigoDisciplina(codigoDisciplina);
		this.setCodigoAluno(codigoAluno);
		this.setNumeroAvaliacao(numeroAvaliacao);
		this.setValorNota(valorNota);
	}
	
	//	getters e setters
	public int getCodigoDisciplina() {
		return codigoDisciplina;
	}
	public void setCodigoDisciplina(int codigoDisciplina) {
		this.codigoDisciplina = codigoDisciplina;
	}
	public int getCodigoAluno() {
		return codigoAluno;
	}
	public void setCodigoAluno(int codigoAluno) {
		this.codigoAluno = codigoAluno;
	}
	public int getNumeroAvaliacao() {
		return numeroAvaliacao;
	}
	public void setNumeroAvaliacao(int numeroAvaliacao) {
		this.numeroAvaliacao = numeroAvaliacao;
	}
	public double getValorNota() {
		return valorNota;
	}
	public void setValorNota(double valorNota) {
		this.valorNota = valorNota;
	}
	
	public Avaliacao criaAvaliacao()
	{
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Código da disciplina: ");
		int codDisciplina = Integer.parseInt(teclado.nextLine());
		
		System.out.println("Código do aluno: ");
		int codAluno = Integer.parseInt(teclado.nextLine());
		
		System.out.println("Nr da avaliacao: ");
		int nrAvaliacao = Integer.parseInt(teclado.nextLine());
		
		System.out.println("Valor Nota: ");
		Double vlrNota = Double.parseDouble(teclado.nextLine());
		
		teclado.close();
		
		Avaliacao avaliacao = new Avaliacao(codDisciplina, codAluno, nrAvaliacao, vlrNota);
		
		return avaliacao;
	}
	
}
