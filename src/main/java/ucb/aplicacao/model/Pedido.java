package ucb.aplicacao.model;

public class Pedido {
    private int pedidoId;
    private int clienteId;
    private double valorTotal;
    private String dataPedido;

    public Pedido() {}

    public Pedido(int pedidoId, int clienteId, double valorTotal, String dataPedido) {
        this.pedidoId = pedidoId;
        this.clienteId = clienteId;
        this.valorTotal = valorTotal;
        this.dataPedido = dataPedido;
    }

    public int getPedidoId() { return pedidoId; }
    public void setPedidoId(int pedidoId) { this.pedidoId = pedidoId; }

    public int getClienteId() { return clienteId; }
    public void setClienteId(int clienteId) { this.clienteId = clienteId; }

    public double getValorTotal() { return valorTotal; }
    public void setValorTotal(double valorTotal) { this.valorTotal = valorTotal; }

    public String getDataPedido() { return dataPedido; }
    public void setDataPedido(String dataPedido) { this.dataPedido = dataPedido; }

    @Override
    public String toString() {
        return "Pedido [ID=" + pedidoId + ", Cliente=" + clienteId + ", Valor=" + valorTotal + ", Data=" + dataPedido + "]";
    }
}
