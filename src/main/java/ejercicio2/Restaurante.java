package ejercicio2;

public class Restaurante {

    private String nombre;

    public Restaurante(String nombre) {
        this.nombre = nombre;
    }

    public double pagarCuenta(Pedido pedido, int propinaPorc, Tarjeta tarjeta) {

        double dineroPagar = 0;

        dineroPagar = tarjeta.aplicarDescuento(pedido.calcularPrecioTotal(), pedido.calcularPrecioBebida()
                , pedido.calcularPrecioComida());


        System.out.println("Se confirmo el pago de: " + dineroPagar + "$");
        System.out.println("Se pago una propina de: " + calcularPropina(propinaPorc, (int) dineroPagar) + "$");

        return dineroPagar;

    }


    public int calcularPropina(int porcentaje, int precioTotal) {

        int propina = 0;

        if (porcentaje < 6 && porcentaje != 4 && porcentaje > 1) {
            propina = (porcentaje * precioTotal) / 100;
        } else {
            throw new RuntimeException("cantidad de porcentaje no valida, tiene que ser 2, 3 o 5");
        }

        return propina;
    }

}
