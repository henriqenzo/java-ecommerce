package ucb.aplicacao.model;

public class Produto {
    private int id;
    private String nome;
    private double preco;
    private String tamanho;
    private int qtdEstoque;
    private int categoriaId;

    public Produto() {}

    public Produto(int id, String nome, double preco, String tamanho, int qtdEstoque, int categoriaId) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.tamanho = tamanho;
        this.qtdEstoque = qtdEstoque;
        this.categoriaId = categoriaId;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }

    public String getTamanho() { return tamanho; }
    public void setTamanho(String tamanho) { this.tamanho = tamanho; }

    public int getQtdEstoque() { return qtdEstoque; }
    public void setQtdEstoque(int qtdEstoque) { this.qtdEstoque = qtdEstoque; }

    public int getCategoriaId() { return categoriaId; }
    public void setCategoriaId(int categoriaId) { this.categoriaId = categoriaId; }

    @Override
    public String toString() {
        return String.format("[%d] %s - R$%.2f (Estoque: %d)", id, nome, preco, qtdEstoque);
    }
}
