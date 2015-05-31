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
    
    public ControladorApuesta() {
    }

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
    
    public void allin()
    {
        dealerJug.setJugadorDinero(dealerJug.getJugadorDinero());
    }
    public void bet(int monto)
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
    public void call(int monto, int apuestaVigente)
    {
        if((dealerJug.getJugadorDinero()-apuestaVigente) <0)
        {
            System.err.println("No se puede hacer esta apuesta");
        }
        else
        {
            dealerJug.setJugadorDinero(monto);
        }
    }
    
    public void check()
    {
        
    }
    public void fold()
    {
        /*
        RMI para retirarse
        */
    }
    
}
