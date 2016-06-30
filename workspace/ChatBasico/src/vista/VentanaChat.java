package vista;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import modelo.Cliente;


/**
 * 
 * @author
 *
 */
public final class VentanaChat extends JFrame implements ActionListener, MouseListener {
	/**
	 * 2.- crear la variable de la instancia
	 */
	private static final VentanaChat chat=new VentanaChat();
	
	/**
	 * Atributos de la clase
	 */
	private JLabel lbTit=new JLabel("Bienvenido Al Chat Básico");
	private JLabel lbUsua=new JLabel ("Usuario");
	private JLabel lbSubT=new JLabel("Escribe el mensaje que quieres enviar");
	private JTextField txtNom = new JTextField();
	private JTextField txtMensaje=new JTextField();
	private Container c=getContentPane();
	private JButton btnEnviar=new JButton("Enviar");
	private JTextPane Jpane=new JTextPane();
	private JScrollPane scroll=new JScrollPane();
	private JButton btnSesion=new JButton("Salir");
	private int user=0;
	Cliente cte=Cliente.instanciaCte();
	
	//Imagen
		private ImageIcon salir=new ImageIcon(super.getClass().getResource("/Icons/salir.png"));
		private ImageIcon usua=new ImageIcon(super.getClass().getResource("/Icons/usuario.png"));
	/**
	 * constructor de la clase
	 * 3- tipo final
	 */
	Cliente clien;
	private JTextField textField;
	VentanaChat(){
		super.setTitle("Chat Básico");
		super.setSize(350, 550);
		setLocationRelativeTo(null);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		cargarObjetos();
		
		textField = new JTextField();
		textField.setBounds(10, 400, 124, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre ");
		lblNombre.setBounds(10, 371, 46, 14);
		getContentPane().add(lblNombre);
		 Thread hilo = new Thread(clien);
		 hilo.start();
	}
	
	/**
	 * Método que contiene los objetos y ubicación de los mismos
	 */
	
	private void cargarObjetos() {
		c.setLayout(null);
		c.setBackground(Color.WHITE);
		getContentPane();
		
		Jpane.setContentType("text/html"); // NOI18N
		Jpane.setBounds(10,50, 380, 280);
		Jpane.disable();
		Jpane.setDisabledTextColor(Color.BLUE);
		c.add(Jpane);
		
		lbTit.setBounds(80, 10, 190, 30);
	
		c.add(lbTit);
		
		lbUsua.setBounds(10, 400, 32, 32);
		lbUsua.setIcon(usua);
		c.add(lbUsua);
		lbSubT.setBounds(10, 430, 300, 30);
		c.add(lbSubT);
		
		txtMensaje.setBounds(10, 460, 240, 30);
		c.add(txtMensaje);
		
		btnEnviar.setBounds(255, 460, 75,30);
		btnEnviar.addActionListener(this);
		c.add(btnEnviar);
		
		btnSesion.setBounds(260, 2, 80, 40);
		btnSesion.setBorder(null);
		btnSesion.setBackground(Color.WHITE);
		btnSesion.setBorder(null);
		btnSesion.setFocusable(false);
		btnSesion.setIcon(salir);
		btnSesion.addActionListener(this);
		c.add(btnSesion);
	}

	/**
	 * La acciones del botoón enviar, asi como de señalar un contacto
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnEnviar){
			String Usuario="";
			if(txtNom.getText().equals("")){
				txtNom.setText("Escribe tu Nombre");
				user=0;
			}
			if(txtMensaje.getText().equals("")){
				
				JOptionPane.showMessageDialog(null, "Necesitas ingresar un Mensaje");
			}else{
				String Mens=txtMensaje.getText();
				txtMensaje.setText(null);
				if(txtNom.getText().equals("Escribe tu Nombre")){
					
					Usuario="Anónimo";
					clien.enviarMensaje("<strong>" +Usuario+ ": </strong> "+Mens+"<br>");
				}else{
					Usuario=txtNom.getText();
					clien.enviarMensaje("<strong>" +Usuario+ ": </strong> "+Mens+"<br>");
				}
			}
			
		}else if(e.getSource()==btnSesion){
			int i=JOptionPane.showConfirmDialog(this,"¿Deseas Cerrar Sesión?","Cerrar Sesión",JOptionPane.YES_NO_OPTION);
			if(i==0){
				JOptionPane.showMessageDialog(null, "Hasta Pronto");
				this.dispose();
			}
			
		}
		
	}

	/**
	 * Método que retorna la instancia
	 */
	public static VentanaChat instanciaChat(){
		return chat;
		
	}
/**
 * Met que valia el click del botón
 * @param e evento
 */
	@Override
	public void mouseClicked(MouseEvent e) {
		if(user==0){
			txtNom.setText("");
			user=1;
		}
	}
	/**
	 *  Met que valia la presion del mause
	 * @param e evento
	 */

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * método del mause
	 * @param e evento
	 */

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * el mause se queda presionado
	 * @param e evento
	 */

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * presión del mouse
	 * @param e evento
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}

