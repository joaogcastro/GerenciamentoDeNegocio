package views;

import data.DataFornecedor;
import models.Fornecedor;
import util.CNPJUtils;
import util.Console;
import util.TelefoneUtils;

public class ComprasFornecedor {

    public static void gerenciarFornecedores() {
        Fornecedor fornecedor;
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
                    fornecedor = new Fornecedor();
                    fornecedor.setCnpj(Console.readString("Informe o CNPJ do fornecedor: "));
                    if (CNPJUtils.validarCNPJ(fornecedor.getCnpj())) {
                        if (DataFornecedor.buscarCNPJ(fornecedor) == null) {
                            fornecedor.setNome(Console.readString("Informe o nome do fornecedor: "));
                            fornecedor.setTelefone(Console.readString("Informe o telefone do fornecedor: "));
                            
                            //Formatar no padrao do banco
                            String cnpjFormatado = CNPJUtils.formatarCNPJ(fornecedor.getCnpj());
                            fornecedor.setCnpj(cnpjFormatado);
                            String telefoneFormatado = TelefoneUtils.formatarTelefone(fornecedor.getTelefone());
                            fornecedor.setTelefone(telefoneFormatado);

                            if (DataFornecedor.incluir(fornecedor)) {
                                System.out.println("Fornecedor adicionado com sucesso.");
                            } else {
                                System.out.println("Erro ao adicionar fornecedor.");
                            }

                        } else {
                            System.out.println("Este fornecedor já está cadastrado.");
                        }
                    } else {
                        System.out.println("CNPJ inválido.");
                    }
                    break;

                case 3:
                    System.out.println("\nAlterar fornecedor:");
                    fornecedor = DataFornecedor.buscarFornecedorPorId(Console.readInt("Informe o ID do fornecedor a ser alterado: "));

                    if (fornecedor != null) {
                        fornecedor.setNome(Console.readString("Informe o novo nome do fornecedor: "));
                        fornecedor.setTelefone(Console.readString("Informe o novo telefone do fornecedor: "));
                        fornecedor.setCnpj(Console.readString("Informe o novo CNPJ do fornecedor: "));

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
                    fornecedor= DataFornecedor.buscarFornecedorPorId(Console.readInt("Informe o ID do fornecedor a ser removido: "));
                    if (fornecedor != null) {
                        if (DataFornecedor.excluir(fornecedor)) {
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