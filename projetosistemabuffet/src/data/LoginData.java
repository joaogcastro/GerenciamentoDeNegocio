package data;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import models.Usuario;
import util.Console;

public class LoginData {
    
    public static boolean incluir(Usuario usuario){
		try{
			if(retornarUsuario(usuario)==null){
				EntityManager manager = EntityManagerFactory.getInstance();
				manager.getTransaction().begin();
				manager.persist(usuario);
				manager.getTransaction().commit();
				System.out.println("Usuario "+usuario.getUsuario()+" criado com sucesso.");
				return true;
			}else{
				System.out.println("Este usuário já existe.");
				return false;
			}	
		}
		catch(Exception e){
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
	
    public static boolean excluir(Usuario usuario){
		try{
			usuario=retornarUsuario(usuario);
			if(usuario!=null){
				EntityManager manager = EntityManagerFactory.getInstance();
				manager.getTransaction().begin();
				manager.remove(usuario);
				manager.getTransaction().commit();
				System.out.println("Usuario "+usuario.getUsuario()+" exlcuido com sucesso.");
				return true;			
			}else{
				System.out.println("Este usuário não existe no banco de dados.");
				return false;
			}
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	public static void alterarUsuario (Usuario usuario){
		boolean alterado = false;
		int opc;
		System.out.println("\nAlterar usuario "+usuario.getUsuario()+": ");
		System.out.println("1- Nome de usuario.\n2- Senha.\n3- Cargo");
		opc=Console.readInt("Informe a opção: ");
		switch(opc){
			case 1:
				usuario.setUsuario(Console.readString("Novo usuario: "));
				alterado=true;
				break;
			case 2:
				usuario.setSenha(Console.readString("Nova senha: "));
				alterado=true;
				break;
			case 3:
				usuario.setCargo(Console.readString("Novo cargo: "));
				alterado=true;
				break;
			default:
				System.out.println("Opção não listada, voltando ao menu.");
				break;
		}
		if(alterado==true){
			if(alterar(usuario)==true){
				System.out.println("Usuario "+usuario.getUsuario()+" alterado com sucesso.");
			}else{
				System.out.println("Houve um erro ao alterar o usuario.");
			}
			
		}
	}

    public static boolean autenticarLogin(Usuario usuario){
		EntityManager manager = EntityManagerFactory.getInstance();
		Query consulta = manager.createQuery("from Usuario where usuario = :param");
		consulta.setParameter("param", usuario.getUsuario());
		List<Usuario> usuarios = consulta.getResultList();
		for(Usuario item: usuarios){
            if(item.getUsuario().equalsIgnoreCase(usuario.getUsuario())){
				if(item.getSenha().equals(usuario.getSenha())){
					return true;
				}
            }
        }
        return false;
	}

	public static Usuario retornarUsuario(Usuario usuario){
		EntityManager manager = EntityManagerFactory.getInstance();
		Query consulta = manager.createQuery("from Usuario where usuario = :param");
		consulta.setParameter("param", usuario.getUsuario());
		List<Usuario> usuarios = consulta.getResultList();
		for(Usuario item: usuarios){
            if(item.getUsuario().equals(usuario.getUsuario())){
                return item;
            }
        }
        return null;
	}

	public static void listarUsuario() {
		EntityManager manager = EntityManagerFactory.getInstance();
		Query consulta = manager.createQuery("select u from Usuario u");
		List<Usuario> usuarios = consulta.getResultList();
		for (Usuario item : usuarios) {
			System.out.println("Id: " + item.getId() + "    Cargo: " + item.getCargo() + "    Usuario: " + item.getUsuario() + "    Senha: " + item.getSenha());
		}
	}
	
}