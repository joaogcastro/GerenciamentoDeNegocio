package views;

import models.Funcionario;
import util.CPFUtils;
import util.Console;

public class GerenteFuncionario {
    
    public static void crudFuncionario(){
        Funcionario funcionario;
        int opc;
        do{
            System.out.println("\nGerenciar funcionários:");
            System.out.println("1- Exibir funcionários cadastrados.");
            System.out.println("2- Adicionar novo funcionáro.");
            System.out.println("3- Alterar funcionário.");
            System.out.println("4- Excluir funcionário.");
            System.out.println("5- Voltar ao menu.");
            opc= Console.readInt("Informe a opção: ");

            switch(opc){
                case 1:
                    System.out.println("\nFuncionários cadastrados do banco:");

                    break;
                case 2:
                    System.out.println("\nAdicionar novo funcionário:");
                    funcionario= new Funcionario();
                    funcionario.setCpf("Informe o CPF do funcionário: ");
                    if(CPFUtils.validarCPF(funcionario.getCpf())==true){
                        
                    }
            }
        }while(opc!=5);
    }
}
