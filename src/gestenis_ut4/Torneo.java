package gestenis_ut4;

import java.io.*;
import java.util.ArrayList;


public class Torneo  {
	
	//No usado:
    public static String GRAND_SLAM = "Grand Slam";
    public static String MASTER1000 = "ATP World Tour Master 1000";
    public static String MASTER500 = "ATP World Tour 500";
    public static String MASTER250 = "ATP World Tour 250";
    
    private String nombreTorneo;
    private int puntuacion;
    
    Torneo (String nombreTorneo,int puntuacion){
        this.nombreTorneo=nombreTorneo;
        this.puntuacion=puntuacion;
    }

    /**
     * 
     * @return nombreTorneo Devuelve el nombre del torneo
     */
    public String getnombreTorneo() {
        return nombreTorneo;
    }

    /**
     * 
     * @param nombreTorneo Asignamos un nombre de torneo
     */
    public void setnombreTorneo(String nombreTorneo) {
        this.nombreTorneo = nombreTorneo;
    }

    /**
     * 
     * @return puntuacion Devuelve la puntuacionuación asignada al torneo
     */
    public int getpuntuacion() {
        return puntuacion;
    }

    /**
     * 
     * @param Introducimos la puntuacionuación asignada para el torneo
     */
    public void setpuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }
    /**
     * 
     * 
     * @param fichero Carga los datos del fichero en el ArrayList lista
     * @return devuelve true si todo ha ido bien o false si ha fallado algo
     */
    public static ArrayList<Torneo> cargar(File fichero){
        ArrayList<Torneo> lista = null;
        try{
        	lista = new ArrayList<Torneo>();
            ObjectInputStream ficheroEntrada = null;
            ficheroEntrada = new ObjectInputStream(new FileInputStream(fichero));
            lista = (ArrayList<Torneo>) ficheroEntrada.readObject();
            ficheroEntrada.close();
            return lista;
        }catch(ClassNotFoundException cnfe){
            return null;
        }catch(FileNotFoundException fnfe){
            return null;
        }catch (IOException ioe){
            return null;
        }
    }
    /**
     * 
     *  
     * @param lista Guarda los datos del ArrayList lista en el fichero fichero
     * @param fichero
     * @return Si todo ha ido bien devuelve true y en caso contrario false
     */
    public static boolean guardar(ArrayList<Torneo> lista,File fichero){
        try{
        	//Fichero de salida
            ObjectOutputStream sal = null; 
            sal = new ObjectOutputStream(new FileOutputStream (fichero));
            sal.writeObject(lista);
            sal.flush();
            sal.close();
            return true;
        }catch(FileNotFoundException fnfe){
            return false;
        }catch(IOException ioe){
            return false;
        }
    }
    
    /**
     * Carga los datos del fichero en el ArrayList lista, luego guarda los datos del ArrayList lista en el fichero fichero
     * 
     * @param lista
     * @param fichero
     * @return Si todo ha ido bien devuelve true y en caso contrario false.
     */
   
}