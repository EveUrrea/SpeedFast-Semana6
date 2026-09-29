package vista;

import dao.PedidoDAO;
import modelo.Pedido;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class VentanaRegistroPedido extends JFrame {

    private JTextField txtCliente;
    private JTextField txtDireccion;
    private JComboBox<String> cmbEstado;

    private List<Pedido> listaPedidos;

    public VentanaRegistroPedido(List<Pedido> listaPedidos) {

        this.listaPedidos = listaPedidos;

        setTitle("SpeedFast - Registrar Pedido");
        setSize(450, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLayout(new BorderLayout(10, 10));

        JLabel lblTitulo = new JLabel(
                "Registrar nuevo pedido",
                SwingConstants.CENTER
        );

        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));

        add(lblTitulo, BorderLayout.NORTH);

        JPanel panelFormulario = new JPanel(new GridLayout(3, 2, 10, 10));

        panelFormulario.setBorder(
                BorderFactory.createEmptyBorder(30, 30, 30, 30)
        );

        panelFormulario.add(new JLabel("Cliente:"));

        txtCliente = new JTextField();
        panelFormulario.add(txtCliente);

        panelFormulario.add(new JLabel("Dirección:"));

        txtDireccion = new JTextField();
        panelFormulario.add(txtDireccion);

        panelFormulario.add(new JLabel("Estado:"));

        cmbEstado = new JComboBox<>(new String[]{
                "Pendiente",
                "En preparación",
                "En reparto",
                "Entregado"
        });

        panelFormulario.add(cmbEstado);

        add(panelFormulario, BorderLayout.CENTER);

        JButton btnGuardar = new JButton("Guardar pedido");

        btnGuardar.addActionListener(e -> guardarPedido());

        JPanel panelBoton = new JPanel();

        panelBoton.add(btnGuardar);

        add(panelBoton, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void guardarPedido() {

        String cliente = txtCliente.getText().trim();
        String direccion = txtDireccion.getText().trim();
        String estado = cmbEstado.getSelectedItem().toString();

        if (cliente.isEmpty() || direccion.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Debe completar todos los campos.",
                    "Advertencia",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        PedidoDAO pedidoDAO = new PedidoDAO();

        boolean guardado = pedidoDAO.guardarPedido(
                cliente,
                direccion,
                estado
        );

        if (guardado) {

            JOptionPane.showMessageDialog(
                    this,
                    "Pedido registrado correctamente en la base de datos."
            );

            txtCliente.setText("");
            txtDireccion.setText("");
            cmbEstado.setSelectedIndex(0);

        } else {

            JOptionPane.showMessageDialog(
                    this,
                    "No fue posible registrar el pedido.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
}