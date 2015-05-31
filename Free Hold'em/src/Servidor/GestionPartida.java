package Servidor;

import Cliente.ClienteInterface;
import java.lang.reflect.Array;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Random;

/**
    * Esta clase se encarga de ejecutar acciones necesarias para el transcuros de partida
    * y guardar los datos necesarios para esta
    * 
    */
public class GestionPartida {
    ArrayList<Jugador> jugadores= new ArrayList<>();
    ArrayList<Jugador> jugadoresListos= new ArrayList<>();
    ArrayList<Carta> cartasComunales= new ArrayList<>();
    int dealer=0;
    private boolean cartasRepartidas=false;

    public GestionPartida() {
        crearCartasComunales();
    }
    
    /**
    * Este metodo se encarga de verificar que un jugador este accediendo con el
    * nombre de usuario y clave con la que se registro, en caso de que si se regresara
    * el objeto del jugador
    *
    *  @param  usuario  el nombre de usuario digitado por el ususario
    *  @param  pass     clave de usuario digitado por el usuario
    *  @return      el objeto jugador que esta guardado
    */
    public Jugador autenticarJugador(String usuario, String pass){
        for (int i=0;i<jugadores.size();i++){
			if (jugadores.get(i).getNombre().equalsIgnoreCase(usuario) && jugadores.get(i).getPassword().equalsIgnoreCase(pass) ){
                            System.out.println("SERVIDOR: Jugador Accede: "+jugadores.get(i).getNombre());
                            return jugadores.get(i);
			}
		}
            return null;
    }
    
     /**
    * Este metodo se encarga de agregar un nuevo jugador solo en caso de que ningun otro
    * anteriormente haya utilizado el mismo nombre de usuario
    * 
    *  @param  usuario  el nombre de usuario digitado por el usuario
    *  @param  pass     clave de usuario digitado por el usuario
    *  @return      si es agregado el jugador o no
    */
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
   
    public void cambiarDineroJugadores(){
        
    }
    
     /**
    * Este metodo se encarga de definir un dealer aleatoriamente paara una partida
    * 
    */
public void definirDealer(){
    Random rand = new Random();
    int x = rand.nextInt(jugadoresListos.size())+1;
    dealer=x;
}
     /**
    * Este metodo se encarga de encontrar el jugador ganador dependiendo 
    * las reglas de juego
    * 
    *  @return      Jugador ganador de la partida
    */
public Jugador determinarGanador(){
    //Hacer reglas   
    return null;
    
}
     /**
    * Este metodo se encarga de enviar una jugada realizada por algun jugador 
    * a la mesa para que esta notifique al resto de jugadores
    * 
    *  @param  cantidad  cantidad apostada
    *  @param  tipo     tipo de apuesta realizada en su turno     
    */
public void enviarJugada(long cantidad, String tipo){
    
}
     /**
    * Este metodo se encarga de llamar al metodo de determinar ganador para obtener 
    * el jugador ganador
    * 
    */
public void finPartida(){
    Jugador gana=determinarGanador();
}
     /**
    * Este metodo se encarga de enviar a la mesa un jugador que salio de la partida
    * para posteriormente retirarlo de esta
    * 
    *  @param  jugador  jugador que salio de la partida
    */

public void notificarSalida(Jugador jugador){
    //Enviar a jugadoresListos que alguin salio
}

     /**
    * Este metodo se encarga de regresarle a un usuario las cartas que le corresponden,
    * buscando estas en la lista de jugadores
    * 
    *  @param  jugador  jugador que pida las cartas
    *  @return      Un objeto de tipo mano que tiene las cartas pedidas
    */
public Mano pedirCartasIniciales(Jugador jugador){
    for (Jugador jugador1 : jugadoresListos) {
        if (jugador1.getNombre().equalsIgnoreCase(jugador.getNombre())){
            return jugador1.getMano();
        }
    }
    return null;
}

     /**
    * Este metodo se encarga de regresarle al usuario el puesto que le corresponde en 
    * la mesa
    * 
    *  @param  jugador jugador que pide la ubicacion en la mesa
    *  @return      entero que representa el numero de silla que le corresponde
    */
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

     /**
    * Este metodo se encarga de darle a cada jugador de los jugadores listos para iniciar
    * cartas aleatorias en el momento que se inicie la partida
    * la partida
    * 
    */
public void repartirCartas(){
    
    for (Jugador jugador : jugadoresListos) {
        Carta cartaUno=cartaAleatoria();
        Carta cartaDos=cartaAleatoria();
        ArrayList<Carta> mano=new ArrayList<>();
        mano.add(cartaUno);
        mano.add(cartaDos);
        Mano nuevaMano= new Mano(mano);
        jugador.setMano(nuevaMano);
    }
    
}
     /**
    * Este metodo se encarga de generar una carta aleatoria considerando las posibilidades
    * de figura, color y numero
    * 
    *  @return      una carta aleatorea
    */
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


     /**
    * Este metodo se encarga de guardar en este gestor una lista de jugadores que
    * se le envie 
    * 
    *  @param  jugadores  lista de jugadores que se le da para guardar
    */
public void guardarJugadores(ArrayList<Jugador> jugadores){
    this.jugadores=jugadores;
}
     /**
    * Este metodo se encarga de notificar a la mesa para que notifique 
    * a todos los jugadores que una ronda ya termino
    * y se jugara la siguiente
    * 
    */
    void notificarNuevoTurno() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
    * Este metodo se encarga de notificar a un jugador el inicio de su turno
    * 
    *  @param  jugador  jugador a notificar
    */
    void notificarTurno(Jugador jugador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public ArrayList<Jugador> getJugadoresListos() {
        return jugadoresListos;
    }

    public int getDealer() {
        return dealer;
    }

    public ArrayList<Carta> getCartasComunales() {
        return cartasComunales;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public void setJugadoresListos(ArrayList<Jugador> jugadoresListos) {
        this.jugadoresListos = jugadoresListos;
    }

    public void setDealer(int dealer) {
        this.dealer = dealer;
    }

    public void crearCartasComunales()
    {
        for(int i=0; i<5;i++)
        {
            Carta carta=new Carta();
            carta=cartaAleatoria();
            cartasComunales.add(carta);
                 
        }
    }



}
