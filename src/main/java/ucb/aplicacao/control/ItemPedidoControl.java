package ucb.aplicacao.control;

import java.util.List;
import java.util.Scanner;
import ucb.aplicacao.dao.ItemPedidoDAO;
import ucb.aplicacao.dao.PedidoDAO;
import ucb.aplicacao.dao.ProdutoDAO;
import ucb.aplicacao.model.ItemPedido;
import ucb.aplicacao.model.Pedido;
import ucb.aplicacao.model.Produto;

public class ItemPedidoControl {
    private ItemPedidoDAO dao = new ItemPedidoDAO();
    private PedidoDAO pedidoDAO = new PedidoDAO();
    private ProdutoDAO produtoDAO = new ProdutoDAO();
    private Scanner sc = new Scanner(System.in);

    public void menu() {
        int opcao;
        do {
            System.out.println("\n===== ITENS DE PEDIDO =====");
            System.out.println("1 - Adicionar item a um pedido");
            System.out.println("2 - Listar todos os itens");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");
            opcao = sc.nextInt(); sc.nextLine();

            switch (opcao) {
                case 1 -> cadastrar();
                case 2 -> listar();
                case 0 -> System.out.println("Voltando...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private void cadastrar() {
        ItemPedido item = new ItemPedido();

        // Lista os pedidos disponíveis
        System.out.println("\nPedidos disponíveis:");
        List<Pedido> pedidos = pedidoDAO.listar();
        pedidos.forEach(System.out::println);
        System.out.print("Digite o ID do pedido: ");
        item.setPedidoId(sc.nextInt());

        // Lista os produtos disponíveis
        System.out.println("\nProdutos disponíveis:");
        List<Produto> produtos = produtoDAO.listar();
        produtos.forEach(System.out::println);
        System.out.print("Digite o ID do produto: ");
        item.setProdutoId(sc.nextInt());

        // Quantidade
        System.out.print("Quantidade: ");
        item.setQtd(sc.nextInt());

        dao.inserir(item);
    }

    private void listar() {
        List<ItemPedido> itens = dao.listar();
        if (itens.isEmpty()) {
            System.out.println("Nenhum item de pedido cadastrado.");
        } else {
            System.out.println("\n--- Itens cadastrados ---");
            itens.forEach(System.out::println);
        }
    }
}
