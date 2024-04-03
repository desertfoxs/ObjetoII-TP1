package ejercicio2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PruebaTest {

    String ruta = "C:/Users/desertfoxs/Desktop/txt tp2/historialComidas.txt";
    Restaurante restaurante = new Restaurante("Roma", new RegistrarTXT(ruta));

    Pedido pedido = new Pedido();
    Comida pizza = new Comida("pizza 4queso", 2500);
    Comida hamburguesaBig = new Comida("hamburguesa Big", 4000);
    Bebida cocaCola = new Bebida("coca cola", 1000);

    @Test
    public void pagarConVisaFake() {

        var registrarFake = new RegistrarFakePago();
        Restaurante restaurante = new Restaurante("fake", registrarFake);

        var tarjetaVisa = new Visa("Angel Olivetti", 45823645, 0.3);

        pedido.agregar(pizza);
        pedido.agregar(hamburguesaBig);
        pedido.agregar(cocaCola);

        assertEquals(7500, pedido.calcularPrecioTotal());
        assertEquals(7200.0, restaurante.pagarCuenta(pedido, 5, tarjetaVisa));
        assertEquals(true, registrarFake.fueInvocado());
    }

    @Test
    public void pagarConMasterCardFake() {

        var registrarFake = new RegistrarFakePago();
        Restaurante restaurante = new Restaurante("fake", registrarFake);

        var tarjetaMasterCard = new MasterCard("Angel Olivetti", 526389742, 0.2);

        pedido.agregar(pizza);
        pedido.agregar(hamburguesaBig);
        pedido.agregar(cocaCola);

        assertEquals(7500, pedido.calcularPrecioTotal());
        assertEquals(6200, restaurante.pagarCuenta(pedido, 3, tarjetaMasterCard));
        assertEquals(true, registrarFake.fueInvocado());
    }

    @Test
    public void pagarConComarcaPlusFake() {

        var registrarFake = new RegistrarFakePago();
        Restaurante restaurante = new Restaurante("fake", registrarFake);

        var tarjetaComarcaPlus = new ComarcaPlus("Angel Olivetti", 26354789, 0.2);

        pedido.agregar(pizza);
        pedido.agregar(hamburguesaBig);
        pedido.agregar(cocaCola);

        assertEquals(7500, pedido.calcularPrecioTotal());
        assertEquals(6000, restaurante.pagarCuenta(pedido, 2, tarjetaComarcaPlus));
        assertEquals(true, registrarFake.fueInvocado());
    }

    @Test
    public void pagarConViedmaDisco() {

        var tajertaViedma = new TajetaSinDescuento("Angel Olivetti", 26354789, 0);

        pedido.agregar(pizza);
        pedido.agregar(hamburguesaBig);
        pedido.agregar(cocaCola);

        assertEquals(7500, pedido.calcularPrecioTotal());
        assertEquals(7500, restaurante.pagarCuenta(pedido, 2, tajertaViedma));

        assertThrows(RuntimeException.class, () -> assertEquals(7500,
                restaurante.pagarCuenta(pedido, 0, tajertaViedma)));

    }

    @Test
    public void pagarConVisaBD() {

        var tarjetaVisa = new Visa("Angel Olivetti", 45823645, 0.3);
        Restaurante restauranteBD = new Restaurante("roma", new RegistrarBaseDatoPago());

        pedido.agregar(pizza);
        pedido.agregar(hamburguesaBig);
        pedido.agregar(cocaCola);

        restauranteBD.pagarCuenta(pedido, 2, tarjetaVisa);

        assertEquals(7500, pedido.calcularPrecioTotal());
        assertEquals(7200.0, restaurante.pagarCuenta(pedido, 5, tarjetaVisa));

    }

}
