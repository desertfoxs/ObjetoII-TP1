package ejercicio2;

import java.util.HashMap;
import java.util.Map;

public class Pedido {

    Map<Comida, Integer> comidas = new HashMap<>();
    Map<Bebida, Integer> bebidas = new HashMap<>();
    private int costoTotal;
    private int costoDescuento;
    private int precioTotalComida;
    private int precioTotalBebida;
    private int propina;

    public Pedido() {
        this.costoTotal = 0;
        this.costoDescuento = 0;
        this.propina = 0;
    }

    public void agregar(Comida comida) {
        if (precioTotalComida == 0) {
            if (comidas.containsKey(comida)) {
                comidas.put(comida, (comidas.get(comida)) + 1);
            } else {
                comidas.put(comida, 1);
            }
        }
    }

    public void agregar(Bebida bebida) {
        if (precioTotalComida == 0) {

            if (bebidas.containsKey(bebida)) {
                bebidas.put(bebida, (bebidas.get(bebida)) + 1);
            } else {
                bebidas.put(bebida, 1);
            }
        }
    }

    public int calcularPrecioTotal() {

        precioTotalComida = calcularPrecioComida();
        precioTotalBebida = calcularPrecioBebida();

        precioTotalComida = precioTotalBebida + precioTotalComida;
        return precioTotalComida;
    }

    public int calcularPrecioComida() {

        int precioComidaFinal = 0;

        for (Comida comida : comidas.keySet()) {
            precioComidaFinal += comida.getPrecio();
        }

        return precioComidaFinal;

    }

    public int calcularPrecioBebida() {

        int precioBebidaFinal = 0;

        for (Bebida bebida : bebidas.keySet()) {
            precioBebidaFinal += bebida.getPrecio();
        }

        return precioBebidaFinal;
    }
}
