package views;

import models.Decoracao;
import data.DataDecoracao;
import util.Console;

public class ComprasDecoracao {

    public static void gerenciarDecoracao() {
        int opcDecoracao;
        do {
            System.out.println("\nMenu Gerenciar Decorações:");
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
                    String tema = Console.readString("Informe o tema da decoração: ");
                    double preco = Console.readDouble("Informe o preço da decoração: ");

                    Decoracao novaDecoracao = new Decoracao();
                    novaDecoracao.setTema(tema);
                    novaDecoracao.setPreco(preco);

                    if (DataDecoracao.incluir(novaDecoracao)) {
                        System.out.println("Decoração adicionada com sucesso.");
                    } else {
                        System.out.println("Erro ao adicionar decoração.");
                    }
                    break;

                case 3:
                    System.out.println("\nAlterar decoração:");
                    int id = Console.readInt("Informe o ID da decoração a ser alterada: ");
                    Decoracao decoracao = DataDecoracao.buscarDecoracaoPorId(id);

                    if (decoracao != null) {
                        String temaAlterar = Console.readString("Informe o novo tema da decoração: ");
                        double precoAlterar = Console.readDouble("Informe o novo preço da decoração: ");

                        decoracao.setTema(temaAlterar);
                        decoracao.setPreco(precoAlterar);

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
                    int idRemover = Console.readInt("Informe o ID da decoração a ser removida: ");
                    Decoracao decoracaoRemover = DataDecoracao.buscarDecoracaoPorId(idRemover);

                    if (decoracaoRemover != null) {
                        if (DataDecoracao.excluir(decoracaoRemover)) {
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
