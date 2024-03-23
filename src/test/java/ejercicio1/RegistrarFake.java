package ejercicio1;

public class RegistrarFake implements Registrador {

    private boolean invocado = false;

    @Override
    public void registrar(String registro) {
        this.invocado = true;
    }

    public boolean fueInvocado() {
        return invocado;
    }
}
