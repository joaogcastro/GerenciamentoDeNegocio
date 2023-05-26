package controllers;

import data.LoginData;
import models.Usuario;
import util.Console;
import views.MenuCozinheiro;
import views.MenuGerente;
import views.MenuMaster;
import views.MenuVendedor;

public class Login {
    public static void fazerLogin() {
		boolean logado=false;
		do {
			Usuario usuario= new Usuario();
			usuario.setUsuario(Console.readString("Usuario: "));
            usuario.setSenha(Console.readString("Senha: "));
			if(LoginData.autenticarLogin(usuario)==true) {
				usuario = LoginData.retornUsuario(usuario);
				System.out.println("Login realizado com sucesso");
				logado=true;
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
					case "master":
						MenuMaster.exibirMenuMaster();
						break;
					default:
						System.out.println("Cargo desconhecido.");
						break;
				}
			}else {
				System.out.println("Usuario incorreto.");
			}
		}while(logado==false);

	}
}