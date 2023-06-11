package views;

import data.DataCardapio;
import models.Cardapio;
import util.Console;

public class CozinheiroCardapio {

    public static void gerenciarCardapio() {
        int opcCardapio;
        do {
            System.out.println("\nMenu Cardápio:");
            System.out.println("1- Listar pratos do cardápio.");
            System.out.println("2- Adicionar prato ao cardápio.");
            System.out.println("3- Alterar prato do cardápio");
            System.out.println("4- Remover prato do cardápio.");
            System.out.println("5- Voltar ao menu anterior.");
            opcCardapio = Console.readInt("Informe a opção: ");

            switch (opcCardapio) {
                case 1:
                    System.out.println("\nListar itens do cardápio:");
                    DataCardapio.listarItensCardapio();
                    break;

                case 2:
                    System.out.println("\nAdicionar item ao cardápio:");
                    String nome = Console.readString("Informe o nome do item: ");
                    double preco = Console.readDouble("Informe o preço do item: ");
                    Cardapio novoItem = new Cardapio();
                    novoItem.setNome(nome);
                    novoItem.setPreco(preco);
                    if (DataCardapio.adicionarItemCardapio(novoItem)) {
                        System.out.println("Item adicionado ao cardápio com sucesso.");
                    } else {
                        System.out.println("Erro ao adicionar o item ao cardápio.");
                    }
                    break;

                case 3:
                    System.out.println("\nAlterar prato do cardápio:");
                    int idPrato = Console.readInt("Informe o ID do prato a ser alterado: ");
                    Cardapio pratoExistente = DataCardapio.buscarItemCardapio(idPrato);
                    if (pratoExistente != null) {
                        String novoNome = Console.readString("Informe o novo nome do prato: ");
                        double novoPreco = Console.readDouble("Informe o novo preço do prato: ");
                        pratoExistente.setNome(novoNome);
                        pratoExistente.setPreco(novoPreco);
                        if (DataCardapio.alterarItemCardapio(pratoExistente)) {
                            System.out.println("Prato do cardápio alterado com sucesso.");
                        } else {
                            System.out.println("Erro ao alterar o prato do cardápio.");
                        }
                    } else {
                        System.out.println("Prato do cardápio não encontrado.");
                    }
                    break;

                case 4:
                    System.out.println("\nRemover item do cardápio:");
                    int id = Console.readInt("Informe o ID do item a ser removido: ");
                    if (DataCardapio.removerItemCardapio(id)) {
                        System.out.println("Item removido do cardápio com sucesso.");
                    } else {
                        System.out.println("Erro ao remover o item do cardápio.");
                    }
                    break;

                case 5:
                    System.out.println("Voltando ao menu anterior.");
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (opcCardapio != 5);
    }
}