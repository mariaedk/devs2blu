package classes;
import java.sql.Date;

/**
 * @author maria
 */

public class Aluno
{
	private int codigoAluno;
	private String nomeAluno;
	private String nomePai;
	private String nomeMae;
	private Date dataNasc;
	private double mediaAluno;
	
	// getters e setters
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
	public Date getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}
	public Double getMediaAluno() {
		return mediaAluno;
	}
	public void setMediaAluno(Double mediaAluno) {
		this.mediaAluno = mediaAluno;
	}
	
    public void incluirAluno() {
        // TODO implement here
    }

    /**
     * 
     */
    public void alterarAluno() {
        // TODO implement here
    }

    /**
     * 
     */
    public void excluirAluno() {
        // TODO implement here
    }

    /**
     * 
     */
    public void consultarAluno() {
        // TODO implement here
    }

    /**
     * 
     */
    public void listarAlunos() {
        // TODO implement here
    }
}
