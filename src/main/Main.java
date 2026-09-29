package main;

import conexion.ConexionBD;
import vista.VentanaPrincipal;

import javax.swing.SwingUtilities;
import java.sql.Connection;

public class Main {

    public static void main(String[] args) {

        Connection conexion = ConexionBD.conectar();

        if (conexion != null) {
            System.out.println("Base de datos conectada correctamente.");
        }

        SwingUtilities.invokeLater(() -> {
            new VentanaPrincipal();
        });
    }
}
