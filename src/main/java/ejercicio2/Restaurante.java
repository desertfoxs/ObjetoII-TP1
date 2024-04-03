package ejercicio2;

import java.time.LocalDateTime;

public class Restaurante {

    private String nombre;
    private RegistradorPagos registro;

    public Restaurante(String nombre, RegistradorPagos registro) {
        this.nombre = nombre;
        this.registro = registro;
    }

    public double pagarCuenta(Pedido pedido, int propinaPorc, Tarjeta tarjeta) {

        double dineroPagar = 0;

        dineroPagar = tarjeta.aplicarDescuento(pedido.calcularPrecioTotal(), pedido.calcularPrecioBebida()
                , pedido.calcularPrecioComida());

        LocalDateTime tiempo = LocalDateTime.now();

        
        String mensaje = tiempo.toString() + "---" + pedido.calcularPrecioTotal() + "\n";
        this.registro.registrar(mensaje);


        calcularPropina(propinaPorc, (int) dineroPagar);
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
