package ejercicio2;

public abstract class Tarjeta {

    protected String propietario;
    protected int numTarj;
    protected double descuento;


    public Tarjeta(String propietario, int numTarj, double descuento) {

        this.propietario = propietario;
        this.numTarj = numTarj;
        this.descuento = descuento;
    }

    public abstract double aplicarDescuento(int montoTotal, int montoBebida, int montoComida);

}
