package views;
import util.Console;

public class MenuMaster {
    
    public static void exibirMenuMaster(){
        int opc;
        do{
        System.out.println("Menu master.");
        System.out.println("1 - Fazer lista de itens em falta.");
		System.out.println("2 - Consultar estoque.");
		System.out.println("3 - Lista de fornecedores.");
        System.out.println("4 - Adicionar itens ao estoque.");
        System.out.println("5 - Consultar Estoque:");
        System.out.println("6 - Dar baixa em itens utilizados.");
        System.out.println("7- Lista de funcionários\n2- Festas");
        System.out.println("8 - Sair.");
        opc = Console.readInt("Escolha a opção.");

        switch (opc){
            case 1:

            case 2:

            case 3:

            case 4:

            case 5:

            case 6:

            case 7:
            }

        }while (opc != 8);
    }
}
