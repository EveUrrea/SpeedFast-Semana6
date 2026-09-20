package modelo;

public class PedidoComida extends Pedido
        implements Despachable, Cancelable, Rastreable {

    public PedidoComida(int id, String direccion, double distancia) {
        super(id, direccion, distancia);
    }

    @Override
    public void asignarRepartidor() {
        repartidor = "Luis Díaz";
        System.out.println("Repartidor automático para comida: " + repartidor);
    }

    @Override
    public int calcularTiempoEntrega() {
        return 20 + (int) (distancia * 2);
    }

    @Override
    public void despachar() {
        estado = "Despachado";
        System.out.println("Pedido de comida #" + id + " despachado correctamente.");
    }

    @Override
    public void cancelar() {
        estado = "Cancelado";
        System.out.println("Pedido de comida #" + id + " cancelado exitosamente.");
    }

    @Override
    public void verHistorial() {
        System.out.println(
                "PedidoComida #" + id +
                        " | Repartidor: " + repartidor +
                        " | Estado: " + estado
        );
    }
}