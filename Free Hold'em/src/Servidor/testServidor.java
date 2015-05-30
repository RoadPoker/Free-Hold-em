package Servidor;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Scanner;

public class testServidor {

	public static void main(String[] args) throws RemoteException, MalformedURLException {
		
                
                System.out.println("Digite ip de Servidor");
                Scanner scanner= new Scanner(System.in);
                String input =scanner.nextLine();
                Naming.rebind("rmi://"+input+":1099/Servidor", new ServidorImp());
                System.out.println("Servidor iniciado");
	}

}
