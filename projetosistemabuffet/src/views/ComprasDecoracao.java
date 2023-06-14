package views;

import models.Decoracao;
import models.Fornecedor;
import data.DataDecoracao;
import data.DataFornecedor;
import util.Console;

public class ComprasDecoracao {

    public static void gerenciarDecoracao() {
        Decoracao decoracao;
        int opcDecoracao;
        do {
            System.out.println("\nGerenciar Decorações:");
            System.out.println("1- Listar decorações.");
            System.out.println("2- Adicionar decoração.");
            System.out.println("3- Alterar decoração.");
            System.out.println("4- Remover decoração.");
            System.out.println("5- Voltar ao menu anterior.");
            opcDecoracao = Console.readInt("Informe a opção: ");

            switch (opcDecoracao) {
                case 1:
                    System.out.println("\nListar decorações:");
                    DataDecoracao.listarDecoracoes();
                    break;

                case 2:
                    System.out.println("\nAdicionar decoração:");
                    decoracao = new Decoracao();
                    decoracao.setTema(Console.readString("Informe o tema da decoração: "));
                    decoracao.setPreco(Console.readDouble("Informe o preço da decoração: "));
                    System.out.println("Informe o fornecedor dessa decoração: ");
                    DataFornecedor.listarFornecedores();
                    Fornecedor fornecedor = new Fornecedor();
                    do{
                        fornecedor= DataFornecedor.buscarFornecedorPorId(Console.readInt("Informe o id do fornecedor: "));
                        if(fornecedor==null){
                            System.out.println("Este id não corresponde a nenhum fornecedor.");
                        }
                    }while(fornecedor==null);

                    decoracao.setFornecedor(fornecedor);

                    if (DataDecoracao.incluir(decoracao)) {
                        System.out.println("Decoração adicionada com sucesso.");
                    } else {
                        System.out.println("Erro ao adicionar decoração.");
                    }
                    break;

                case 3:
                    System.out.println("\nAlterar decoração:");
                    int id = Console.readInt("Informe o ID da decoração a ser alterada: ");
                    decoracao = DataDecoracao.buscarDecoracaoPorId(id);

                    if (decoracao != null) {
                        decoracao.setTema(Console.readString("Informe o novo tema da decoração: "));
                        decoracao.setPreco(Console.readDouble("Informe o novo preço da decoração: "));

                        if (DataDecoracao.alterar(decoracao)) {
                            System.out.println("Decoração alterada com sucesso.");
                        } else {
                            System.out.println("Erro ao alterar decoração.");
                        }
                    } else {
                        System.out.println("Decoração não encontrada.");
                    }
                    break;

                case 4:
                    System.out.println("\nRemover decoração:");
                    decoracao = DataDecoracao.buscarDecoracaoPorId(Console.readInt("Informe o ID da decoração a ser removida: "));

                    if (decoracao != null) {
                        if (DataDecoracao.excluir(decoracao)) {
                            System.out.println("Decoração removida com sucesso.");
                        } else {
                            System.out.println("Erro ao remover decoração.");
                        }
                    } else {
                        System.out.println("Decoração não encontrada.");
                    }
                    break;

                case 5:
                    System.out.println("Voltando ao menu anterior.");
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (opcDecoracao != 5);
    }
    
}