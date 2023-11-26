package main;

import controller.PacoteViagemController;
import controller.usuarios.AdminController;
import controller.usuarios.UsuarioController;
import model.conexao.ConexaoModel;
import model.conexao.PacoteViagemConnectionModel;
import model.conexao.UserConnectionModelImpl;
import model.pacotesViagem.CategoriaDestinoModel;
import view.interfaceGrafica.Tela;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public final class Main {
    private static UsuarioController usuarioController;
    private static Tela tela;

    public static void main(String[] args) {
        tela = Tela.getInstance(800, 1000);
        Scanner scanner = new Scanner(System.in);
        while (tela.isVisible()){
            // Fazer nada
            assert true;
        }

        while (!tela.isVisible()){
            System.out.println("---- Menu Turismo ----\n");
            System.out.println("1. Consultar Pacotes");
            System.out.println("\n\n");
            System.out.println("5. Logout");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    // Menu de Pacotes
                    menuPacotes(scanner);
                    break;
                case 5:
                    // Abre a interface gráfica novamente
                    tela.setVisible(true);
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        }


        // Iniciando conexao com o banco de dados
        ConexaoModel.iniciarConexao();

        // Encerrando conexao com o banco de dados
        //ConexaoModel.encerrarConexao();
    }
    private static void menuPacotes(Scanner scanner){
        System.out.println("---- Pacotes ----\n");
        // Imprime uma lista de Pacotes no formato  "{categoria} | {avaliacao}/10 | {precoBase}"
        System.out.println("1. Buscar por categoria");
        System.out.println("2. Buscar por destino");
        System.out.println("3. Voltar");

        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao){
            case 1:
                menuCategorias(scanner);
                break;
            case 2:
                System.out.println("Qual o destino desejado?");
                String destino = scanner.nextLine();
                List<PacoteViagemController> pacotesPorDestino = usuarioController.buscarPacotePorDestino(destino);
                if (pacotesPorDestino != null){
                    buscarPorDestino(scanner, pacotesPorDestino);
                } else {
                    System.out.println("Destino não encontrado");
                }
                break;
            case 3:
               return;
            default:
                System.out.println("Opção inválida. Por favor, escolha novamente.");
        }
    }
    private static void menuCategorias(Scanner scanner){
        System.out.println("---- Categorias ----\n");
        System.out.println("1. Aventura");
        System.out.println("2. Cultura");
        System.out.println("3. Relaxamento");
        System.out.println("4. Voltar");

        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao){
            case 1:
                buscaPorCategoria(scanner, CategoriaDestinoModel.Aventura);
            case 2:
                buscaPorCategoria(scanner, CategoriaDestinoModel.Cultura);
            case 3:
                buscaPorCategoria(scanner, CategoriaDestinoModel.Relaxamento);
            case 4:
                return;
            default:
                System.out.println("Opção inválida. Por favor, escolha novamente.");
        }
    }
    private static void menuInfoPacote(Scanner scanner, PacoteViagemController pacote){
        System.out.printf("Categoria:" + pacote.getCategoria());
        System.out.println("Nota:" + pacote.getAvaliacao() + "/10");
        System.out.println("Destino:" + pacote.getDestino());
        System.out.println("Preço:" + pacote.getPrecoBase());
        System.out.println(" ");
        System.out.println("1. Comprar");
        System.out.println("2. Voltar");

        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1:
                System.out.println("Compra efetuada com sucesso!");
                break;
            case 2:
                return;
            default:
                System.out.println("Opção inválida. Por favor, escolha novamente.");
        }

    }
    private static void buscaPorCategoria(Scanner scanner, CategoriaDestinoModel categoria){
        System.out.println("1. Voltar");
        List<PacoteViagemController> listaPacotes = usuarioController.buscarPacotePorCategoria(categoria);
        listarPacotes(scanner, listaPacotes);
    }
    private static void buscarPorDestino(Scanner scanner, List<PacoteViagemController> listaPacotes){
        System.out.println("1. Voltar");
        listarPacotes(scanner, listaPacotes);
    }
    private static void listarPacotes(Scanner scanner, List<PacoteViagemController> listaPacotes){
        int i = 2;
        for (PacoteViagemController pacoteViagem : listaPacotes){
            System.out.println(i + ". " + pacoteViagem.getAvaliacao() + "|" +
                    pacoteViagem.getCategoria() + "|" +
                    pacoteViagem.getAvaliacao() + "/10" + "|" +
                    pacoteViagem.getPrecoBase() + "\n");
        }

        int opcao = scanner.nextInt();
        scanner.nextLine();

        if (opcao == 1){
            assert true; // Não faz nada
        } else if (opcao <= i) {
            menuInfoPacote(scanner, listaPacotes.get(opcao));
        } else {
            System.out.println("Opção inválida. Por favor, escolha novamente.");
        }
    }
    public static void setUsuarioController(UsuarioController newController) {
        usuarioController = newController;
    }

}