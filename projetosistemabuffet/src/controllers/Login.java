package controllers;

import data.CredenciaisLogin;
import models.Usuario;
import util.Console;
import views.MenuCozinheiro;
import views.MenuGerente;
import views.MenuMaster;
import views.MenuVendedor;

public class Login {
    public static void fazerLogin() {
		int logado=0;
		do {
            CredenciaisLogin.adicionarCredenciais();
			Usuario usuario= new Usuario();
			usuario.setUsuario(Console.readString("Usuario: "));
            usuario.setSenha(Console.readString("Senha: "));
			if(CredenciaisLogin.verificarUsuario(usuario.getUsuario())=="encontrado") {
				if(CredenciaisLogin.verificarSenha(usuario.getSenha())=="encontrado") {
					usuario = CredenciaisLogin.retornarUsuario(usuario);
					System.out.println("Login realizado com sucesso");
					logado=1;

                    switch (usuario.getCargo()) {
						case "vendedor":
							MenuVendedor.exibirMenuVendedor();
							break;
						case "cozinheiro":
							MenuCozinheiro.exibirMenuCozinheiro();
							break;
						case "gerente":
							MenuGerente.exibirMenuGerente(usuario);
							break;
						case "mestre":
							MenuMaster.exibirMenuMaster();
							break;
						default:
							System.out.println("Cargo desconhecido.");
							break;
					}
				}else {
					System.out.println("Senha incorreta.");
				}
			}else {
				System.out.println("Usuario incorreto.");
			}
		}while(logado!=1);

	}
}