package ejercicio1;

public class Participante {

    private String nombre;
    private int DNI;
    private int puntos;

    public Participante(String nombre, int DNI) {
        this.nombre = nombre;
        this.DNI = DNI;
        puntos = 0;
    }

    public void sumarPuntos(int puntos) {
        this.puntos += puntos;
    }

    public boolean cantPuntos(int punt) {
        return punt == puntos;
    }
}
