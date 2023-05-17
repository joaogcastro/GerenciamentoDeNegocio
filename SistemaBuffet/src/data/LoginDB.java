package data;

import java.util.ArrayList;

import entidades.Usuario;

public class LoginDB {
	private static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	
	public static String verificarUsuario (String usuario) {
		for(Usuario item: usuarios) {
			if(item.getUsuario().equalsIgnoreCase(item.getUsuario())) {
				return "encontrado";
			}
		}
		return "nao encontrado";
	}
	
	public static String verificarSenha (String senha) {
		for(Usuario item: usuarios) {
			if(item.getSenha().equalsIgnoreCase(item.getSenha())) {
				return "encontrado";
			}
		}
		return "nao encontrado";
	}
	
	public static Usuario retornarUsuario (Usuario usuario) {
		for(Usuario item: usuarios) {
			if(item.getSenha().equalsIgnoreCase(item.getSenha()) && item.getUsuario().equalsIgnoreCase(item.getUsuario())) {
				return item;
			}
		}
		return null;
	}
}
