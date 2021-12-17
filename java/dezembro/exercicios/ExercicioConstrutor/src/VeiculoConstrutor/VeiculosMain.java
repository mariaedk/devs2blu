package VeiculoConstrutor;

/* 
	Com base no exerc�cio anterior, implemente um construtor com sobrecarga nas classes
	Autom�vel e Moto da seguinte forma:
	1. Acelerar � deve enviar o limite de velocidade 60Km/h;
	2. Abastecer � deve enviar o tipo do combust�vel (gasolina) e a litragem total(Autom�vel
	40 litros e Moto � 8 litros);
	3. Frear � deve enviar a intensidade da frenagem(Alta,M�dia ou Baixa);
 */

public class VeiculosMain 
{
	public static void main(String[] args) 
	{
		Automovel automovel =  new Automovel(80, 36, "ALTA", "DIESEL");
		automovel.listarDados();
		
		Moto moto =  new Moto(70, 4, "M�DIA", "GASOLINA");
		moto.listarDados();

	}
}
