package modelo;

public class PedidoEncomienda extends Pedido
        implements Despachable, Cancelable, Rastreable {

    public PedidoEncomienda(int id, String direccion, double distancia) {
        super(id, direccion, distancia);
    }

    @Override
    public void asignarRepartidor() {
        repartidor = "Daniela Tapia";
        System.out.println("Repartidor automático para encomienda: " + repartidor);
    }

    @Override
    public int calcularTiempoEntrega() {
        return 15 + (int) (distancia * 3);
    }

    @Override
    public void despachar() {
        estado = "Despachado";
        System.out.println("Pedido de encomienda #" + id + " despachado correctamente.");
    }

    @Override
    public void cancelar() {
        estado = "Cancelado";
        System.out.println("Pedido de encomienda #" + id + " cancelado exitosamente.");
    }

    @Override
    public void verHistorial() {
        System.out.println(
                "PedidoEncomienda #" + id +
                        " | Repartidor: " + repartidor +
                        " | Estado: " + estado
        );
    }
}