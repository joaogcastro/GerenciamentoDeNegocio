package views;

import util.Console;

public class CozinheiroMenu {

    public static void exibirMenuCozinheiro() {
        int opc;
        
        do {
            System.out.println("\n\nMenu Cozinheiro:");
            System.out.println("1- Consultar Estoque:");
            System.out.println("2- Dar baixa em itens utilizados.");
            System.out.println("3- Gerenciar Cardápio.");
            System.out.println("4- Sair.");
            opc = Console.readInt("Informe a opção: ");

            switch (opc) {
                case 1:
                    CozinheiroIngrediente.consultarEstoque();
                    break;

                case 2:
                    CozinheiroIngrediente.darBaixaIngredientes();
                    break;

                case 3:
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