package controllers;

import data.DataLogin;
import models.Usuario;
import util.Console;
import views.ComprasMenu;
import views.CozinheiroMenu;
import views.GerenteMenu;
import views.MasterMenu;
import views.VendedorMenu;

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
						VendedorMenu.exibirMenuVendedor();
						break;
					case "cozinheiro":
						CozinheiroMenu.exibirMenuCozinheiro();
						break;
					case "gerente":
						GerenteMenu.exibirMenuGerente();
						break;
					case "master":
						MasterMenu.exibirMenuMaster();
						break;
					case "compras":
						ComprasMenu.exibirMenuCompras();
						break;
					default:
						System.out.println("Erro: Cargo desconhecido. Informe ao administrador do sistema.");
						break;
				}
			} else {
				System.out.println("Usuario ou senha incorretos.");
			}
		} while (logado == false);
	}
}