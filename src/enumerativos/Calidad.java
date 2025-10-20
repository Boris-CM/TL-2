package enumerativos;

public enum Calidad {
	P240(240),
    P480(480),
    P720(720),
    P1080(1080),
    P4K(2160);

    private int resolucion;

    // Constructor
    private Calidad(int resolucion) {
        this.resolucion = resolucion;
    }

    public int getResolucion() {
        return resolucion;
    }

    @Override
    public String toString() {
        return resolucion + "p";
    }
}
