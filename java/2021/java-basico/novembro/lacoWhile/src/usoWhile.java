import javax.swing.JOptionPane;

public class usoWhile 
{

	public static void main(String[] args) 
	{
		// informar a qtde de notas, pedir as notas e calcular a média
		
		float nota, media = 0;
		int qtdNotas, contaNotas;
		
		qtdNotas = Integer.parseInt(JOptionPane.showInputDialog("Informe a qtd de notas:"));
		
		contaNotas = 1;
		while (contaNotas <= qtdNotas)
		{
			
			nota = Float.parseFloat(JOptionPane.showInputDialog("Informe a nota nrº " + contaNotas));
			
			media+= nota;
			contaNotas++;
		}
		
		media = media / qtdNotas;
		
		JOptionPane.showMessageDialog(null, "Média aritmética final: " + media);
	}
}
