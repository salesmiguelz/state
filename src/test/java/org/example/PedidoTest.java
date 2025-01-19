package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PedidoTest {

    Pedido pedido;

    @BeforeEach
    public void setUp() {
        pedido = new Pedido();
        assertNotNull(pedido, "Pedido não deve ser nulo após a inicialização.");
    }

    // Pedido Criado
    @Test
    public void devePagarPedidoCriado() {
        pedido.setEstado(PedidoEstadoCriado.getInstance());
        assertTrue(pedido.pagar());
    }

    @Test
    public void deveCancelarPedidoCriado() {
        pedido.setEstado(PedidoEstadoCriado.getInstance());
        assertTrue(pedido.cancelar());
        assertEquals(PedidoEstadoCancelado.getInstance(), pedido.getEstado());
    }

    @Test
    public void naoDeveEnviarPedidoCriado() {
        pedido.setEstado(PedidoEstadoCriado.getInstance());
        assertFalse(pedido.enviar());
    }

    // Pedido Pago
    @Test
    public void deveEnviarPedidoPago() {
        pedido.setEstado(PedidoEstadoPago.getInstance());
        assertTrue(pedido.enviar());
        assertEquals(PedidoEstadoEnviado.getInstance(), pedido.getEstado());
    }

    @Test
    public void deveCancelarPedidoPago() {
        pedido.setEstado(PedidoEstadoPago.getInstance());
        assertTrue(pedido.cancelar());
        assertEquals(PedidoEstadoCancelado.getInstance(), pedido.getEstado());
    }

    @Test
    public void naoDevePagarPedidoPago() {
        pedido.setEstado(PedidoEstadoPago.getInstance());
        assertFalse(pedido.pagar());
    }

    // Pedido Enviado
    @Test
    public void deveEntregarPedidoEnviado() {
        pedido.setEstado(PedidoEstadoEnviado.getInstance());
        assertTrue(pedido.entregar());
        assertEquals(PedidoEstadoEntregue.getInstance(), pedido.getEstado());
    }

    @Test
    public void naoDevePagarPedidoEnviado() {
        pedido.setEstado(PedidoEstadoEnviado.getInstance());
        assertFalse(pedido.pagar());
    }

    @Test
    public void naoDeveCancelarPedidoEnviado() {
        pedido.setEstado(PedidoEstadoEnviado.getInstance());
        assertFalse(pedido.cancelar());
    }

    // Pedido Entregue
    @Test
    public void naoDevePagarPedidoEntregue() {
        pedido.setEstado(PedidoEstadoEntregue.getInstance());
        assertFalse(pedido.pagar());
    }

    @Test
    public void naoDeveCancelarPedidoEntregue() {
        pedido.setEstado(PedidoEstadoEntregue.getInstance());
        assertFalse(pedido.cancelar());
    }

    @Test
    public void naoDeveEnviarPedidoEntregue() {
        pedido.setEstado(PedidoEstadoEntregue.getInstance());
        assertFalse(pedido.enviar());
    }

    // Pedido Cancelado
    @Test
    public void naoDevePagarPedidoCancelado() {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        assertFalse(pedido.pagar());
    }

    @Test
    public void naoDeveEnviarPedidoCancelado() {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        assertFalse(pedido.enviar());
    }

    @Test
    public void naoDeveEntregarPedidoCancelado() {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        assertFalse(pedido.entregar());
    }

    // Pedido Devolvido
    @Test
    public void naoDevePagarPedidoDevolvido() {
        pedido.setEstado(PedidoEstadoDevolvido.getInstance());
        assertFalse(pedido.pagar());
    }

    @Test
    public void naoDeveCancelarPedidoDevolvido() {
        pedido.setEstado(PedidoEstadoDevolvido.getInstance());
        assertFalse(pedido.cancelar());
    }

    @Test
    public void naoDeveEnviarPedidoDevolvido() {
        pedido.setEstado(PedidoEstadoDevolvido.getInstance());
        assertFalse(pedido.enviar());
    }

    @Test
    public void naoDeveEntregarPedidoDevolvido() {
        pedido.setEstado(PedidoEstadoDevolvido.getInstance());
        assertFalse(pedido.entregar());
    }
}
