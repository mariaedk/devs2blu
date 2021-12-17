package VeiculoConstrutor;

public class Automovel extends Veiculo
{
	
	public Automovel(int velocidade, float litragem, String frenagem, String tipoCombustivel) 
	{
		super(velocidade, litragem, frenagem, tipoCombustivel);

	}
	
	public String getLimiteVelocidade()
	{
		return " 60 km/h";
	}

	@Override
	public String getAbastecimento()
	{
		return this.getTipoCombustivel() + " - 40 LITROS";
	}

	@Override
	public String getIntensidadeFrenagem() 
	{
		return this.getFrenagem();
	}

	@Override
	public void listarDados() 
	{
		System.out.println("Automóvel:");
		System.out.println("Velocidade: " + this.getVelocidade());
		System.out.println("Litragem atual: " + this.getLitragem());
		System.out.println("Limite velocidade: " + getLimiteVelocidade());
		System.out.println("Abastecimento: " + getAbastecimento());
		System.out.println("Intensidade frenagem: " + getIntensidadeFrenagem());
	}
}
