/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import Servidor.Jugador;
import Servidor.Mesa;
import Servidor.ServidorInterface;
import java.rmi.RemoteException;

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
    private ServidorInterface servidor;
    
/**
 * constructor por defecto.
 * 
 */
    public controladorJuego() throws RemoteException {
        conexion= new ClienteImp(servidor);
        contApuestas= new ControladorApuesta();
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
 * Recupera el dealer de la interfaz del jugador objetivo
 * @return 
 */
    public Dealer getDealerjuego() {
        return dealerjuego;
    }
/**
 * Recupera el dinero que el jugador apostó.
 * @return 
 */
    public int getMonto() {
        return monto;
    }
/**
 *Recupera el valor de la apuesta
 * @return 
 */
    public int getValorApuesta() {
        return valorApuesta;
    }
    /**
     * Recupera el servidor.
     * @return 
     */

    public ServidorInterface getServidor() {
        return servidor;
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

    public void setDealerjuego(Dealer dealerjuego) {
        this.dealerjuego = dealerjuego;
    }
/**
 * modifica el monto de apuesta
 * @param monto 
 */
    public void setMonto(int monto) {
        this.monto = monto;
    }
/**
 * Modifica el valor de la apuesta.
 * @param valorApuesta 
 */
    public void setValorApuesta(int valorApuesta) {
        this.valorApuesta = valorApuesta;
    }
/**
 * Modifica al servidor
 * @param servidor 
 */
    public void setServidor(ServidorInterface servidor) {
        this.servidor = servidor;
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
    /**
     * Recupera la información del jugador.
     * @return 
     */
    public Jugador getJugador()
    {
        return conexion.getUsuario();
    }
}
