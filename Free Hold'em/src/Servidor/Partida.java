package Servidor;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import Cliente.ClienteInterface;

public class Partida extends UnicastRemoteObject implements ServidorInterface{
	private static final long serialVersionUID = 1L;
        GestionPartida gestion= new GestionPartida();
        private ArrayList<Jugador> jugadoresListos=new ArrayList<Jugador>();
	
        String listos=" \n";
	protected Partida() throws RemoteException {
		
	}
	
        
        public synchronized Jugador Acceder(String usuario,String pass)throws RemoteException {
         Jugador regreso=gestion.autenticarJugador(usuario, pass);
            if (regreso!=null){
                return regreso;
            }
            return null;
                  
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
        if (jugadoresListos.size()>=2){
            return true;
        }
        return false;
    }

    @Override
    public void enviarJugada(long cantidad, String tipoApuesta) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean iniciarPartida(Jugador jugador) throws RemoteException {
       jugadoresListos.add(jugador);
       return determinarInicioDePartida();
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