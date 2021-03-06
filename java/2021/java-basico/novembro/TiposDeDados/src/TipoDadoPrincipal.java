import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

//25/11/2021 - Maria Eduarda Krutzsch

public class TipoDadoPrincipal {

	public static void main(String[] args) {

		String nome; // caracteres
		
		int idade; // inteiro
		
		char sexo;
		
		float salario; // metade de um double -> tem 6 casas decimais (32 bits)
		
		double salarioAnual; // dobro de um float -> tem 10 casas decimais (64 bits)
		
		String dataNascimento;
		
		// formatador
		
		/* IMPORTANTE: cuidar com os tipos, pois usar demais double sem necessidade
		  pode causar sobrecarga no programa */
		
		/* entrada de dados DIRETA:
		 * nome = "Jo?o do Nascimento"; 
		 * idade = 45; 
		 * sexo = 'M'; 
		 * salario = 1000.00f; // f no final para informar que ? um float inv?s de um double 
		 * salarioAnual = 12000.00;
		 * 
		 */
				
		DateTimeFormatter formatador1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter formatador2 = DateTimeFormatter.ofPattern("d-MMM-yyyy");
		DateTimeFormatter formatador3 = DateTimeFormatter.ofPattern("M/d/yyyy");
		
		//nome = JOptionPane.showInputDialog("Qual o seu nome?");
		
		//idade = Integer.parseInt(JOptionPane.showInputDialog("Qual a sua idade?"));
		
		//sexo = JOptionPane.showInputDialog("Qual o sexo? ").charAt(0);
		
		//salario = Float.parseFloat(JOptionPane.showInputDialog("Qual o seu sal?rio?"));
		
		//salarioAnual = Double.parseDouble(JOptionPane.showInputDialog("Qual o seu sal?rio anual? "));
		
		dataNascimento = JOptionPane.showInputDialog("Informe a data de nascimento: ");
		
		LocalDate date1 = LocalDate.parse(dataNascimento, formatador1);

		
		System.out.println("----------------------------------------");
		System.out.println(date1); // aqui ele mostra o normal
		System.out.println(formatador1.format(date1)); // aqui ele mostra formatado com x formata??o
		
		System.out.println("----------------------------------------");
		System.out.println(date1);
		System.out.println(formatador2.format(date1));
		
		System.out.println("----------------------------------------");
		System.out.println(date1);
		System.out.println(formatador3.format(date1));
		
	}
}
