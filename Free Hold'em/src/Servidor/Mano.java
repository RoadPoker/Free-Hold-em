package Servidor;

import java.io.Serializable;
import java.util.ArrayList;


/**
 *  Esta clase representa una mano para un jugador la cual consiste de dos cartas
 */
public class Mano implements Serializable {
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

    @Override
    public String toString() {
        return "Mano{" + "cartas=" + cartas + '}';
    }
    
    public String tipoCarta1()
    {
        return ""+cartas.get(0).getColor().charAt(0)+cartas.get(0).getFigura().charAt(0)+cartas.get(0).getNumero();
    }
    public String tipoCarta2()
    {
        return ""+cartas.get(1).getColor().charAt(0)+cartas.get(1).getFigura().charAt(0)+cartas.get(1).getNumero();
    }
}
