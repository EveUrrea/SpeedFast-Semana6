package modelo;

public abstract class Pedido {

    protected int id;
    protected String direccion;
    protected double distancia;
    protected String repartidor;
    protected String estado;

    public Pedido(int id, String direccion, double distancia) {
        this.id = id;
        this.direccion = direccion;
        this.distancia = distancia;
        this.repartidor = "Sin asignar";
        this.estado = "Pendiente";
    }

    public void mostrarResumen() {
        System.out.println("Pedido #" + id);
        System.out.println("Dirección: " + direccion);
        System.out.println("Distancia: " + distancia + " km");
        System.out.println("Repartidor asignado: " + repartidor);
        System.out.println("Estado: " + estado);
    }

    public abstract void asignarRepartidor();

    // Sobrecarga
    public void asignarRepartidor(String nombre) {
        repartidor = nombre;
        System.out.println("Repartidor asignado manualmente: " + nombre);
    }

    public abstract int calcularTiempoEntrega();

    public int getId() {
        return id;
    }

    public String getRepartidor() {
        return repartidor;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
