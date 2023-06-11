package views;

import data.DataEstoque;
import models.Ingrediente;
import util.Console;

public class MenuCozinheiro {

    public static void exibirMenuCozinheiro() {
        int opc;
        do {
            System.out.println("\n\nMenu Cozinheiro:");
            System.out.println("1- Consultar Estoque:"); // listar os ingredientes no estoque: id, nome, quantidade
            System.out.println("2- Dar baixa em itens utilizados."); // diminuir a quantidade de um item no estoque
            System.out.println("3- Gerenciar Cardápio."); // crud para o cardapio
            System.out.println("4- Sair.");
            opc = Console.readInt("Informe a opção: ");

            switch (opc) {
                case 1:
                    System.out.println("\nConsultar Estoque:");
                    DataEstoque.listarIngredientes();
                    break;

                case 2:
                    System.out.println("\nDar baixa em itens utilizados.");
                    int idItem = Console.readInt("Informe o ID do item utilizado: ");
                    int quantidade = Console.readInt("Informe a quantidade utilizada: ");
                    Ingrediente ingrediente = new Ingrediente();
                    ingrediente.setIdIngrediente(idItem);
                    Ingrediente itemEncontrado = DataEstoque.procurarID(ingrediente);
                    if (itemEncontrado != null) {
                        DataEstoque.baixaItens(itemEncontrado, quantidade);
                    } else {
                        System.out.println("Item não encontrado no estoque.");
                    }
                    break;

                case 3:
                    System.out.println("\nGerenciar Cardápio:");
                    CozinheiroCardapio.gerenciarCardapio();
                    break;

                case 4:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }

        } while (opc != 4);
    }
}