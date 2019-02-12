package aplicacao_swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

import fachada.Fachada;
import modelo.Cliente;

import javax.swing.JList;

public class ListarClientes {

	private JFrame frame;
	public JButton btnNewButton;
	public JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarClientes window = new ListarClientes();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws Exception 
	 */
	public ListarClientes() throws Exception {
		initialize();
		Fachada.cadastrarCliente("98820-0222", "maria", "maria@gmail.com","Rua da Justiça, 12");
		Fachada.cadastrarCliente("98745-0643", "joao", "joao@gmail.com","Rua dos Tronos, 3");
	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnNewButton = new JButton("Listar clientes");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				for(Cliente c : Fachada.listarClientes()) {
					textArea.setText(textArea.getText() + c + "\n");
				}
			}
		});
		btnNewButton.setBounds(100, 216, 236, 34);
		frame.getContentPane().add(btnNewButton, BorderLayout.SOUTH);
		
		textArea = new JTextArea();
		textArea.setBounds(10, 37, 414, 156);
		frame.getContentPane().add(textArea);
	}

}
