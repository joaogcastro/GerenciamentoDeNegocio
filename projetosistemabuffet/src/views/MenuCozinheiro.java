package views;

import util.Console;

public class MenuCozinheiro {
    static int opc;
    
    public static void exibirMenuCozinheiro(){

        do{
        System.out.println("\n\nMenu cozinha.");
        System.out.println("1 - Consultar Estoque:");
        System.out.println("2- Alterar pratos do cardápio");
        System.out.println("3 - Dar baixa em itens utilizados.");
        System.out.println("4 - Sair.");
        opc = Console.readInt("Escolha a opção.");

        switch (opc){
            case 1:

            case 2:

        }
            
        }while(opc !=4);
    }
}
