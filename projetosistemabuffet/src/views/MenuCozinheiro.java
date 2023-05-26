package views;

import util.Console;

public class MenuCozinheiro {
    static int opc;
    //consultar estoque
    //dar baixa nos itens utilizados
    public static void exibirMenuCozinheiro(){

        do{
        System.out.println("Menu cozinha.");
        System.out.println("1 - Consultar Estoque:");
        System.out.println("2 - Dar baixa em itens utilizados.");
        System.out.println("3 - Sair.");
        opc = Console.readInt("Escolha a opção.");

        switch (opc){
            case 1:

            case 2:

        }
            
        }while(opc !=3)
    }
}
