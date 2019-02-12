package aplicacao_swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CadastroCliente {

	private JFrame frame;
	public JLabel lblNewLabel;
	public JLabel lblNewLabel_1;
	public JTextField textField;
	public JLabel lblNomeDoCliente;
	public JTextField textField_1;
	public JLabel lblEmail;
	public JTextField textField_2;
	public JLabel lblEndereo;
	public JTextField textField_3;
	public JButton btnCadastrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroCliente window = new CadastroCliente();
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
	public CadastroCliente() {
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
		
		lblNewLabel = new JLabel("Cadastro de clientes");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblNewLabel.setBounds(135, 11, 244, 28);
		frame.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Telefone");
		lblNewLabel_1.setBounds(42, 50, 95, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(42, 65, 145, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		lblNomeDoCliente = new JLabel("Nome do cliente");
		lblNomeDoCliente.setBounds(42, 92, 145, 14);
		frame.getContentPane().add(lblNomeDoCliente);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(42, 106, 145, 20);
		frame.getContentPane().add(textField_1);
		
		lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(42, 132, 46, 14);
		frame.getContentPane().add(lblEmail);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(42, 146, 145, 20);
		frame.getContentPane().add(textField_2);
		
		lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setBounds(42, 172, 110, 14);
		frame.getContentPane().add(lblEndereo);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(42, 186, 145, 20);
		frame.getContentPane().add(textField_3);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(85, 212, 103, 23);
		frame.getContentPane().add(btnCadastrar);
	}

}
