package views;

import data.DataIngrediente;
import models.Ingrediente;
import util.Console;

public class ComprasIngrediente {

    public static void consultarEstoque() {
        System.out.println("\nConsultar Estoque:");
        DataIngrediente.listarIngredientes();
    }

    public static void gerenciarIngredientesDoEstoque() {
        int opc;
        System.out.println("\nGerenciar ingredientes do estoque da cozinha:");
        do {
            opc = Console.readInt(
                    "1- Adicionar ingrediente novo.\n 2- Adicionar quantidade para um ingrediente existente.\n3- Excluir um ingrediente.\n4- Voltar ao menu.\nInforme a opção:  ");

            switch (opc) {
                case 1:
                    adicionarNovoIngrediente();
                    break;

                case 2:
                    alterarQuantidadeIngrediente();
                    break;

                case 3:
                    excluirIngrediente();
                    break;

                case 4:
                    System.out.println("\nVoltando ao menu.");
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (opc != 4);
    }

    private static void adicionarNovoIngrediente() {
        System.out.println("\nAdicionando um novo ingrediente:");
        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setNomeIngrediente(Console.readString("Informe o nome do ingrediente: "));
        if (DataIngrediente.procurarNomeIngrediente(ingrediente) == null) {
            ingrediente.setQuantidade(Console.readInt("Informe a quantidade do ingrediente: "));
            ingrediente.setValorUnitario(Console.readDouble("Informe quanto foi pago na unidade deste ingrediente: "));
            if (DataIngrediente.incluir(ingrediente)) {
                System.out.println("\nIngrediente adicionado ao estoque com sucesso.");
            } else {
                System.out.println("\nErro ao adicionar ingrediente ao estoque.");
            }
        } else {
            System.out.println("\nEste ingrediente já está cadastrado.");
        }
    }

    private static void alterarQuantidadeIngrediente() {
        System.out.println("Adicionando mais quantidade para um ingrediente existente:");
        Ingrediente ingredienteExistente = new Ingrediente();
        String escolha = Console.readString("Você deseja pesquisar o ingrediente pelo nome ou id?\n");
        if (escolha.equalsIgnoreCase("id")) {
            ingredienteExistente = DataIngrediente.procurarID(Console.readInt("Informe o id do ingrediente: "));
        } else {
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

    private static void excluirIngrediente() {
        System.out.println("\nExcluir um ingrediente do banco de dados:");
        Ingrediente ingrediente = DataIngrediente.procurarID(Console.readInt("Informe o id do ingrediente: "));
        if (ingrediente != null) {
            if (DataIngrediente.excluir(ingrediente)) {
                System.out.println("\nIngrediente excluído com sucesso.");
            } else {
                System.out.println("\nHouve um erro ao excluir o ingrediente.");
            }
        } else {
            System.out.println("\nEsse ID não corresponde a nenhum ingrediente.");
        }
    }

}