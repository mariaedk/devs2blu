package EncapsulamentoModel;

public class Encapsulamento {

	public static void main(String[] args) {
		// Este projeto pretende demonstrar como funciona o encapsulamento em JAVA
		
		// A Classe Livro deve ser instanciada para que possamos utiliz�-la
		// Lembre-se que: uma classe n�o instanciada � somente um arquivo texto
		
		Livro liv = new Livro();
		// o new � um construtor nativo que permite a cria��o do objeto liv
		// atrav�s do objeto � que conseguimos utilizr os atributos e m�todos
		// da referida classe
		
		// atribuindo valores ao atributos que est�o "privados"
		liv.setAutor("Jos� de Alencar");
		liv.setTitulo("Iracema");
		
		// imprimindo o conte�do dos atributos
		System.out.println(liv.toString());

	}

}
