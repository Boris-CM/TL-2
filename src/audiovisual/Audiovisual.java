package audiovisual;

import java.util.List;

public abstract class Audiovisual {
    private int id;
    private String titulo;
    private String sinopsis;
    private List<String> elenco;
    private String director;
    private int vistas;

    public Audiovisual(int id, String titulo, String sinopsis, List<String> elenco, String director, int vistas) {
        this.id = id;
        this.titulo = titulo;
        this.sinopsis = sinopsis;
        this.elenco = elenco;
        this.director = director;
        this.vistas = vistas;
    }

    // Getters y Setters
    public int getId() { 
    	return id;
    	}
    public void setId(int id) {
    	this.id = id;
    	}

    public String getTitulo() { 
    	return titulo; 
    	}
    
    public void setTitulo(String titulo) { 
    	this.titulo = titulo; 
    	}

    public String getSinopsis() { 
    	return sinopsis; 
    	}
    public void setSinopsis(String sinopsis) { 
    	this.sinopsis = sinopsis; 
    	}

    public List<String> getElenco() { 
    	return elenco; 
    	}
    public void setElenco(List<String> elenco) { 
    	this.elenco = elenco;
    	}

    public String getDirector() {
    	return director; 
    	}
    public void setDirector(String director) {
    	this.director = director; 
    	}

    public int getVistas() { 
    	return vistas; 
    	}
    public void setVistas(int vistas) { 
    	this.vistas = vistas;
    	}

    
    public abstract void reproducir();
}
