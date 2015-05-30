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
public class Carta {
    
    String color;
    String figura;
    int numero;

    public Carta(String color, String figura, int numero) {
        this.color = color;
        this.figura = figura;
        this.numero = numero;
    }

    public String getColor() {
        return color;
    }

    public String getFigura() {
        return figura;
    }

    public int getNumero() {
        return numero;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setFigura(String figura) {
        this.figura = figura;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    
    
}
