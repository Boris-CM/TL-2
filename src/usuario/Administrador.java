package usuario;

import java.util.ArrayList;
import audiovisual.*;
/**
 * La clase Administrador implementa la logica que sea nesesaria para manipular todo lo correspondiente a los administradores
 * 
 * @author Boris
 * @author  Tomas
 */
public class Administrador extends Usuario {
	
	/**
	 * Agrega el Audiovisual al final de la ListaDeRepoduccion
	 * 
	 * @param elemento El audiovisual que se desea agregar
	 * @param lista La listaDeRepoduccion en la que se agregar el elemento
	 */
	public void agregarAudiovisual(ListaReproduccion list, Audiovisual elemento) {
		list.agregarContenido(elemento);
	}
	
	/**
	 * Elimina el Audiovisual de la ListaDeRepoduccion
	 * 
	 * @param elemento El audiovisual que se desea eliminar
	 * @param lista La listaDeRepoduccion en la que se elimina el elemento
	 */
	public void eliminarAudiovisual(ListaReproduccion list, Audiovisual elemento) {
		list.eliminarContenido(elemento);
	}
	
	/**
	 * Agrega la listaDeRepoduccion al final de la lista de listaDeRepoduccion
	 * 
	 * @param catalogo La lista de listaDeRepoduccion en la que va agregar el elemento
	 * @param elemento La listaDeRepoduccion que se desea agregar
	 */
	public void agregarCatalogo(ArrayList<ListaReproduccion> list, ListaReproduccion elemento) {
		list.add(elemento);
	}
	
	/**
	 * Elimina la listaDeRepoduccionque de la lista de ListaDeRepoduccion
	 * 
	 * @param lista La lista de ListaReproduccion en la que se elimina el elemento
	 * @param elemento La ListaReproduccion que se desea eliminar
	 * 
	 * @return {@code true} Si la ListaReproduccion se eliminó
	 */
	public boolean eliminarCatalogo(ArrayList<ListaReproduccion> list, ListaReproduccion elemento) {
		return list.remove(elemento);
	}
}
