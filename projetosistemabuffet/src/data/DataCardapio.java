package data;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import models.Cardapio;

public class DataCardapio {

    public static boolean adicionarItemCardapio(Cardapio cardapio) {
        try {
            EntityManager manager = EntityManagerFactory.getInstance();
            manager.getTransaction().begin();
            manager.persist(cardapio);
            manager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean alterarItemCardapio(Cardapio prato) {
        try {
            EntityManager manager = EntityManagerFactory.getInstance();
            manager.getTransaction().begin();
            manager.merge(prato);
            manager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean removerItemCardapio(int id) {
        try {
            EntityManager manager = EntityManagerFactory.getInstance();
            manager.getTransaction().begin();
            Cardapio cardapio = manager.find(Cardapio.class, id);
            manager.remove(cardapio);
            manager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void listarItensCardapio() {
        EntityManager manager = EntityManagerFactory.getInstance();
        TypedQuery<Cardapio> consulta = manager.createQuery("SELECT c FROM Cardapio c", Cardapio.class);
        List<Cardapio> cardapios = consulta.getResultList();
        System.out.println("Itens do cardápio:");
        for (Cardapio cardapio : cardapios) {
            System.out.println(
                    "ID: " + cardapio.getId() + ", Nome: " + cardapio.getNome() + ", Preço: " + cardapio.getPreco());
        }
    }

    public static Cardapio buscarItemCardapio(int id) {
        EntityManager manager = EntityManagerFactory.getInstance();
        return manager.find(Cardapio.class, id);
    }

}