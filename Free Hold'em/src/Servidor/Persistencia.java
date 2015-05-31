package Servidor;

import java.util.ArrayList;

/**
 *  Esta clase se encarga de definir los metodos a implemetar por la clase
 * que realicen la persistencia
 * 
 */
public interface Persistencia {
    ArrayList<Jugador> Cargarjugadores (String localizacion);
    boolean SalvarJugadores(ArrayList<Jugador> jugadores);
}
