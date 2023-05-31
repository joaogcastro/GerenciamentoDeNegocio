package data;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import models.Cliente;

public class DataCliente {
    public static boolean incluir (Cliente cliente){
        String cpfFormatado = cliente.getCpf().replaceAll("[\\.-]", ""); // Remove os caracteres especiais do CPF
        cliente.setCpf(cpfFormatado); // Atualiza o CPF do cliente com o valor formatado
    
        try{
			EntityManager manager = EntityManagerFactory.getInstance();
			manager.getTransaction().begin();
			manager.persist(cliente);
			manager.getTransaction().commit();
            System.out.println("\nCliente cadastrado com sucesso.\n");
			return true;
		}
		catch(Exception e){
			return false;
		}
    }

    public static Cliente buscarCPF(Cliente cliente) {
        String cpfFormatado = cliente.getCpf().replaceAll("[\\.-]", ""); // Remove os caracteres especiais do CPF
        EntityManager manager = EntityManagerFactory.getInstance();
        Query consulta = manager.createQuery("from Cliente where cpf = :parametro");
        consulta.setParameter("parametro", cpfFormatado);
        List<Cliente> resultados = consulta.getResultList();
        
        if (!resultados.isEmpty()) {
            return resultados.get(0);
        } else {
            return null;
        }
    }

    public static void listarClientes(){
        EntityManager manager = EntityManagerFactory.getInstance();
        Query consulta = manager.createQuery("select u from Cliente u");
        List<Cliente> clientes = consulta.getResultList();
        for(Cliente item: clientes){
            System.out.println("Id: "+item.getId()+"   CPF: "+item.getCpf()+"   Nome: "+item.getNome()+"   Telefone: "+item.getTelefone()+"   Email: "+item.getEmail());
        }
    }

    public static void procurarNomeClientes(String nome){
        EntityManager manager = EntityManagerFactory.getInstance();
        Query consulta = manager.createQuery("select from Cliente where nome like :param");
        consulta.setParameter("param", nome);
        List<Cliente> clientes = consulta.getResultList();
        for(Cliente item: clientes){
            System.out.println("Id: "+item.getId()+"   CPF: "+item.getCpf()+"   Nome: "+item.getNome()+"   Telefone: "+item.getTelefone()+"   Email: "+item.getEmail());
        }
    }
}
