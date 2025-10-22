package ucb.aplicacao.control;

import java.util.List;
import java.util.Scanner;
import ucb.aplicacao.dao.CategoriaDAO;
import ucb.aplicacao.model.Categoria;

public class CategoriaControl {
    private CategoriaDAO dao = new CategoriaDAO();
    private Scanner sc = new Scanner(System.in);

    public void menu() {
        int opcao;
        do {
            System.out.println("\n===== CATEGORIAS =====");
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
        Categoria c = new Categoria();
        System.out.print("Nome da categoria: ");
        c.setNome(sc.nextLine());
        dao.inserir(c);
    }

    private void listar() {
        List<Categoria> categorias = dao.listar();
        categorias.forEach(System.out::println);
    }

    private void atualizar() {
        listar();
        System.out.print("ID da categoria para atualizar: ");
        int id = sc.nextInt(); sc.nextLine();
        Categoria c = new Categoria();
        c.setId(id);
        System.out.print("Novo nome: ");
        c.setNome(sc.nextLine());
        dao.atualizar(c);
    }

    private void excluir() {
        listar();
        System.out.print("ID da categoria para excluir: ");
        int id = sc.nextInt();
        dao.deletar(id);
    }
}
