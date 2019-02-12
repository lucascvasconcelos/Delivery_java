package aplicacao_swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

import fachada.Fachada;
import modelo.Pedido;

public class ListarPedidos extends JFrame{

	private JFrame frame;
	public JButton btnNewButton;
	public JTextArea textArea;


	/**
	 * Create the application.
	 */
	public ListarPedidos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		btnNewButton = new JButton("Listar pedidos");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				for(Pedido p: Fachada.listarPedidos()) {
					textArea.setText(textArea.getText() + p + "\n");
				}
			}
		});
		btnNewButton.setBounds(110, 191, 207, 39);
		getContentPane().add(btnNewButton);
		
		textArea = new JTextArea();
		textArea.setBounds(61, 39, 308, 141);
		getContentPane().add(textArea);
	}

}
