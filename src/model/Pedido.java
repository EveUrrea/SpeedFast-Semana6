package model;

public abstract class Pedido {

    private String idPedido;
    private String direccionEntrega;
    private double distanciaKm;

    // Constructor
    public Pedido(String idPedido, String direccionEntrega, double distanciaKm) {
        this.idPedido = idPedido;
        this.direccionEntrega = direccionEntrega;
        this.distanciaKm = distanciaKm;
    }

    // Getters
    public String getIdPedido() {
        return idPedido;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public double getDistanciaKm() {
        return distanciaKm;
    }

    // Setters
    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    public void setDistanciaKm(double distanciaKm) {
        this.distanciaKm = distanciaKm;
    }

    // Método común para todos los pedidos
    public void mostrarResumen() {
        System.out.println(getClass().getSimpleName() + " #" + idPedido);
        System.out.println("Dirección: " + direccionEntrega);
        System.out.println("Distancia: " + distanciaKm + " km");
    }

    // Método abstracto que cada subclase debe implementar
    public abstract int calcularTiempoEntrega();
}
