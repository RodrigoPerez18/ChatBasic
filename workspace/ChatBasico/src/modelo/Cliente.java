package modelo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import vista.VentanaChat;

public final class Cliente implements Runnable {
	private static final Cliente cte = new Cliente();
	private Socket soCli;
	private DataInputStream entrada;
	private DataOutputStream salida;
	private int puerto=8580;
	private String host= "localhost";
	private String mensaje = "";
	private JTextPane jPane;
	VentanaChat vchat= VentanaChat.instanciaChat();

	
	private Cliente(){
		
	}
	private Cliente(JTextPane jPane){
		this.jPane=jPane;
		try {
			soCli = new Socket(host, puerto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void run() {
		try {
			while(true){
				entrada = new DataInputStream(soCli.getInputStream());
				mensaje +=entrada.readUTF();
				jPane.setText(mensaje);
			}
		} catch (Exception e) {
			Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE,null,e);
			e.printStackTrace();
		}
	}
	public void enviarMensaje(String mensaje){
		try {
			salida = new DataOutputStream(soCli.getOutputStream());
			salida.writeUTF(mensaje);
			salida.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static Cliente instanciaCte(){
		return cte;
	}
}
