package views;

import util.Console;

public class GerenteCargos {
    
    public static void escolherMenu() {
        int opc;
        do {
            System.out.println("\n\nSelecione o menu de um cargo para ser acessado:");
            System.out.println("1- Menu Compras");
            System.out.println("2- Menu Vendedor.");
            System.out.println("3- Menu Cozinheiro.");
            System.out.println("4- Voltar ao Menu Gerente.");
            opc = Console.readInt("Informe a opção: ");

            switch (opc) {
                case 1:
                    ComprasMenu.exibirMenuCompras();
                    break;
                case 2:
                    VendedorMenu.exibirMenuVendedor();
                    break;
                case 3:
                    CozinheiroMenu.exibirMenuCozinheiro();
                    break;
                case 4:
                    System.out.println("\nVoltando ao Menu Gerente.");
                    break;
                default:
                    System.out.println("Esta opção não é válida.");
                    break;
            }

        } while (opc != 4);
    }
}
