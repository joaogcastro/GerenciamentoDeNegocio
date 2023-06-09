package views;

import data.DataEstoque;
import models.Ingrediente;
import util.Console;

public class CozinheiroEstoque {

    public static void gerenciarEstoque() {

        int opc;

        do {
            System.out.println("Estoque: ");
            System.out.println("1 - Consultar estoque.");
            System.out.println("2 - Dar baixa em itens.");
            System.out.println("3 - Sair.");
            opc = Console.readInt("Escolha a opção.");

            switch (opc) {
                case 1:
                    DataEstoque.listarIngredientes();
                    break;

                case 2:
                    System.out.println("\nDar baixa de itens ");
                    Ingrediente objIngrediente = new Ingrediente();
                    objIngrediente.setIdIngrediente(Console.readInt("Id do item que será alterado: "));
                    objIngrediente = DataEstoque.procurarID(objIngrediente);
                    System.out.println("Nome: " + objIngrediente.getNomeIngrediente() + "  Quantidade: "
                            + objIngrediente.getQuantidade());
                    int qntItem = Console.readInt("Quantidade que será retirada do estoque: ");

                    break;
            }
        } while (opc != 3);
    }
}
