package model;

public class PedidoExpress extends Pedido
        implements Despachable, Cancelable, Rastreable {

    public PedidoExpress(int idPedido, String direccionEntrega, double distanciaKm) {
        super(idPedido, direccionEntrega, distanciaKm);
    }

    @Override
    public int calcularTiempoEntrega() {
        return 10 + (int) distanciaKm;
    }

    @Override
    public void despachar() {
        estado = "Despachado";
        System.out.println("Pedido express #" + idPedido + " despachado correctamente.");
    }

    @Override
    public void cancelar() {
        estado = "Cancelado";
        System.out.println("Pedido express #" + idPedido + " cancelado exitosamente.");
    }

    @Override
    public void verHistorial() {
        System.out.println(
                "PedidoExpress #" + idPedido +
                        " | Repartidor: " + repartidor +
                        " | Estado: " + estado
        );
    }
}
