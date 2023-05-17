package data;

import java.util.ArrayList;

import models.Usuario;

public class CredenciaisLogin {
    private static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

    public static void adicionarCredenciais(){
        Usuario usuario= new Usuario();
        usuario.setUsuario("Gerente");
        usuario.setSenha("1234");
        usuario.setCargo("gerente");
        usuarios.add(usuario);
        usuario=null;
    }
	
	public static String verificarUsuario (String usuario) {
		for(Usuario item: usuarios) {
			if(item.getUsuario().equalsIgnoreCase(usuario)) {
				return "encontrado";
			}
		}
		return "nao encontrado";
	}
	
	public static String verificarSenha (String senha) {
		for(Usuario item: usuarios) {
			if(item.getSenha().equalsIgnoreCase(senha)) {
				return "encontrado";
			}
		}
		return "nao encontrado";
	}
	
	public static Usuario retornarUsuario (Usuario usuario) {
		for(Usuario item: usuarios) {
			if(item.getSenha().equalsIgnoreCase(usuario.getSenha()) && item.getUsuario().equalsIgnoreCase(usuario.getUsuario())) {
				return item;
			}
		}
		return null;
	}
}
