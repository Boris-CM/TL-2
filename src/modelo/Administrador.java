package modelo;

import java.util.ArrayList;
/**
 * La clase Administrador implementa la logica que sea nesesaria para manipular todo lo correspondiente a los administradores
 * 
 * @author Boris
 * @author  Tomas
 */
public class Administrador extends Usuario {
	
	public Administrador() {}
	
	/**
	 * Agrega el Contenido al final de la lista
	 * 
	 * @param elemento El Contenido que se desea agregar
	 * @param lista La lista de contenidos en la que se agregar el elemento
	 */
	public void agregarContenido(ArrayList<Contenido> list, Contenido elemento) {
		list.add(elemento);
	}
	
	/**
	 * Elimina el Contenido de la lista
	 * 
	 * @param elemento El Contenido que se desea eliminar
	 * @param lista La lista de contenidos en la que se elimina el elemento
	 */
	public void eliminarContenido(ArrayList<Contenido> list, Contenido elemento) {
		list.remove(elemento);
	}
	
}
