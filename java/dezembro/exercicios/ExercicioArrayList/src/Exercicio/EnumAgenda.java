package Exercicio;

public enum EnumAgenda
{
	INCLUIR(1), 
	ALTERAR(2), 
	EXCLUIR(3), 
	CONSULTAR(4);

	public int valor;
	EnumAgenda(int valor) {
		this.valor = valor;
	}
}
