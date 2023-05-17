package front;

import data.LoginDB;
import entidades.Usuario;

public class Login {
	
	public static void fazerLogin() {
		int logado=0;
		do {
			Usuario usuario= new Usuario();
			System.out.println("===========================");
			usuario.setUsuario(Console.readString("Usuario: "));
			if(LoginDB.verificarUsuario(usuario.getUsuario())=="encontrado") {
				usuario.setSenha(Console.readString("Senha: "));
				if(LoginDB.verificarSenha(usuario.getSenha())=="encontrado") {
					usuario= LoginDB.retornarUsuario(usuario);
					System.out.println("Login realizado com sucesso");
					logado=1;
				}else {
					System.out.println("Senha incorreta.");
				}
			}else {
				System.out.println("Usuario incorreto.");
			}
		}while(logado!=1);

	}
}