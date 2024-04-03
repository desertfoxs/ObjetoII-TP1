package Main;

import ejercicio1.Concurso;
import ejercicio1.EnviarGmail;
import ejercicio1.Participante;
import ejercicio1.RegistrarBaseDatoConcurso;
import ejercicio2.*;

import java.time.LocalDateTime;

public class Main {

    Pedido pedido = new Pedido();
    Comida pizza = new Comida("pizza 4queso", 2500);
    Comida hamburguesaBig = new Comida("hamburguesa Big", 4000);
    Bebida cocaCola = new Bebida("coca cola", 1000);


    public void Main() {

        var tarjetaVisa = new Visa("Angel Olivetti", 45823645, 0.3);
        Restaurante restauranteBD = new Restaurante("roma", new RegistrarBaseDatoPago());

        pedido.agregar(pizza);
        pedido.agregar(hamburguesaBig);
        pedido.agregar(cocaCola);

        restauranteBD.pagarCuenta(pedido, 2, tarjetaVisa);

        //----------------------------------------------------------------------

        Participante participante1 = new Participante("Angel", 42498132);
        Concurso concurso1 = new Concurso(1, "Bingo",
                LocalDateTime.now().plusMonths(1), LocalDateTime.now().minusDays(2), new RegistrarBaseDatoConcurso(), new EnviarGmail());

        concurso1.inscribir(participante1);

    }

}
