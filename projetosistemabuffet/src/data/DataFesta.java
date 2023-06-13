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

    public static void listarDecoracoes() {
        try {
            EntityManager manager = EntityManagerFactory.getInstance();
            TypedQuery<Festa> consulta = manager.createQuery("SELECT d FROM Festa d", Festa.class);
            List<Festa> decoracoes = consulta.getResultList();

            if (!decoracoes.isEmpty()) {
                System.out.println("Decorações cadastradas:");
                for (Festa festa : decoracoes) {
                    System.out.println("ID: " + festa.getIdFesta());
                    System.out.println("Data de início: " + festa.getDataInicio());
                    System.out.println("Data do fim: " + festa.getDataFim());
                    System.out.println("Cliente: " + festa.getCliente().getNome());
                    System.out.println("Número de convidados: " + festa.getNumeroConvidados());
                    System.out.println("Valor: " + festa.getValorFesta());
                    System.out.println("-----------------------------");
                }
            } else {
                System.out.println("Nenhuma decoração cadastrada.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
