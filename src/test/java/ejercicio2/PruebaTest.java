package ejercicio2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PruebaTest {

    Restaurante restaurante = new Restaurante("Roma");
    Pedido pedido = new Pedido();
    Comida pizza = new Comida("pizza 4queso", 2500);
    Comida hamburguesaBig = new Comida("hamburguesa Big", 4000);
    Bebida cocaCola = new Bebida("coca cola", 1000);

    @Test
    public void pagarConVisa() {

        var tarjetaVisa = new Visa("Angel Olivetti", 45823645, 0.3);

        pedido.agregar(pizza);
        pedido.agregar(hamburguesaBig);
        pedido.agregar(cocaCola);

        assertEquals(7500, pedido.calcularPrecioTotal());
        assertEquals(7200.0, restaurante.pagarCuenta(pedido, 5, tarjetaVisa));

    }

    @Test
    public void pagarConMasterCard() {

        var tarjetaMasterCard = new MasterCard("Angel Olivetti", 526389742, 0.2);


        pedido.agregar(pizza);
        pedido.agregar(hamburguesaBig);
        pedido.agregar(cocaCola);

        assertEquals(7500, pedido.calcularPrecioTotal());
        assertEquals(6200, restaurante.pagarCuenta(pedido, 3, tarjetaMasterCard));

    }

    @Test
    public void pagarConComarcaPlus() {

        var tarjetaComarcaPlus = new ComarcaPlus("Angel Olivetti", 26354789, 0.2);

        pedido.agregar(pizza);
        pedido.agregar(hamburguesaBig);
        pedido.agregar(cocaCola);

        assertEquals(7500, pedido.calcularPrecioTotal());
        assertEquals(6000, restaurante.pagarCuenta(pedido, 2, tarjetaComarcaPlus));

    }

    @Test
    public void pagarConViedma() {

        var tajertaViedma = new TajetaSinDescuento("Angel Olivetti", 26354789, 0);

        pedido.agregar(pizza);
        pedido.agregar(hamburguesaBig);
        pedido.agregar(cocaCola);

        assertEquals(7500, pedido.calcularPrecioTotal());
        assertEquals(7500, restaurante.pagarCuenta(pedido, 2, tajertaViedma));

        assertThrows(RuntimeException.class, () -> assertEquals(7500,
                restaurante.pagarCuenta(pedido, 0, tajertaViedma)));

    }
}
