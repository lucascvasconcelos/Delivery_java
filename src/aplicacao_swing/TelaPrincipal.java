package aplicacao_swing;
 
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
 
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
 
import fachada.Fachada;
import modelo.*;
 
public class TelaPrincipal {
 
    private JFrame frame;
    private JMenuItem mntmCadastrar;
    private JMenuItem mntmListar;
    private JMenu mnProduto;
    private JLabel label;
 
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TelaPrincipal window = new TelaPrincipal();
                    window.frame.setVisible(true);
            		Fachada.cadastrarCliente("98820-0222", "maria", "maria@gmail.com","Rua da Justiça, 12");
            		Fachada.cadastrarCliente("98745-0643", "joao", "joao@gmail.com","Rua dos Tronos, 3");
            		Fachada.cadastrarProduto("Pizza", 30);
            		Fachada.cadastrarProduto("Sushi", 40);
            		Fachada.abrirPedido("98745-0643");
            		Fachada.abrirPedido("98820-0222");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
 
    /**
     * Create the application.
     */
    public TelaPrincipal() {
        initialize();
    }
 
    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setResizable(false);
        frame.setTitle("RESTAURANTE");
 
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent arg0) {
            }
            @Override
            public void windowClosing(WindowEvent e) {
                JOptionPane.showMessageDialog(null, "até breve !");
            }
        });
 
        frame.setBounds(100, 100, 384, 271);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
 
        label = new JLabel("");
        label.setBounds(0, 0, 378, 221);
     
        frame.getContentPane().add(label);
 
        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
 
        mnProduto = new JMenu("Produto");
        menuBar.add(mnProduto);
 
        mntmCadastrar = new JMenuItem("Cadastrar");
        mntmCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                CadastroProduto j = new CadastroProduto();
                j.setVisible(true);
            }
        });
        mnProduto.add(mntmCadastrar);
 
        mntmListar = new JMenuItem("Listar");
        mntmListar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                ListarProdutos j = new ListarProdutos();
                j.setVisible(true);
            }
        });
 
        JMenuItem mntmApagar = new JMenuItem("Apagar");
        mntmApagar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                TelaApagarProduto j = new TelaApagarProduto();
                j.setVisible(true);
            }
        });
        mnProduto.add(mntmApagar);
        mnProduto.add(mntmListar);
 
        JMenu mnPrateleira = new JMenu("Cliente");
        menuBar.add(mnPrateleira);
 
        JMenuItem mntmCriar = new JMenuItem("Criar");
        mntmCriar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                TelaCadastroPrateleira j = new TelaCadastroPrateleira();
                j.setVisible(true);
            }
        });
        mnPrateleira.add(mntmCriar);
 
        JMenuItem mntmListar_1 = new JMenuItem("Listar");
        mntmListar_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ListarClientes j = new ListarClientes();
                j.setVisible(true);
            }
        });
        mnPrateleira.add(mntmListar_1);
 
        JMenuItem mntmInserirProduto = new JMenuItem("Inserir produto");
        mntmInserirProduto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                TelaProdutoPrateleira j = new TelaProdutoPrateleira();
                j.setVisible(true);
            }
        });
        mnPrateleira.add(mntmInserirProduto);
 
        JMenuItem mntmRemoverProduto = new JMenuItem("Remover produto");
        mntmRemoverProduto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                TelaProdutoPrateleira j = new TelaProdutoPrateleira();
                j.setVisible(true);
            }
        });
        mnPrateleira.add(mntmRemoverProduto);
 
        JMenu mnConsulta = new JMenu("Pedido");
        mnConsulta.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                ListarPedidos j = new ListarPedidos();
                j.setVisible(true);
            }
        });
        menuBar.add(mnConsulta);
 
    }
}