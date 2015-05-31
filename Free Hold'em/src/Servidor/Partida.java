package Servidor;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import Cliente.ClienteInterface;
import java.util.logging.Level;
import java.util.logging.Logger;
import static sun.management.snmp.jvminstr.JvmThreadInstanceEntryImpl.ThreadStateMap.Byte0.runnable;
/**
 *  Esta clase se encarga de implementar los metodos descritos por la clase
 * ServidorInterface, con un conjunto de metodos que un jugador puede usar
 * mediante rmi, por lo tanto esterepresenta el funcionamito del servidor
 * y los servicios que presta
 * @author Road Poker
 */
public class Partida extends UnicastRemoteObject implements ServidorInterface {
	private static final long serialVersionUID = 1L;
        GestionPartida gestion= new GestionPartida();
        private ArrayList<Jugador> jugadoresListos=new ArrayList<Jugador>();
        ExpertoPersistencia persiste= new ExpertoPersistencia();
        boolean enUso=false;
        private static int tiempo;
	
    /**
    * Constructor
    * 
    */
	protected Partida()  throws RemoteException {
		
	}
	
       /**
    * Dado un nombre de usuario y una contraseña este contacta con gestionPartida para
    * darle acceso con los datos que dio
    * 
    *  @param  usuario nombre del usuario que el usuario da
    *  @param  pass contraseña del usuario que el usuario da
    *  @return      Jugador que encuentra para el acceso
    */   
        public synchronized Jugador Acceder(String usuario,String pass)throws RemoteException {
         Jugador regreso=gestion.autenticarJugador(usuario, pass);
            if (regreso!=null){
                return regreso;
            }
            return null;
                  
}
  /**
    * Este metodo se encarga de dado un nombre de usuario que no exista y una contraseña
    * le pide a  GestionPartida que cree uno y lo guarde
    * 
    *  @param  usuario nombre del usuario que el usuario da
    *  @param  pass contraseña del usuario que el usuario da
    *  @return      si fue agregado o no
    */
          public boolean agregarJugador(String usuario, String pass) throws RemoteException {
             return gestion.AgergarJugador(usuario, pass);
         }

  /**
    * Este metodo se encarga de dado un nombre de archivo de llamar al objeto de la
    * calse Experto persistencia para que cargue los datos serializados en el
    * 
    *  @param  localizacion nombre del archivo donde se encuentra guardados los datos serializados
    *  @return      la lista de jugadores cargada
    */
    public ArrayList<Jugador> cargarJugadores(String localizacion) throws RemoteException {
        
        return persiste.Cargarjugadores(localizacion);
                 
    }

    /**
    * Este metodo se encarga de determinar si la cantidad de jugadores listos para iniciar
    * es suficiente para que inicie la partida
    * 
    *  @return      si es posible iniciar partida o no
    */
    public boolean determinarInicioDePartida() throws RemoteException {
        
        
        
        if (jugadoresListos.size()>=2){
            return true;
        }
        return false;
    }

    /**
    * Este metodo se encarga de mandar a GestionPartida  una jugada realizada por 
    * alhun jugador dorante su turno
    * 
    *  @param  cantidad  cantidad apostada en el turno
    *  @param  tipoApuesta  tipo de apuesta realizada por el ususario
    */
    public void enviarJugada(long cantidad, String tipoApuesta) throws RemoteException {
        gestion.enviarJugada(cantidad, tipoApuesta);
    }

