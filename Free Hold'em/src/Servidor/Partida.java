package Servidor;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import Cliente.ClienteInterface;

public class Partida extends UnicastRemoteObject implements ServidorInterface{
	private static final long serialVersionUID = 1L;
        GestionPartida gestion= new GestionPartida();
	
        String listos=" \n";
	protected Partida() throws RemoteException {
		
	}
	
        
        public synchronized boolean Acceder(String usuario,String pass)throws RemoteException {
            return gestion.autenticarJugador(usuario, pass);
}

          public boolean agregarJugador(String usuario, String pass) throws RemoteException {
             return gestion.AgergarJugador(usuario, pass);
         }

    @Override
    public ArrayList<Jugador> cargarJugadores(String usuario, String pass) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean determinarInicioDePartida() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enviarJugada(long cantidad, String tipoApuesta) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean iniciarPartida(Jugador jugador) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void notificarTurnoJugador(Jugador jugador) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Mano pedirCartasIniciales(Jugador jugador) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int pedirUbicacionEnMesa(Jugador jugador) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void salirJugador(Jugador jugador) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void salvarJugadores(ArrayList<Jugador> jugadores) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
}
