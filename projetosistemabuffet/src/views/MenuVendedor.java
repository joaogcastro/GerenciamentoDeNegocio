package views;

import util.Console;
import util.GerenciadorFestas;

public class MenuVendedor {

    public static void exibirMenuVendedor() {
        int opc;
        do {
            System.out.println("\n\nMenu Vendedor:");
            System.out.println("1- Nova festa.");
            System.out.println("2- Resumo da festa.");
            System.out.println("3- Calendario de festas.");
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
                    
                case 3:
                    
                case 4:

                boolean dataOcupada = GerenciadorFestas.verificarDataOcupada(dataInicio, dataFim);

                case 5:
                    VendedorCliente.contatarClientes();
                    break;

                case 6:
                    VendedorCliente.crudCliente();
                    break;

                case 7:
                    System.out.println("");
            }

        } while (opc != 7);
    }
}
