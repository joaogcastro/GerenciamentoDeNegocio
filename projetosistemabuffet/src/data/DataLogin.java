package data;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import models.Usuario;

public class DataLogin {

	public static boolean incluir(Usuario usuario) {
		try {
			EntityManager manager = EntityManagerFactory.getInstance();
			manager.getTransaction().begin();
			manager.persist(usuario);
			manager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean alterar(Usuario usuario) {
		try {
			EntityManager manager = EntityManagerFactory.getInstance();
			manager.getTransaction().begin();
			manager.merge(usuario);
			manager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean excluir(Usuario usuario) {
		try {
			EntityManager manager = EntityManagerFactory.getInstance();
			manager.getTransaction().begin();
			manager.remove(usuario);
			manager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static Usuario buscarID(Usuario usuario) {
		EntityManager manager = EntityManagerFactory.getInstance();
		TypedQuery<Usuario> consulta = manager.createQuery("select u from Usuario u where u.id = :param",
				Usuario.class);
		consulta.setParameter("param", usuario.getId());
		List<Usuario> ids = consulta.getResultList();
		for (Usuario item : ids) {
			if (item.getId() == usuario.getId()) {
				return item;
			}
		}
		return null;
	}

	public static Usuario buscarUsuario(Usuario usuario) {
		EntityManager manager = EntityManagerFactory.getInstance();
		TypedQuery<Usuario> consulta = manager.createQuery("select u from Usuario u where u.usuario = :param",
				Usuario.class);
		consulta.setParameter("param", usuario.getUsuario());
		List<Usuario> usuarios = consulta.getResultList();
		for (Usuario item : usuarios) {
			if (item.getUsuario().equals(usuario.getUsuario())) {
				return item;
			}
		}
		return null;
	}

	public static Usuario buscarUsuario(String usuario) {
		EntityManager manager = EntityManagerFactory.getInstance();
		TypedQuery<Usuario> consulta = manager.createQuery("select u from Usuario u where u.usuario = :param",
				Usuario.class);
		consulta.setParameter("param", usuario);
		List<Usuario> usuarios = consulta.getResultList();
		for (Usuario item : usuarios) {
			if (item.getUsuario().equals(usuario)) {
				return item;
			}
		}
		return null;
	}

	public static void listarUsuario() {
		EntityManager manager = EntityManagerFactory.getInstance();
		TypedQuery<Usuario> consulta = manager.createQuery("select u from Usuario u", Usuario.class);
		List<Usuario> usuarios = consulta.getResultList();
		for (Usuario item : usuarios) {
			System.out.println("Id: " + item.getId() + "    Cargo: " + item.getCargo() + "    Usuario: "
					+ item.getUsuario() + "    Senha: " + item.getSenha());
		}
	}

	public static boolean autenticarLogin(Usuario usuario) {
		EntityManager manager = EntityManagerFactory.getInstance();
		TypedQuery<Usuario> consulta = manager.createQuery("select u from Usuario u where u.usuario = :param",
				Usuario.class);
		consulta.setParameter("param", usuario.getUsuario());
		List<Usuario> usuarios = consulta.getResultList();
		for (Usuario item : usuarios) {
			if (item.getUsuario().equalsIgnoreCase(usuario.getUsuario())) {
				if (item.getSenha().equals(usuario.getSenha())) {
					return true;
				}
			}
		}
		return false;
	}
}