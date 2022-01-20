
public class Aritmeticos {

	public static void main(String[] args) {
		int numero1 = 10, numero2 = 20, resultado = 0;
		float resto = 0f;
		
		//soma
		resultado = numero1 + numero2;
		System.out.println("O resultado da soma é :" + resultado);
		// subtracao
		resultado = numero1 - numero2;
		System.out.println("O resultado da subtração é :" + resultado);
		// multiplicacao
		resultado = numero1 * numero2;
		System.out.println("O resultado da multiplicação é :" + resultado);
		// divisao
		resultado = numero2 / numero1;
		System.out.println("O resultado da divisão é :" + resultado);
		//exponenciacao a função Math.pow é a utilizada para potenciação e não o ^, que equiva a um XOR
		numero1 = 2;
		numero2 = 3;
		resultado = (int)Math.pow(numero1, numero2);
		System.out.println("O resultado da exponenciação é :" + resultado);
		// resto de divisao
		numero1 = 5;
		numero2 = 2;
		resto = numero1 % numero2;
		resultado = numero1 / numero2;
		System.out.println("O resultado da divisão é " + resultado + " e o resto é :" + resto);

	}

}
