
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
 *  Esta clase implementa los metodos de la clase Persistencia y es quien se encarga de guardar y cargar los datos ya salvados
 * @author Road Poker
 */
public class ExpertoPersistencia implements Persistencia{

    /**
    * Este metodo se encarga de cargar de un archivo dado en la carpeta
    * archivos, donde se encuentra serializado una lista de jugadores la cual
    * se regresara
    *
    *  @param  localizacion  nombre del archivo en la carpeta archivos
    *  @return      lista de jugadores encontrado
    */
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

    /**
    * Este metodo se encarga de cargar de un archivo dado en la carpeta
    * archivos, donde se encuentra serializado una lista de jugadores la cual
    * se regresara
    *
    *  @param  jugadores  lista de jugadores los cuales se serializaran y se guat
    *  @return      si se guardo correctamente o no
    */
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
