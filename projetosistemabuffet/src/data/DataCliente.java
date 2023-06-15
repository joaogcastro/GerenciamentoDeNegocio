package data;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import models.Cliente;

public class DataCliente {
    
    public static boolean incluir(Cliente cliente) {
        try {
            EntityManager manager = EntityManagerFactory.getInstance();
            manager.getTransaction().begin();
            manager.persist(cliente);
            manager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean alterar(Cliente cliente) {
        try {
            EntityManager manager = EntityManagerFactory.getInstance();
            manager.getTransaction().begin();
            manager.merge(cliente);
            manager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean excluir(Cliente cliente) {
        try {
            EntityManager manager = EntityManagerFactory.getInstance();
            manager.getTransaction().begin();
            manager.remove(cliente);
            manager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Cliente buscarCPF(Cliente cliente) {
        String cpfFormatado = cliente.getCpf().replaceAll("[\\.-]", ""); // Remove os caracteres especiais do CPF
        EntityManager manager = EntityManagerFactory.getInstance();
        TypedQuery<Cliente> consulta = manager.createQuery("select c from Cliente c where c.cpf = :parametro",
                Cliente.class);
        consulta.setParameter("parametro", cpfFormatado);
        List<Cliente> resultados = consulta.getResultList();

        if (!resultados.isEmpty()) {
            return resultados.get(0);
        } else {
            return null;
        }
    }

    public static void buscarNomeCliente(String nome) {
        EntityManager manager = EntityManagerFactory.getInstance();
        TypedQuery<Cliente> consulta = manager
                .createQuery("select c from Cliente c where lower(c.nome) like lower(:param)", Cliente.class);
        consulta.setParameter("param", "%" + nome.toLowerCase() + "%");
        List<Cliente> clientes = consulta.getResultList();
        for (Cliente item : clientes) {
            System.out.println("Id: " + item.getId() + "   CPF: " + item.getCpf() + "   Nome: " + item.getNome()
                    + "   Telefone: " + item.getTelefone() + "   Email: " + item.getEmail());
        }
    }

    public static void listarContatoClientes() {
        EntityManager manager = EntityManagerFactory.getInstance();
        TypedQuery<Cliente> consulta = manager.createQuery("select c from Cliente c", Cliente.class);
        List<Cliente> clientes = consulta.getResultList();

        if (!clientes.isEmpty()) {
            for (Cliente item : clientes) {
                System.out.println("Nome: " + item.getNome() + "   CPF: " + item.getCpf() + "   Telefone: "
                        + item.getTelefone() + "   Email: " + item.getEmail() + "   Endereço: " + item.getEndereco());
            }
        } else {
            System.out.println("Não há clientes cadastrados no banco.");
        }
    }

    public static void listarClientesNoBanco() {
        EntityManager manager = EntityManagerFactory.getInstance();
        TypedQuery<Cliente> consulta = manager.createQuery("select c from Cliente c", Cliente.class);
        List<Cliente> clientes = consulta.getResultList();

        if (!clientes.isEmpty()) {
            for (Cliente item : clientes) {
                System.out.println("Id: " + item.getId() + "   CPF: " + item.getCpf() + "   Nome: " + item.getNome());
            }
        } else {
            System.out.println("Não há clientes cadastrados no banco.");
        }
    }
}