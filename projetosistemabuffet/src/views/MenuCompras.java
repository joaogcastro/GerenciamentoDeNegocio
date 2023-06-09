package views;

import util.Console;

public class MenuCompras {

    public static void exibirMenuCompras() {
        int opc;
        do {
            System.out.println("\n\nMenu Compras:");
            System.out.println("1- Consultar estoque da cozinha."); //listar os ingredientes no estoque: id, nome, quantidade
            System.out.println("2- Adicionar itens ao estoque da cozinha."); //nesta tela, deve ter a opção de adicionar um ingrediente novo ou só adicionar mais quantidade para um ingrediente que já existe
            System.out.println("3- Gerenciar Decorações"); //crud para as decoracoes da festa
            System.out.println("4- Gerenciar Fornecedores."); //crud para os fornecedores
            System.out.println("5- Sair.");
            opc = Console.readInt("Informe a opção: ");

            switch (opc) {
                case 1:

                    break;

                case 2:
                    ComprasFornecedor.crudMenuFornecedor();
                    break;

                case 3:

                case 4:
                    System.out.println("Fazendo logoff.");
                    break;

                default:
                    System.out.println("Esta opção não é válida.");
                    break;

            }
        } while (opc != 4);
    }
}