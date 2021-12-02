import javax.swing.JOptionPane;

public class usandoSwitch {
	public static void main(String[] args) {
		
		int opcao;
		
		opcao = Integer.parseInt(JOptionPane.showInputDialog("Informe a opção (1/2)"));
		
		switch(opcao)
		{
		
		case 1:
			System.out.println("Ímpar");
			System.out.println("Um");
			break;
			
		case 2:
			System.out.println("Par");
			
		default:
			JOptionPane.showMessageDialog(null, "Atenção! Opção inválida.");
		}
	}
}
