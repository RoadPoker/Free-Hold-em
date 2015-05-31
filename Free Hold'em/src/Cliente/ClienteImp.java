package Cliente;

import Servidor.Carta;
import Servidor.Jugador;
import Servidor.Mano;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Scanner;

import Servidor.Partida;
import Servidor.ServidorInterface;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class ClienteImp extends UnicastRemoteObject implements ClienteInterface, Runnable {
	
	private static final long serialVersionUID = 1L;
	private String nombre,pass;
	private ServidorInterface servidor;
        private JTextArea jTextArea1;
        private Servidor.Jugador usuario;
        private int idJug;
        /**
         * 
         * @return 
         */
        public static long getSerialVersionUID() {
        return serialVersionUID;
        }
        /**
         * retorna el id del jugador
         * @return 
         */
        public int getIdJug() {
        return idJug;
        }
        /**
         * Retorna el nombre del jugador.
         * @return 
         */
        public String getNombre() {
        return nombre;
        }
        /**
         * returna el servidor
         * @return 
         */
        public ServidorInterface getServidor() {
        return servidor;
        }
        /**
         * 
         * @return 
         */
        public JTextArea getjTextArea1() {
        return jTextArea1;
        }
        /**
         * Obtiene el usuario
         * @return 
         */
        public Jugador getUsuario() {
        return usuario;
        }
        /**
         * Modifica el nombre del usuario
         * @param nombre 
         */
        public void setNombre(String nombre) {
        this.nombre = nombre;
        }
        /**
         * Modifica el password de la cuenta del usuario
         * @param pass 
         */
        public void setPass(String pass) {
        this.pass = pass;
        }
        /**
         * Modifica el servidor Objetivo
         * @param servidor 
         */
        public void setServidor(ServidorInterface servidor) {
        this.servidor = servidor;
        }
        /**
         * 
         * @param jTextArea1 
         */
        public void setjTextArea1(JTextArea jTextArea1) {
        this.jTextArea1 = jTextArea1;
        }
        /**
         * modifica la instancia del usuario.
         * @param usuario 
         */
        public void setUsuario(Jugador usuario) {
        this.usuario = usuario;
        }
        /**
         *  contructor mediante el servidor interface
         * @param servido
         * @throws RemoteException 
         */
	protected ClienteImp(ServidorInterface servido) throws RemoteException {
		super();
		
		servidor=servido;
		//servidor.registarCliente(this);
		
	}
        /**
         * Devuelve mensaje en la interfaz cliente
         * @param mensaje
         * @throws RemoteException 
         */
	public void retriveMensaje(String mensaje) throws RemoteException {
		System.out.println(mensaje);
                jTextArea1.setText(mensaje);
               
	}
        
        
        /**
         * Metodo abstracto no necesario
         */
	public void run(){
		Scanner scanner= new Scanner(System.in);
		String mensaje;
		while(true){
			mensaje=scanner.nextLine();
		}
	}
        /**
         * 
         * @return
         * @throws RemoteException 
         */
	public String getName() throws RemoteException {
		
		return nombre;
	}
/**
 * RegistroJugador: registra el jugador en el servidor, devuelve error en caso de
 * existir otro jugador con el mismo nombre de usuario
 * @param nombre, nombre del usuario
 * @param pass, contraseña
 * @return retorna falso en caso de no generar el usuario.
 * @throws RemoteException 
 */
    public boolean RegistroJugador(String nombre,String pass) throws RemoteException {
            this.nombre=nombre;
            this.pass=pass;
            if (servidor.agregarJugador(nombre,pass)){
						System.out.println("Registro correcto");
                                                return true;
					}
					else{
						System.out.println("Error!!");
					}
        return false;
    }
/**
 * getPass: recupera contraseña del usuario
 * @return
 * @throws RemoteException 
 */
    public String getPass() throws RemoteException {
       return pass;
    }
    /**
     * AccesoJugador: permite al usuario acceder al sistema con un usuario
     * registrado.
     * @param nombre
     * @param pass
     * @return en caso de ser una conexión fallida devuelve false.
     * @throws RemoteException 
     */
    public boolean AccesoJugador(String nombre,String pass) throws RemoteException {
        this.nombre=nombre;
        this.pass=pass;
        usuario=servidor.Acceder(nombre, pass);
        if(usuario==null)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
/**
 * EnviarListo: confirma el usuario para ingresar a su partida o iniciar una nueva.
 * @return devuelve un booleano si se pudo registrar y entrar a la partida en caso 
 * tal que la partida ha iniciado devuelve un false.
 * 
 */
    public boolean EnviarListo() {
            
            try {
                if(servidor.iniciarPartida(usuario))
                {
                    idJug=servidor.pedirUbicacionEnMesa(usuario);
                    System.out.println("Mi ubicación"+servidor.pedirUbicacionEnMesa(usuario));
                    while(!servidor.verificarInicioPartida())
                    {
                        
                    }
                    Mano manoJuego=servidor.pedirCartasIniciales(usuario);
                    usuario.setMano(manoJuego);
                    System.out.println("primera carta"+usuario.getMano().getCartas().get(0).toString());
                    return true;
                }
                else
                {
                    return false;
                }
                
            } catch (RemoteException ex) {
                Logger.getLogger(ClienteImp.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
    }
/**
 * 
 * @param jTextArea1
 * @throws RemoteException 
 */
    public void setArea(JTextArea jTextArea1) throws RemoteException {
        this.jTextArea1=jTextArea1;
    }
    /**
     * Método que ayuda a recuperar los jugadores listos en la mesa de juego
     * @return un ArrayList con la información de todos los jugadores.
     * @throws RemoteException 
     */
    public ArrayList<Jugador> pedirJugadoresListos() throws RemoteException
    {
        return servidor.PedirJugadoresListos();
    }
/**
 * Método que recupera las cartas comunales asignadas por el servidor en dicha mesa.
 * @return ArrayList con las cartas comunales de la mesa.
 * @throws RemoteException 
 */
    @Override
    public ArrayList<Carta> pedirCartasComunales() throws RemoteException {
       return servidor.pedirCartasComunales();
    }

    
}
