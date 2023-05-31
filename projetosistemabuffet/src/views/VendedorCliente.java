package views;

import data.DataCliente;
import models.Cliente;
import util.Console;
import util.ValidadorCPF;

public class VendedorCliente {
    public static void crudCliente (){
        System.out.println("\nAlterar dados do cliente:\n1- Adicionar novo cliente\n2-Alterar Cliente\n3- Deletar cliente\n4- Voltar ao menu.");
        int opc= Console.readInt("Informe a opção:");
        switch(opc){
            case 1:
                System.out.println("Adicionar novo cliente:");
                Cliente cliente= new Cliente();
                cliente.setCpf(Console.readString("Informe o cpf do cliente: "));
                if(ValidadorCPF.validarCPF(cliente.getCpf())==true){
                    cliente.setNome(Console.readString("Nome do cliente: "));
                    cliente.setTelefone(Console.readString("Informe o telefone do cliente: "));
                    cliente.setEmail(Console.readString("Informe o email do cliente: "));
                    cliente.setEndereco(Console.readString("Informe o endereço do cliente: "));
                    DataCliente.incluir(cliente);
                }else{
                    System.out.println("O CPF digitado não é válido");
                }
            case 2:
                
        }
    }
}
