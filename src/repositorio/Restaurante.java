package repositorio;

import java.util.ArrayList;

import modelo.Cliente;
import modelo.Pedido;
import modelo.Produto;

public class Restaurante {
	private ArrayList<Produto> produtos = new ArrayList<Produto>();
	private ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	
	public void adicionar(Produto p){
		produtos.add(p);
	}
	
	public ArrayList<Produto> getProdutos() {
		return produtos;
	}
	
	public ArrayList<Pedido> getPedidos() {
		return pedidos;
	}
	
	public ArrayList<Cliente> getClientes(){
		return clientes;
	}
}
