package modelo;

import java.util.ArrayList;

public class Temporada {
	private int numTemporada;
	private ArrayList<Audiovisual> episodios;
	
	public Temporada(int numTemporada, ArrayList<Audiovisual> episodios) {
		this.numTemporada = numTemporada;
		this.episodios = episodios;
	}
	
	// ----- Getters & Setters -----
	
	public int getNumTemporada() {
		return numTemporada;
	}

	public void setNumTemporada(int numTemporada) {
		this.numTemporada = numTemporada;
	}

	public Temporada(ArrayList<Audiovisual> episodios) {
		this.episodios = episodios;
	}

	public ArrayList<Audiovisual> getEpisodios() {
		return episodios;
	}

	public void setEpisodios(ArrayList<Audiovisual> episodios) {
		this.episodios = episodios;
	}
	
	public void agregarEpisodio(Audiovisual episodio) {
		this.episodios.add(episodio);
	}
	
	public void eliminarEliminar(Audiovisual episodio) {
		String titulo = episodio.getTitulo();
		this.getEpisodios().removeIf(obj -> obj.getTitulo().compareTo(titulo) == 0);
	}

}
