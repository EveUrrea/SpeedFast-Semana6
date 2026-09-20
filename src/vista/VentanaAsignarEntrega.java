package vista;

import modelo.Pedido;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class VentanaAsignarEntrega extends JFrame {

    private final List<Pedido> listaPedidos;
    private JComboBox<String> cmbPedidos;
    private JTextField txtRepartidor;

    public VentanaAsignarEntrega(List<Pedido> listaPedidos) {

        this.listaPedidos = listaPedidos;

        setTitle("SpeedFast - Asignar Repartidor");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Título
        JLabel lblTitulo = new JLabel(
                "Asignar Repartidor / Iniciar Entrega",
                SwingConstants.CENTER
        );

        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitulo.setBorder(
                BorderFactory.createEmptyBorder(15, 10, 10, 10)
        );

        add(lblTitulo, BorderLayout.NORTH);

        // Formulario
        JPanel panelFormulario = new JPanel(
                new GridLayout(2, 2, 10, 10)
        );

        panelFormulario.setBorder(
                BorderFactory.createEmptyBorder(30, 40, 30, 40)
        );

        cmbPedidos = new JComboBox<>();
        txtRepartidor = new JTextField();

        panelFormulario.add(new JLabel("Pedido:"));
        panelFormulario.add(cmbPedidos);

        panelFormulario.add(new JLabel("Nombre repartidor:"));
        panelFormulario.add(txtRepartidor);

        add(panelFormulario, BorderLayout.CENTER);

        // Botón
        JButton btnIniciar = new JButton(
                "Asignar e iniciar entrega"
        );

        JPanel panelBoton = new JPanel();
        panelBoton.add(btnIniciar);

        add(panelBoton, BorderLayout.SOUTH);

        // Cargar pedidos
        cargarPedidos();

        // Acción del botón
        btnIniciar.addActionListener(e -> asignarEntrega());

        setVisible(true);
    }

    private void cargarPedidos() {

        cmbPedidos.removeAllItems();

        for (Pedido pedido : listaPedidos) {

            cmbPedidos.addItem(
                    "Pedido #" + pedido.getIdPedido()
                            + " - " + pedido.getDireccionEntrega()
            );
        }
    }

    private void asignarEntrega() {

        int indice = cmbPedidos.getSelectedIndex();
        String nombreRepartidor = txtRepartidor.getText().trim();

        // Validar que existan pedidos
        if (indice == -1) {

            JOptionPane.showMessageDialog(
                    this,
                    "No existen pedidos disponibles.",
                    "Sin pedidos",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        // Validar nombre
        if (nombreRepartidor.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Debe ingresar el nombre del repartidor.",
                    "Campo incompleto",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        Pedido pedidoSeleccionado = listaPedidos.get(indice);

        // Asignar repartidor
        pedidoSeleccionado.asignarRepartidor(nombreRepartidor);

        // Cambiar estado para simular el inicio
        pedidoSeleccionado.setEstado("En entrega");

        JOptionPane.showMessageDialog(
                this,
                "Repartidor asignado correctamente.\n"
                        + "La entrega del pedido #"
                        + pedidoSeleccionado.getIdPedido()
                        + " ha sido iniciada.",
                "Entrega iniciada",
                JOptionPane.INFORMATION_MESSAGE
        );

        txtRepartidor.setText("");
    }
}
