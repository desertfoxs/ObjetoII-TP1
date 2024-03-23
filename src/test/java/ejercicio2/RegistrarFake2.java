package ejercicio2;

public class RegistrarFake2 implements Registrador2 {

    private boolean invocado = false;

    @Override
    public void registrar(String registro) {
        this.invocado = true;
    }

    public boolean fueInvocado() {
        return invocado;
    }

}
