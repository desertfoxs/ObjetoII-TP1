package ejercicio1;

public class EnviarMensajeFake implements EnviarMensaje {

    private boolean invocado = false;

    @Override
    public void enviar(String registro) {
        this.invocado = true;
    }

    public boolean fueInvocado() {
        return invocado;
    }


}
