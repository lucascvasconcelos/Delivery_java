package aplicacao_swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import fachada.Fachada;
import modelo.Pedido;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class ListarPedidoCliente {

	private JFrame frame;
	public JLabel lblNewLabel;
	public JTextField textField;
	public JButton btnNewButton;
	public JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarPedidoCliente window = new ListarPedidoCliente();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ListarPedidoCliente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("Informe o n\u00FAmero do telefone do cliente:");
		lblNewLabel.setBounds(10, 11, 233, 25);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(10, 35, 113, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		btnNewButton = new JButton("Listar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(Pedido p:Fachada.listarPedidos(textField.getText())){
					textArea.setText(textArea.getText()+ p + "\n");
				}
			}
		});
		btnNewButton.setBounds(133, 34, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		textArea = new JTextArea();
		textArea.setBounds(10, 76, 346, 146);
		frame.getContentPane().add(textArea);
	}

}
