package views;

public class MenuVendedor {

    int opc;
    //nova festa
    //contato dos clientes
    //tabela de valores e produtos disponiveis
    //resumo da festa
    //calendario de festas
    //cancelar festa
    public static void exibirMenuVendedor(){
        System.out.println("Menu vendedor");

        do{
            System.out.println("Menu master.");
            System.out.println("1 - nova festa.");
            System.out.println("2 - contato dos clientes.");
            System.out.println("3 - tabela de valores e produtos disponiveis.");
            System.out.println("4 - resumo da festa.");
            System.out.println("5 - calendario de festas.");
            System.out.println("6 - cancelar festa.");
            System.out.println("7 - Sair.");
            opc = Console.readInt("Escolha a opção.");

        switch (opc){
            case 1:

            case 2:

            case 3:

            case 4:

            case 5:

            case 6:
        
        }
        
    }while (opc != 7);
}
