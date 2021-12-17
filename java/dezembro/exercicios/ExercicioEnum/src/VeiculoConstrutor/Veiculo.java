package VeiculoConstrutor;

public abstract class Veiculo {
	
	private int velocidade;
	private float litragem;
	private String frenagem;
	private String tipoCombustivel;
	
	public Veiculo(int velocidade, float litragem, String frenagem, String tipoCombustivel)
	{
		this.setFrenagem(frenagem);
		this.setLitragem(litragem);
		this.setTipoCombustivel(tipoCombustivel);
		this.setVelocidade(velocidade);
	}
	
	public int getVelocidade() {
		return velocidade;
	}
	public void setVelocidade(int velocidade) {
		this.velocidade = velocidade;
	}
	public float getLitragem() {
		return litragem;
	}
	public void setLitragem(float litragem) {
		this.litragem = litragem;
	}
	public String getFrenagem() {
		return frenagem;
	}
	public void setFrenagem(String frenagem) {
		this.frenagem = frenagem;
	}
	public String getTipoCombustivel() {
		return tipoCombustivel;
	}
	public void setTipoCombustivel(String tipoCombustivel) {
		this.tipoCombustivel = tipoCombustivel;
	}
	
	public abstract String getLimiteVelocidade();
	
	public abstract String getAbastecimento();
	
	public abstract String getIntensidadeFrenagem();
	
	public abstract void listarDados();
	
}
