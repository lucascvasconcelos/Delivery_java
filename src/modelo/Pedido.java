package modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Pedido {
	private int id;
	private LocalDateTime data;
	private double total;
	private String entregador;
	private boolean fechado;
	private Cliente cliente;
	private ArrayList<Produto> produtos = new ArrayList<Produto>();
	
	public Pedido(int id) {
		super();
		data = LocalDateTime.now();
		this.id = id;
	}
	
	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public String getEntregador() {
		return entregador;
	}

	public void setEntregador(String entregador) {
		this.entregador = entregador;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public boolean isFechado() {
		return fechado;
	}

	public void setFechado(boolean fechado) {
		this.fechado = fechado;
	}

	public ArrayList<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", data=" + data + ", total=" + total + ", entregador=" + entregador + ", fechado="
				+ fechado + ", cliente=" + cliente.getNome() + ", produtos=" + produtos + "]";
	}

	

}
