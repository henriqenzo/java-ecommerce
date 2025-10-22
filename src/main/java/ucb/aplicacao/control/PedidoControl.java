package ucb.aplicacao.control;

import java.util.List;
import java.util.Scanner;
import ucb.aplicacao.dao.PedidoDAO;
import ucb.aplicacao.model.Pedido;

public class PedidoControl {
    private PedidoDAO dao = new PedidoDAO();
    private Scanner sc = new Scanner(System.in);

    public void menu() {
        int opcao;
        do {
            System.out.println("\n===== PEDIDOS =====");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Atualizar");
            System.out.println("4 - Excluir");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");
            opcao = sc.nextInt(); sc.nextLine();

            switch (opcao) {
                case 1 -> cadastrar();
                case 2 -> listar();
                case 3 -> atualizar();
                case 4 -> excluir();
                case 0 -> System.out.println("Voltando...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private void cadastrar() {
        Pedido p = new Pedido();
        System.out.print("ID do cliente: ");
        p.setClienteId(sc.nextInt());
        System.out.print("Valor total: ");
        p.setValorTotal(sc.nextDouble());
        sc.nextLine();

        dao.inserir(p);
    }

    private void listar() {
        List<Pedido> pedidos = dao.listar();
        pedidos.forEach(System.out::println);
    }

    private void atualizar() {
        listar();
        Pedido p = new Pedido();
        System.out.print("ID do pedido para atualizar: ");
        p.setPedidoId(sc.nextInt());
        System.out.print("Novo ID de cliente: ");
        p.setClienteId(sc.nextInt());
        System.out.print("Novo valor total: ");
        p.setValorTotal(sc.nextDouble());
        sc.nextLine();
        System.out.print("Nova data (YYYY-MM-DD): ");
        p.setDataPedido(sc.nextLine());
        dao.atualizar(p);
    }

    private void excluir() {
        listar();
        System.out.print("ID do pedido para excluir: ");
        int id = sc.nextInt();
        dao.excluir(id);
    }
}
