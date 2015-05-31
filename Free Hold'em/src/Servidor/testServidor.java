package Servidor;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Scanner;
/**
 *  Esta clase representa el servidor ya que lo crea dada una ip y una clase que implemente
 * los metodos de ServidorInterface
 * @author Road Poker
 */
public class testServidor {

	public static void main(String[] args) throws RemoteException, MalformedURLException {
		
                
                System.out.println("Digite ip de Servidor");
                Scanner scanner= new Scanner(System.in);
                String input =scanner.nextLine();
                Naming.rebind("rmi://"+input+":1099/Servidor", new Partida());
                System.out.println("Servidor iniciado");
	}

}
