package ejercicio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class RegistrarTXT implements RegistradorPagos {
    private String ruta;

    public RegistrarTXT(String ruta) {
        this.ruta = ruta;
    }

    @Override
    public void registrar(String mensaje) {
        try {
            Files.writeString(Paths.get(ruta),
                    mensaje, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
