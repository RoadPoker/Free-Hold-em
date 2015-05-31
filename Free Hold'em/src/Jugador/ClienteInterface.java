package Jugador;

import Servidor.Carta;
import Servidor.Jugador;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import javax.swing.JTextArea;
/**
 * Interface para comunicar con RMI del servidor
 * 
 * @author RoadPoker
 */
public interface ClienteInterface extends Remote{
	public  void retriveMensaje(String mensaje) throws RemoteException;
	public String getName() throws RemoteException;
        public String getPass() throws RemoteException; 
        public boolean RegistroJugador(String nombre,String pass) throws RemoteException; 
        public boolean AccesoJugador(String nombre,String pass) throws RemoteException;
        public boolean EnviarListo() throws RemoteException;
        public void setArea(JTextArea jTextArea1) throws RemoteException;
        public ArrayList <Jugador> pedirJugadoresListos() throws RemoteException;
        public ArrayList <Carta> pedirCartasComunales() throws RemoteException;
}
