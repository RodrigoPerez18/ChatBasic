package vista;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import modelo.Conexion;


public class Login extends JFrame implements ActionListener {
	private Container contenedor=getContentPane();
	private JLabel lbusuario =new JLabel("Usuario: ");
	private JLabel lbcontrasenia =new JLabel("Contraseña:");
	private JLabel lbicon=new JLabel("");
	private JTextField txtUsuario =new JTextField(10);
	private JPasswordField txtcontrasenia =new JPasswordField();
	private JButton btnAccesar=new JButton("Accesar");
	private Conexion db=new Conexion();
	private String user, pass;
	private ResultSet rs=null;
	private String consulta;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	
public Login (){
		
		super.setTitle("Login");
		super.setSize(480,240);
		cargarControles();	
	}

	private void cargarControles(){
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/Imagenes/los-usuarios-de-foro-de-la-familia-icono-4429-96.png")));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contenedor.setLayout(null);
		
		lbusuario.setBounds(83, 51, 77, 14);
		txtcontrasenia.setBounds(202, 101, 86, 20);
		
		lbcontrasenia.setBounds(83, 104, 77, 14);
		txtUsuario.setBounds(202, 48, 86, 20);
	
		btnAccesar.setBounds(190,140,117,20);
		btnAccesar.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/descarga (1).jpg")));
		
		lbicon = new JLabel("");
		lbicon.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/los-usuarios-de-foro-de-la-familia-icono-4429-96.png")));
		lbicon.setBounds(314, 51, 96, 82);
		contenedor.add(lbicon);
		
		contenedor.add(lbusuario);
		contenedor.add(txtUsuario);
		contenedor.add(lbcontrasenia);
		contenedor.add(txtcontrasenia);
		contenedor.add(btnAccesar);
		
		btnAccesar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		VentanaChat vc=new VentanaChat();
		boolean estado=false;
		user=txtUsuario.getText();
		pass=new String(txtcontrasenia.getPassword());
		
		consulta="SELECT * from login WHERE usuario LIKE '"+user+"' AND contrasenia LIKE '"+pass+"'";
		rs=db.consultar(consulta);
		
		
		try {
			while (rs.next()) {
				estado=true;
				vc.setVisible(true);
				this.setVisible(false);
				
				
			}
			if(estado){
				JOptionPane.showMessageDialog(null, "Bienvenido");
			}else{
				JOptionPane.showMessageDialog(null, "No esta en la Base de Datos");
			}
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error de Consulta", "Error:", JOptionPane.ERROR_MESSAGE);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Otro de Consulta", "Error:", JOptionPane.ERROR_MESSAGE);
		}
				
	}

		
	}

