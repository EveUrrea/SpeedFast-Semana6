package modelo;

public class PedidoEncomienda extends Pedido
        implements Despachable, Cancelable, Rastreable {

    public PedidoEncomienda(int idPedido, String direccionEntrega, double distanciaKm) {
        super(idPedido, direccionEntrega, distanciaKm);
    }

    @Override
    public int calcularTiempoEntrega() {
        return 15 + (int) (distanciaKm * 3);
    }

    @Override
    public void despachar() {
        estado = "Despachado";
        System.out.println("Pedido de encomienda #" + idPedido + " despachado correctamente.");
    }

    @Override
    public void cancelar() {
        estado = "Cancelado";
        System.out.println("Pedido de encomienda #" + idPedido + " cancelado exitosamente.");
    }

    @Override
    public void verHistorial() {
        System.out.println(
                "PedidoEncomienda #" + idPedido +
                        " | Repartidor: " + repartidor +
                        " | Estado: " + estado
        );
    }
}