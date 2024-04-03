package ejercicio2;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistrarBaseDatoPago implements RegistradorPagos {

    private final static String sqlCreate = "INSERT INTO `registropagorestaurante` (`Fecha`, `Pago`)" + "VALUES (?, ?);";


    @Override
    public void registrar(String mensaje) {
        String[] parts = mensaje.split("---");
        String fecha = parts[0];
        String pago = parts[1];

        try (java.sql.Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/ejercicio3_oobj", "root", "");
             PreparedStatement sent = conexion.prepareStatement(sqlCreate);) {
            sent.setString(1, fecha);
            sent.setString(2, pago);


            int update = sent.executeUpdate();
            if (update == 1) {
                //imprime un mensaje diciendo que fue exitoso
                //System.out.println("operacion exitosa");
            }

            sent.close();
        } catch (SQLException icve) {    //Exeption por si intenta cargar en la BD un dispositivo con el mismo nombre.
            // System.out.println("Se violo la integridad de la BD");
            throw new RuntimeException(icve);
        }
    }
}
