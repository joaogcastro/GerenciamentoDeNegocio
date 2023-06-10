package views;

import data.DataCliente;
import models.Cliente;
import util.Console;
import util.TelefoneUtils;
import util.CPFUtils;

public class VendedorCliente {
    
    public static void crudCliente() {
        Cliente cliente;
        int opc;
        do {
            System.out.println(
                    "\nAlterar dados do cliente:\n1- Clientes cadastrados no banco\n2- Adicionar novo cliente\n3- Alterar Cliente\n4- Excluir cliente\n5- Voltar ao menu.");
            opc = Console.readInt("Informe a opção:");
            switch (opc) {
                case 1:
                    System.out.println("\nClientes cadastrados no banco:");
                    DataCliente.listarClientesNoBanco();
                    break;
                case 2:
                    System.out.println("\nAdicionar novo cliente:");
                    cliente = new Cliente();
                    cliente.setCpf(Console.readString("Informe o cpf do cliente: "));
                    if (CPFUtils.validarCPF(cliente.getCpf()) == true) {
                        if (DataCliente.buscarCPF(cliente) == null) {
                            cliente.setNome(Console.readString("Nome do cliente: "));
                            cliente.setTelefone(Console.readString("Informe o telefone do cliente: "));
                            cliente.setEmail(Console.readString("Informe o email do cliente: "));
                            cliente.setEndereco(Console.readString("Informe o endereço do cliente: "));
                            // Formatando no padrão do banco
                            String cpfFormatado = CPFUtils.formatarCPF(cliente.getCpf());
                            cliente.setCpf(cpfFormatado);
                            String telefoneFormatado = TelefoneUtils.formatarTelefone(cliente.getTelefone());
                            cliente.setTelefone(telefoneFormatado);
                            if (DataCliente.incluir(cliente) == true) {
                                System.out.println("\nCliente " + cliente.getNome() + " cadastrado com sucesso.\n");
                            } else {
                                System.out.println("\nHouve um erro ao adicionar o cliente.");
                            }
                        } else {
                            System.out.println("\nEsse cliente já está cadastrado no banco de dados.");
                        }
                    } else {
                        System.out.println("\nO CPF digitado não é válido");
                    }
                    break;

                case 3:
                    System.out.println("\nAlterar o cadastro de um cliente: ");
                    cliente = new Cliente();
                    int opcAlterar;
                    boolean alterado = false;
                    cliente.setCpf(Console.readString("Informe o cpf do cliente que será alterado: "));
                    cliente = DataCliente.buscarCPF(cliente);
                    if (cliente != null) {
                        System.out.println("Alterando o cliente " + cliente.getNome());
                        System.out.println(
                                "1- Alterar nome\n2- Alterar CPF\n3- Alterar telefone\n4- Alterar email\n5- Alterar endereço");
                        opcAlterar = Console.readInt("Informe a opção: ");
                        switch (opcAlterar) {
                            case 1:
                                cliente.setNome(Console.readString("Informe o novo nome para este cliente: "));
                                alterado = true;
                                break;
                            case 2:
                                cliente.setCpf(Console.readString("Informe o novo cpf para este cliente: "));
                                if (CPFUtils.validarCPF(cliente.getCpf()) == true) {
                                    String cpfFormatado = CPFUtils.formatarCPF(cliente.getCpf());
                                    cliente.setCpf(cpfFormatado);
                                    alterado = true;
                                } else {
                                    System.out.println("\nO cpf digitado não é válido.");
                                }
                                break;
                            case 3:
                                cliente.setTelefone(Console.readString("Informe o novo telefone para este cliente: "));
                                String telefoneFormatado = TelefoneUtils.formatarTelefone(cliente.getTelefone());
                                cliente.setTelefone(telefoneFormatado);
                                alterado = true;
                                break;
                            case 4:
                                cliente.setEndereco(
                                        Console.readString("Informe o novo endereço de email deste cliente: "));
                                alterado = true;
                                break;
                            case 5:
                                cliente.setEndereco(Console.readString("Informe o novo endereço deste cliente: "));
                                alterado = true;
                                break;
                            default:
                                System.out.println("Opção não listada, voltando ao menu.");
                                break;
                        }

                        if (alterado == true) {
                            if (DataCliente.alterar(cliente)) {
                                System.out.println("\nCliente " + cliente.getNome() + " alterado com sucesso.");
                            } else {
                                System.out.println("\nHouve um erro ao alterar o cliente.");
                            }
                        } else {
                            System.out.println("\nOperação cancelada, não houveram alterações.");
                        }

                    } else {
                        System.out.println("\nEste cliente não existe no banco de dados.");
                    }
                    break;

                case 4:
                    System.out.println("\nExcluir cliente: ");
                    cliente = new Cliente();
                    cliente.setCpf(Console.readString("Informe o cpf do cliente que será excluído: "));
                    cliente = DataCliente.buscarCPF(cliente);
                    if (cliente != null) {
                        if (DataCliente.excluir(cliente) == true) {
                            System.out.println("\nCliente " + cliente.getNome() + " excluido com sucesso.");
                        } else {
                            System.out.println("\nHouve um erro ao excluir o cliente.");
                        }
                    } else {
                        System.out.println("\nEste cliente não existe no banco de dados.");
                    }
                    break;

                case 5:
                    System.out.println("\nVoltando ao menu.\n");
                    break;

                default:
                    System.out.println("\nA opção selecionada não é válida.");
            }
        } while (opc != 5);
    }

    public static void contatarClientes() {
        int opc;
        do {
            System.out.println("\n1- Exibir todos os clientes.\n2- Procurar um cliente específico\n3- Voltar ao menu.");
            opc = Console.readInt("Informe a opção: ");
            switch (opc) {
                case 1:
                    System.out.println("\nLista de clientes:");
                    DataCliente.listarContatoClientes();
                    break;
                case 2:
                    System.out.println("\nBuscar um cliente por nome:");
                    String nomeCliente = Console.readString("Informe o nome do cliente: ");
                    DataCliente.buscarNomeCliente(nomeCliente);
                    break;
                case 3:
                    System.out.println("\nVoltando ao menu.\n");
            }
        } while (opc != 3);
    }
}