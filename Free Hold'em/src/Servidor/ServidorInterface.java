package Servidor;

import java.rmi.Remote;
import java.rmi.RemoteException;

import Cliente.ClienteInterface;

public interface ServidorInterface extends Remote{
	void registarCliente(ClienteInterface cliente) throws RemoteException;
	void enviarMensaje(String mensaje) throws RemoteException;
	boolean nuevoJugador(ClienteInterface cliente) throws RemoteException;
        boolean AccesoJugador(ClienteInterface cliente)throws RemoteException;
}
