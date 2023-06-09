package views;

import data.DataLogin;
import models.Usuario;
import util.Console;

public class MasterCredenciaisLogin {
    public static void crudCredenciaisLogin() {
        int opc;
        Usuario usuario;
        do {
            System.out.println(
                    "\nGerenciar credenciais de login do banco:\n1- Exibir as credenciais de login existentes no banco.\n2- Adicionar nova credencial de login.\n3- Alterar uma credencial de login existente\n4- Excluir uma crendecial de login\n5- Voltar ao menu.");
            opc = Console.readInt("Informe a opção: ");

            switch (opc) {
                case 1:
                    System.out.println("\nCrendenciais de login do sistema:");
                    DataLogin.listarUsuario();
                    break;
                case 2:
                    System.out.println("\nAdicionar credencial de login: ");
                    usuario = new Usuario();
                    usuario.setCargo(Console
                            .readString("Qual será o cargo deste login? (gerente, vendedor, cozinheiro ou compras): "));
                    if (usuario.getCargo().equalsIgnoreCase("master")) {
                        System.out.println("Você não tem permissão para adicionar mais um login dessa categoria.");
                    } else {
                        usuario.setUsuario(Console.readString("Digite o login: "));
                        if (DataLogin.buscarUsuario(usuario) == null) {
                            usuario.setSenha(Console.readString("Digite a senha: "));
                            if (DataLogin.incluir(usuario) == true) {
                                System.out.println("\nUsuario " + usuario.getUsuario() + " cadastrado com sucesso.");
                            } else {
                                System.out.println("\nHouve um erro ao adicionar o cliente.");
                            }
                        } else {
                            System.out.println("\nEste nome de usuário já está em uso.");
                        }
                    }
                    break;
                case 3:
                    System.out.println("\nAlterar credencial de login: ");
                    usuario = new Usuario();
                    int opcAlterar;
                    boolean alterado = false;
                    usuario.setId(Console.readInt("Id do usuario que será alterado: "));
                    usuario = DataLogin.buscarID(usuario);
                    if (usuario != null) {
                        System.out.println("\nAlterar usuário " + usuario.getUsuario() + ": ");
                        System.out.println("1- Nome de usuário.\n2- Senha.\n3- Cargo");
                        opcAlterar = Console.readInt("Informe a opção: ");
                        switch (opcAlterar) {
                            case 1:
                                String novoUsuario = Console.readString("Novo usuário: ");
                                if (DataLogin.buscarUsuario(novoUsuario) == null) {
                                    usuario.setUsuario(novoUsuario);
                                    alterado = true;
                                } else {
                                    System.out.println("\nEste nome de usuário já está em uso.");
                                    alterado = false;
                                }
                                break;
                            case 2:
                                usuario.setSenha(Console.readString("Nova senha: "));
                                alterado = true;
                                break;
                            case 3:
                                usuario.setCargo(Console.readString("Novo cargo: "));
                                if (usuario.getCargo().equalsIgnoreCase("master")) {
                                    System.out.println(
                                            "\nVocê não tem permissão para adicionar outro login com este cargo.");
                                    alterado = false;
                                } else {
                                    alterado = true;
                                }
                                break;
                            default:
                                System.out.println("\nOpção não listada, voltando ao menu.");
                                break;
                        }

                        if (alterado == true) {
                            if (DataLogin.alterar(usuario) == true) {
                                System.out.println("Usuário " + usuario.getUsuario() + " alterado com sucesso.");
                            } else {
                                System.out.println("\nHouve um erro ao alterar o usuário.");
                            }
                        } else {
                            System.out.println("\nOperação cancelada, não houveram alterações.");
                        }
                    } else {
                        System.out.println("\nUsuário não encontrado.");
                    }
                    break;
                case 4:
                    System.out.println("\nExcluir credencial de login: ");
                    usuario = new Usuario();
                    usuario.setId(Console.readInt("Id do usuario que será excluído: "));
                    usuario = DataLogin.buscarID(usuario);
                    if (usuario != null) {
                        if (DataLogin.excluir(usuario) == true) {
                            System.out.println("\nUsuário " + usuario.getUsuario() + " excluído com sucesso.");
                        } else {
                            System.out.println("\nHouve um erro ao excluir o usuário.");
                        }
                    } else {
                        System.out.println("\nEste usuário não existe no banco de dados.");
                    }
                    break;
                case 5:
                    System.out.println("\nVoltando ao menu master.\n");
                    break;
                default:
                    System.out.println("Essa opção não é válida.");
                    break;
            }
        } while (opc != 5);
    }
}