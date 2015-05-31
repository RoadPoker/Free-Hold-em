package Cliente;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Scanner;

import Servidor.Partida;
import Servidor.ServidorInterface;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class ClienteImp extends UnicastRemoteObject implements ClienteInterface, Runnable {
	
	private static final long serialVersionUID = 1L;
	String nombre,pass;
	ServidorInterface servidor;
        JTextArea jTextArea1;
        Servidor.Jugador usuario;

	protected ClienteImp(ServidorInterface servido) throws RemoteException {
		super();
		
		servidor=servido;
		//servidor.registarCliente(this);
		
	}

	public void retriveMensaje(String mensaje) throws RemoteException {
		System.out.println(mensaje);
                jTextArea1.setText(mensaje);
               
	}
        
        

	public void run(){
		Scanner scanner= new Scanner(System.in);
		String mensaje;
		while(true){
			mensaje=scanner.nextLine();
		}
	}

	public String getName() throws RemoteException {
		
		return nombre;
	}
/**
 * RegistroJugador: registra el jugador en el servidor, devuelve error en caso de
 * existir otro jugador con el mismo nombre de usuario
 * @param nombre, nombre del usuario
 * @param pass, contraseña
 * @return retorna falso en caso de no generar el usuario.
 * @throws RemoteException 
 */
    public boolean RegistroJugador(String nombre,String pass) throws RemoteException {
            this.nombre=nombre;
            this.pass=pass;
            if (servidor.agregarJugador(nombre,pass)){
						System.out.println("Registro correcto");
                                                return true;
					}
					else{
						System.out.println("Error!!");
					}
        return false;
    }
/**
 * getPass: recupera contraseña del usuario
 * @return
 * @throws RemoteException 
 */
    public String getPass() throws RemoteException {
       return pass;
    }
    /**
     * AccesoJugador: permite al usuario acceder al sistema con un usuario
     * registrado.
     * @param nombre
     * @param pass
     * @return en caso de ser una conexión fallida devuelve false.
     * @throws RemoteException 
     */
    public boolean AccesoJugador(String nombre,String pass) throws RemoteException {
        this.nombre=nombre;
        this.pass=pass;
        usuario=servidor.Acceder(nombre, pass);
        if(usuario==null)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
/**
 * EnviarListo: confirma el usuario para ingresar a su partida o iniciar una nueva.
 */
    public void EnviarListo() {
            
            try {
                servidor.iniciarPartida(usuario);
            } catch (RemoteException ex) {
                Logger.getLogger(ClienteImp.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    public void setArea(JTextArea jTextArea1) throws RemoteException {
        this.jTextArea1=jTextArea1;
    }
    
}
