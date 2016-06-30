package modelo;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Conexion {
	
	private Connection conection=null;
	private void conectar(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conection= DriverManager.getConnection("jdbc:mysql://localhost:3306/chat", "root","");
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, "Error de conexion", "Error", JOptionPane.ERROR_MESSAGE);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Otro error de conexion", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public ResultSet consultar(String consulta){
		this.conectar();
		ResultSet rs= null;
		Statement sentencia=null;
		
		
		try{
			sentencia = conection.createStatement();
			rs=sentencia.executeQuery(consulta);
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, "Error de consulta"+" "+e, "Error", JOptionPane.ERROR_MESSAGE);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Otro error de consulta"+" "+e, "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		return rs;
	}
	public ResultSet consultarIns(String consulta){
		this.conectar();
		ResultSet rs= null;
		Statement sentencia=null;
		
		
		try{
			sentencia = conection.createStatement();
			sentencia.execute(consulta);
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, "Error de consulta"+" "+e, "Error", JOptionPane.ERROR_MESSAGE);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Otro error de consulta"+" "+e, "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		return rs;
	}
	
	

}
