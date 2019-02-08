package fachada;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeMessage.RecipientType;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import modelo.Cliente;
import modelo.Pedido;
import modelo.Produto;
import repositorio.Restaurante;

public class Fachada {
	private static Restaurante restaurante = new Restaurante();
	private static int idpedido=0;	//autoincremento
	private static int idproduto=0;	//autoincremento

	public static ArrayList<Produto> listarProdutos(String nome) {
		ArrayList<Produto> produtosListagem = new ArrayList<Produto>();
		for (Produto p : restaurante.getProdutos()) {
			if(p.getNome().contains(nome))
				produtosListagem.add(p);
		}
		if (produtosListagem.isEmpty()){
			return restaurante.getProdutos();
		}
		return produtosListagem;
	}
	
	public static ArrayList<Cliente> listarClientes(){
		return restaurante.getClientes();
	}
	
	public static ArrayList<Pedido> listarPedidos(){
		return restaurante.getPedidos();
	}
	
	public static Cliente localizarCliente(String telefone) {
		for(Cliente c: restaurante.getClientes()) {
			if(c.getTelefone().equals(telefone)) {
				return c;
			}
		}
		return null;
	}
	
	public static ArrayList<Pedido> listarPedidos(String telefone_cliente){
		for (Cliente c : restaurante.getClientes()) {
			if(c.getTelefone().equals(telefone_cliente)) {
				return c.getPedidos();
			}
		}
		return null;
	}
	
	public static Produto cadastrarProduto(String nome, double preco)throws Exception {
		Produto p = Fachada.findProduto(nome);
		if (p != null) {
			throw new Exception("Produto ja cadastrado!");
		}
		idproduto ++;
		p = new Produto(idproduto, nome, preco);
		restaurante.getProdutos().add(p);
		return p;
	}
	
	public static Produto findProduto(String nome) {
		for (Produto p : restaurante.getProdutos()) {
			if(p.getNome().equals(nome)) 
				return p;
		}
		return null;
	}
	
	public static Cliente cadastrarCliente(String telefone, String nome, String email, String endereco) throws Exception{
		for(Cliente c: Fachada.restaurante.getClientes()) {
			if (c.getTelefone().equals(telefone))
				throw new Exception("Cliente já cadastrado com esse numero");
		}
		Cliente c = new Cliente(telefone, nome, email, endereco);
		restaurante.getClientes().add(c);
		return c;
	}
	
	public static Pedido abrirPedido(String telefone_cliente)throws Exception {
		Cliente c = Fachada.localizarCliente(telefone_cliente);
		if(telefone_cliente.equals("")) {
			throw new Exception("Telefone invalido!");
		}
		if(c==null) {
			throw new Exception("Nao existe cliente com esse telefone!");
		}
		Pedido pedido = c.verificarPedidoAberto();
		if(pedido!=null)
			throw new Exception("Ja existe um pedido aberto para esse telefone!!");
		
		idpedido++;
		pedido = new Pedido(idpedido);
		pedido.setFechado(false);
		c.getPedidos().add(pedido);
    	restaurante.getPedidos().add(pedido);
    	pedido.setCliente(c);
		return pedido;
	}
	
	public static Produto localizarProduto(int id_produto) {
		for(Produto p : restaurante.getProdutos()) {
			if(p.getId() == id_produto) {
				return p;
			}
		}
		return null;
	}
	
	public static void adicionarProdutoPedido(String telefone_cliente, int id_produto) throws Exception {
		Cliente c = Fachada.localizarCliente(telefone_cliente);
		Produto p = Fachada.localizarProduto(id_produto);
		Pedido ped = c.verificarPedidoAberto();
		if(ped == null)
			throw new Exception("NÃ£o existe pedido aberto");
		if(p == null)
			throw new Exception("O produto nao existe");
		if(telefone_cliente.equals("")) 
			throw new Exception("Telefone invalido!");
		if(c==null)
			throw new Exception("Nao existe cliente com esse telefone!");
		
		ped.getProdutos().add(p);	
	}
	
	public static void removerProdutoPedido(String telefone_cliente, int id_produto)throws Exception{
		Cliente c = Fachada.localizarCliente(telefone_cliente);
		if(c==null)
			throw new Exception("Nao existe cliente com esse telefone!");
		Produto p = Fachada.localizarProduto(id_produto);
		
		if(p == null)
			throw new Exception("O produto nao existe");
		
		Pedido ped = c.verificarPedidoAberto();
		if(ped == null)
			throw new Exception("NÃ£o existe pedido aberto");
		
		ped.getProdutos().remove(p);

	}
	
	public static Pedido consultarPedido(String telefone_cliente)throws Exception{
		Cliente c = Fachada.localizarCliente(telefone_cliente);
		if(c == null || telefone_cliente.equals("")) {
			throw new Exception("Nao existe cliente com esse numero!");
		}
		Pedido p = c.verificarPedidoAberto();
		if(p==null) {
			throw new Exception("O cliente nao tem pedido aberto!");
		}
		return p;
	}
	
