package gestenis_ut4;

import java.io.*;
import java.util.ArrayList;


public class Tenis {
    private String nombre;
    private int edad;
    private ArrayList<Torneo> palmares;
    
    Tenis(String nombre,int edad){
        this.nombre=nombre;
        this.edad=edad;
        //lista de torneos
        palmares=new ArrayList<Torneo>();
    }

    /**
     * 
     * @return nombre Obtenemos el nombre del tenista
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * 
     * @param nombre Asignamos el nombre del tenista
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * 
     * @return edad Nos devuelve la edad del tenista
     */
    public int getEdad() {
        return edad;
    }

    /**
     * 
     * @param edad Asigna la edad del tenista
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }
    /*
     * Devuelve el palmarés con los nombres de los torneos ganados
     * @return
     */
    public String[] getPalmares(){
        String[] p = new String[palmares.size()];
        for(int i=0;i<p.length;i++){
            p[i] = palmares.get(i).getnombreTorneo();
        }
        return p;
    }
    /**
     * 
     * @param torneo Añade el torneo ganado al palmarés
     */
    public void aniadirPalmares(Torneo torneo){
        palmares.add(torneo);
    }
    
    /*
     * Recorre un bucle acumulando la puntuación obtenida
     * 
     */
    public int getPuntuacionATP(){
    	int p = 1;
        p = 0;
        for(Torneo t:palmares){
            p += t.getpuntuacion();
        }
        return p;
    }
    /**
     * 
     * @param fichero Carga en fichero el archivo seleccionado e introduce
     * sus datos en el ArrayList Tenista 
     * @return devuelve lista
     */
	public static ArrayList<Tenis> cargar(File fichero){
        ArrayList<Tenis> l = null;
        ObjectInputStream ficheroEntrada = null;
        try{
            ficheroEntrada = new ObjectInputStream(new FileInputStream(fichero));
            l = (ArrayList<Tenis>) ficheroEntrada.readObject();
            ficheroEntrada.close();
            return l;
        }catch(ClassNotFoundException onfe){
            return null;
        }catch(FileNotFoundException fnfe){
            return null;
        }catch(IOException ioe){
            return null;
        }
    }
    /**
     * 
     * 
     * @param lista Graba en fichero los datos del ArrayList lista
     * @param fichero
     * @return devolviendo true si ha sido todo correcto o false en caso contrario
     */
    public static boolean guardar(ArrayList<Tenis> lista, File fichero){
        try{
            ObjectOutputStream ficheroSalida = new ObjectOutputStream(new FileOutputStream(fichero));
            ficheroSalida.writeObject(lista);
            ficheroSalida.flush();
            ficheroSalida.close();
            return true;
        }catch(FileNotFoundException fnfe){
            return false;
        }catch(IOException ioe){
            return false;
        }
    }
    
}