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
public class Mesa {
    long apuestaprevia;
    long apuestaRonda;
    Pot pot;
    ArrayList <Carta> cartas;
    
  public void enviarganador(Jugador ganador){
      
  }
  
  public void enviarJugada(long cantidad,String apuesta){
      
  }
  
  public void InformarSalida(Jugador sale){
      
  }
  
  public void notificarCambioAJugadores(){
      
  }
  
  public void notificarGanador(){
      
  }
  public void notificarSalidaJugadores(){
      
  }

    public Mesa(long apuestaprevia, long apuestaRonda) {
        this.apuestaprevia = apuestaprevia;
        this.apuestaRonda = apuestaRonda;
    }

    public long getApuestaprevia() {
        return apuestaprevia;
    }

    public long getApuestaRonda() {
        return apuestaRonda;
    }

    public void setApuestaprevia(long apuestaprevia) {
        this.apuestaprevia = apuestaprevia;
    }

    public void setApuestaRonda(long apuestaRonda) {
        this.apuestaRonda = apuestaRonda;
    }
  
  
  
  
}
