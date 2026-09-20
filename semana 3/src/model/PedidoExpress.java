package modelo;

public class PedidoExpress extends Pedido
        implements Despachable, Cancelable, Rastreable {

    public PedidoExpress(int id, String direccion, double distancia) {
        super(id, direccion, distancia);
    }

    @Override
    public void asignarRepartidor() {
        repartidor = "Carlos Soto";
        System.out.println("Repartidor automático para pedido express: " + repartidor);
    }

    @Override
    public int calcularTiempoEntrega() {
        return 10 + (int) distancia;
    }

    @Override
    public void despachar() {
        estado = "Despachado";
        System.out.println("Pedido express #" + id + " despachado correctamente.");
    }

    @Override
    public void cancelar() {
        estado = "Cancelado";
        System.out.println("Pedido express #" + id + " cancelado exitosamente.");
    }

    @Override
    public void verHistorial() {
        System.out.println(
                "PedidoExpress #" + id +
                        " | Repartidor: " + repartidor +
                        " | Estado: " + estado
        );
    }
}
