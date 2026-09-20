package modelo;

public class PedidoComida extends Pedido
        implements Despachable, Cancelable, Rastreable {

    public PedidoComida(int idPedido, String direccionEntrega, double distanciaKm) {
        super(idPedido, direccionEntrega, distanciaKm);
    }

    @Override
    public int calcularTiempoEntrega() {
        return 20 + (int) (distanciaKm * 2);
    }

    @Override
    public void despachar() {
        estado = "Despachado";
        System.out.println("Pedido de comida #" + idPedido + " despachado correctamente.");
    }

    @Override
    public void cancelar() {
        estado = "Cancelado";
        System.out.println("Pedido de comida #" + idPedido + " cancelado exitosamente.");
    }

    @Override
    public void verHistorial() {
        System.out.println(
                "PedidoComida #" + idPedido +
                        " | Repartidor: " + repartidor +
                        " | Estado: " + estado
        );
    }
}