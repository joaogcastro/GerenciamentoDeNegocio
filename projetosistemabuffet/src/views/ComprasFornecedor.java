package views;

import data.DataFornecedor;
import models.Fornecedor;
import util.Console;

public class ComprasFornecedor {

    public static void gerenciarFornecedores() {
        int opcFornecedor;
        do {
            System.out.println("\nMenu Gerenciar Fornecedores:");
            System.out.println("1- Listar fornecedores.");
            System.out.println("2- Adicionar fornecedor.");
            System.out.println("3- Alterar fornecedor.");
            System.out.println("4- Remover fornecedor.");
            System.out.println("5- Voltar ao menu anterior.");
            opcFornecedor = Console.readInt("Informe a opção: ");

            switch (opcFornecedor) {
                case 1:
                    System.out.println("\nListar fornecedores:");
                    DataFornecedor.listarFornecedores();
                    break;

                case 2:
                    System.out.println("\nAdicionar fornecedor:");
                    String nome = Console.readString("Informe o nome do fornecedor: ");
                    String telefone = Console.readString("Informe o telefone do fornecedor: ");
                    String cnpj = Console.readString("Informe o CNPJ do fornecedor: ");

                    Fornecedor novoFornecedor = new Fornecedor();
                    novoFornecedor.setNome(nome);
                    novoFornecedor.setTelefone(telefone);
                    novoFornecedor.setCnpj(cnpj);

                    if (DataFornecedor.incluir(novoFornecedor)) {
                        System.out.println("Fornecedor adicionado com sucesso.");
                    } else {
                        System.out.println("Erro ao adicionar fornecedor.");
                    }
                    break;

                case 3:
                    System.out.println("\nAlterar fornecedor:");
                    int id = Console.readInt("Informe o ID do fornecedor a ser alterado: ");
                    Fornecedor fornecedor = DataFornecedor.buscarFornecedorPorId(id);

                    if (fornecedor != null) {
                        String nomeAlterar = Console.readString("Informe o novo nome do fornecedor: ");
                        String telefoneAlterar = Console.readString("Informe o novo telefone do fornecedor: ");
                        String cnpjAlterar = Console.readString("Informe o novo CNPJ do fornecedor: ");

                        fornecedor.setNome(nomeAlterar);
                        fornecedor.setTelefone(telefoneAlterar);
                        fornecedor.setCnpj(cnpjAlterar);

                        if (DataFornecedor.alterar(fornecedor)) {
                            System.out.println("Fornecedor alterado com sucesso.");
                        } else {
                            System.out.println("Erro ao alterar fornecedor.");
                        }
                    } else {
                        System.out.println("Fornecedor não encontrado.");
                    }
                    break;

                case 4:
                    System.out.println("\nRemover fornecedor:");
                    int idRemover = Console.readInt("Informe o ID do fornecedor a ser removido: ");
                    Fornecedor fornecedorRemover = DataFornecedor.buscarFornecedorPorId(idRemover);

                    if (fornecedorRemover != null) {
                        if (DataFornecedor.excluir(fornecedorRemover)) {
                            System.out.println("Fornecedor removido com sucesso.");
                        } else {
                            System.out.println("Erro ao remover fornecedor.");
                        }
                    } else {
                        System.out.println("Fornecedor não encontrado.");
                    }
                    break;

                case 5:
                    System.out.println("Voltando ao menu anterior.");
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (opcFornecedor != 5);
    }
}