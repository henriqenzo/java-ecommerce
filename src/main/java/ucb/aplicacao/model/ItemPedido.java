package ucb.aplicacao.model;

public class ItemPedido {
    private int pedidoId;
    private int produtoId;
    private int qtd;

    public ItemPedido() {}

    public ItemPedido(int pedidoId, int produtoId, int qtd) {
        this.pedidoId = pedidoId;
        this.produtoId = produtoId;
        this.qtd = qtd;
    }

    public int getPedidoId() { return pedidoId; }
    public void setPedidoId(int pedidoId) { this.pedidoId = pedidoId; }

    public int getProdutoId() { return produtoId; }
    public void setProdutoId(int produtoId) { this.produtoId = produtoId; }

    public int getQtd() { return qtd; }
    public void setQtd(int qtd) { this.qtd = qtd; }

    @Override
    public String toString() {
        return String.format("Pedido #%d | Produto #%d | Qtd: %d", pedidoId, produtoId, qtd);
    }
}
