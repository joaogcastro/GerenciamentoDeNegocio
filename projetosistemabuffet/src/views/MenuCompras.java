package views;

import util.Console;

public class MenuCompras {
    
    public static void exibirMenuCompras(){
        int opcao;
        System.out.println("\n\nMenu Compras.");
        do {
			
			System.out.println("1 - Fazer lista de itens em falta.");
			System.out.println("2 - Consultar estoque.");
			System.out.println("3 - Lista de fornecedores.");
            System.out.println("4 - Adicionar itens ao estoque.");
            System.out.println("5 - Sair.");

			opcao = Console.readInt("Escolha a opção.");
		
			switch (opcao) {
                case 1:
                MenuComprasFornecedor.crudMenuFornecedor();
                break;

                case 2: System.out.println("");
                break;

                case 3: 
                
                System.out.println("1 - Alterar fornecedores.");
                System.out.println("2 - Excluir fornecedores.");
                System.out.println("3 - Voltar.");
                        

                break;

                case 4: System.out.println("");
                break;

            }
        }while(opcao != 5);
    }
}