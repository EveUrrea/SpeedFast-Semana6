package vista;

import modelo.Pedido;
import modelo.PedidoComida;
import modelo.PedidoEncomienda;
import modelo.PedidoExpress;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class VentanaRegistroPedido extends JFrame {

    private JTextField txtId;
    private JTextField txtDireccion;
    private JTextField txtDistancia;
    private JComboBox<String> cmbTipo;

    private List<Pedido> listaPedidos;

    public VentanaRegistroPedido(List<Pedido> listaPedidos) {

        this.listaPedidos = listaPedidos;

        setTitle("SpeedFast - Registrar Pedido");
        setSize(450, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLayout(new BorderLayout(10, 10));

        JLabel lblTitulo = new JLabel(
                "Registro de Pedido",
                SwingConstants.CENTER
        );

        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitulo.setBorder(
                BorderFactory.createEmptyBorder(15, 10, 10, 10)
        );

        add(lblTitulo, BorderLayout.NORTH);

        // Panel del formulario
        JPanel panelFormulario = new JPanel(
                new GridLayout(4, 2, 10, 10)
        );

        panelFormulario.setBorder(
                BorderFactory.createEmptyBorder(20, 40, 20, 40)
        );

        txtId = new JTextField();
        txtDireccion = new JTextField();
        txtDistancia = new JTextField();

        cmbTipo = new JComboBox<>(
                new String[]{"Comida", "Encomienda", "Express"}
        );

        panelFormulario.add(new JLabel("ID del pedido:"));
        panelFormulario.add(txtId);

        panelFormulario.add(new JLabel("Dirección:"));
        panelFormulario.add(txtDireccion);

        panelFormulario.add(new JLabel("Distancia (km):"));
        panelFormulario.add(txtDistancia);

        panelFormulario.add(new JLabel("Tipo de pedido:"));
        panelFormulario.add(cmbTipo);

        add(panelFormulario, BorderLayout.CENTER);

        // Botón Guardar
        JButton btnGuardar = new JButton("Guardar pedido");

        JPanel panelBoton = new JPanel();
        panelBoton.add(btnGuardar);

        add(panelBoton, BorderLayout.SOUTH);

        btnGuardar.addActionListener(e -> guardarPedido());

        setVisible(true);
    }

    private void guardarPedido() {

        String idTexto = txtId.getText().trim();
        String direccion = txtDireccion.getText().trim();
        String distanciaTexto = txtDistancia.getText().trim();

        // Validar campos vacíos
        if (idTexto.isEmpty()
                || direccion.isEmpty()
                || distanciaTexto.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Debe completar todos los campos.",
                    "Campos incompletos",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        try {

            int id = Integer.parseInt(idTexto);
            double distancia = Double.parseDouble(distanciaTexto);

            if (id <= 0 || distancia <= 0) {
                JOptionPane.showMessageDialog(
                        this,
                        "El ID y la distancia deben ser mayores a 0.",
                        "Datos inválidos",
                        JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            // Evitar IDs repetidos
            for (Pedido pedido : listaPedidos) {
                if (pedido.getIdPedido() == id) {

                    JOptionPane.showMessageDialog(
                            this,
                            "Ya existe un pedido con ese ID.",
                            "ID duplicado",
                            JOptionPane.WARNING_MESSAGE
                    );

                    return;
                }
            }

            String tipo = (String) cmbTipo.getSelectedItem();

            Pedido nuevoPedido;

            switch (tipo) {

                case "Comida":
                    nuevoPedido =
                            new PedidoComida(id, direccion, distancia);
                    break;

                case "Encomienda":
                    nuevoPedido =
                            new PedidoEncomienda(id, direccion, distancia);
                    break;

                default:
                    nuevoPedido =
                            new PedidoExpress(id, direccion, distancia);
                    break;
            }

            listaPedidos.add(nuevoPedido);

            JOptionPane.showMessageDialog(
                    this,
                    "Pedido registrado correctamente.",
                    "Registro exitoso",
                    JOptionPane.INFORMATION_MESSAGE
            );

            // Limpiar formulario
            txtId.setText("");
            txtDireccion.setText("");
            txtDistancia.setText("");
            cmbTipo.setSelectedIndex(0);

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "El ID debe ser un número entero y la distancia un número válido.",
                    "Datos inválidos",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
}
