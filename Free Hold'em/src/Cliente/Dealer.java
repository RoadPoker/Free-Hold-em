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
    private Servidor.Mesa mesajuego;
    
    
/**
 * constructor por defecto
 */
    public Dealer() {
    }
/**
 * método que recupera el pot de apuestas del juego en curso.
 * @return 
 */
    public Pot getPotJuego() {
        return potJuego;
    }
    /**
     * Método que recupera la información del jugador en ejecución
     * @return 
     */
    public Jugador getJugador() {
        return jugador;
    }
/**
 * retorna el objeto mesa con todos sus valores e instancias.
 * @return 
 */
    public Servidor.Mesa getMesajuego() {
        return mesajuego;
    }
/**
 * modifica el pot del juego
 * @param potJuego 
 */
    public void setPotJuego(Pot potJuego) {
        this.potJuego = potJuego;
    }
/**
 * modifica la clase jugador
 * @param jugador 
 */
    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }
/**
 * Modifica la mesa
 * @param mesajuego 
 */
    public void setMesajuego(Servidor.Mesa mesajuego) {
        this.mesajuego = mesajuego;
    }
/**
 * Recupera el dinero total del juegador.
 * @return 
 */
    public int getJugadorDinero()
    {
        return jugador.getDinero();
    }
  /**
   * modifica el dinero del jugador.
   * @param monto 
   */
    public void setJugadorDinero(int monto)
    {
        jugador.setDinero(jugador.getDinero()-monto);
    }
}
