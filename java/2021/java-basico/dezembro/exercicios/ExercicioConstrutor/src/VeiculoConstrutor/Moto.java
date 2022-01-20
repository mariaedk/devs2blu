package VeiculoConstrutor;

public class Moto extends Veiculo
{

	public Moto(int velocidade, float litragem, String frenagem, String tipoCombustivel)
	{
		super(velocidade, litragem, frenagem, tipoCombustivel);
	}

	@Override
	public String getLimiteVelocidade() 
	{
		return " 60 km/h";
	}

	@Override
	public String getAbastecimento() 
	{
		return this.getTipoCombustivel() + " - 8 LITROS";
	}

	@Override
	public String getIntensidadeFrenagem() 
	{
		return this.getFrenagem();
	}

	@Override
	public void listarDados() 
	{
		System.out.println("Moto:");
		System.out.println("Velocidade: " + this.getVelocidade());
		System.out.println("Litragem atual: " + this.getLitragem());
		System.out.println("Limite velocidade: " + getLimiteVelocidade());
		System.out.println("Abastecimento: " + getAbastecimento());
		System.out.println("Intensidade frenagem: " + getIntensidadeFrenagem());
	}
}
