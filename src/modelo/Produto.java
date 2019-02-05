package modelo;

import java.util.ArrayList;

public class Produto {
	private int id;
	private String nome;
	private double pre�o;
	private ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
	
	//CONSTRUTOR
	public Produto(String nome, double pre�o) {
		super();
		this.nome = nome;
		this.pre�o = pre�o;
	}
	
	//M�TODOS ESPECIAIS
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

	public double getPre�o() {
		return pre�o;
	}

	public void setPre�o(double pre�o) {
		this.pre�o = pre�o;
	}

}
