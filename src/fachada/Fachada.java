package fachada;
import java.util.ArrayList;

import modelo.Cliente;
import modelo.Pedido;
import modelo.Produto;
import repositorio.Restaurante;

public class Fachada {
	private static Restaurante restaurante = new Restaurante();
	private static int idpedido=0;	//autoincremento
	private static int idproduto=0;	//autoincremento

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
	
	public static Cliente localizarCliente(String telefone) {
		for(Cliente c: restaurante.getClientes()) {
			if(c.getTelefone().equals(telefone)) {
				return c;
			}
		}
		return null;
	}
	
	public static ArrayList<Pedido> listarPedidos(String telefone_cliente){
		for (Cliente c : restaurante.getClientes()) {
			if(c.getTelefone().equals(telefone_cliente)) {
				return c.getPedidos();
			}
		}
		return null;
	}
	
	public static Produto cadastrarProduto(String nome, double preco)throws Exception {
		Produto p = Fachada.findProduto(nome);
		if (p != null) {
			throw new Exception("Produto ja cadastrado!");
		}
		idproduto ++;
		p = new Produto(idproduto, nome, preco);
		restaurante.getProdutos().add(p);
		return p;
	}
	
	public static Produto findProduto(String nome) {
		for (Produto p : restaurante.getProdutos()) {
			if(p.getNome().equals(nome)) 
				return p;
		}
		return null;
	}
	
	public static Cliente cadastrarCliente(String telefone, String nome, String email, String endereco) {
		Cliente c = new Cliente(telefone, nome, email, endereco);
		restaurante.getClientes().add(c);
		return c;
	}
	
	public static Pedido abrirPedido(String telefone_cliente)throws Exception {
		Cliente c = Fachada.localizarCliente(telefone_cliente);
		if(telefone_cliente.equals("")) {
			throw new Exception("Telefone invalido!");
		}
		if(c==null) {
			throw new Exception("Nao existe cliente com esse telefone!");
		}
		Pedido pedido = c.verificarPedidoAberto();
		if(pedido!=null)
			throw new Exception("Ja existe um pedido aberto para esse telefone!!");
		
		idpedido++;
		pedido = new Pedido(idpedido);
		pedido.setFechado(false);
		c.getPedidos().add(pedido);
    	restaurante.getPedidos().add(pedido);
    	pedido.setCliente(c);
		return pedido;
	}
	
	public static Produto localizarProduto(int id_produto) {
		for(Produto p : restaurante.getProdutos()) {
			if(p.getId() == id_produto) {
				return p;
			}
		}
		return null;
	}
	
	public static void adicionarProdutoPedido(String telefone_cliente, int id_produto) throws Exception {
		Cliente c = Fachada.localizarCliente(telefone_cliente);
		Produto p = Fachada.localizarProduto(id_produto);
		Pedido ped = c.verificarPedidoAberto();
		if(ped == null)
			throw new Exception("Não existe pedido aberto");
		if(p == null)
			throw new Exception("O produto nao existe");
		if(telefone_cliente.equals("")) 
			throw new Exception("Telefone invalido!");
		if(c==null)
			throw new Exception("Nao existe cliente com esse telefone!");
		
		ped.getProdutos().add(p);	
	}
	
	public static void removerProdutoPedido(String telefone_cliente, int id_produto)throws Exception{
		Cliente c = Fachada.localizarCliente(telefone_cliente);
		if(c==null)
			throw new Exception("Nao existe cliente com esse telefone!");
		Produto p = Fachada.localizarProduto(id_produto);
		
		if(p == null)
			throw new Exception("O produto nao existe");
		
		Pedido ped = c.verificarPedidoAberto();
		if(ped == null)
			throw new Exception("Não existe pedido aberto");
		
		ped.getProdutos().remove(p);

	}
	
	public static Pedido consultarPedido(String telefone_cliente)throws Exception{
		Cliente c = Fachada.localizarCliente(telefone_cliente);
		if(c == null || telefone_cliente.equals("")) {
			throw new Exception("Nao existe cliente com esse numero!");
		}
		Pedido p = c.verificarPedidoAberto();
		if(p==null) {
			throw new Exception("O cliente nao tem pedido aberto!");
		}
		return p;
	}
	
	public static void cancelarPedido(String telefone_cliente)throws Exception {
		Cliente c = Fachada.localizarCliente(telefone_cliente);
		if(c == null || telefone_cliente.equals("")) {
			throw new Exception("Nao existe cliente com esse numero!");
		}
		Pedido p = c.verificarPedidoAberto();
		if(p==null) {
				throw new Exception("O cliente nao tem pedido aberto!");
		}
		c.getPedidos().remove(p);
		restaurante.getPedidos().remove(p);
		for(Produto prod: restaurante.getProdutos()) {
			for(Pedido ped : prod.getPedidos()) {
				if(ped == p) {
				prod.getPedidos().remove(p);}
			}
		}
		
	}
	
	public static void fecharPedido(String telefone_cliente, String nome_entregador)throws Exception{
		Cliente c = Fachada.localizarCliente(telefone_cliente);
		if(c == null || telefone_cliente.equals("")) {
			throw new Exception("Nao existe cliente com esse numero!");
		}
		Pedido p = c.verificarPedidoAberto();
		if(p==null) {
			throw new Exception("O cliente nao tem pedido aberto!");
		}
		p.setEntregador(nome_entregador);
		p.setFechado(true);
	}
	
	public static double calcularArrecadacao(int dia) {
		ArrayList<Pedido> pedidosFechados = new ArrayList<Pedido>();
		for(Pedido p : Fachada.listarPedidos()) 
			if(p.isFechado() && p.getData().getDayOfMonth() == dia)
				pedidosFechados.add(p);
		
		int soma = 0;
		for (Pedido p: pedidosFechados) 
			for (Produto prod: p.getProdutos()) 
				soma+=prod.getpreco();
		
		return soma;
	}
	
		

}
