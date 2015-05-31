/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servidor;

import Cliente.ClienteInterface;
import java.lang.reflect.Array;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Diego
 */
public class GestionPartida {
    ArrayList<Jugador> jugadores= new ArrayList<>();
    ArrayList<Jugador> jugadoresListos= new ArrayList<>();
    
    
    
    public Jugador autenticarJugador(String usuario, String pass){
        for (int i=0;i<jugadores.size();i++){
			if (jugadores.get(i).getNombre().equalsIgnoreCase(usuario) && jugadores.get(i).getPassword().equalsIgnoreCase(pass) ){
                            System.out.println("SERVIDOR: Jugador Accede: "+jugadores.get(i).getNombre());
                            return jugadores.get(i);
			}
		}
            return null;
    }
    
    
    public synchronized boolean AgergarJugador(String nombre, String pass)throws RemoteException {
            System.out.println("SERVIDOR: "+nombre+" se quiere registar");
            
            for (int i=0;i<jugadores.size();i++){
			if (jugadores.get(i).getNombre().equalsIgnoreCase(nombre)){
                            System.out.println("SERVIDOR: Jugador ya existe: "+jugadores.get(i).getNombre());
                            return false;
			}
		}
		
                jugadores.add(new Jugador(nombre,pass));
                System.out.println("SERVIDOR: "+nombre+" se registro");
		return true;
	}
    
    public void agregarJugadores(ArrayList<Jugador> jugadores){
        this.jugadores= jugadores;
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
    Jugador gana=determinarGanador();
}
public void notificarSalida(Jugador jugador){
    //Enviar a jugadoresListos que alguin salio
}

public Mano pedirCartasIniciales(Jugador jugador){
    for (Jugador jugador1 : jugadores) {
        if (jugador1.getNombre().equalsIgnoreCase(jugador.getNombre())){
            return jugador1.getMano();
        }
    }
    return null;
}

public int pedirUbicacionEnMesa(Jugador jugador){
    int i=1;
    for (Jugador jug : jugadoresListos) {
        if (jug.getNombre().equalsIgnoreCase(jugador.getNombre())){
            return i; 
        }
        i++;
        
    }
    return 0;
}
public void repartirCartas(ArrayList<Jugador> jugadores){
    
    for (Jugador jugador : jugadores) {
        Carta cartaUno=cartaAleatoria();
        Carta cartaDos=cartaAleatoria();
        ArrayList<Carta> mano=new ArrayList<>();
        mano.add(cartaUno);
        mano.add(cartaDos);
        Mano nuevaMano= new Mano(mano);
        jugador.setMano(nuevaMano);
    }
    
}

public Carta cartaAleatoria(){
    Random rand = new Random();
    int x = rand.nextInt(4)+1;
    String color="";
    String figura="";
    int numero;
    if (x==1){
        color="Rojo";
        figura="Corazones";
    }
    if (x==2){
        color="Rojo";
        figura="Diamantes";
    }
    if (x==3){
        color= "Negro";
        figura="Trebol";
        
    }
    if (x==4){
        color="Negro";
        figura="Picas";
    }
    x = rand.nextInt(13)+1;
    
    return new Carta(color,figura,x,false);
}
public void ubicarJugadoresEnMesa(ArrayList<Jugador> jugadores){
    //Se ubica dependiendo el orden
}

public void guardarJugadores(ArrayList<Jugador> jugadores){
    this.jugadores=jugadores;
}





}
