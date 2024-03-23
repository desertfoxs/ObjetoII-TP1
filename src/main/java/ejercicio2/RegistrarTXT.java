package ejercicio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class RegistrarTXT implements Registrador2 {
    String ruta = "C:/Users/desertfoxs/Desktop/txt tp2/historialComidas.txt";

    @Override
    public void registrar(String mensaje) {

        try {
            Files.writeString(Paths.get(ruta),
                    mensaje, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        }
    }
}
