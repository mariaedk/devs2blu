import javax.swing.JOptionPane;

public class usoWhile 
{

	public static void main(String[] args) 
	{
		// informar a qtde de notas, pedir as notas e calcular a m�dia
		
		float nota, media = 0;
		int qtdNotas, contaNotas;
		
		qtdNotas = Integer.parseInt(JOptionPane.showInputDialog("Informe a qtd de notas:"));
		
		contaNotas = 1;
		while (contaNotas <= qtdNotas)
		{
			
			nota = Float.parseFloat(JOptionPane.showInputDialog("Informe a nota nr� " + contaNotas));
			
			media+= nota;
			contaNotas++;
		}
		
		media = media / qtdNotas;
		
		JOptionPane.showMessageDialog(null, "M�dia aritm�tica final: " + media);
	}
}
