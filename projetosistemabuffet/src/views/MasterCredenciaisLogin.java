package views;

import util.Console;

public class MasterCredenciaisLogin {
    public static void crudCredenciaisLogin (){
        int res=0;
        do{      
            System.out.println("1- Exibir as credenciais de login existentes no banco.\n2- Acionar nova credencialde login.\n3- Alterar uma credencial de login existente\n4- Excluir uma crendecial de login\n5- Voltar ao menu.");
            res= Console.readInt("Informe a opção: ");
            switch(res){
                case 1:
                    
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                default:
                    System.out.println("Essa opção não é válida.");
                    break;
                
            }
        }while(res!=5)
    }
}
