/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servidor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diego
 */
public class ExpertoPersistencia implements Persistencia{

    @Override
    public ArrayList<Jugador> Cargarjugadores(String localizacion) {
        ArrayList<Jugador> jugadoresCargados= new ArrayList<>();
        try {
            FileInputStream door = null;
            
            door = new FileInputStream("archivos/"+localizacion);
            try {
                ObjectInputStream reader = new ObjectInputStream(door);
                try { 
                    jugadoresCargados = (ArrayList<Jugador>) reader.readObject();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ExpertoPersistencia.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (IOException ex) {
                Logger.getLogger(ExpertoPersistencia.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                door.close();
            } catch (IOException ex) {
                Logger.getLogger(ExpertoPersistencia.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ExpertoPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return jugadoresCargados;
    }

    @Override
    public boolean SalvarJugadores(ArrayList<Jugador> jugadores) {
        Calendar calendario = new GregorianCalendar();
        int hora, minutos, segundos;
        hora =calendario.get(Calendar.HOUR_OF_DAY);
        minutos = calendario.get(Calendar.MINUTE);
        segundos = calendario.get(Calendar.SECOND);
        ObjectOutputStream out;
        try {
            out = new ObjectOutputStream(new  FileOutputStream("archivos/"+hora+"-"+minutos+"-"+segundos));
            out.writeObject(jugadores);
            out.close();
        } catch (IOException ex) {
           // Logger.getLogger(testServidor.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    
}
