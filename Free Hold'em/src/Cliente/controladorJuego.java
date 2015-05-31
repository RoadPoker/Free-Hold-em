/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import Servidor.Mesa;

/**
 *
 * @author felipe
 */
public class controladorJuego {
    private ClienteImp conexion;
    private ControladorApuesta contApuestas;
    private Dealer dealerjuego;

    public controladorJuego() {
    }

    public controladorJuego(ClienteImp conexion, ControladorApuesta contApuestas) {
        this.conexion = conexion;
        this.contApuestas = contApuestas;
    }

    public ClienteImp getConexion() {
        return conexion;
    }

    public ControladorApuesta getContApuestas() {
        return contApuestas;
    }

    public void setConexion(ClienteImp conexion) {
        this.conexion = conexion;
    }

    public void setContApuestas(ControladorApuesta contApuestas) {
        this.contApuestas = contApuestas;
    }
    public Mesa getMesaDealer()
    {
        return dealerjuego.getMesajuego();
    }
}
