package fachada;
import java.util.ArrayList;

import modelo.Cliente;
import modelo.Pedido;
import modelo.Produto;
import repositorio.Restaurante;

public class Fachada {
	private static Restaurante restaurante = new Restaurante();

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
	
	public static ArrayList<Pedido> listarPedidos(String Telefone_cliente){
		for (Cliente c : restaurante.getClientes()) {
			if(c.getTelefone().equals(Telefone_cliente)) {
				return c.getPedidos();
			}
		}
		return null;
	}
	
	public static Produto cadastrarProduto(String nome, double preco) {
		Produto p = new Produto(nome, preco);
		restaurante.adicionar(p);
		return p;
	}
	
	
}
