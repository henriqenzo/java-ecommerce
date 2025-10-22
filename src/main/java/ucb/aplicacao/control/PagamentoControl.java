package ucb.aplicacao.control;

import java.util.List;
import java.util.Scanner;
import ucb.aplicacao.dao.PagamentoDAO;
import ucb.aplicacao.model.Pagamento;

public class PagamentoControl {
    private PagamentoDAO dao = new PagamentoDAO();
    private Scanner sc = new Scanner(System.in);

    public void menu() {
        int opcao;
        do {
            System.out.println("\n===== PAGAMENTOS =====");
            System.out.println("1 - Registrar pagamento");
            System.out.println("2 - Listar pagamentos");
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
        Pagamento p = new Pagamento();
        System.out.print("ID do pedido: ");
        p.setPedidoId(sc.nextInt());
        System.out.print("Valor: ");
        p.setValor(sc.nextDouble());
        sc.nextLine();
        System.out.print("Status: ");
        p.setStatus(sc.nextLine());
        dao.inserir(p);
    }

    private void listar() {
        List<Pagamento> lista = dao.listar();
        lista.forEach(System.out::println);
    }
}
