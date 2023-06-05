package views;
import util.Console;

public class MenuVendedor {
    
    public static void exibirMenuVendedor(){
        int opc;
        System.out.println("Menu vendedor");

        do{
            System.out.println("\n\nMenu Vendedor:");
            System.out.println("1 - Nova festa.");
            System.out.println("2 - Contato dos clientes.");
            System.out.println("3 - Alterar cadastro dos clientes.");
            System.out.println("4 - resumo da festa.");
            System.out.println("5 - calendario de festas.");
            System.out.println("6 - cancelar festa.");
            System.out.println("7 - Sair.");
            opc = Console.readInt("Escolha a opção.");

        switch (opc){
            case 1:
                //VendedorNovaFesta.venderFesta();
                break;
            case 2:
                VendedorContato.contatarClientes();
                break;
            case 3:
                VendedorCliente.crudCliente();
                break;
            case 4:

            case 5:

            case 6:
        
            }
        
        }while (opc != 7);
    }
}
