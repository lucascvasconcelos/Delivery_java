package aplicacao_console;

import java.util.ArrayList;

import fachada.Fachada;
import modelo.Combo;
import modelo.Produto;
import repositorio.Restaurante;

public class Testando {
	public static void main(String[] args) {
		Restaurante r = new Restaurante();
		System.out.println(r.getProdutos());
		ArrayList<Integer> ids = new ArrayList<>();
		try {
			Produto p = Fachada.cadastrarProduto("Pizza", 2);
			Combo c = Fachada.criarCombo("blas", ids);
			System.out.println(Fachada.listarProdutos());
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
}
