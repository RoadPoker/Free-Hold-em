/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servidor;

/**
 *
 * @author Diego
 */
public class Jugador {
    String nombre,password;
    int dinero;

    public Jugador(String nombre, String pass) {
        this.nombre = nombre;
        this.password = pass;
        dinero=500;
    }

    public String getName() {
        return nombre;
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

    
    
    
}
