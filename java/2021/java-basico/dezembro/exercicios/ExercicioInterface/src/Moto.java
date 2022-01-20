
public class Moto implements Veiculo
{

	@Override
	public String acelerar() {
		return "Acelerando moto";
	}

	@Override
	public String abastecer() {
		return "Abastecendo moto";
	}

	@Override
	public String frear() {
		return "Freando moto";
	}
}
