package Servidor;

import java.io.Serializable;

/**
 *  Esta clase representa una carta la cual tiene atributos como su figura, su color, su numero y su visibilidad.
 *  Con los atributos de todas las cartas segun las reglas del juego se puede definir cual es el ganador
 * @author Road Poker
 */
public class Carta implements Serializable {
    
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

    @Override
    public String toString() {
        return "Carta{" + "color=" + color + ", figura=" + figura + ", numero=" + numero + ", visible=" + visible + '}';
    }
    
    
    
}
