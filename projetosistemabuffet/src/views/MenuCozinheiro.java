package views;

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

                case 2:

                case 3:

            }

        } while (opc != 4);
    }
}
