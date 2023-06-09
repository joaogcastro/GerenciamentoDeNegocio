package data;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import models.Fornecedor;
import models.Ingrediente;

public class DataEstoque {
    public static boolean incluir(Ingrediente ingeredientes) {
        try {
            EntityManager manager = EntityManagerFactory.getInstance();
            manager.getTransaction().begin();
            manager.persist(ingeredientes);
            manager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public static void listarIngredientes() {

        EntityManager manager = EntityManagerFactory.getInstance();
        Query consulta = manager.createQuery("select u from Ingredientes u");
        List<Ingrediente> ingredientes = consulta.getResultList();
        for (Ingrediente item : ingredientes) {
            System.out.println("id " + item.getIdIngrediente() + "   quantidade: " + item.getQuantidade());
        }
    }

    public static void baixaItens(Ingrediente ingrediente, int qntItem) {
        int novaQnt = ingrediente.getQuantidade() - qntItem;
        if (qntItem >= 0) {
            ingrediente.setQuantidade(novaQnt);
            alterar(ingrediente);
            System.out.println("Alterada com sucesso.");
        } else {
            System.out.println("não é possivel realizar a alteração.");
        }
    }

    public static Ingrediente procurarID(Ingrediente ingrediente) {

        EntityManager manager = EntityManagerFactory.getInstance();
        Query consulta = manager.createQuery("from Ingrediente where id = :param");
        consulta.setParameter("param", ingrediente.getIdIngrediente());
        List<Ingrediente> ids = consulta.getResultList();
        for (Ingrediente item : ids) {
            if (item.getIdIngrediente() == ingrediente.getIdIngrediente()) {
                return item;
            }
        }
        return null;
    }

    public static boolean alterar(Ingrediente ingrediente) {
        try {
            EntityManager manager = EntityManagerFactory.getInstance();
            manager.getTransaction().begin();
            manager.merge(ingrediente);
            manager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static Fornecedor buscarID(Fornecedor fornecedor) {
        EntityManager manager = EntityManagerFactory.getInstance();
        Query consulta = manager.createQuery("from Fornecedor where id = :param");
        consulta.setParameter("param", fornecedor.getId());
        List<Fornecedor> ids = consulta.getResultList();
        for (Fornecedor item : ids) {
            if (item.getId() == fornecedor.getId()) {
                return item;
            }
        }
        return null;
    }

}
