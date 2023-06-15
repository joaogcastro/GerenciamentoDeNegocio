package views;

import util.Console;

public class ComprasMenu {

    public static void exibirMenuCompras() {
        int opc;
        
        do {
            System.out.println("\n\nMenu Compras:");
            System.out.println("1- Consultar estoque da cozinha.");
            System.out.println("2- Gerenciar ingredientes do estoque da cozinha.");
            System.out.println("3- Gerenciar Decorações");
            System.out.println("4- Gerenciar Fornecedores.");
            System.out.println("5- Sair.");
            opc = Console.readInt("Informe a opção: ");

            switch (opc) {
                case 1:
                    ComprasIngrediente.consultarEstoque();
                    break;

                case 2:
                    ComprasIngrediente.gerenciarIngredientesDoEstoque();
                    break;

                case 3:
                    ComprasDecoracao.gerenciarDecoracao();
                    break;

                case 4:
                    ComprasFornecedor.gerenciarFornecedores();
                    break;

                case 5:
                    System.out.println("Fazendo logoff.");
                    break;

                default:
                    System.out.println("Esta opção não é válida.");
                    break;
            }
        } while (opc != 5);
    }
}