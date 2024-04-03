package ejercicio1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class RegistrarDisco implements RegistradorConcurso {

    private String ruta;

    public RegistrarDisco(String url) {
        ruta = url;
    }

    @Override
    public void registrar(String mensaje) {
        try {
            if (Files.notExists(Path.of(ruta))) {
                Files.writeString(Paths.get(ruta), mensaje, StandardOpenOption.CREATE);
            } else {
                Files.writeString(Paths.get(ruta), mensaje, StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
