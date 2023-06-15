package data;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import models.Cardapio;

public class DataCardapio {

    public static boolean incluir(Cardapio cardapio) {
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

    public static boolean alterar(Cardapio prato) {
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

    public static boolean excluir(Cardapio prato) {
        try {
			EntityManager manager = EntityManagerFactory.getInstance();
			manager.getTransaction().begin();
			manager.remove(prato);
			manager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
    }

    public static Cardapio buscarPratoCardapio(int id) {
        EntityManager manager = EntityManagerFactory.getInstance();
        return manager.find(Cardapio.class, id);
    }

    public static void listarPratosCardapio() {
        EntityManager manager = EntityManagerFactory.getInstance();
        TypedQuery<Cardapio> consulta = manager.createQuery("SELECT c FROM Cardapio c", Cardapio.class);
        List<Cardapio> cardapios = consulta.getResultList();
        System.out.println("Itens do cardápio:");
        for (Cardapio cardapio : cardapios) {
            System.out.println(
                    "ID: " + cardapio.getId() + ", Nome: " + cardapio.getNome() + ", Preço: " + cardapio.getPreco());
        }
    }
}