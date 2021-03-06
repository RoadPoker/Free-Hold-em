package Servidor;

import java.io.Serializable;


/**
 *  Esta clase representaa un jugador en el cual estaran el nombre, su clave ademas 
 * del dinero que tiene disponible para apostar y la mano de cartas que le corresponde
 * al momento de iniciar una partida
 */
public class Jugador implements Serializable{
    String nombre,password;
    int dinero;
    Mano mano;

    public Jugador(String nombre, String pass) {
        this.nombre = nombre;
        this.password = pass;
        dinero=500;
    }




    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPassword() {
        return password;
    }

    public int getDinero() {
        return dinero;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }

    public Mano getMano() {
        return mano;
    }

    public void setMano(Mano mano) {
        this.mano = mano;
    }

    
    
    
}
