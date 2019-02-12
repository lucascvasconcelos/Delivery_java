package modelo;
import java.util.ArrayList;

public class Combo extends Produto{
	private ArrayList<Produto> produtos = new ArrayList<Produto>();
	double precoCombo = 0;
	
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
		for(Produto p: produtos) {
			precoCombo = precoCombo + p.getpreco();
		}
		precoCombo = precoCombo - (precoCombo*0.1);
		return precoCombo;
	}

	@Override
	public String toString() {
		return "Combo "+getNome()+"("+getId()+")"+
				"\nProdutos: "+getProdutos()+
				"\nPreço do combo: "+getpreco()+
				"\n";
	}
	
}
