package aplicacao_swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroProduto {

	private JFrame frame;
	private JLabel lblCadastroDeProdutos;
	public JLabel lblInformeOPreo;
	public JLabel lblInformeONome;
	public JTextField textField;
	public JTextField textField_1;
	public JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroProduto window = new CadastroProduto();
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
	public CadastroProduto() {
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
		
		lblCadastroDeProdutos = new JLabel("Cadastro de produtos");
		lblCadastroDeProdutos.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblCadastroDeProdutos.setBounds(130, 0, 184, 34);
		frame.getContentPane().add(lblCadastroDeProdutos);
		
		lblInformeOPreo = new JLabel("Informe o pre\u00E7o:");
		lblInformeOPreo.setBounds(32, 103, 110, 20);
		frame.getContentPane().add(lblInformeOPreo);
		
		lblInformeONome = new JLabel("Informe o nome do produto:");
		lblInformeONome.setBounds(32, 54, 164, 20);
		frame.getContentPane().add(lblInformeONome);
		
		textField = new JTextField();
		textField.setBounds(30, 72, 134, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(30, 121, 134, 20);
		frame.getContentPane().add(textField_1);
		
		btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(64, 152, 101, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
