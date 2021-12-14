package EncapsulamentoModel;

public class Encapsulamento {

	public static void main(String[] args) {
		// Este projeto pretende demonstrar como funciona o encapsulamento em JAVA
		
		// A Classe Livro deve ser instanciada para que possamos utilizá-la
		// Lembre-se que: uma classe não instanciada é somente um arquivo texto
		
		Livro liv = new Livro();
		// o new é um construtor nativo que permite a criação do objeto liv
		// através do objeto é que conseguimos utilizr os atributos e métodos
		// da referida classe
		
		// atribuindo valores ao atributos que estão "privados"
		liv.setAutor("José de Alencar");
		liv.setTitulo("Iracema");
		
		// imprimindo o conteúdo dos atributos
		System.out.println(liv.toString());

	}

}
