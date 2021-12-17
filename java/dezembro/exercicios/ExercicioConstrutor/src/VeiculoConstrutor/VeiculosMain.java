package VeiculoConstrutor;

/* 
	Com base no exercício anterior, implemente um construtor com sobrecarga nas classes
	Automóvel e Moto da seguinte forma:
	1. Acelerar – deve enviar o limite de velocidade 60Km/h;
	2. Abastecer – deve enviar o tipo do combustível (gasolina) e a litragem total(Automóvel
	40 litros e Moto – 8 litros);
	3. Frear – deve enviar a intensidade da frenagem(Alta,Média ou Baixa);
 */

public class VeiculosMain 
{
	public static void main(String[] args) 
	{
		Automovel automovel =  new Automovel(80, 36, "ALTA", "DIESEL");
		automovel.listarDados();
		
		Moto moto =  new Moto(70, 4, "MÉDIA", "GASOLINA");
		moto.listarDados();

	}
}
