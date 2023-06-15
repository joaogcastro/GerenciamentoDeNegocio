package views;

import util.Console;

public class MasterMenu {

    public static void exibirMenuMaster() {
        int opc;
        do {
            System.out.println("\n\nMenu Master:");
            System.out.println("1 - Gerenciar credenciais de login.");
            System.out.println("2 - Sair.");
            opc = Console.readInt("Informe a opção: ");

            switch (opc) {
                case 1:
                    MasterCredenciaisLogin.crudCredenciaisLogin();
                    break;
                case 2:
                    System.out.println("Fazendo logoff.");
                    break;
                default:
                    System.out.println("Esta opção não é válida.");
                    break;
            }
        } while (opc != 2);
    }
}