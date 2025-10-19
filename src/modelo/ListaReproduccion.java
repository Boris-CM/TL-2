package modelo;

import java.util.ArrayList;

/**
 * Representa una lista de reproducción que contiene múltiples objetos de tipo {@link Contenido}.
 * Permite agregar, eliminar y consultar contenidos almacenados.
 * 
 * @author Tomas
 * @author Boris
 * @version 1.0
 */
public class ListaReproduccion {
    private int id;
    private String nombre;
    private ArrayList<Audiovisual> contenidos;

    /**
     * Crea una nueva lista de reproducción.
     *
     * @param id identificador único de la lista
     * @param nombre nombre de la lista de reproducción
     */
    public ListaReproduccion(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.contenidos = new ArrayList<Audiovisual>(); 
    }

    /**
     * Devuelve el identificador único de la lista de reproducción.
     *
     * @return id de la lista
     */
    public int getId() {  
        return id; 
    }

    /**
     * Establece el identificador único de la lista de reproducción.
     *
     * @param id nuevo identificador
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Devuelve el nombre de la lista de reproducción.
     *
     * @return nombre de la lista
     */
    public String getNombre() {
        return nombre; 
    }

    /**
     * Establece el nombre de la lista de reproducción.
     *
     * @param nombre nuevo nombre de la lista
     */
    public void setNombre(String nombre) { 
        this.nombre = nombre; 
    }

    /**
     * Devuelve la colección de audiovisual almacenados en la lista.
     *
     * @return lista de audiovisuales
     */
    public ArrayList<Audiovisual> getContenidos() {
        return contenidos; 
    }

    /**
     * Agrega un audiovisual a la lista de reproducción si no estaba previamente.
     *
     * @param c audiovisual a agregar
     */
    public void agregarContenido(Audiovisual c) {
        if (c != null && !contenidos.contains(c)) {
            contenidos.add(c);
        }
    }

    /**
     * Elimina un audiovisual de la lista de reproducción si existe.
     *
     * @param c audiovisual a eliminar
     * @return {@code true} si el audiovisual se eliminó, false si no estaba
     */
    public boolean eliminarContenido(Audiovisual c) {
        return contenidos.remove(c);
    }
}
