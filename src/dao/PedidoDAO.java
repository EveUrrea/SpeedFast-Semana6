package dao;

import conexion.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PedidoDAO {

    public boolean guardarPedido(String cliente, String direccion, String estado) {

        String sql = "INSERT INTO pedidos (cliente, direccion, estado) VALUES (?, ?, ?)";

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement stmt = conexion.prepareStatement(sql)) {

            stmt.setString(1, cliente);
            stmt.setString(2, direccion);
            stmt.setString(3, estado);

            stmt.executeUpdate();

            System.out.println("Pedido guardado correctamente en MySQL.");
            return true;

        } catch (SQLException e) {
            System.out.println("Error al guardar el pedido.");
            e.printStackTrace();
            return false;
        }
    }
}