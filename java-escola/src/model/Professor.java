package model;

import java.util.ArrayList;

/**
 * Classe responsavel por armazenar os atributos e metodos do objeto Professor 
 *
 * @author Israel Oliveira Rodrigues
 * @since 23 de fev. de 2021
 * 
 */
public class Professor extends Funcionario {
	
	// Declarando os atributos do professor
	private ArrayList<Materia> listaMaterias;
	
	// Método para execução da classe
	public ArrayList<Materia> getListaMaterias() {
		return listaMaterias;
	}
	public void setListaMaterias(ArrayList<Materia> listaMaterias) {
		this.listaMaterias = listaMaterias;
	}
}
