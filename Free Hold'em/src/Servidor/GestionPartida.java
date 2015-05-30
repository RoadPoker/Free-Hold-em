/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servidor;

import Cliente.ClienteInterface;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Diego
 */
public class GestionPartida {
    ArrayList<Jugador> jugadores= new ArrayList<>();
    
    
    public boolean autenticarJugador(String usuario, String pass){
        for (int i=0;i<jugadores.size();i++){
			if (jugadores.get(i).getName().equalsIgnoreCase(usuario) && jugadores.get(i).getPassword().equalsIgnoreCase(pass) ){
                            System.out.println("SERVIDOR: Jugador Accede: "+jugadores.get(i).getName());
                            return true;
			}
		}
            return false;
    }
    
    
    public synchronized boolean AgergarJugador(String nombre, String pass)throws RemoteException {
            System.out.println("SERVIDOR: "+nombre+" se quiere registar");
            
            for (int i=0;i<jugadores.size();i++){
			if (jugadores.get(i).getName().equalsIgnoreCase(nombre)){
                            System.out.println("SERVIDOR: Jugador ya existe: "+jugadores.get(i).getName());
                            return false;
			}
		}
		
                jugadores.add(new Jugador(nombre,pass));
                System.out.println("SERVIDOR: "+nombre+" se registro");
		return true;
	}
    
    public void agregarJugadores(ArrayList<Jugador> jugadores){
        
    }
    public void cambiarDineroJugadores(){
        
    }
public void definirDealer(ArrayList<Jugador> jugadores){

}

public Jugador determinarGanador(){
        return null;
    
}

public void enviarJugada(long cantidad, String tipo){
    
}
public void finPartida(){
    
}
public void notificarSalida(Jugador jugador){
    
}

public void pedirCartasIniciales(Jugador jugador){
    
}

public void pedirUbicacionEnMesa(Jugador jugador){
    
}
public void repartirCartas(ArrayList<Jugador> jugadores){
    
}
public void ubicarJugadoresEnMesa(ArrayList<Jugador> jugadores){
    
}

public boolean verificarJugador(String nombre,String pass){
        return false;
    
}

}
