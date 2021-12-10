
public class EmpresaRH 
{
	public static void main(String[] args)
	{
		Gerencia ger = new Gerencia();
		System.out.println("Dados do gerente: ");
		ger.nome = "Roberto";
		ger.descDepto = "Geremcoa de TI";
		ger.comissao = 0.02f;
		ger.salario = 3000;
		ger.listarFuncionario();
		
		System.out.println("Dados do presidente: ");
		Presidente pres = new Presidente();
		pres.nome = "Ana";
		pres.salario = 3000;
		
		
	}
}
