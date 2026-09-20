package vista;

import modelo.Pedido;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class VentanaPrincipal extends JFrame {

    // Lista común donde se almacenan los pedidos en memoria
    private final List<Pedido> listaPedidos;

    public VentanaPrincipal() {

        listaPedidos = new ArrayList<>();

        // Configuración de la ventana
        setTitle("SpeedFast - Gestión de Entregas");
        setSize(500, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Título
        JLabel lblTitulo = new JLabel(
                "Sistema de Gestión de Entregas - SpeedFast",
                SwingConstants.CENTER
        );

        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        add(lblTitulo, BorderLayout.NORTH);

        // Panel de botones
        JPanel panelBotones = new JPanel(
                new GridLayout(3, 1, 10, 10)
        );

        JButton btnRegistrar = new JButton("Registrar pedido");
        JButton btnListar = new JButton("Listar pedidos");
        JButton btnEntrega =
                new JButton("Asignar repartidor / Iniciar entrega");

        panelBotones.add(btnRegistrar);
        panelBotones.add(btnListar);
        panelBotones.add(btnEntrega);

        panelBotones.setBorder(
                BorderFactory.createEmptyBorder(40, 60, 40, 60)
        );

        add(panelBotones, BorderLayout.CENTER);

        // Abrir ventana para registrar pedidos
        btnRegistrar.addActionListener(e ->
                new VentanaRegistroPedido(listaPedidos)
        );

        // Abrir ventana para listar pedidos
        btnListar.addActionListener(e ->
                new VentanaListaPedidos(listaPedidos)
        );

        // Abrir ventana para asignar repartidor e iniciar entrega
        btnEntrega.addActionListener(e ->
                new VentanaAsignarEntrega(listaPedidos)
        );

        setVisible(true);
    }
}
