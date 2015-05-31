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
    
    private String color;
    private String figura;
    private int numero;
    private boolean visible;
    public Carta(String color, String figura, int numero, boolean visible) {
        this.color = color;
        this.figura = figura;
        this.numero = numero;
        this.visible=visible;
        
    }

    public boolean isVisible() {
        return visible;
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

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    
    
    
}
