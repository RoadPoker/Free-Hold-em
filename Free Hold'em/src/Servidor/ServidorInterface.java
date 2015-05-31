package Servidor;


import Cliente.ClienteInterface;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface ServidorInterface extends Remote{
	
	boolean agregarJugador(String usuario,String pass) throws RemoteException;
        Jugador Acceder(String usuario,String pass)throws RemoteException;
        ArrayList<Jugador> cargarJugadores(String localizacion)throws RemoteException;
        boolean determinarInicioDePartida()throws RemoteException;
        void enviarJugada(long cantidad, String tipoApuesta) throws RemoteException;;
        boolean iniciarPartida(Jugador jugador) throws RemoteException;
        void notificarTurnoJugador(Jugador jugador)throws RemoteException;
        Mano pedirCartasIniciales(Jugador jugador)throws RemoteException;
        int pedirUbicacionEnMesa(Jugador jugador)throws RemoteException;
        void salirJugador(Jugador jugador) throws RemoteException;
        void salvarJugadores(ArrayList<Jugador> jugadores) throws RemoteException;
        public boolean verificarInicioPartida() throws RemoteException;
        public ArrayList<Jugador> PedirJugadoresListos() throws RemoteException;
}       

