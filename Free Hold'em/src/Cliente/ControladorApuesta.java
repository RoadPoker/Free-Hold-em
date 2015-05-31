/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

/**
 *
 * @author felipe
 */
public class ControladorApuesta {

    private Dealer dealerJug;
    /**
     * constructor por defecto
     * 
     */
    public ControladorApuesta() {
    }
/**
 * preFlop, apuesta inicial al momento de iniciar un juego.
 * @param monto 
 */
    public void preFlop(int monto)
    {
        if(dealerJug.getJugadorDinero()-monto<0)
        {
            System.err.println("No hay suficiente dinero para realizar la apuesta");
        }
        else
        {
            dealerJug.setJugadorDinero(monto);
        }
    }
    /**
     * Allin: implementa el tipo de apuesta, apostar todo.
     */
    public void allin()
    {
        dealerJug.setJugadorDinero(dealerJug.getJugadorDinero());
    }
    /**
     * Bet: implementa el tipo de apuesta, apuesta con ajuste manual
     * @param monto
     * @return falso en caso de superar el dinero total del usuario.
     */
    public boolean bet(int monto)
    {
         if(dealerJug.getJugadorDinero()-monto<0)
        {
            System.err.println("No hay suficiente dinero para realizar la apuesta");
            return false;
        }
        else
        {
            dealerJug.setJugadorDinero(monto);
            return true;
        }
    }
    /**
     * call: implementa el tipo de apuesta, iguala la apuesta anterior.
     * @param apuestaVigente
     * @return 
     */
    public boolean call(int apuestaVigente)
    {
        if((dealerJug.getJugadorDinero()-apuestaVigente) <0)
        {
            return false;
        }
        else
        {
            dealerJug.setJugadorDinero(apuestaVigente);
            return true;
        }
    }
    /**
     * check: pasa el turno de apuesta sin dejar dinero en la mesa.
     */
    public void check()
    {
        /**
         * implementa el retirarse de la mesa.
         */
    }
    /**
     * Retirarse del juego.
     */
    public void fold()
    {
        /*
        RMI para retirarse
        */
    }
    
}
