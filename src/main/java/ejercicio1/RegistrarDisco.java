package ejercicio1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class RegistrarDisco implements Registrador {

    String ruta = "C:/Users/desertfoxs/Desktop/txt tp2/historial.txt";

    @Override
    public void registrar(String mensaje) {

        try {
            Files.writeString(Paths.get("C:/Users/desertfoxs/Desktop/txt tp2/historial.txt"),
                    mensaje, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        }
    }
}
