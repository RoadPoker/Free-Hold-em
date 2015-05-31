/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;
import Servidor.*;
import java.util.List;

/**
 *
 * @author felipe
 */
public  class Dealer {
    private Pot potJuego;
    private Jugador jugador;
    private Mesa mesajuego;
    
    

    public Dealer() {
    }

    public Pot getPotJuego() {
        return potJuego;
    }
    public Jugador getJugador() {
        return jugador;
    }

    public Cliente.Mesa getMesajuego() {
        return mesajuego;
    }

    public void setPotJuego(Pot potJuego) {
        this.potJuego = potJuego;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public void setMesajuego(Cliente.Mesa mesajuego) {
        this.mesajuego = mesajuego;
    }

    public int getJugadorDinero()
    {
        return jugador.getDinero();
    }
    public void setJugadorDinero(int monto)
    {
        jugador.setDinero(jugador.getDinero()-monto);
    }
}
