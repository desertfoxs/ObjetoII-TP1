package ejercicio2;

public class MasterCard extends Tarjeta {

    public MasterCard(String propietario, int numTarj, double descuento) {
        super(propietario, numTarj, descuento);
    }

    @Override
    public double aplicarDescuento(int montoTotal, int montoBebida, int montoComida) {
        double montoApliado;
        montoApliado = montoBebida + (montoComida - montoComida * descuento);
        return montoApliado;
    }

}