	public static void cancelarPedido(String telefone_cliente)throws Exception {
		Cliente c = Fachada.localizarCliente(telefone_cliente);
		if(c == null || telefone_cliente.equals("")) {
			throw new Exception("Nao existe cliente com esse numero!");
		}
		Pedido p = c.verificarPedidoAberto();
		if(p==null) {
				throw new Exception("O cliente nao tem pedido aberto!");
		}
		c.getPedidos().remove(p);
		restaurante.getPedidos().remove(p);
		for(Produto prod: restaurante.getProdutos()) {
			for(Pedido ped : prod.getPedidos()) {
				if(ped == p) {
				prod.getPedidos().remove(p);}
			}
		}
		
	}
	
	public static void fecharPedido(String telefone_cliente, String nome_entregador)throws Exception{
		Cliente c = Fachada.localizarCliente(telefone_cliente);
		if(c == null || telefone_cliente.equals("")) {
			throw new Exception("Nao existe cliente com esse numero!");
		}
		Pedido p = c.verificarPedidoAberto();
		if(p==null) {
			throw new Exception("O cliente nao tem pedido aberto!");
		}
		p.setEntregador(nome_entregador);
		p.setFechado(true);
	}
	
	public static double calcularArrecadacao(int dia) {
		ArrayList<Pedido> pedidosFechados = new ArrayList<Pedido>();
		for(Pedido p : Fachada.listarPedidos()) 
			if(p.isFechado() && p.getData().getDayOfMonth() == dia)
				pedidosFechados.add(p);
		
		int soma = 0;
		for (Pedido p: pedidosFechados) 
			for (Produto prod: p.getProdutos()) 
				soma+=prod.getpreco();
		
		return soma;
	}
	
	public static void enviarPedido(String telefone, String email) throws MessagingException {
		Document document = new Document();
		Cliente cli = Fachada.localizarCliente(telefone);
		Pedido ultimoPedido = cli.getUltimoPedido(); 
		
		final String emailEnvio = "lucascvasconcelos2@gmail.com";
		final String senha = "luc09870";
		
		Properties props = new Properties();
		props.put("mail.smtp.host", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(emailEnvio, senha);
			}
		});

		
		try {
			//Instanciando o documento PDF
			PdfWriter.getInstance(document, new FileOutputStream("pdf//teste.pdf"));
			document.setPageSize(PageSize.A6);
			//Adicionando um titulo ao arquivo
			document.addSubject("Testando criação de PDF em Java com api Itext");
			//setando o criador do arquivo
			document.addCreator("iText");
			//setando o autor do arquivo criado
			document.addAuthor("Restaurane Ifoof");
			//Abrindo o documento PDF criado
			document.open();
			
			// adicionando um parágrafo ao documento
			document.add(new Paragraph(ultimoPedido.toString()));
			document.close();
			//Se arquivo for criado com sucesso, é exibida uma mensagem de confirmação
			System.out.println("PDF criado com sucesso!");
			//criando a mensagem
			MimeMessage msg = new MimeMessage(session);

			//inserir os emails 
			Address from = new InternetAddress(emailEnvio);
			Address to = new InternetAddress(email);

			//configurando o remetente e o destinatario
			msg.setFrom(from);
			msg.addRecipient(RecipientType.TO, to);

			//configurando a data de envio,  o assunto e o texto da mensagem
			msg.setSentDate(new Date());
			msg.setSubject("Enviando Email com mensagem e anexo");		
			msg.setSubject("Email com último pedido realizado: " );
			msg.setText("exemplo de email");
			msg.setHeader("XPriority", "1");
			
			// conteudo html que sera atribuido a mensagem
			String htmlMessage = "<html> Email com anexo </html>";
			//criando a Multipart
			Multipart multipart = new MimeMultipart();
			//criando a primeira parte da mensagem
			MimeBodyPart attachment0 = new MimeBodyPart();
			//configurando o htmlMessage com o mime type
			attachment0.setContent(htmlMessage,"text/html; charset=UTF-8");
			//adicionando na multipart
			multipart.addBodyPart(attachment0);
			//arquivo que será anexado
			String pathname = "pdf/teste.pdf";
			
			File file = new File(pathname);
			//criando a segunda parte da mensagem
			MimeBodyPart attachment1 = new MimeBodyPart();  
			attachment1.setDataHandler(new DataHandler(new FileDataSource(file)));
			
			attachment1.setFileName(file.getName());
			
			multipart.addBodyPart(attachment1);

			msg.setContent(multipart);
			
			Transport.send(msg);
			
			System.out.println("Email enviado com sucesso!");
		} catch (MessagingException mex) {
			System.out.println("problema no envio" + mex);
		}
		catch(DocumentException de) {         
			System.out.println(de.getMessage());
		}
		catch(IOException ioe) {
			System.out.println(ioe.getMessage());
		}
		document.close();
		


	}
		

}
