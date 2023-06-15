package views;

import util.Console;

public class VendedorMenu {

    public static void exibirMenuVendedor() {
        int opc;
        do {
            System.out.println("\n\nMenu Vendedor:");
            System.out.println("1- Nova festa.");
            System.out.println("2- Buscar festas.");
            System.out.println("3- Resumo da festa.");
            System.out.println("4- Cancelar festa.");
            System.out.println("5- Contato dos clientes.");
            System.out.println("6- Gerenciar cadastro dos clientes.");
            System.out.println("7- Sair.");
            opc = Console.readInt("Informe a opção: ");

            switch (opc) {
                case 1:
                    VendedorFesta.venderFesta();
                    break;

                case 2:
                    VendedorFesta.buscarFestas();
                    break;
                    
                case 3:
                    VendedorFesta.exibirResumoDaFesta();
                    break;

                case 4:
                    VendedorFesta.cancelarFesta();
                    break;

                case 5:
                    VendedorCliente.contatarClientes();
                    break;

                case 6:
                    VendedorCliente.crudCliente();
                    break;

                case 7:
                    System.out.println("Fazendo logoff.");
                    break;

                default:
                    System.out.println("Esta opção não é válida.");
                    break;
            }

        } while (opc != 7);
    }
}