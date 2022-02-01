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
	private String situacaoAluno;
	private double mediaAluno;
	
	public Aluno()
	{
		
	}
	
	
	
	public Aluno(int codigoAluno, String nomeAluno, String nomePai, String nomeMae, Date dataNasc, String situacaoAluno,
				double mediaAluno) {
		this.codigoAluno = codigoAluno;
		this.nomeAluno = nomeAluno;
		this.nomePai = nomePai;
		this.nomeMae = nomeMae;
		this.dataNasc = dataNasc;
		this.situacaoAluno = situacaoAluno;
		this.mediaAluno = mediaAluno;
	}



	public Aluno(String nomeAluno, String nomePai, String nomeMae, Date dataNasc, String situacaoAluno, double mediaAluno)
	{
		this.setNomeAluno(nomeAluno);
		this.setNomePai(nomePai);
		this.setNomeMae(nomeMae);
		this.setDataNasc(dataNasc);
		this.setSituacaoAluno(situacaoAluno);
		this.setMediaAluno(getMediaAluno());
	}
	
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
	public String getSituacaoAluno() {
		return situacaoAluno;
	}
	public void setSituacaoAluno(String situacaoAluno) {
		this.situacaoAluno = situacaoAluno;
	}

	//	methods
    public boolean incluirAluno() 
    {
    	
        return true;
    }

    public void alterarAluno() 
    {
 
    }

    public void excluirAluno() 
    {

    }

    public void consultarAluno() 
    {

    }

    public void listarAlunos()
    {
    	
    }
}
