package ejercicio2;

public class ComarcaPlus extends Tarjeta {

    public ComarcaPlus(String propietario, int numTarj, double descuento) {
        super(propietario, numTarj, descuento);
    }

    @Override
    public double aplicarDescuento(int montoTotal, int montoBebida, int montoComida) {
        double montoApliado;
        montoApliado = (montoTotal - montoTotal * descuento);
        return montoApliado;
    }
}
