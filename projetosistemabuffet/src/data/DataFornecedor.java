package data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import models.Fornecedor;

public class DataFornecedor {

	public static boolean incluir(Fornecedor fornecedor) {
		try {
			EntityManager manager = EntityManagerFactory.getInstance();
			manager.getTransaction().begin();
			manager.persist(fornecedor);
			manager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean alterar(Fornecedor fornecedor) {
		try {
			EntityManager manager = EntityManagerFactory.getInstance();
			manager.getTransaction().begin();
			manager.merge(fornecedor);
			manager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean excluir(Fornecedor fornecedor) {
		try {
			EntityManager manager = EntityManagerFactory.getInstance();
			manager.getTransaction().begin();
			manager.remove(fornecedor);
			manager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static Fornecedor buscarCNPJ(Fornecedor fornecedor) {
		String cnpjFormatado = fornecedor.getCnpj().replaceAll("[\\.-]", ""); // Remove os caracteres especiais do CPF
		EntityManager manager = EntityManagerFactory.getInstance();
		Query consulta = manager.createQuery("from Fornecedor where cnpj = :parametro");
		consulta.setParameter("parametro", cnpjFormatado);
		List<Fornecedor> resultados = consulta.getResultList();

		if (!resultados.isEmpty()) {
			return resultados.get(0);
		} else {
			return null;
		}
	}

	public static Fornecedor buscarCNPJ(String cnpj) {
		String cnpjFormatado = cnpj.replaceAll("[\\.-]", ""); // Remove os caracteres especiais do CPF
		EntityManager manager = EntityManagerFactory.getInstance();
		Query consulta = manager.createQuery("from Fornecedor where cnpj = :parametro");
		consulta.setParameter("parametro", cnpjFormatado);
		List<Fornecedor> resultados = consulta.getResultList();

		if (!resultados.isEmpty()) {
			return resultados.get(0);
		} else {
			return null;
		}
	}

}