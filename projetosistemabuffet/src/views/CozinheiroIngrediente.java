package views;

import data.DataIngrediente;
import models.Ingrediente;
import util.Console;

public class CozinheiroIngrediente {

    public static void consultarEstoque() {
        System.out.println("\nConsultar Estoque:");
        DataIngrediente.listarIngredientes();
    }

    public static void darBaixaIngredientes() {
        System.out.println("\nDar baixa em ingredientes utilizados.");
        Ingrediente ingrediente = new Ingrediente();
        String escolha = Console.readString("Você deseja pesquisar o ingrediente pelo nome ou id?\n");
        if (escolha.equalsIgnoreCase("id")) {
            ingrediente = DataIngrediente.procurarID(Console.readInt("Informe o id do ingrediente: "));
        } else {
            ingrediente.setNomeIngrediente(Console.readString("Informe o nome do ingrediente: "));
            ingrediente = DataIngrediente.procurarNomeIngrediente(ingrediente);
        }

        if (ingrediente != null) {
            int quantidade = Console.readInt("Informe a quantidade utilizada: ");
            if (quantidade >= ingrediente.getQuantidade()) {
                int novaQuantidade = ingrediente.getQuantidade()-quantidade;
                ingrediente.setQuantidade(novaQuantidade);
                DataIngrediente.alterar(ingrediente);
                System.out.println("Alterada com sucesso.");
            } else {
                System.out.println("Erro. O número informado é maior do que o número em estoque.");
            }
        } else {
            System.out.println("Item não encontrado no estoque.");
        }
    }

}