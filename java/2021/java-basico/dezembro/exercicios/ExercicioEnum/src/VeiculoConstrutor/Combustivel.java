package VeiculoConstrutor;

public enum Combustivel 
{
  GASOLINA(1), 
  DIESEL(2), 
  EL�TRICO(3), 
  G�S_NATURAL(4);

final int numeroCombustivel;
	
Combustivel(int numeroCombustivel) 
{
	this.numeroCombustivel = numeroCombustivel;
	
}
}
