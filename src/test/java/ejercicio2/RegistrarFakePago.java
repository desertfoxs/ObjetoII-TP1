package ejercicio2;

public class RegistrarFakePago implements RegistradorPagos {

    private boolean invocado = false;

    @Override
    public void registrar(String registro) {
        this.invocado = true;
    }

    public boolean fueInvocado() {
        return invocado;
    }

}
