package data;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
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
        TypedQuery<Usuario> consulta = manager.createQuery("select u from Usuario u where u.cargo = 'master'",
                Usuario.class);
        List<Usuario> usuarioMaster = consulta.getResultList();
        return !usuarioMaster.isEmpty();
    }

}