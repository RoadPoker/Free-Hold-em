/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servidor;

import java.util.ArrayList;

/**
 *
 * @author Diego
 */
public interface Persistencia {
    ArrayList<Jugador> Cargarjugadores (String localizacion);
    boolean SalvarJugadores(ArrayList<Jugador> jugadores);
}
