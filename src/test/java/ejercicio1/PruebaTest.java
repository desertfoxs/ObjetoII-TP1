package ejercicio1;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class PruebaTest {

    @Test
    public void ingresarParticipanteRegistroFake() {

        var fakeRegistro = new RegistrarFakeConcurso();
        var fakeMensaje = new EnviarMensajeFake();

        Participante participante1 = new Participante("Ezequiel", 42458632);
        Concurso concurso1 = new Concurso(1, "Bingo",
                LocalDateTime.now().plusMonths(1), LocalDateTime.now().minusDays(2), fakeRegistro, fakeMensaje);

        concurso1.inscribir(participante1);

        assertTrue(concurso1.CantInscriptos(1));
        assertTrue(participante1.cantPuntos(0));
        assertTrue(fakeRegistro.fueInvocado());
        assertTrue(fakeMensaje.fueInvocado());
    }

    @Test
    public void ingresarParticipantePrimerDiaRegistroFake() {

        var fakeRegistro = new RegistrarFakeConcurso();
        var fakeMensaje = new EnviarMensajeFake();

        Participante participante0 = new Participante("Angel", 44705032);
        Concurso concurso0 = new Concurso(2, "Boletira", LocalDateTime.now().plusMonths(1), fakeRegistro, fakeMensaje);
        concurso0.inscribir(participante0);

        assertTrue(concurso0.CantInscriptos(1));
        assertTrue(participante0.cantPuntos(10));
        assertTrue(fakeRegistro.fueInvocado());
        assertTrue(fakeMensaje.fueInvocado());
    }

    @Test
    public void ingresarParticipanteFueraFechaRegistroFake() {

        var fakeRegistro = new RegistrarFakeConcurso();
        var fakeMensaje = new EnviarMensajeFake();

        Participante participante2 = new Participante("Olivetti", 25305032);
        Concurso concurso2 = new Concurso(3, "Boletira", LocalDateTime.now().minusDays(1), fakeRegistro, fakeMensaje);

        assertThrows(RuntimeException.class, () -> concurso2.inscribir(participante2));
        assertTrue(concurso2.CantInscriptos(0));
        assertFalse(fakeRegistro.fueInvocado());
        assertFalse(fakeMensaje.fueInvocado());

    }

    @Test
    public void ingresarParticipanteRegistroDisco() {
        String ruta = "C:/Users/desertfoxs/Desktop/txt tp2/historial2.txt";

        Participante participante1 = new Participante("Ezequiel", 42458632);
        Concurso concurso1 = new Concurso(1, "Bingo",
                LocalDateTime.now().plusMonths(1), LocalDateTime.now().minusDays(2), new RegistrarDisco(ruta), new EnviarGmail());

        concurso1.inscribir(participante1);

        assertTrue(concurso1.CantInscriptos(1));
        assertTrue(participante1.cantPuntos(0));

    }

    @Test
    public void ingresarParticipanteRegistroBaseDato() {

        Participante participante1 = new Participante("mar", 822196);
        Concurso concurso1 = new Concurso(1, "Bingo",
                LocalDateTime.now().plusMonths(1), LocalDateTime.now().minusDays(2), new RegistrarBaseDatoConcurso(), new EnviarGmail());

        concurso1.inscribir(participante1);

        assertTrue(concurso1.CantInscriptos(1));
        assertTrue(participante1.cantPuntos(0));
    }


}
