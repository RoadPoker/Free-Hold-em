package Servidor;

import java.util.ArrayList;


/**
 *  Esta clase representa una mano para un jugador la cual consiste de dos cartas
 */
public class Mano {
    ArrayList<Carta> cartas;

    public Mano(ArrayList<Carta> cartas) {
        this.cartas = cartas;
    }

    public ArrayList<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(ArrayList<Carta> cartas) {
        this.cartas = cartas;
    }
    
    
    
}
