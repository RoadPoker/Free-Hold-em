package Servidor;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import Cliente.ClienteInterface;

public class Partida extends UnicastRemoteObject implements ServidorInterface{
	private static final long serialVersionUID = 1L;
	private ArrayList<ClienteInterface> clientes;
        private ArrayList<Jugador> jugadores= new ArrayList<Jugador>();
        String listos=" \n";
	protected Partida() throws RemoteException {
		clientes= new ArrayList<ClienteInterface>();
	}
	public synchronized void registarCliente(ClienteInterface cliente)
			throws RemoteException {
		clientes.add(cliente);
		
	}
	public synchronized void enviarMensaje(String mensaje) throws RemoteException {
		listos+=mensaje+"\n";
                int i=0;
		while(i<clientes.size()){
			clientes.get(i++).retriveMensaje(listos);
		}
		
	}
	public synchronized boolean nuevoJugador(ClienteInterface cliente)throws RemoteException {
            System.out.println("SERVIDOR: "+cliente.getName()+" se quiere registar");
            
            for (int i=0;i<jugadores.size();i++){
			if (jugadores.get(i).getName().equalsIgnoreCase(cliente.getName())){
                            System.out.println("SERVIDOR: Jugador ya existe: "+jugadores.get(i).getName());
                            return false;
			}
		}
		clientes.add(cliente);
                jugadores.add(new Jugador(cliente.getName(),cliente.getPass()));
                System.out.println("SERVIDOR: "+cliente.getName()+" se registro");
		return true;
	}
        
        public synchronized boolean AccesoJugador(ClienteInterface cliente)throws RemoteException {
            for (int i=0;i<jugadores.size();i++){
			if (jugadores.get(i).getName().equalsIgnoreCase(cliente.getName()) && jugadores.get(i).getPass().equalsIgnoreCase(cliente.getPass()) ){
                            System.out.println("SERVIDOR: Jugador Accede: "+jugadores.get(i).getName());
                            return true;
			}
		}
            return false;
}
        
}
