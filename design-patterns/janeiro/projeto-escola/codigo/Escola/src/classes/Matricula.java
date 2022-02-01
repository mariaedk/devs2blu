package classes;

import java.sql.Date;

/**
 * @author maria
 */

public class Matricula {


    public Matricula() {
    }

    private int codigoAluno;
    private int codigoDisciplina;
    private Date dataMatricula;
    private char statusMatricula;

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