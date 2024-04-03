package ejercicio1;

public class RegistrarFakeConcurso implements RegistradorConcurso {

    private boolean invocado = false;

    @Override
    public void registrar(String registro) {
        this.invocado = true;
    }

    public boolean fueInvocado() {
        return invocado;
    }
}
