package modelo;

import java.util.ArrayList;

public class Cliente {
	private String telefone;
	private String nome;
	private String email;
	private String endereco;
	private ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
	
	//CONSTRUTOR DA CLASSE

	public Cliente(String telefone, String nome, String email, String endereco) {
		super();
		this.telefone = telefone;
		this.nome = nome;
		this.email = email;
		this.endereco = endereco;
	}

	//M�TODOS ESPECIAIS
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public ArrayList<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(ArrayList<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public Pedido verificarPedidoAberto() {
		for(Pedido p : pedidos){
			if(!p.isFechado())
				return p;
		}
		return null;
	}
	
}
