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

public class ListarClientes extends JFrame{

	private JFrame frame;
	public JButton btnNewButton;
	public JTextArea textArea;


	/**
	 * Create the application.
	 * @throws Exception 
	 */
	public ListarClientes(){
		initialize();
	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
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
		getContentPane().add(btnNewButton, BorderLayout.SOUTH);
		
		textArea = new JTextArea();
		textArea.setBounds(10, 37, 414, 156);
		getContentPane().add(textArea);
	}

}
