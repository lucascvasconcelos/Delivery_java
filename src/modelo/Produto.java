package modelo;

import java.util.ArrayList;

public class Produto {
	private int id;
	private String nome;
	private double preço;
	private ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
	
	//CONSTRUTOR
	public Produto(String nome, double preço) {
		super();
		this.nome = nome;
		this.preço = preço;
	}
	
	//MÉTODOS ESPECIAIS
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreço() {
		return preço;
	}

	public void setPreço(double preço) {
		this.preço = preço;
	}

}
