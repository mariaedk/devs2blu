package entidades;

import java.sql.Date;

/**
 * @author maria
 */

public class Matricula {

    private int codigoAluno;
    private int codigoDisciplina;
    private Date dataMatricula;
    private char statusMatricula;
    
//	construtor default
    public Matricula() 
    {
    	
    }

    public Matricula(int codigoAluno, int codigoDisciplina, Date dataMatricula, char statusMatricula)
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

	public Date getDataMatricula() {
		return dataMatricula;
	}

	public void setDataMatricula(Date dataMatricula) {
		this.dataMatricula = dataMatricula;
	}

	public char getStatusMatricula() {
		return statusMatricula;
	}

	public void setStatusMatricula(char statusMatricula) {
		this.statusMatricula = statusMatricula;
	}

//	methods
    public void alterarMatricula() {
        // TODO implement here
    }
 
	public void incluirMatricula() {
        // TODO implement here
    }

    public void excluirMatricula() {
        // TODO implement here
    }

    public void consultarMatricula() {
        // TODO implement here
    }

    public void listarMatriculas() {
        // TODO implement here
    }

}