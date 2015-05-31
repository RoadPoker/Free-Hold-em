/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import Servidor.Mesa;

/**
 *Clase controladora del juego, representa el controlador principal encargado de conectar,
 * modificar y recibir las ordenes del usuario
 * @author felipe
 */
public class controladorJuego {
    private ClienteImp conexion;
    private ControladorApuesta contApuestas;
    private Dealer dealerjuego;
    private int monto;
    private int valorApuesta;
    
/**
 * constructor por defecto.
 * 
 */
    public controladorJuego() {
    }
/**
 * Constructor por copia, controladores de conexión y apuestas.
 * 
 * @param conexion
 * @param contApuestas 
 */
    public controladorJuego(ClienteImp conexion, ControladorApuesta contApuestas) {
        this.conexion = conexion;
        this.contApuestas = contApuestas;
    }
/**
 * Retorna el controlador de conexión.
 * @return 
 */
    public ClienteImp getConexion() {
        return conexion;
    }
/**
 * retorna el controlador de apuestas.
 * 
 * @return 
 */
    public ControladorApuesta getContApuestas() {
        return contApuestas;
    }
/**
 * modifica el controlador de conexión.
 * 
 * @param conexion 
 */
    public void setConexion(ClienteImp conexion) {
        this.conexion = conexion;
    }
/**
 * modifica el controlador de apuestas.
 * @param contApuestas 
 */
    public void setContApuestas(ControladorApuesta contApuestas) {
        this.contApuestas = contApuestas;
    }
    /**
     * recupera la mesa administrada por el dealer, la mesa en del juego.
     * @return 
     */
    public Mesa getMesaDealer()
    {
        return dealerjuego.getMesajuego();
    }
   /**
    * Recibe el evento de igualar apuestas.
    * 
    * @return retorna falso si no puede igualar la apuesta
    */
    public boolean realizarIgualar()
    {
        return contApuestas.call(dealerjuego.getMesajuego().getApuestaprevia());
    }
    /**
     * Recibe el evento de retirarse del juego.
     */
    public void retirarse()
    {
        contApuestas.fold();
    }
    /**
     * recibe el evento apostar.
     * @param monto
     * @return falso si el monto es superior a la cantidad de dinero total del usuario.
     * 
     */
    public boolean apostar(int monto)
    {
        return contApuestas.bet(monto);
    }
    /**
     * recibe el evento pasar sin apostar
     */
    public void pasar()
    {
        contApuestas.check();
    }
    /**
     * recibe el evento de apostar todo el dinero.
     */
    public void apuestaTodo()
    {
        contApuestas.allin();
    }
}
