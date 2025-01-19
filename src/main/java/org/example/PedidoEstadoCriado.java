package org.example;

public class PedidoEstadoCriado extends PedidoEstado {

    private PedidoEstadoCriado() {}

    private static PedidoEstadoCriado instance = new PedidoEstadoCriado();

    public static PedidoEstadoCriado getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Criado";
    }

    public boolean pagar(Pedido pedido) {
        pedido.setEstado(PedidoEstadoPago.getInstance());
        return true;
    }

    public boolean cancelar(Pedido pedido) {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        return true;
    }
}