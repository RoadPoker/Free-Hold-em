
package Servidor;

/**
 *  Esta clase representa el pot el cual esta dentro de la mesa y representa la 
 * cantidad de dinero apostado por todos los jugadores
 * @author Road Poker
 */
public class Pot {
    long monto;

    public long getMonto() {
        return monto;
    }

    public Pot(long monto) {
        this.monto = monto;
    }

    public void setMonto(long monto) {
        this.monto = monto;
    }
    
    
}
