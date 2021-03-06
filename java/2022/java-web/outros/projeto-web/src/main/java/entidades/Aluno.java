package entidades;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * @author maria
 */

public class Aluno
{
	
//	atributos
	private int codigoAluno;
	private String nomeAluno;
	private String nomePai;
	private String nomeMae;
	private LocalDate dataNasc;
	private String situacaoAluno;
	private double mediaAluno;
	
//	 construtor padr?o
	public Aluno()
	{
		
	}
	
//	construtor com c?digo
	public Aluno(int codigoAluno, String nomeAluno,String nomeMae, String nomePai,  LocalDate dataNasc, 
				 String situacaoAluno, double mediaAluno) 
	{
		this.setCodigoAluno(codigoAluno);
		this.setNomeAluno(nomeAluno);
		this.setNomeMae(nomeMae);
		this.setNomePai(nomePai);
		this.setDataNasc(dataNasc);
		this.setSituacaoAluno(situacaoAluno);
		this.setMediaAluno(mediaAluno);
	}
	
//	construtor sem c?digo
	public Aluno(String nomeAluno, String nomePai, String nomeMae, LocalDate dataNasc,
				 String situacaoAluno, double mediaAluno)
	{
		this.setNomeAluno(nomeAluno);
		this.setNomePai(nomePai);
		this.setNomeMae(nomeMae);
		this.setDataNasc(dataNasc);
		this.setSituacaoAluno(situacaoAluno);
		this.setMediaAluno(mediaAluno);
	}
	
//	 getters e setters
	public int getCodigoAluno() {
		return codigoAluno;
	}
	public void setCodigoAluno(int codigoAluno) {
		this.codigoAluno = codigoAluno;
	}
	public String getNomeAluno() {
		return nomeAluno;
	}
	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}
	public String getNomePai() {
		return nomePai;
	}
	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}
	public String getNomeMae() {
		return nomeMae;
	}
	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}
	public LocalDate getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(LocalDate dataNasc) {
		this.dataNasc = dataNasc;
	}
	public double getMediaAluno() {
		return mediaAluno;
	}
	public void setMediaAluno(double mediaAluno) {
		this.mediaAluno = mediaAluno;
	}
	public String getSituacaoAluno() {
		return situacaoAluno;
	}
	public void setSituacaoAluno(String situacaoAluno) {
		this.situacaoAluno = situacaoAluno;
	}
    
//	 formatar data de nascimento do aluno
	public LocalDate formataDataNascAluno(String dataNascString)
	{
//		cria um formatador para que a data seja enviada ao banco de dados com um formato que ele entenda 
		DateTimeFormatter formatadorData = DateTimeFormatter.ofPattern("d/MM/yyyy");
		
//		converter de String para LocalDate
		LocalDate dataNasc = LocalDate.parse(dataNascString, formatadorData);
		
		return dataNasc;
	}
	
//	cria um objeto de aluno e retorna o mesmo
	public Aluno criaAluno()
	{
		Scanner teclado = new Scanner(System.in);
		
//		l? os dados do aluno
		System.out.print("Nome do aluno: ");
		String nomeAluno = teclado.nextLine();
		
		System.out.print("Nome da m?e do aluno: ");
		String nomeMae = teclado.nextLine();
		
		System.out.print("Nome do pai do aluno: ");
		String nomePai = teclado.nextLine();
		
		System.out.print("Data de nascimento do aluno: ");
		String dataNascString = teclado.nextLine();
		
		System.out.print("Situa??o cadastral do aluno: ");
		String situacaoAluno = teclado.nextLine();
		
		System.out.print("M?dia do aluno: ");
		double mediaAluno = Double.parseDouble(teclado.nextLine());
		
		System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
		

		Aluno aluno = new Aluno (nomeAluno, nomePai, nomeMae, formataDataNascAluno(dataNascString),
				 				 situacaoAluno, mediaAluno);
		
		teclado.close();
		
		return aluno;
	}

}
