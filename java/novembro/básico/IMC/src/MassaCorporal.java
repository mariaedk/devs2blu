// 26/11/2021 - Maria Eduarda Krutzsch

import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class MassaCorporal 
{
	public static void main(String[] args) 
	{
		// Máscara de formatação
		DecimalFormat formatador =  new DecimalFormat("##.####");
		
		float altura, peso, imc;
		
		// Prompt usuário para dados
		altura = Float.parseFloat(JOptionPane.showInputDialog("Informe a altura: "));
		peso = Float.parseFloat(JOptionPane.showInputDialog("Informe o peso: "));
		
		// Calcula o IMC
		imc = peso / (altura * altura);
		System.out.println("IMC: " + formatador.format(imc));
		System.out.print("Seu IMC é considerado: ");
		
		if (imc > 40)
		{
			System.out.println("Obesidade grave");
		}
		else if (imc >= 30)
		{
			System.out.println("Obesidade");
		}
		else if (imc >= 25)
		{
			System.out.println("Sobrepeso");
		}
		else if (imc >= 18.5)
		{
			System.out.println("Normal");
		}
		else
		{
			System.out.println("Magreza");
		}
	}
}
