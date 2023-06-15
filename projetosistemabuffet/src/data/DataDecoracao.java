package data;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import models.Decoracao;

public class DataDecoracao {

    public static boolean incluir(Decoracao decoracao) {
        try {
            EntityManager manager = EntityManagerFactory.getInstance();
            manager.getTransaction().begin();
            manager.persist(decoracao);
            manager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean alterar(Decoracao decoracao) {
        try {
            EntityManager manager = EntityManagerFactory.getInstance();
            manager.getTransaction().begin();
            manager.merge(decoracao);
            manager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean excluir(Decoracao decoracao) {
        try {
            EntityManager manager = EntityManagerFactory.getInstance();
            manager.getTransaction().begin();
            manager.remove(decoracao);
            manager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Decoracao buscarDecoracaoPorId(int id) {
        try {
            EntityManager manager = EntityManagerFactory.getInstance();
            return manager.find(Decoracao.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void listarDecoracoes() {
        try {
            EntityManager manager = EntityManagerFactory.getInstance();
            TypedQuery<Decoracao> consulta = manager.createQuery("SELECT d FROM Decoracao d", Decoracao.class);
            List<Decoracao> decoracoes = consulta.getResultList();

            if (!decoracoes.isEmpty()) {
                System.out.println("Decorações cadastradas:");
                for (Decoracao decoracao : decoracoes) {
                    System.out.println("ID: " + decoracao.getId());
                    System.out.println("Tema: " + decoracao.getTema());
                    System.out.println("Preço: " + decoracao.getPreco());
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