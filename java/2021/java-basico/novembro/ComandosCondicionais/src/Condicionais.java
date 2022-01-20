
public class Condicionais {

	public static void main(String[] args) {
		// Comando condicional simples
		
		int idade;
		/*
		idade = 15;
		if (idade < 18) {
			System.out.println("Menor de Idade");
		}
		
		// Comando condicional composto com "else"
		idade = 23;
		if (idade < 18) {
			System.out.println("Menor de Idade");
		} else {
			System.out.println("Maior de Idade");
		}
		*/
		// Comando condicional composto com "else"
		idade = 92;
		if (idade < 18) {
			System.out.println("Menor de Idade");
		} else if (idade >= 18 && idade <= 64) {
			System.out.println("Adulto");			
		} else if (idade >= 65 && idade <= 80){
			System.out.println("Idoso");
		} else {
			System.out.println("Muito Idoso");			
		}
	
	}

}
