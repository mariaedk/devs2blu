
public class Aritmeticos {

	public static void main(String[] args) {
		int numero1 = 10, numero2 = 20, resultado = 0;
		float resto = 0f;
		
		//soma
		resultado = numero1 + numero2;
		System.out.println("O resultado da soma � :" + resultado);
		// subtracao
		resultado = numero1 - numero2;
		System.out.println("O resultado da subtra��o � :" + resultado);
		// multiplicacao
		resultado = numero1 * numero2;
		System.out.println("O resultado da multiplica��o � :" + resultado);
		// divisao
		resultado = numero2 / numero1;
		System.out.println("O resultado da divis�o � :" + resultado);
		//exponenciacao a fun��o Math.pow � a utilizada para potencia��o e n�o o ^, que equiva a um XOR
		numero1 = 2;
		numero2 = 3;
		resultado = (int)Math.pow(numero1, numero2);
		System.out.println("O resultado da exponencia��o � :" + resultado);
		// resto de divisao
		numero1 = 5;
		numero2 = 2;
		resto = numero1 % numero2;
		resultado = numero1 / numero2;
		System.out.println("O resultado da divis�o � " + resultado + " e o resto � :" + resto);

	}

}