   /**
    * Este metodo se encarga de darle la oportunidad al usuario de decir en si quiere
    * iniciar partida, agregandolo a una lista de jugadores listos y posteriora
    * esto determina si es posible para iniciar y se lo informa al jugador
    * 
    *  @param  jugador jugador dispuesto a iniciar partida
    *  @return      si es posible iniciar o no
    */
    public boolean iniciarPartida(Jugador jugador) throws RemoteException {
        if(enUso)
        {
            return false;
        }
       jugadoresListos.add(jugador);
        System.out.println("El usuario pide iniciar partida"+jugador.getNombre());
        tiempo=10;
        while(tiempo>0)
        {
           try {
               Thread.sleep(1000);
           } catch (InterruptedException ex) {
               Logger.getLogger(Partida.class.getName()).log(Level.SEVERE, null, ex);
           }
            tiempo --;
        }
        while(!determinarInicioDePartida())
        {
           try {
               Thread.sleep(1000);
           } catch (InterruptedException ex) {
               Logger.getLogger(Partida.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
        
        gestion.setJugadoresListos(jugadoresListos);
        if(tiempo<=0)
        {
            enUso=true;
            for(int i=0;i<jugadoresListos.size();i++)
            {
                jugadoresListos.get(i).setIdJugador(i+1);
            }
            gestion.repartirCartas();
        }
        return true;
      
    }

    /**
    * Este metodo se encarga de dado un jugador de notificarle que es su turno
    * 
    *  @param  jugador jugador con turno actual
    */
    public void notificarTurnoJugador(Jugador jugador) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
    * Dado un jugador este metodo se encarga de regresarle la mano que le correspondio
    * 
    *  @param  jugador jugador que pide las cartas que le corresponden por esa partida
    *  @return      mano que le corresponde al juagdor
    */
    public Mano pedirCartasIniciales(Jugador jugador) throws RemoteException {
        return gestion.pedirCartasIniciales(jugador);
    }

    /**
    * Dado un jugador este metodo se encarga de regresarle la posicion que le corresponde
    * en la mesa
    * 
    *  @param  jugador jugador que pide la ubiacion que le corresponde por esa partida en la mesa
    *  @return      numero de silla que le corresponde al jugador
    */
    public int pedirUbicacionEnMesa(Jugador jugador) throws RemoteException {
        return gestion.pedirUbicacionEnMesa(jugador);
    }

     /**
    * Dada la intencion de un jugador de salir este metodo se encarga de notificarle al gestor 
    * para que este a su vez notifique a todos de la salida del jugador al resto de ellos
    * 
    *  @param  jugador jugador que pide retirarse de la partida
    */
    public void salirJugador(Jugador jugador) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

     /**
    * Dado una lista de jugadores este metodo se encarga de guardar esta lista serializada
    * por medio de la clase Experto persistencia
    * 
    *  @param  jugadores lista de jugadores a ser guardada
    *  @return      mano que le corresponde al juagdor
    */
    public void salvarJugadores(ArrayList<Jugador> jugadores) throws RemoteException {
         persiste.SalvarJugadores(jugadores);
    }
     /**
    * Este metodo se encarga de guardar a los jugadores en el gestor
    * llamando a la clase de cargar los jugadores dada una localizacion donde se encuentra
    * el archivo con estos datos
    * 
    *  @param  localizacion lugar donde se ecnuentra el archivo de datos de los jugadores
    */
    public void guardarJugadoresEnGestor(String localizacion){
            try {
                gestion.guardarJugadores(cargarJugadores(localizacion));
            } catch (RemoteException ex) {
                Logger.getLogger(Partida.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
   /**
    * Este metodo se encarga de gestionar una partida en curso
    * 
    */  
    public void partidaEnCurso(){
        enUso=true;
        gestion.setJugadoresListos(jugadoresListos);
        gestion.repartirCartas();
        for(int i=0;i<3;i++){
            for(int j=0;j<jugadoresListos.size();j++){
                gestion.notificarTurno(jugadoresListos.get(j));
            }            
            gestion.notificarNuevoTurno();
        }
        gestion.determinarGanador();
    }

    public boolean verificarInicioPartida() throws RemoteException
    {
        return enUso;
    }
    public ArrayList<Jugador> PedirJugadoresListos() throws RemoteException
    {
        return jugadoresListos;
    }

    @Override
    public ArrayList<Carta> pedirCartasComunales() throws RemoteException {
        return gestion.getCartasComunales();
    }
}
