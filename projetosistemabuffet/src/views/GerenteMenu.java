package views;

import util.Console;

public class GerenteMenu {

    public static void exibirMenuGerente() {
        int opc;
        do {
            System.out.println("\n\nMenu Gerente:");
            System.out.println("1- Relatório financeiro.");
            System.out.println("2- Gerenciar funcionários.");
            System.out.println("3- Acessar funcionalidades dos demais cargos.");
            System.out.println("4- Sair.");
            opc = Console.readInt("Informe a opção: ");

            switch (opc) {
                case 1:
                    GerenteFinancas.exibirRelatorioFinanceiro();
                    break;

                case 2:
                    GerenteFuncionario.crudFuncionario();
                    break;

                case 3:
                    GerenteCargos.escolherMenu();
                    break;

                case 4:
                    System.out.println("Fazendo logoff.");
                    break;

                default:
                    System.out.println("Esta opção não é válida.");
                    break;
            }
        } while (opc != 4);
    }
}