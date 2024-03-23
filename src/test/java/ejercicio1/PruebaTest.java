package ejercicio1;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class PruebaTest {

    @Test
    public void ingresarParticipanteRegistroFake() {

        var fake = new RegistrarFake();

        Participante participante1 = new Participante("Ezequiel", 42458632);
        Concurso concurso1 = new Concurso(1, "Bingo",
                LocalDateTime.now().plusMonths(1), LocalDateTime.now().minusDays(2), fake);

        concurso1.inscribir(participante1);

        assertTrue(concurso1.CantInscriptos(1));
        assertTrue(participante1.cantPuntos(0));
        assertEquals(true, fake.fueInvocado());
    }

    @Test
    public void ingresarParticipantePrimerDiaRegistroFake() {

        var fake = new RegistrarFake();

        Participante participante0 = new Participante("Angel", 44705032);
        Concurso concurso0 = new Concurso(2, "Boletira", LocalDateTime.now().plusMonths(1), fake);
        concurso0.inscribir(participante0);

        assertTrue(concurso0.CantInscriptos(1));
        assertTrue(participante0.cantPuntos(10));
        assertEquals(true, fake.fueInvocado());
    }

    @Test
    public void ingresarParticipanteFueraFechaRegistroFake() {

        var fake = new RegistrarFake();

        Participante participante2 = new Participante("Olivetti", 25305032);
        Concurso concurso2 = new Concurso(3, "Boletira", LocalDateTime.now().minusDays(1), fake);

        assertThrows(RuntimeException.class, () -> concurso2.inscribir(participante2));
        assertTrue(concurso2.CantInscriptos(0));
        assertEquals(false, fake.fueInvocado());

    }

    @Test
    public void ingresarParticipanteRegistroDisco() {

        Participante participante1 = new Participante("Ezequiel", 42458632);
        Concurso concurso1 = new Concurso(1, "Bingo",
                LocalDateTime.now().plusMonths(1), LocalDateTime.now().minusDays(2), new RegistrarDisco());

        concurso1.inscribir(participante1);

        assertTrue(concurso1.CantInscriptos(1));
        assertTrue(participante1.cantPuntos(0));

    }
}
