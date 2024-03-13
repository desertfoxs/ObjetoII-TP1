package ejercicio1;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PruebaTest {

    @Test
    public void ingresarParticipante() {

        Participante participante1 = new Participante("Ezequiel", 42458632);
        Concurso concurso1 = new Concurso("Bingo", LocalDateTime.now().plusMonths(1), LocalDateTime.now().minusDays(2));
        concurso1.inscribir(participante1);

        assertTrue(concurso1.CantInscriptos(1));
        assertTrue(participante1.cantPuntos(0));

    }

    @Test
    public void ingresarParticipantePrimerDia() {

        Participante participante0 = new Participante("Angel", 44705032);
        Concurso concurso0 = new Concurso("Boletira", LocalDateTime.now().plusMonths(1));
        concurso0.inscribir(participante0);

        assertTrue(concurso0.CantInscriptos(1));
        assertTrue(participante0.cantPuntos(10));
    }

    @Test
    public void ingresarParticipanteFueraFecha() {
        
        Participante participante2 = new Participante("Olivetti", 25305032);
        Concurso concurso2 = new Concurso("Boletira", LocalDateTime.now().minusDays(1));

        assertThrows(RuntimeException.class, () -> concurso2.inscribir(participante2));
        assertTrue(concurso2.CantInscriptos(0));

    }
}
