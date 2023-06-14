package views;

import data.DataIngrediente;
import models.Ingrediente;
import util.Console;

public class MenuCompras {

    public static void exibirMenuCompras() {
        int opc;
        do {
            System.out.println("\n\nMenu Compras:");
            System.out.println("1- Consultar estoque da cozinha.");
            System.out.println("2- Adicionar itens ao estoque da cozinha.");
            System.out.println("3- Gerenciar Decorações");
            System.out.println("4- Gerenciar Fornecedores.");
            System.out.println("5- Sair.");
            opc = Console.readInt("Informe a opção: ");

            switch (opc) {
                case 1:
                    System.out.println("\nConsultar Estoque:");
                    DataIngrediente.listarIngredientes();
                    break;

                case 2:
                    System.out.println("\nAdicionar itens ao estoque da cozinha:");
                    int opcAdicionar = Console.readInt("1- Adicionar ingrediente novo \n 2- Adicionar quantidade para um ingrediente existente\nInforme a opção:  ");

                    switch (opcAdicionar) {
                        case 1:
                            adicionarNovoIngrediente();
                            break;

                        case 2:
                            alterarQuantidadeIngrediente();
                            break;

                        default:
                            System.out.println("Opção inválida.");
                            break;
                    }
                    break;

                case 3:
                    ComprasDecoracao.gerenciarDecoracao();
                    break;

                case 4:
                    ComprasFornecedor.gerenciarFornecedores();
                    break;

                case 5:
                    System.out.println("Fazendo logoff.");
                    break;

                default:
                    System.out.println("Esta opção não é válida.");
                    break;
            }
        } while (opc != 5);
    }

    private static void alterarQuantidadeIngrediente() {
        System.out.println("Adicionando mais quantidade para um ingrediente existente:");
        Ingrediente ingredienteExistente = new Ingrediente();
        String escolha = Console.readString("Você deseja pesquisar o ingrediente pelo nome ou id?\n");
        if(escolha.equalsIgnoreCase("id")){
            ingredienteExistente = DataIngrediente.procurarID(Console.readInt("Informe o id do ingrediente: "));
        }else{
            ingredienteExistente.setNomeIngrediente(Console.readString("Informe o nome do ingrediente: "));
            ingredienteExistente = DataIngrediente.procurarNomeIngrediente(ingredienteExistente);
        }                           

        if (ingredienteExistente != null) {
            int quantidadeAdicional = Console.readInt("Informe a quantidade comprada do ingrediente: ");
            ingredienteExistente.setQuantidade(ingredienteExistente.getQuantidade() + quantidadeAdicional);

            if (DataIngrediente.alterar(ingredienteExistente)) {
                System.out.println("Quantidade adicionada ao ingrediente com sucesso.");
            } else {
                System.out.println("Erro ao adicionar quantidade ao ingrediente.");
            }
        } else {
            System.out.println("Ingrediente não encontrado.");
        }
    }

    private static void adicionarNovoIngrediente() {
        System.out.println("\nAdicionando um novo ingrediente:");
        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setNomeIngrediente(Console.readString("Informe o nome do ingrediente: "));
        if(DataIngrediente.procurarNomeIngrediente(ingrediente)==null){
            ingrediente.setQuantidade(Console.readInt("Informe a quantidade do ingrediente: "));
            if (DataIngrediente.incluir(ingrediente)) {
            System.out.println("\nIngrediente adicionado ao estoque com sucesso.");
            } else {
                System.out.println("\nErro ao adicionar ingrediente ao estoque.");
            }
        }else{
            System.out.println("\nEste ingrediente já está cadastrado.");
        }
    }
}