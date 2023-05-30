package data;

import javax.persistence.Query;

import java.util.List;

import javax.persistence.EntityManager;

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
}
