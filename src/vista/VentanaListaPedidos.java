package vista;

import modelo.Pedido;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class VentanaListaPedidos extends JFrame {

    private final List<Pedido> listaPedidos;
    private final DefaultTableModel modeloTabla;
    private final JTable tablaPedidos;

    public VentanaListaPedidos(List<Pedido> listaPedidos) {

        this.listaPedidos = listaPedidos;

        setTitle("SpeedFast - Lista de Pedidos");
        setSize(750, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Título
        JLabel lblTitulo = new JLabel(
                "Listado de Pedidos",
                SwingConstants.CENTER
        );

        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitulo.setBorder(
                BorderFactory.createEmptyBorder(15, 10, 10, 10)
        );

        add(lblTitulo, BorderLayout.NORTH);

        // Columnas de la tabla
        String[] columnas = {
                "ID",
                "Dirección",
                "Distancia (km)",
                "Tipo",
                "Repartidor",
                "Estado"
        };

        // Modelo de la tabla
        modeloTabla = new DefaultTableModel(columnas, 0) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tablaPedidos = new JTable(modeloTabla);
        tablaPedidos.setRowHeight(25);

        JScrollPane scrollPane = new JScrollPane(tablaPedidos);

        add(scrollPane, BorderLayout.CENTER);

        // Botón actualizar
        JButton btnActualizar = new JButton("Actualizar lista");

        JPanel panelBoton = new JPanel();
        panelBoton.add(btnActualizar);

        add(panelBoton, BorderLayout.SOUTH);

        btnActualizar.addActionListener(e -> cargarPedidos());

        // Cargar los pedidos al abrir la ventana
        cargarPedidos();

        setVisible(true);
    }

    private void cargarPedidos() {

        // Limpiar tabla
        modeloTabla.setRowCount(0);

        // Agregar pedidos actuales
        for (Pedido pedido : listaPedidos) {

            String tipo = pedido.getClass().getSimpleName();

            if (tipo.equals("PedidoComida")) {
                tipo = "Comida";
            } else if (tipo.equals("PedidoEncomienda")) {
                tipo = "Encomienda";
            } else if (tipo.equals("PedidoExpress")) {
                tipo = "Express";
            }

            Object[] fila = {
                    pedido.getIdPedido(),
                    pedido.getDireccionEntrega(),
                    pedido.getDistanciaKm(),
                    tipo,
                    pedido.getRepartidor(),
                    pedido.getEstado()
            };

            modeloTabla.addRow(fila);
        }
    }
}
