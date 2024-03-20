package ejercicio2;

public class Visa extends Tarjeta {


    public Visa(String propietario, int numTarj, double descuento) {
        super(propietario, numTarj, descuento);
    }

    @Override
    public double aplicarDescuento(int montoTotal, int montoBebida, int montoComida) {
        double montoApliado;
        montoApliado = montoComida + (montoBebida - montoBebida * descuento);
        return montoApliado;
    }

}
