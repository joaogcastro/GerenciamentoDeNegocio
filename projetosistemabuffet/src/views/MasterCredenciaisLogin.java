package views;

import data.LoginData;
import models.Usuario;
import util.Console;

public class MasterCredenciaisLogin {
    public static void crudCredenciaisLogin (){
        int res=0;
        Usuario usuario = null;
        do{      
            System.out.println("\n\n1- Exibir as credenciais de login existentes no banco.\n2- Acionar nova credencial de login.\n3- Alterar uma credencial de login existente\n4- Excluir uma crendecial de login\n5- Voltar ao menu.");
            res= Console.readInt("Informe a opção: ");
            switch(res){
                case 1:
                    System.out.println("\nCrendenciais de login do sistema:");
                    LoginData.listarUsuario();
                    System.out.println("\n");
                    break;
                case 2:
                    System.out.println("\nAdicionar credencial de login: ");
                    usuario = new Usuario();
                    usuario.setCargo(Console.readString("Qual será o cargo deste login? (Gerente, vendedor ou cozinheiro): "));
                    if(usuario.getCargo().equalsIgnoreCase("master")){
                        System.out.println("Você não pode adicionar mais um login dessa categoria.");
                    }else{
                        usuario.setUsuario(Console.readString("Digite o login: "));
                        usuario.setSenha(Console.readString("Digite a senha: "));
                        if(LoginData.incluir(usuario)==true){
                            System.out.println("Usuario "+usuario.getUsuario()+" adicinado com sucesso.");
                        }else{
                            System.out.println("Este login já existe no banco de dados.");
                        }
                    }
                    break;
                case 3:
                    System.out.println("\nAlterar credencial de login: ");
                    usuario= new Usuario();
                    usuario.setUsuario(Console.readString("Usuario a ser alterado: "));
                    LoginData.alterarUsuario(usuario);
                    break;
                case 4:
                    System.out.println("\nExcluir credencial de login: ");
                    usuario = new Usuario();
                    usuario.setUsuario(Console.readString("Informe o login que deseja excluir: "));
                    usuario=LoginData.retornarUsuario(usuario);

                    break;
                case 5:

                    break;
                default:
                    System.out.println("Essa opção não é válida.");
                    break;
                
            }
        }while(res!=5);
    }
}
