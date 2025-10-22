package ucb.aplicacao.control;

import java.util.List;
import java.util.Scanner;
import ucb.aplicacao.dao.ProdutoDAO;
import ucb.aplicacao.dao.CategoriaDAO;
import ucb.aplicacao.model.Produto;
import ucb.aplicacao.model.Categoria;

public class ProdutoControl {
    private ProdutoDAO dao = new ProdutoDAO();
    private CategoriaDAO catDao = new CategoriaDAO();
    private Scanner sc = new Scanner(System.in);

    public void menu() {
        int opcao;
        do {
            System.out.println("\n===== PRODUTOS =====");
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
        Produto p = new Produto();
        System.out.print("Nome: "); p.setNome(sc.nextLine());
        System.out.print("Preço: "); p.setPreco(sc.nextDouble()); sc.nextLine();
        System.out.print("Tamanho: "); p.setTamanho(sc.nextLine());
        System.out.print("Qtd em estoque: "); p.setQtdEstoque(sc.nextInt()); sc.nextLine();

        System.out.println("Escolha a categoria:");
        List<Categoria> categorias = catDao.listar();
        categorias.forEach(System.out::println);
        System.out.print("ID da categoria: ");
        p.setCategoriaId(sc.nextInt()); sc.nextLine();

        dao.inserir(p);
    }

    private void listar() {
        List<Produto> produtos = dao.listar();
        produtos.forEach(System.out::println);
    }

    private void atualizar() {
        listar();
        System.out.print("ID do produto: ");
        int id = sc.nextInt(); sc.nextLine();
        Produto p = new Produto();
        p.setId(id);
        System.out.print("Novo nome: "); p.setNome(sc.nextLine());
        System.out.print("Novo preço: "); p.setPreco(sc.nextDouble()); sc.nextLine();
        System.out.print("Novo tamanho: "); p.setTamanho(sc.nextLine());
        System.out.print("Nova quantidade: "); p.setQtdEstoque(sc.nextInt()); sc.nextLine();
        System.out.print("ID nova categoria: "); p.setCategoriaId(sc.nextInt());
        dao.atualizar(p);
    }

    private void excluir() {
        listar();
        System.out.print("ID do produto: ");
        int id = sc.nextInt();
        dao.deletar(id);
    }
}
