package views;

import data.DataFornecedor;
import models.Fornecedor;
import util.CNPJUtils;
import util.Console;
import util.TelefoneUtils;

public class ComprasFornecedor {

    public static void crudMenuFornecedor() {

        Fornecedor fornecedor;
        int opc;
        do {
            System.out.println("/nAlterar dados dos fornecedores:");
            System.out.println("1 - Listar fornecedores.");
            System.out.println("2 - Alterar fornecedores.");
            System.out.println("3 - excluir fornecedores.");
            System.out.println("4 - Sair.");

            opc = Console.readInt("Informe a opção.");
            switch (opc) {
                case 1:

                    System.out.println("Lista de fornecedores:");

                case 2:

                    System.out.println("\nAlterar o cadastro de um cliente: ");
                    fornecedor = new Fornecedor();
                    int opcAlterar;
                    boolean alterado = false;
                    fornecedor.setCnpj(null);
                    fornecedor.setCnpj(Console.readString("Informe o cpf do cliente que será alterado: "));
                    fornecedor = DataFornecedor.buscarCNPJ(fornecedor);
                    if (fornecedor != null) {
                        System.out.println("Alterando o fornecedor " + fornecedor.getNome());
                        System.out.println("1- Alterar nome\n2- Alterar CNPJ\n3- Alterar telefone");
                        opcAlterar = Console.readInt("Informe a opção: ");
                        switch (opcAlterar) {
                            case 1:

                                fornecedor.setNome(Console.readString("Informe o novo nome para este fornecedor: "));
                                alterado = true;
                                break;
                            case 2:

                                String novoCnpj = (Console.readString("Informe o novo cnpj para este cliente: "));
                                if (CNPJUtils.validarCNPJ(fornecedor.getCnpj()) == true) {
                                    if (DataFornecedor.buscarCNPJ(novoCnpj) == null) {
                                        String cnpjFormatado = CNPJUtils.formatarCNPJ(fornecedor.getCnpj());
                                        fornecedor.setCnpj(cnpjFormatado);
                                        alterado = true;
                                    } else {
                                        System.out.println("CNPJ ja cadastrado.");
                                    }
                                } else {
                                    System.out.println(
                                            "\nO cpf digitado não é válido. Cancelando a operação de alteração.");
                                }
                                break;
                            case 3:

                                fornecedor.setTelefone(
                                        Console.readString("Informe o novo telefone para este fornecedor: "));
                                String telefoneFormatado = TelefoneUtils.formatarTelefone(fornecedor.getTelefone());
                                fornecedor.setTelefone(telefoneFormatado);
                                alterado = true;
                                break;

                            default:
                                System.out.println("Opção não listada, voltando ao menu.");
                                break;
                        }

                        if (alterado == true) {
                            if (DataFornecedor.alterar(fornecedor)) {
                                System.out.println("\nFornecedor " + fornecedor.getNome() + " alterado com sucesso.");
                            } else {
                                System.out.println("\nHouve um erro ao alterar o Fornecedor.");
                            }
                        } else {
                            System.out.println("\nOperação cancelada, não houveram alterações.");
                        }

                    } else {
                        System.out.println("\nEste fornecedor não existe no banco de dados.");
                    }
                    break;

                case 3:
                    System.out.println("\nExcluir credencial de login: ");
                    fornecedor = new Fornecedor();
                    fornecedor.setId(Console.readInt("Id do fornecedor que será excluído: "));
                    fornecedor = DataFornecedor.buscarCNPJ(fornecedor);
                    // FAZER ID FORNECEDOR//

                    if (fornecedor != null) {
                        if (DataFornecedor.excluir(fornecedor) == true) {
                            System.out.println("\nUsuário " + fornecedor.getNome() + " excluído com sucesso.");
                        } else {
                            System.out.println("\nHouve um erro ao excluir o usuário.");
                        }
                    } else {
                        System.out.println("\nEste usuário não existe no banco de dados.");
                    }
                    break;

                case 4:
                    System.out.println("saindo.");
                    break;
            }

        } while (opc != 4);

    }

}
