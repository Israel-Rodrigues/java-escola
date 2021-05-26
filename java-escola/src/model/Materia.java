package model;

/**
 * Classe para armazenar os atributos e metodos do objeto mat�ria
 *
 * @author Israel Oliveira Rodrigues
 * @since 23 de fev. de 2021
 * 
 */
public class Materia {
	
	// Declara��o dos atributos do objeto mat�ria
	private int codigo;
	private String nome;
	
	// M�todos para execu��o da classe
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
