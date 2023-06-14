package views;

import data.DataFuncionario;
import models.Funcionario;
import util.BooleanUtils;
import util.CPFUtils;
import util.Console;
import util.TelefoneUtils;

public class GerenteFuncionario {

    public static void crudFuncionario() {
        Funcionario funcionario;
        int opc;
        int opcAlterar;
        boolean alterado;

        do {
            System.out.println("\nGerenciar funcionários:");
            System.out.println("1- Exibir funcionários cadastrados.");
            System.out.println("2- Adicionar novo funcionáro.");
            System.out.println("3- Alterar funcionário CLT.");
            System.out.println("4- Alterar funcionário taxa.");
            System.out.println("5- Excluir funcionário.");
            System.out.println("6- Voltar ao menu.");
            opc = Console.readInt("Informe a opção: ");

            switch (opc) {
                case 1:
                    contatarFuncionarios();
                    break;

                case 2:
                    System.out.println("\nAdicionar novo funcionário:");
                    funcionario = new Funcionario();
                    funcionario.setCpf(Console.readString("Informe o CPF do funcionário: "));
                    if (CPFUtils.validarCPF(funcionario.getCpf()) == true) {
                        if (DataFuncionario.buscarCPF(funcionario) == null) {

                            funcionario.setNome(Console.readString("Informe o nome do funcionário: "));
                            funcionario.setTelefone(Console.readString("Informe o telefone do funcionário: "));

                            System.out.println("O funcionário será CLT?");
                            funcionario.setClt(BooleanUtils.formatarSimNao());
                            if (funcionario.isClt()) {

                                funcionario.setFuncao(Console.readString("Informe a função do funcionário: "));
                                funcionario.setSalario(
                                        Console.readDouble("Informe o salário combinado para este funcionário: R$"));

                            } else {
                                System.out.println("O funcionário é garçom ?");
                                funcionario.setGarcom(BooleanUtils.formatarSimNao());
                                System.out.println("O funcionário é monitor ?");
                                funcionario.setMonitor(BooleanUtils.formatarSimNao());
                                funcionario.setValorHora(
                                        Console.readDouble("Informe o valor da hora desse funcionário: "));
                            }

                            // Formatando no padrao do banco
                            String cpfFormatado = CPFUtils.formatarCPF(funcionario.getCpf());
                            funcionario.setCpf(cpfFormatado);
                            String telefoneFormatado = TelefoneUtils.formatarTelefone(funcionario.getTelefone());
                            funcionario.setTelefone(telefoneFormatado);

                            if (DataFuncionario.incluir(funcionario)) {
                                System.out.println(
                                        "\nFuncionario " + funcionario.getNome() + " cadastrado com sucesso.\n");
                            } else {
                                System.out.println("\nHouve um erro ao adicionar o funcionário.");
                            }

                        } else {
                            System.out.println("\nEsse funcionário já está cadastrado no banco de dados.");
                        }

                    } else {
                        System.out.println("\nO CPF digitado não é válido");
                    }
                    break;

                case 3:
                    System.out.println("\nAlterar o cadastro de um funcionário CLT: ");
                    funcionario = new Funcionario();
                    opcAlterar = 0;
                    alterado = false;
                    
                    funcionario.setCpf(Console.readString("Informe o cpf do funcionário que será alterado: "));
                    funcionario = DataFuncionario.buscarCPF(funcionario);
                    if (funcionario != null) {
                        if (funcionario.isClt()) {
                            System.out.println("Alterando o funcionário " + funcionario.getNome());
                            System.out.println(
                                    "1- Alterar nome\n2- Alterar CPF\n3- Alterar telefone\n4- Alterar função\n5- Alterar salário");
                            opcAlterar = Console.readInt("Informe a opção: ");

                            switch (opcAlterar) {
                                case 1:
                                    funcionario
                                            .setNome(Console.readString("Informe o novo nome para este funcionário: "));
                                    alterado = true;
                                    break;

                                case 2:
                                    funcionario
                                            .setCpf(Console.readString("Informe o novo cpf para este funcionário: "));
                                    if (CPFUtils.validarCPF(funcionario.getCpf()) == true) {
                                        if (DataFuncionario.buscarCPF(funcionario) == null) {
                                            String cpfFormatado = CPFUtils.formatarCPF(funcionario.getCpf());
                                            funcionario.setCpf(cpfFormatado);
                                            alterado = true;
                                        } else {
                                            System.out.println("\nEsse CPF já está cadastrado no banco de dados.");
                                        }
                                    } else {
                                        System.out.println("\nO cpf digitado não é válido.");
                                    }
                                    break;

                                case 3:
                                    funcionario.setTelefone(
                                            Console.readString("Informe o novo telefone para este funcionário: "));
                                    String telefoneFormatado = TelefoneUtils
                                            .formatarTelefone(funcionario.getTelefone());
                                    funcionario.setTelefone(telefoneFormatado);
                                    alterado = true;
                                    break;

                                case 4:
                                    funcionario
                                            .setFuncao(Console.readString("Informe a nova função deste funcionário: "));
                                    alterado = true;
                                    break;

                                case 5:
                                    funcionario.setSalario(
                                            Console.readDouble("Informe o novo salário deste funcionário: R$"));
                                    alterado = true;
                                    break;

                                default:
                                    System.out.println("Opção não listada, voltando ao menu.");
                                    break;
                            }

                            if (alterado == true) {
                                if (DataFuncionario.alterar(funcionario)) {
                                    System.out.println(
                                            "\nFuncionário " + funcionario.getNome() + " alterado com sucesso.");
                                } else {
                                    System.out.println("\nHouve um erro ao alterar o funcionário.");
                                }
                            } else {
                                System.out.println("\nOperação cancelada, não houveram alterações.");
                            }

                        } else {
                            System.out.println(
                                    "\nEste funcionário não é CLT. Portanto não pode ser alterado neste menu.");
                        }
                    } else {
                        System.out.println("\nEste funcionário não existe no banco de dados.");
                    }
                    break;

                case 4:
                    System.out.println("\nAlterar o cadastro de um funcionário taxa: ");
                    funcionario = new Funcionario();
                    opcAlterar = 0;
                    alterado = false;
                    funcionario.setCpf(Console.readString("Informe o cpf do funcionário que será alterado: "));
                    funcionario = DataFuncionario.buscarCPF(funcionario);
                    if (funcionario != null) {
                        if (!funcionario.isClt()) {
                            System.out.println("Alterando o funcionário " + funcionario.getNome());
                            System.out.println(
                                    "1- Alterar nome\n2- Alterar CPF\n3- Alterar telefone\n4- Alterar se é garçom\n5- Alterar se é monitor\n6- Alterar o valor da hora.");
                            opcAlterar = Console.readInt("Informe a opção: ");

                            switch (opcAlterar) {
                                case 1:
                                    funcionario
                                            .setNome(Console.readString("Informe o novo nome para este funcionário: "));
                                    alterado = true;
                                    break;

                                case 2:
                                    funcionario
                                            .setCpf(Console.readString("Informe o novo cpf para este funcionário: "));
                                    if (CPFUtils.validarCPF(funcionario.getCpf()) == true) {
                                        if (DataFuncionario.buscarCPF(funcionario) == null) {
                                            String cpfFormatado = CPFUtils.formatarCPF(funcionario.getCpf());
                                            funcionario.setCpf(cpfFormatado);
                                            alterado = true;
                                        } else {
                                            System.out.println("\nEsse CPF já está cadastrado no banco de dados.");
                                        }
                                    } else {
                                        System.out.println("\nO cpf digitado não é válido.");
                                    }
                                    break;

                                case 3:
                                    funcionario.setTelefone(
                                            Console.readString("Informe o novo telefone para este funcionário: "));
                                    String telefoneFormatado = TelefoneUtils
                                            .formatarTelefone(funcionario.getTelefone());
                                    funcionario.setTelefone(telefoneFormatado);
                                    alterado = true;
                                    break;

                                case 4:
                                    System.out.println("Informe se esse funcionário é garçom: ");
                                    funcionario.setGarcom(BooleanUtils.formatarSimNao());
                                    ;
                                    alterado = true;
                                    break;

                                case 5:
                                    System.out.println("Informe se esse funcionário é monitor: ");
                                    funcionario.setMonitor(BooleanUtils.formatarSimNao());
                                    alterado = true;
                                    break;

                                case 6:
                                    funcionario.setValorHora(
                                            Console.readDouble("Informe o novo valor da hora deste funcionário: R$"));
                                    alterado = true;
                                    break;

                                default:
                                    System.out.println("Opção não listada, voltando ao menu.");
                                    break;
                            }

                            if (alterado == true) {
                                if (DataFuncionario.alterar(funcionario)) {
                                    System.out.println(
                                            "\nFuncionário " + funcionario.getNome() + " alterado com sucesso.");
                                } else {
                                    System.out.println("\nHouve um erro ao alterar o funcionário.");
                                }
                            } else {
                                System.out.println("\nOperação cancelada, não houveram alterações.");
                            }

                        } else {
                            System.out.println("\nEste funcionário é CLT. Portanto não pode ser alterado neste menu");
                        }
                    } else {
                        System.out.println("\nEste funcionário não existe no banco de dados.");
                    }
                    break;

                case 5:
                    System.out.println("\nExcluir funcionário: ");
                    funcionario = new Funcionario();
                    funcionario.setCpf(Console.readString("Informe o cpf do funcionário que será excluído: "));
                    funcionario = DataFuncionario.buscarCPF(funcionario);
                    if (funcionario != null) {
                        if (DataFuncionario.excluir(funcionario) == true) {
                            System.out.println("\nFuncionário " + funcionario.getNome() + " excluido com sucesso.");
                        } else {
                            System.out.println("\nHouve um erro ao excluir o funcionário.");
                        }
                    } else {
                        System.out.println("\nEste funcionário não existe no banco de dados.");
                    }
                    break;

                case 6:
                    System.out.println("\nVoltando ao menu.\n");
                    break;

                default:
                    System.out.println("\nA opção selecionada não é válida.");
                    break;

            }
        } while (opc != 6);
    }

    private static void contatarFuncionarios() {
        int opc;
        do {
            System.out.println("\nFuncionários cadastrados do banco:");
            System.out.println("1- Exibir todos os funcionários CLT.");
            System.out.println("2- Exibir todos os funcionários taxa.");
            System.out.println("3- Pesquisar um funcionário pelo nome.");
            System.out.println("4- Voltar ao menu.");
            opc = Console.readInt("Informe a opção: ");

            switch (opc) {
                case 1:
                    System.out.println("\nLista de funcionários CLT:");
                    DataFuncionario.listarFuncionariosCLT();
                    break;

                case 2:
                    System.out.println("\nLista de funcionários taxa:");
                    DataFuncionario.listarFuncionariosTaxa();
                    break;

                case 3:
                    System.out.println("\nBuscar um funcionário por nome:");
                    String nomeFuncionario = Console.readString("Informe o nome do funcionário: ");
                    DataFuncionario.buscarNomeFuncionario(nomeFuncionario);
                    break;

                case 4:
                    System.out.println("\nVoltando ao menu.\n");
                    break;

                default:
                    System.out.println("\nA opção selecionada não é válida.");
                    break;
            }
        } while (opc != 4);
    }
}
