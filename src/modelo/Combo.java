package modelo;
import java.util.ArrayList;
import java.util.List;

public class Combo extends Produto{
	private ArrayList<Produto> produtos = new ArrayList<Produto>();
	
	public Combo(int id, String nome, double preco) {
		super(id, nome, preco);
	}
	
	public void adicionarProdutoCombo(Produto p) {
		produtos.add(p);
	}
	public void removerProdutoCombo(Produto p) {
		produtos.remove(p);
	}
	public ArrayList<Produto> getProdutos() {
		return produtos;
	}
	public double getpreco() {
		return preco * 0.9;
	}
	public void adicionarProdutos (List<Produto> produtos) {
		produtos.addAll(produtos);
	}
	
	public void adicionarProduto (Produto produto) {
		produtos.add(produto);
	}
	
	@Override
	public String toString() {
		return "Combo "+getNome()+"("+getId()+")"+
				"\nProdutos: "+getProdutos()+
				"\nPre�o do combo: "+getpreco()+
				"\n";
	}
	
}
