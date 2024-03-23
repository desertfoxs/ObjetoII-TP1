package ejercicio2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PruebaTest {


    Restaurante restaurante = new Restaurante("Roma", new RegistrarTXT());

    Pedido pedido = new Pedido();
    Comida pizza = new Comida("pizza 4queso", 2500);
    Comida hamburguesaBig = new Comida("hamburguesa Big", 4000);
    Bebida cocaCola = new Bebida("coca cola", 1000);

    @Test
    public void pagarConVisaFake() {

        var fake = new RegistrarFake2();
        Restaurante restauranteFake = new Restaurante("fake", fake);

        var tarjetaVisa = new Visa("Angel Olivetti", 45823645, 0.3);

        pedido.agregar(pizza);
        pedido.agregar(hamburguesaBig);
        pedido.agregar(cocaCola);

        assertEquals(7500, pedido.calcularPrecioTotal());
        assertEquals(7200.0, restauranteFake.pagarCuenta(pedido, 5, tarjetaVisa));
        assertEquals(true, fake.fueInvocado());
    }

    @Test
    public void pagarConMasterCardFake() {

        var fake = new RegistrarFake2();
        Restaurante restauranteFake = new Restaurante("fake", fake);

        var tarjetaMasterCard = new MasterCard("Angel Olivetti", 526389742, 0.2);

        pedido.agregar(pizza);
        pedido.agregar(hamburguesaBig);
        pedido.agregar(cocaCola);

        assertEquals(7500, pedido.calcularPrecioTotal());
        assertEquals(6200, restauranteFake.pagarCuenta(pedido, 3, tarjetaMasterCard));
        assertEquals(true, fake.fueInvocado());
    }

    @Test
    public void pagarConComarcaPlusFake() {

        var fake = new RegistrarFake2();
        Restaurante restauranteFake = new Restaurante("fake", fake);

        var tarjetaComarcaPlus = new ComarcaPlus("Angel Olivetti", 26354789, 0.2);

        pedido.agregar(pizza);
        pedido.agregar(hamburguesaBig);
        pedido.agregar(cocaCola);

        assertEquals(7500, pedido.calcularPrecioTotal());
        assertEquals(6000, restauranteFake.pagarCuenta(pedido, 2, tarjetaComarcaPlus));
        assertEquals(true, fake.fueInvocado());
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
}
