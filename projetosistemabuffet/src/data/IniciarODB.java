package data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import models.Usuario;

public class IniciarODB {
    public static boolean adicionarCredenciais() {
        if (verificarDBIniciado() == false) {
            Usuario usuario = new Usuario();
            usuario.setUsuario("Master");
            usuario.setSenha("master");
            usuario.setCargo("master");
            if (DataLogin.incluir(usuario)) {
                return true;
            }
        }
        return false;
    }

    public static boolean verificarDBIniciado() {
        EntityManager manager = EntityManagerFactory.getInstance();
        Query consulta = manager.createQuery("from Usuario where cargo = 'master'");
        List<Usuario> usuarioMaster = consulta.getResultList();
        if (usuarioMaster.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
}
