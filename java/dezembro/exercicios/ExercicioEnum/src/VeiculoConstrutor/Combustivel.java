package VeiculoConstrutor;

public enum Combustivel 
{
  GASOLINA(1), 
  DIESEL(2), 
  ELÉTRICO(3), 
  GÁS_NATURAL(4);

final int numeroCombustivel;
	
Combustivel(int numeroCombustivel) 
{
	this.numeroCombustivel = numeroCombustivel;
	
}
}
