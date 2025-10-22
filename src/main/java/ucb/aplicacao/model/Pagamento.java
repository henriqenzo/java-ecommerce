package ucb.aplicacao.model;

public class Pagamento {
    private int pagamentoId;
    private int pedidoId;
    private double valor;
    private String dataPagamento;
    private String status;

    public Pagamento() {}

    public Pagamento(int pagamentoId, int pedidoId, double valor, String dataPagamento, String status) {
        this.pagamentoId = pagamentoId;
        this.pedidoId = pedidoId;
        this.valor = valor;
        this.dataPagamento = dataPagamento;
        this.status = status;
    }

    public int getPagamentoId() { return pagamentoId; }
    public void setPagamentoId(int pagamentoId) { this.pagamentoId = pagamentoId; }

    public int getPedidoId() { return pedidoId; }
    public void setPedidoId(int pedidoId) { this.pedidoId = pedidoId; }

    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }

    public String getDataPagamento() { return dataPagamento; }
    public void setDataPagamento(String dataPagamento) { this.dataPagamento = dataPagamento; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "Pagamento [ID=" + pagamentoId + ", Pedido=" + pedidoId + ", Valor=" + valor + ", Data=" + dataPagamento + ", Status=" + status + "]";
    }
}
