package model;

/**
 * Classe para armazenar os atributos e metodos do objeto matéria
 *
 * @author Israel Oliveira Rodrigues
 * @since 23 de fev. de 2021
 * 
 */
public class Materia {
	
	// Declaração dos atributos do objeto matéria
	private int codigo;
	private String nome;
	
	// Métodos para execução da classe
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
