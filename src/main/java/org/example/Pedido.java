package org.example;

public class Pedido {

    private PedidoEstado estado;

    public Pedido() {
        this.estado = PedidoEstadoCriado.getInstance();
    }

    public void setEstado(PedidoEstado estado) {
        this.estado = estado;
    }

    public boolean pagar() { return estado.pagar(this); }
    public boolean enviar() { return estado.enviar(this); }
    public boolean entregar() { return estado.entregar(this); }
    public boolean cancelar() { return estado.cancelar(this); }
    public boolean devolver() { return estado.devolver(this); }

    public PedidoEstado getEstado() { return estado; }
}