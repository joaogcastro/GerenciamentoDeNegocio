package data;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import models.Cardapio;
import models.Festa;
import models.Funcionario;

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
                System.out.println("Nenhuma decoração cadastrada.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void exibirDetalhesFesta(Festa festa) {
        System.out.println("Festa Id "+festa.getIdFesta()+" do cliente "+festa.getCliente().getNome()+":");
        System.out.println("Data de início: " + festa.getDataInicio());
        System.out.println("Data do fim: " + festa.getDataFim());
        System.out.println("Número de convidados: " + festa.getNumeroConvidados());
        System.out.println("Número de crianças: "+festa.getNumeroCriancas());
        System.out.println("Tema da decoração: "+festa.getDecoracao().getTema());
        exibirPratosDaFesta(festa);
        exibirFuncionariosDaFesta(festa);
        System.out.println("Valor: " + festa.getValorFesta());
    }

    private static void exibirPratosDaFesta (Festa festa){
        for(Cardapio item: festa.getCardapio()){
            System.out.println("Prato: "+ item.getNome()+"   Preço: "+item.getPreco());
        }
    }

    private static void exibirFuncionariosDaFesta (Festa festa){
        for(Funcionario item: festa.getFuncionarios()){
            System.out.println("Id: "+item.getId()+"   Nome: "+item.getNome());
        }
    }
}
