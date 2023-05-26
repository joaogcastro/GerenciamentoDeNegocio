package views;

//consultar festas
//definir funcionarios para cada festa
//controle financeiro
//consultar estoque
//cadastar funcionarios



import models.Usuario;
import util.Console;

public class MenuGerente {
    public static void exibirMenuGerente (Usuario usuario){
        int opc=0;
        do{
            System.out.println("\nBem vindo(a) Gerente "+usuario.getUsuario()+" selecione uma das opções do menu: ");
            System.out.println("1- Lista de funcionários\n2- Festas\n3- Sair");
            opc= Console.readInt("Informe a opção: ");

            switch(opc){
                case 1:
                    System.out.println("Lista de funcionarios");
                    break;
                
                case 2:
                    System.out.println("Festas");
                    break;
            }
        }while(opc!=3);
    }
}
