package views;

import data.DataCliente;
import util.Console;

public class VendedorContato {
    public static void contatarClientes (){
        int opc;
        do{
            System.out.println("\n1- Exibir todos os clientes.\n2- Procurar um cliente específico\n3- Voltar ao menu.");
            opc=Console.readInt("Informe a opção: ");
            switch(opc){
                case 1:
                    System.out.println("\nLista de clientes:");
                    DataCliente.listarContatoClientes();
                    break;
                case 2:
                    System.out.println("\nBuscar um cliente por nome:");
                    String nomeCliente = Console.readString("Informe o nome do cliente: ");
                    DataCliente.buscarNomeCliente(nomeCliente);
                    break;
                case 3:
                    System.out.println("\nVoltando ao menu.\n");
            }
        }while(opc!=3);
    }
}
