package aplicacao_swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

import fachada.Fachada;
import modelo.Produto;

import javax.swing.JList;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ListarProdutos extends JFrame{

	private JFrame frame;
	public JLabel lblNewLabel;
	public JTextField textField;
	public JButton btnListar;
	public JSeparator separator;
	public JTextArea textArea;

	/**
	 * Create the application.
	 * @throws Exception 
	 */
	public ListarProdutos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("Informe o produto que deseja buscar:");
		lblNewLabel.setBounds(10, 11, 239, 23);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(20, 33, 130, 23);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				for (Produto p : Fachada.listarProdutos(textField.getText())) {
					textArea.setText(textArea.getText() + p +"\n");
				}
			}
		});
		btnListar.setBounds(160, 33, 89, 23);
		getContentPane().add(btnListar);
		
		separator = new JSeparator();
		separator.setBounds(10, 67, 266, 13);
		getContentPane().add(separator);
		
		textArea = new JTextArea();
		textArea.setBounds(20, 91, 256, 108);
		getContentPane().add(textArea);
	}
}
