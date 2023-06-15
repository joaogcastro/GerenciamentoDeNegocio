package data;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import models.Festa;

public class DataFesta {

    public static boolean incluir(Festa festa) {
        try {
            EntityManager manager = EntityManagerFactory.getInstance();
            manager.getTransaction().begin();
            manager.persist(festa);
            manager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean alterar(Festa festa) {
        try {
            EntityManager manager = EntityManagerFactory.getInstance();
            manager.getTransaction().begin();
            manager.merge(festa);
            manager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean excluir(Festa festa) {
        try {
            EntityManager manager = EntityManagerFactory.getInstance();
            manager.getTransaction().begin();
            manager.remove(festa);
            manager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Festa buscarFestaPorId(int id) {
        try {
            EntityManager manager = EntityManagerFactory.getInstance();
            return manager.find(Festa.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void buscarFestaPorCliente(String nomeCliente) {
        try {
            EntityManager manager = EntityManagerFactory.getInstance();
            TypedQuery<Festa> consulta = manager.createQuery("SELECT f FROM Festa f WHERE f.cliente.nome = :nomeCliente", Festa.class);
            consulta.setParameter("nomeCliente", nomeCliente);
            List<Festa> festas = consulta.getResultList();

            if (!festas.isEmpty()) {
                System.out.println("Festas cadastradas:");
                for (Festa festa : festas) {
                    System.out.println("ID: " + festa.getIdFesta()+"   Data: "+festa.getDataInicio()+" a "+festa.getDataFim()+"   Cliente: " + festa.getCliente().getNome());
                }
            } else {
                System.out.println("Nenhuma festa cadastrada.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void listarFestas() {
        try {
            EntityManager manager = EntityManagerFactory.getInstance();
            TypedQuery<Festa> consulta = manager.createQuery("SELECT f FROM Festa f", Festa.class);
            List<Festa> festas = consulta.getResultList();

            if (!festas.isEmpty()) {
                System.out.println("Festas cadastradas:");
                for (Festa festa : festas) {
                    System.out.println("ID: " + festa.getIdFesta()+"   Data: "+festa.getDataInicio()+" a "+festa.getDataFim()+"   Cliente: " + festa.getCliente().getNome());
                }
            } else {
                System.out.println("Nenhuma festa cadastrada.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}