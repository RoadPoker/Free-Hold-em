package Cliente;

import java.rmi.Remote;
import java.rmi.RemoteException;
import javax.swing.JTextArea;

public interface ClienteInterface extends Remote{
	void retriveMensaje(String mensaje) throws RemoteException;
	String getName() throws RemoteException;
        String getPass() throws RemoteException; 
        boolean RegistroJugador(String nombre,String pass) throws RemoteException; 
        public boolean AccesoJugador(String nombre,String pass) throws RemoteException;
        void EnviarListo() throws RemoteException;
        void setArea(JTextArea jTextArea1) throws RemoteException;
}
