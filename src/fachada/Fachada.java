package fachada;
import java.util.ArrayList;

import modelo.Cliente;
import modelo.Pedido;
import modelo.Produto;
import repositorio.Restaurante;

public class Fachada {
	private static Restaurante restaurante = new Restaurante();
	private static int idpedido=0;	//autoincremento

	public static ArrayList<Produto> listarProdutos(String nome) {
		ArrayList<Produto> produtosListagem = new ArrayList<Produto>();
		for (Produto p : restaurante.getProdutos()) {
			if(p.getNome().contains(nome))
				produtosListagem.add(p);
		}
		if (produtosListagem.isEmpty()){
			return restaurante.getProdutos();
		}
		return produtosListagem;
	}
	
	public static ArrayList<Cliente> listarClientes(){
		return restaurante.getClientes();
	}
	
	public static ArrayList<Pedido> listarPedidos(){
		return restaurante.getPedidos();
	}
	
	public static ArrayList<Pedido> listarPedidos(String telefone_cliente){
		for (Cliente c : restaurante.getClientes()) {
			if(c.getTelefone().equals(telefone_cliente)) {
				return c.getPedidos();
			}
		}
		return null;
	}
	
	public static Produto cadastrarProduto(String nome, double preco) {
		Produto p = new Produto(nome, preco);
		restaurante.getProdutos().add(p);
		return p;
	}
	
	public static Cliente cadastrarCliente(String nome, String telefone) {
		Cliente c = new Cliente(telefone, nome);
		restaurante.getClientes().add(c);
		return c;
	}
	
	public static Pedido abrirPedido(String telefone_cliente) {
		idpedido ++;
		Pedido p = new Pedido(idpedido);
		for (Cliente c : restaurante.getClientes()) {
			if(c.getTelefone().equals(telefone_cliente)) {
				c.getPedidos().add(p);
				return p;
			}
		}
		return null;
	}
	
}
