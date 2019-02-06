package modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Pedido {
	private int id;
	private LocalDateTime data;
	private double total;
	private String entregador;
	private boolean fechado;
	private ArrayList<Produto> produtos = new ArrayList<Produto>();
	
	public Pedido(int id) {
		super();
		this.id = id;
	}
}
