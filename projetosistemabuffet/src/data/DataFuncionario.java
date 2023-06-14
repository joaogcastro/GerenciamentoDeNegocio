package data;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import models.Funcionario;

public class DataFuncionario {

    public static boolean incluir(Funcionario funcionario) {
        try {
            EntityManager manager = EntityManagerFactory.getInstance();
            manager.getTransaction().begin();
            manager.persist(funcionario);
            manager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean alterar(Funcionario funcionario) {
        try {
            EntityManager manager = EntityManagerFactory.getInstance();
            manager.getTransaction().begin();
            manager.merge(funcionario);
            manager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean excluir(Funcionario funcionario) {
        try {
            EntityManager manager = EntityManagerFactory.getInstance();
            manager.getTransaction().begin();
            manager.remove(funcionario);
            manager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Funcionario buscarCPF(Funcionario funcionario) {
        String cpfFormatado = funcionario.getCpf().replaceAll("[\\.-]", ""); // Remove os caracteres especiais do CPF
        EntityManager manager = EntityManagerFactory.getInstance();
        TypedQuery<Funcionario> consulta = manager.createQuery("select f from Funcionario f where f.cpf = :parametro",
                Funcionario.class);
        consulta.setParameter("parametro", cpfFormatado);
        List<Funcionario> resultados = consulta.getResultList();

        if (!resultados.isEmpty()) {
            return resultados.get(0);
        } else {
            return null;
        }
    }

    public static void buscarNomeFuncionario(String nome) {
        EntityManager manager = EntityManagerFactory.getInstance();
        TypedQuery<Funcionario> consulta = manager
                .createQuery("select f from Funcionario f where lower(f.nome) like lower(:param)", Funcionario.class);
        consulta.setParameter("param", "%" + nome.toLowerCase() + "%");
        List<Funcionario> funcionarios = consulta.getResultList();
        for (Funcionario item : funcionarios) {
            System.out.println("Id: " + item.getId() + "   CPF: " + item.getCpf() + "   Nome: " + item.getNome()
                    + "   Telefone: " + item.getTelefone() + "   Função: " + item.getFuncao() + "   Salário: "
                    + item.getSalario());
        }
    }

    public static void listarFuncionariosCLT() {
        EntityManager manager = EntityManagerFactory.getInstance();
        TypedQuery<Funcionario> consulta = manager.createQuery("select f from Funcionario f where f.clt = true",
                Funcionario.class);
        List<Funcionario> funcionarios = consulta.getResultList();
        if (!funcionarios.isEmpty()) {
            for (Funcionario item : funcionarios) {
                System.out.println("Id: " + item.getId() + "   CPF: " + item.getCpf() + "   Nome: " + item.getNome()
                        + "   Telefone: " + item.getTelefone()
                        + "\n Função: " + item.getFuncao() + "   Salário: " + item.getSalario());
            }
        } else {
            System.out.println("Não há funcionários cadastrados no banco.");
        }
    }

    public static void listarFuncionariosTaxa() {
        EntityManager manager = EntityManagerFactory.getInstance();
        TypedQuery<Funcionario> consulta = manager.createQuery("select f from Funcionario f where f.clt = false",
                Funcionario.class);
        List<Funcionario> funcionarios = consulta.getResultList();
        if (!funcionarios.isEmpty()) {
            for (Funcionario item : funcionarios) {
                System.out.println("Id: " + item.getId() + "   CPF: " + item.getCpf() + "   Nome: " + item.getNome()
                        + "   Telefone: " + item.getTelefone()
                        + "   Garçom: " + item.isGarcom() + "   Monitor: " + item.isMonitor() + "   Valor da hora: "
                        + item.getValorHora());
            }
        } else {
            System.out.println("Não há funcionários cadastrados no banco.");
        }
    }
}