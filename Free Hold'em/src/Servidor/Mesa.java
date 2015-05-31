package Servidor;

import java.util.ArrayList;


/**
 *  Esta clase representa mesa de juego y se encarga de notificar a los jugadores
 *  en el momento de su turno, de apuestas de otros jugadores
 * , de salida de algun jugador o cualquier cosa que requeira conocer para actualziar su mesa
 * ademas de tener datos como el pot y las cartas comunales
 * que este tiene
 * @author Road Poker
 */
public class Mesa {
    int apuestaprevia;
    int apuestaRonda;
    Pot pot;
    ArrayList <Carta> cartas;
      /**
    * Este metodo se encarga de notificar al resto de jugadores que un jugador gano
    * dandole los datos de este
    * 
    *  @param  jugador ganador de la partida
    */
  public void enviarganador(Jugador ganador){
      
  }
    /**
    * Este metodo se encarga de notificar a los jugadores que un jugador ha enviado una jugada
    * 
    *  @param  cantidad  cantidad apostada por el jugador en curso
    *  @param  apuesta  tipo de apuesta que ejecuta jugador con turno en curso
    */
  public void enviarJugada(long cantidad,String apuesta){
      
  }
  /**
    * Este metodo se encarga de notificar a los jugadores que un jugador ha salido
    * 
    *  @param  sale  jugador que decide salir de la partida
    *  o
    */
  public void InformarSalida(Jugador sale){
      
  }
  
    public Mesa(int apuestaprevia,int apuestaRonda) {
        this.apuestaprevia = apuestaprevia;
        this.apuestaRonda = apuestaRonda;
    }

    public int getApuestaprevia() {
        return apuestaprevia;
    }

    public int getApuestaRonda() {
        return apuestaRonda;
    }

    public void setApuestaprevia(int apuestaprevia) {
        this.apuestaprevia = apuestaprevia;
    }

    public void setApuestaRonda(int apuestaRonda) {
        this.apuestaRonda = apuestaRonda;
    }
  
  
  
  
}
