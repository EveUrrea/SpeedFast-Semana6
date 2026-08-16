package model;

public class Pedido {

    // Atributos encapsulados
    private int idPedido;
    private String direccionEntrega;
    private String tipoPedido;

    // Constructor completo
    public Pedido(int idPedido, String direccionEntrega, String tipoPedido) {
        this.idPedido = idPedido;
        this.direccionEntrega = direccionEntrega;
        this.tipoPedido = tipoPedido;
    }

    // Métodos getter y setter
    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    public String getTipoPedido() {
        return tipoPedido;
    }

    public void setTipoPedido(String tipoPedido) {
        this.tipoPedido = tipoPedido;
    }

    // Método genérico
    public void asignarRepartidor() {
        System.out.println("Buscando un repartidor disponible para el pedido N° "
                + idPedido + "...");
    }

    // Sobrecarga del método
    public void asignarRepartidor(String nombreRepartidor) {
        System.out.println("Pedido N° " + idPedido
                + " asignado al repartidor " + nombreRepartidor + ".");
    }
}
