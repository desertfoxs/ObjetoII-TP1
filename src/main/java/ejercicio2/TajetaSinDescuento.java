package ejercicio2;

public class TajetaSinDescuento extends Tarjeta {


    public TajetaSinDescuento(String propietario, int numTarj, double descuento) {
        super(propietario, numTarj, descuento);
    }

    @Override
    public double aplicarDescuento(int montoTotal, int montoBebida, int montoComida) {
        return montoTotal;
    }

}
