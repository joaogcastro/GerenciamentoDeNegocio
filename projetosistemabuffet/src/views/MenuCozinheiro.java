package views;

import data.DataIngrediente;
import models.Ingrediente;
import util.Console;

public class MenuCozinheiro {

    public static void exibirMenuCozinheiro() {
        int opc;
        do {
            System.out.println("\n\nMenu Cozinheiro:");
            System.out.println("1- Consultar Estoque:");
            System.out.println("2- Dar baixa em itens utilizados."); // diminuir a quantidade de um item no estoque
            System.out.println("3- Gerenciar Cardápio."); // crud para o cardapio
            System.out.println("4- Sair.");
            opc = Console.readInt("Informe a opção: ");

            switch (opc) {
                case 1:
                    System.out.println("\nConsultar Estoque:");
                    DataIngrediente.listarIngredientes();
                    break;

                case 2:
                    System.out.println("\nDar baixa em ingredientes utilizados.");
                    Ingrediente ingrediente = new Ingrediente();
                    String escolha = Console.readString("Você deseja pesquisar o ingrediente pelo nome ou id?\n");
                    if (escolha.equalsIgnoreCase("id")) {
                        ingrediente = DataIngrediente.procurarID(Console.readInt("Informe o id do ingrediente: "));
                    } else {
                        ingrediente.setNomeIngrediente(Console.readString("Informe o nome do ingrediente: "));
                        ingrediente = DataIngrediente.procurarNomeIngrediente(ingrediente);
                    }

                    if (ingrediente != null) {
                        int quantidade = Console.readInt("Informe a quantidade utilizada: ");
                        DataIngrediente.darBaixa(ingrediente, quantidade);
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