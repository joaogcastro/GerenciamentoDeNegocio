package controllers;

import data.DataLogin;
import models.Usuario;
import util.Console;
import views.MenuCompras;
import views.MenuCozinheiro;
import views.MenuGerente;
import views.MenuMaster;
import views.MenuVendedor;

public class Login {
	public static void fazerLogin() {
		boolean logado = false;
		do {
			Usuario usuario = new Usuario();
			usuario.setUsuario(Console.readString("\nUsuario: "));
			usuario.setSenha(Console.readString("Senha: "));
			if (DataLogin.autenticarLogin(usuario) == true) {
				usuario = DataLogin.buscarUsuario(usuario);
				System.out.println("Login realizado com sucesso");
				logado = true;
				switch (usuario.getCargo()) {
					case "vendedor":
						MenuVendedor.exibirMenuVendedor();
						break;
					case "cozinheiro":
						MenuCozinheiro.exibirMenuCozinheiro();
						break;
					case "gerente":
						MenuGerente.exibirMenuGerente();
						break;
					case "master":
						MenuMaster.exibirMenuMaster();
						break;
					case "compras":
						MenuCompras.exibirMenuCompras();
						break;
					default:
						System.out.println("Cargo desconhecido.");
						break;
				}
			} else {
				System.out.println("Usuario ou senha incorretos.");
			}
		} while (logado == false);

	}
}