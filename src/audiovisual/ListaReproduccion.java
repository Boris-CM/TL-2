package audiovisual;

import java.util.ArrayList;
import java.util.List;

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
    private List<Contenido> contenidos;

    /**
     * Crea una nueva lista de reproducción.
     *
     * @param id identificador único de la lista
     * @param nombre nombre de la lista de reproducción
     */
    public ListaReproduccion(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.contenidos = new ArrayList<>(); 
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
     * Devuelve la colección de contenidos almacenados en la lista.
     *
     * @return lista de contenidos
     */
    public List<Contenido> getContenidos() {
        return contenidos; 
    }

    /**
     * Agrega un contenido a la lista de reproducción si no estaba previamente.
     *
     * @param c contenido a agregar
     */
    public void agregarContenido(Contenido c) {
        if (c != null && !contenidos.contains(c)) {
            contenidos.add(c);
        }
    }

    /**
     * Elimina un contenido de la lista de reproducción si existe.
     *
     * @param c contenido a eliminar
     * @return true si el contenido se eliminó, false si no estaba
     */
    public boolean eliminarContenido(Contenido c) {
        return contenidos.remove(c);
    }
}
