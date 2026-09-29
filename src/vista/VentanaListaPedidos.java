package vista;

import conexion.ConexionBD;
import modelo.Pedido;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class VentanaListaPedidos extends JFrame {

    private JTable tablaPedidos;
    private DefaultTableModel modeloTabla;

    public VentanaListaPedidos(List<Pedido> listaPedidos) {

        setTitle("SpeedFast - Lista de Pedidos");
        setSize(650, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        JLabel lblTitulo = new JLabel(
                "Pedidos registrados",
                SwingConstants.CENTER
        );

        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        add(lblTitulo, BorderLayout.NORTH);

        modeloTabla = new DefaultTableModel(
                new Object[]{"ID", "Cliente", "Dirección", "Estado"},
                0
        );

        tablaPedidos = new JTable(modeloTabla);

        JScrollPane scrollPane = new JScrollPane(tablaPedidos);
        add(scrollPane, BorderLayout.CENTER);

        JButton btnActualizar = new JButton("Actualizar");

        btnActualizar.addActionListener(e -> cargarPedidos());

        JPanel panelBoton = new JPanel();
        panelBoton.add(btnActualizar);

        add(panelBoton, BorderLayout.SOUTH);

        cargarPedidos();

        setVisible(true);
    }

    private void cargarPedidos() {

        modeloTabla.setRowCount(0);

        String sql = "SELECT id, cliente, direccion, estado FROM pedidos";

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement stmt = conexion.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                Object[] fila = {
                        rs.getInt("id"),
                        rs.getString("cliente"),
                        rs.getString("direccion"),
                        rs.getString("estado")
                };

                modeloTabla.addRow(fila);
            }

            System.out.println("Pedidos cargados correctamente desde MySQL.");

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Error al cargar los pedidos.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );

            e.printStackTrace();
        }
    }
}
