package views;

import data.DataFesta;
import models.Festa;
import util.Console;
import util.GerenciadorFestas;

public class MenuVendedor {

    public static void exibirMenuVendedor() {
        Festa festa;
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
                    System.out.println("\nBuscar festas:");
                    System.out.println("1- Listar todas as festas.");
                    System.out.println("2- Buscar festas por cliente");
                    int opcBuscar = Console.readInt("Informe a opção: ");

                    switch(opcBuscar){
                        case 1:
                            System.out.println("\nLista de festas:");
                            DataFesta.listarFestas();
                    }
                    
                case 3:
                    System.out.println("Detalhes da festa:");
                    festa = new Festa();
                    festa=DataFesta.buscarFestaPorId(Console.readInt("Informe o id da festa: "));
                    if(festa!=null){
                        DataFesta.exibirDetalhesFesta(festa);
                    }else{
                        System.out.println("\nEste id não corresponde a nenhuma festa.");
                    }
                    break;

                case 4:

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
