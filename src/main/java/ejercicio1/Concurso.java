package ejercicio1;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Concurso {

    private String nombre;
    private int numinscriptos;
    private ArrayList<Participante> inscriptos;
    private LocalDateTime fechaIni;
    private LocalDateTime fechaFin;

    public Concurso(String nombre, LocalDateTime fechaFin, LocalDateTime fechaIni) {

        this.nombre = nombre;
        this.fechaFin = fechaFin;
        this.fechaIni = fechaIni;
        numinscriptos = 0;
        inscriptos = new ArrayList<Participante>();

    }

    public Concurso(String nombre, LocalDateTime fechaFin) {

        this.nombre = nombre;
        this.fechaFin = fechaFin;
        this.fechaIni = LocalDateTime.now();
        numinscriptos = 0;
        inscriptos = new ArrayList<Participante>();
    }

    public void inscribir(Participante participante) {


        LocalDateTime fechaAct = LocalDateTime.now();

        if (fechaAct.isBefore(fechaFin)) {

            if (fechaAct.isBefore(fechaIni.plusDays(1))) {
                //en este caso sumar 10 puntos al participante
                inscriptos.add(participante);
                participante.sumarPuntos(10);
                numinscriptos++;
            } else {
                //no sumar nada solo inscribirlo
                inscriptos.add(participante);
                numinscriptos++;
            }
        } else {
            //imprimir un mensaje diciendo que el concurso ya cerro su fecha caduco
            throw new RuntimeException("No se pudo anotar al concurso porque ya cerraron las inscripciones");
        }
    }

    public boolean CantInscriptos(int num) {
        return num == numinscriptos;
    }

}
