package data;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

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

	public static Fornecedor buscarFornecedorPorId(int id) {
		try {
			EntityManager manager = EntityManagerFactory.getInstance();
			return manager.find(Fornecedor.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


	public static void listarFornecedores() {
    try {
        EntityManager manager = EntityManagerFactory.getInstance();
        TypedQuery<Fornecedor> consulta = manager.createQuery("SELECT f FROM Fornecedor f", Fornecedor.class);
        List<Fornecedor> fornecedores = consulta.getResultList();

        if (!fornecedores.isEmpty()) {
            System.out.println("Fornecedores cadastrados:");
            for (Fornecedor fornecedor : fornecedores) {
                System.out.println("ID: " + fornecedor.getId());
                System.out.println("Nome: " + fornecedor.getNome());
                System.out.println("Telefone: " + fornecedor.getTelefone());
                System.out.println("CNPJ: " + fornecedor.getCnpj());
                System.out.println("-----------------------------");
            }
        } else {
            System.out.println("Nenhum fornecedor cadastrado.");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

	public static Fornecedor buscarCNPJ(Fornecedor fornecedor) {
		String cnpjFormatado = fornecedor.getCnpj().replaceAll("[\\.-]", ""); // Remove os caracteres especiais do CNPJ
		return buscarFornecedorPorCNPJ(cnpjFormatado);
	}

	public static Fornecedor buscarCNPJ(String cnpj) {
		String cnpjFormatado = cnpj.replaceAll("[\\.-]", ""); // Remove os caracteres especiais do CNPJ
		return buscarFornecedorPorCNPJ(cnpjFormatado);
	}

	private static Fornecedor buscarFornecedorPorCNPJ(String cnpjFormatado) {
		EntityManager manager = EntityManagerFactory.getInstance();
		TypedQuery<Fornecedor> consulta = manager.createQuery("select f from Fornecedor f where f.cnpj = :parametro",
				Fornecedor.class);
		consulta.setParameter("parametro", cnpjFormatado);
		List<Fornecedor> resultados = consulta.getResultList();

		if (!resultados.isEmpty()) {
			return resultados.get(0);
		} else {
			return null;
		}
	}

}