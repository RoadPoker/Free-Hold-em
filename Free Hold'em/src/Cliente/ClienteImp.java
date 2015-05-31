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

    public String getPass() throws RemoteException {
       return pass;
    }
    
    public boolean AccesoJugador(String nombre,String pass) throws RemoteException {
        this.nombre=nombre;
        this.pass=pass;
        usuario=servidor.Acceder(nombre, pass);
        return true;
    }

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
