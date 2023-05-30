package data;

import models.Usuario;

public class IniciarODB {
    public static void adicionarCredenciais(){
        Usuario usuario = new Usuario();
        usuario.setUsuario("Master");
        usuario.setSenha("master");
        usuario.setCargo("master");
        System.out.println("Credenciais incluidas: "+DataLogin.incluir(usuario));
    }
}
