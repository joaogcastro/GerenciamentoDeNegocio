package data;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import models.Ingrediente;

public class DataIngrediente {

    public static boolean incluir(Ingrediente ingrediente) {
        try {
            EntityManager manager = EntityManagerFactory.getInstance();
            manager.getTransaction().begin();
            manager.persist(ingrediente);
            manager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        }
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

    public static void listarIngredientes() {
        EntityManager manager = EntityManagerFactory.getInstance();
        TypedQuery<Ingrediente> consulta = manager.createQuery("SELECT i FROM Ingrediente i", Ingrediente.class);
        List<Ingrediente> ingredientes = consulta.getResultList();

        for (Ingrediente ingrediente : ingredientes) {
            System.out.println("ID: " + ingrediente.getIdIngrediente());
            System.out.println("Nome: " + ingrediente.getNomeIngrediente());
            System.out.println("Quantidade: " + ingrediente.getQuantidade());
            System.out.println("-----------------------------");
        }
    }

    public static void darBaixa(Ingrediente ingrediente, int qntItem) {
        int novaQnt = ingrediente.getQuantidade() - qntItem;
        if (qntItem >= 0) {
            ingrediente.setQuantidade(novaQnt);
            alterar(ingrediente);
            System.out.println("Alterada com sucesso.");
        } else {
            System.out.println("Não é possível realizar a alteração.");
        }
    }

    public static Ingrediente procurarID(Ingrediente ingrediente) {
        EntityManager manager = EntityManagerFactory.getInstance();
        TypedQuery<Ingrediente> consulta = manager.createQuery("SELECT i FROM Ingrediente i WHERE i.idIngrediente = :id", Ingrediente.class);
        consulta.setParameter("id", ingrediente.getIdIngrediente());
        List<Ingrediente> resultados = consulta.getResultList();

        if (!resultados.isEmpty()) {
            return resultados.get(0);
        } else {
            return null;
        }
    }

    public static Ingrediente procurarID(int idIngrediente) {
        EntityManager manager = EntityManagerFactory.getInstance();
        TypedQuery<Ingrediente> consulta = manager.createQuery("SELECT i FROM Ingrediente i WHERE i.Ingrediente = :id", Ingrediente.class);
        consulta.setParameter("id", idIngrediente);
        List<Ingrediente> resultados = consulta.getResultList();

        if (!resultados.isEmpty()) {
            return resultados.get(0);
        } else {
            return null;
        }
    }

    public static Ingrediente procurarNomeIngrediente (Ingrediente ingrediente){
        EntityManager manager = EntityManagerFactory.getInstance();
        TypedQuery<Ingrediente> consulta = manager.createQuery("SELECT i FROM Ingrediente i WHERE i.nomeIngrediente = :nome", Ingrediente.class);
        consulta.setParameter("nome", ingrediente.getNomeIngrediente());
        List<Ingrediente> resultados = consulta.getResultList();

        if (!resultados.isEmpty()) {
            return resultados.get(0);
        } else {
            return null;
        }
    }

}
