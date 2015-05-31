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
public class Apuesta {
    private long monto;
    private long ApuestaVigente;
    private Dealer dealerJug;
    
    public Apuesta() {
    }

    
    public Apuesta(long monto, long ApuestaVigente) {
        this.monto = monto;
        this.ApuestaVigente = ApuestaVigente;
    }

    public long getMonto() {
        return monto;
    }

    public long getApuestaVigente() {
        return ApuestaVigente;
    }

    public void setMonto(long monto) {
        this.monto = monto;
    }

    public void setApuestaVigente(long ApuestaVigente) {
        this.ApuestaVigente = ApuestaVigente;
    }

    @Override
    public String toString() {
        return "Apuesta{" + "monto=" + monto + ", ApuestaVigente=" + ApuestaVigente + '}';
    }
    
    public void preFlop(int monto)
    {
        
    }
    
}
