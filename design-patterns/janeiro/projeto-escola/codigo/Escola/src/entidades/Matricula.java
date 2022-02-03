package entidades;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * @author maria
 */

public class Matricula {

    private int codigoAluno;
    private int codigoDisciplina;
    private LocalDate dataMatricula;
    private String statusMatricula;
    
//	construtor default
    public Matricula() 
    {
    	
    }

    public Matricula(int codigoAluno, int codigoDisciplina, LocalDate dataMatricula, String statusMatricula)
    {
		this.setCodigoAluno(codigoAluno);
		this.setCodigoDisciplina(codigoDisciplina);
		this.setDataMatricula(dataMatricula);
		this.setStatusMatricula(statusMatricula);
	}

	//    getters e setters
    public int getCodigoAluno() {
		return codigoAluno;
	}

	public void setCodigoAluno(int codigoAluno) {
		this.codigoAluno = codigoAluno;
	}

	public int getCodigoDisciplina() {
		return codigoDisciplina;
	}

	public void setCodigoDisciplina(int codigoDisciplina) {
		this.codigoDisciplina = codigoDisciplina;
	}

	public LocalDate getDataMatricula() {
		return dataMatricula;
	}

	public void setDataMatricula(LocalDate dataMatricula) {
		this.dataMatricula = dataMatricula;
	}

	public String getStatusMatricula() {
		return statusMatricula;
	}

	public void setStatusMatricula(String statusMatricula) {
		this.statusMatricula = statusMatricula;
	}
	
	public Matricula criaMatricula()
	{
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Código do aluno: ");
		int codAluno = teclado.nextInt();
		
		System.out.println("Código da disciplina: ");
		int codDisciplina = teclado.nextInt();
		
		System.out.println("Data de matrícula: ");
		String dtMatricula = teclado.nextLine();
		
		System.out.println("Status da matrícula: ");
		String statusMatricula = teclado.nextLine();
		
		Matricula matricula = new Matricula(codAluno, codDisciplina, formataDataMatricula(dtMatricula), statusMatricula);
		
		return matricula;
	}
	
	public LocalDate formataDataMatricula(String dataNascString)
	{
//		cria um formatador para que a data seja enviada ao banco de dados com um formato que ele entenda 
		DateTimeFormatter formatadorData = DateTimeFormatter.ofPattern("d/MM/yyyy");
		
//		converter de String para LocalDate
		LocalDate dataNasc = LocalDate.parse(dataNascString, formatadorData);
		
		return dataNasc;
	}
	
}