package views;

import data.DataCardapio;
import models.Cardapio;
import util.Console;

public class CozinheiroCardapio {

    public static void gerenciarCardapio() {
        Cardapio prato;
        int opcCardapio;
        do {
            System.out.println("\nGerenciar Cardápio:");
            System.out.println("1- Listar pratos do cardápio.");
            System.out.println("2- Adicionar prato ao cardápio.");
            System.out.println("3- Alterar prato do cardápio");
            System.out.println("4- Remover prato do cardápio.");
            System.out.println("5- Voltar ao menu anterior.");
            opcCardapio = Console.readInt("Informe a opção: ");

            switch (opcCardapio) {
                case 1:
                    System.out.println("\nListar itens do cardápio:");
                    DataCardapio.listarPratosCardapio();
                    break;

                case 2:
                    System.out.println("\nAdicionar Prato ao cardápio:");
                    prato = new Cardapio();
                    prato.setNome(Console.readString("Informe o nome do Prato: "));
                    prato.setPreco(Console.readDouble("Informe o preço do Prato: "));
                    if (DataCardapio.incluir(prato)) {
                        System.out.println("Prato adicionado ao cardápio com sucesso.");
                    } else {
                        System.out.println("Erro ao adicionar o Prato ao cardápio.");
                    }
                    break;

                case 3:
                    System.out.println("\nAlterar prato do cardápio:");
                    prato = new Cardapio();
                    prato = DataCardapio.buscarPratoCardapio(Console.readInt("Informe o ID do prato a ser alterado: "));
                    if (prato != null) {
                        prato.setNome(Console.readString("Informe o novo nome do prato: "));
                        prato.setPreco(Console.readDouble("Informe o novo preço do prato: "));
                        if (DataCardapio.alterar(prato)) {
                            System.out.println("Prato do cardápio alterado com sucesso.");
                        } else {
                            System.out.println("Erro ao alterar o prato do cardápio.");
                        }
                    } else {
                        System.out.println("Prato do cardápio não encontrado.");
                    }
                    break;

                case 4:
                    System.out.println("\nRemover Prato do cardápio:");
                    prato = new Cardapio();
                    prato = DataCardapio.buscarPratoCardapio(Console.readInt("Informe o ID do Prato a ser removido: "));
                    if (prato != null) {
                        if (DataCardapio.excluir(prato)) {
                            System.out.println("Prato removido do cardápio com sucesso.");
                        } else {
                            System.out.println("Erro ao remover o Prato do cardápio.");
                        }
                    } else {
                        System.out.println("Prato do card\u00E1pio n\u00E3o encontrado.");
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