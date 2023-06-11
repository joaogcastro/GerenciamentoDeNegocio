package views;

import data.DataEstoque;
import models.Ingrediente;
import util.Console;

public class MenuCompras {

    public static void exibirMenuCompras() {
        int opc;
        do {
            System.out.println("\n\nMenu Compras:");
            System.out.println("1- Consultar estoque da cozinha."); // listar os ingredientes no estoque: id, nome, quantidade
            System.out.println("2- Adicionar itens ao estoque da cozinha."); // nesta tela, deve ter a opção de adicionar um ingrediente novo ou só adicionar mais quantidade para um ingrediente que já existe
            System.out.println("3- Gerenciar Decorações"); // crud para as decorações da festa
            System.out.println("4- Gerenciar Fornecedores."); // crud para os fornecedores
            System.out.println("5- Sair.");
            opc = Console.readInt("Informe a opção: ");

            switch (opc) {
                case 1:
                    System.out.println("\nConsultar Estoque:");
                    DataEstoque.listarIngredientes();
                    break;

                case 2:
                    System.out.println("\nAdicionar itens ao estoque da cozinha:");
                    int opcAdicionar = Console.readInt("1- Adicionar ingrediente novo \n 2- Adicionar quantidade para um ingrediente existente\nInforme a opção:  ");

                    switch (opcAdicionar) {
                        case 1:
                            // Adicionar ingrediente novo
                            String nome = Console.readString("Informe o nome do ingrediente: ");
                            int quantidade = Console.readInt("Informe a quantidade do ingrediente: ");

                            Ingrediente novoIngrediente = new Ingrediente();
                            novoIngrediente.setNomeIngrediente(nome);
                            novoIngrediente.setQuantidade(quantidade);

                            if (DataEstoque.incluir(novoIngrediente)) {
                                System.out.println("Ingrediente adicionado ao estoque com sucesso.");
                            } else {
                                System.out.println("Erro ao adicionar ingrediente ao estoque.");
                            }
                            break;

                        case 2:
                            // Adicionar quantidade para um ingrediente existente
                            int idIngrediente = Console.readInt("Informe o ID do ingrediente: ");
                            int quantidadeAdicional = Console.readInt("Informe a quantidade adicional do ingrediente: ");

                            Ingrediente ingredienteExistente = DataEstoque.procurarID(idIngrediente);

                            if (ingredienteExistente != null) {
                                ingredienteExistente.setQuantidade(ingredienteExistente.getQuantidade() + quantidadeAdicional);

                                if (DataEstoque.alterar(ingredienteExistente)) {
                                    System.out.println("Quantidade adicionada ao ingrediente com sucesso.");
                                } else {
                                    System.out.println("Erro ao adicionar quantidade ao ingrediente.");
                                }
                            } else {
                                System.out.println("Ingrediente não encontrado.");
                            }
                            break;

                        default:
                            System.out.println("Opção inválida.");
                            break;
                    }
                    break;

                case 3:
                    // TODO: Implementar o gerenciamento de decorações
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
}
