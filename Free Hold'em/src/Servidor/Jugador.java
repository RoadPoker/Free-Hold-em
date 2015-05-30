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
    String nombre,pass;
    int fichas;

    public Jugador(String nombre, String pass) {
        this.nombre = nombre;
        this.pass = pass;
        fichas=500;
    }

    public String getName() {
        return nombre;
    }

 public String getPass() {
        return pass;
    }
    public int getFichas() {
        return fichas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setFichas(int fichas) {
        this.fichas = fichas;
    }
    
    
    
    
}
