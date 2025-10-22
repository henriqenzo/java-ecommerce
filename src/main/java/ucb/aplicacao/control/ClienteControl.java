package ucb.aplicacao.control;

import java.util.List;
import java.util.Scanner;
import ucb.aplicacao.dao.ClienteDAO;
import ucb.aplicacao.model.Cliente;

public class ClienteControl {
    private ClienteDAO dao = new ClienteDAO();
    private Scanner sc = new Scanner(System.in);

    public void menu() {
        int opcao;
        do {
            System.out.println("\n===== CLIENTES =====");
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
        Cliente c = new Cliente();
        System.out.print("Nome: "); c.setNome(sc.nextLine());
        System.out.print("Email: "); c.setEmail(sc.nextLine());
        System.out.print("Senha: "); c.setSenha(sc.nextLine());
        System.out.print("Cidade: "); c.setCidade(sc.nextLine());
        System.out.print("Endereço: "); c.setEndereco(sc.nextLine());
        System.out.print("Número: "); c.setNumero(sc.nextLine());
        System.out.print("CEP: "); c.setCep(sc.nextLine());
        dao.inserir(c);
    }

    private void listar() {
        List<Cliente> clientes = dao.listar();
        clientes.forEach(System.out::println);
    }

    private void atualizar() {
        listar();
        System.out.print("ID do cliente a atualizar: ");
        int id = sc.nextInt(); sc.nextLine();
        Cliente c = new Cliente();
        c.setId(id);
        System.out.print("Novo nome: "); c.setNome(sc.nextLine());
        System.out.print("Novo email: "); c.setEmail(sc.nextLine());
        System.out.print("Nova senha: "); c.setSenha(sc.nextLine());
        System.out.print("Nova cidade: "); c.setCidade(sc.nextLine());
        System.out.print("Novo endereço: "); c.setEndereco(sc.nextLine());
        System.out.print("Novo número: "); c.setNumero(sc.nextLine());
        System.out.print("Novo CEP: "); c.setCep(sc.nextLine());
        dao.atualizar(c);
    }

    private void excluir() {
        listar();
        System.out.print("ID do cliente a excluir: ");
        int id = sc.nextInt();
        dao.deletar(id);
    }
}
