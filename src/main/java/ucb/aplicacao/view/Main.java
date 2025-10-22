package ucb.aplicacao.view;

import java.util.Scanner;
import ucb.aplicacao.control.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProdutoControl produtoControl = new ProdutoControl();
        CategoriaControl categoriaControl = new CategoriaControl();
        ClienteControl clienteControl = new ClienteControl();
        PedidoControl pedidoControl = new PedidoControl();
        ItemPedidoControl itemControl = new ItemPedidoControl();
        PagamentoControl pagamentoControl = new PagamentoControl();

        int opcao;
        do {
            System.out.println("\n===== MENU PRINCIPAL =====");
            System.out.println("1 - Produtos");
            System.out.println("2 - Categorias");
            System.out.println("3 - Clientes");
            System.out.println("4 - Pedidos");
            System.out.println("5 - Itens de Pedido");
            System.out.println("6 - Pagamentos");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1 -> produtoControl.menu();
                case 2 -> categoriaControl.menu();
                case 3 -> clienteControl.menu();
                case 4 -> pedidoControl.menu();
                case 5 -> itemControl.menu();
                case 6 -> pagamentoControl.menu();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        sc.close();
    }
}
