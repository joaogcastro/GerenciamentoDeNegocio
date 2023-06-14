package views;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import data.DataCardapio;
import data.DataCliente;
import data.DataDecoracao;
import data.DataFesta;
import data.EntityManagerFactory;
import models.Cardapio;
import models.Cliente;
import models.Decoracao;
import models.Festa;
import models.Funcionario;
import util.Console;
import util.LocalDateTimeReader;
import util.BooleanUtils;
import util.CPFUtils;

public class VendedorFesta {

    public static void venderFesta() {
        System.out.println("\nNova festa:");
        Cliente cliente = new Cliente();
        cliente.setCpf(Console.readString("Informe o cpf do cliente: "));
        if (CPFUtils.validarCPF(cliente.getCpf()) == true) {
            if (DataCliente.buscarCPF(cliente) == null) {
                cadastrarCliente(cliente);
            }
            cliente = DataCliente.buscarCPF(cliente);
            Festa festa = new Festa();
            festa.setCliente(cliente);
            Scanner scanner = new Scanner(System.in);
            System.out.println("Informe a data de início (no formato dd/MM/yyyy HH:mm): ");
            festa.setDataInicio(LocalDateTimeReader.readLocalDateTimeFromInput(scanner));
            System.out.println("Informe a data do fim (no formato dd/MM/yyyy HH:mm): ");
            festa.setDataFim(LocalDateTimeReader.readLocalDateTimeFromInput(scanner));

            if (verificarConflitoHorario(festa)) {
                System.out.println("O horário selecionado não está disponível. Por favor, escolha outro horário.");
                return;
            } else {
                festa.setNumeroConvidados(Console.readInt("Informe o número de convidados para a festa: "));
                festa.setNumeroCriancas(Console.readInt("Informe o número de crianças na festa: "));
                System.out.println("Escolha a decoração:");
                DataDecoracao.listarDecoracoes();
                Decoracao decoracao = new Decoracao();
                decoracao = DataDecoracao.buscarDecoracaoPorId(
                        Console.readInt("Informe o Id da decoração escolhida: "));
                festa.setDecoracao(decoracao);
                System.out.println("Escolha o prato para o cardápio da festa: ");
                DataCardapio.listarItensCardapio();
                Cardapio cardapio = new Cardapio();
                cardapio.setId(Console.readInt("Informe o Id do prato escolhido: "));

                festa.getCardapio().add(cardapio); // Adiciona o prato escolhido inicialmente ao cardápio da festa

                boolean adicionarMaisPrato = Console
                        .readBoolean("Deseja adicionar mais um prato? (sim/não)");

                while (adicionarMaisPrato) {
                    System.out.println("Escolha o próximo prato para o cardápio da festa: ");
                    DataCardapio.listarItensCardapio();
                    Cardapio proximoPrato = new Cardapio();
                    proximoPrato.setId(Console.readInt("Informe o Id do próximo prato escolhido: "));

                    festa.getCardapio().add(proximoPrato); // Adiciona o próximo prato ao cardápio da festa

                    adicionarMaisPrato = Console.readBoolean("Deseja adicionar mais um prato? (sim/não)");
                }

                adicionarFuncionariosAutomaticamente(festa);

                festa.setValorFesta(calcularPrecoFesta(festa));

                System.out.println("O preço da festa é de: "+festa.getValorFesta());
                System.out.println("Solicite o pagamento para o cliente.");
                System.out.println("O cliente pagou à vista?");
                festa.setPagamentoRealizado(BooleanUtils.formatarSimNao());

                if(DataFesta.incluir(festa)){
                    System.out.println("Festa cadastrada com sucesso.");
                }else{
                    System.out.println("Houve um erro ao adicionar a festa.");
                }
            }
        } else {
            System.out.println("Esse cpf não é válido.");
        }
    }

    private static void cadastrarCliente(Cliente cliente) {
        System.out.println("Cliente não cadastrado, ");
        cliente.setNome(Console.readString("Nome do cliente: "));
        cliente.setTelefone(Console.readString("Informe o telefone do cliente: "));
        cliente.setEmail(Console.readString("Informe o email do cliente: "));
        cliente.setEndereco(Console.readString("Informe o endereço do cliente: "));
        DataCliente.incluir(cliente);
    }

    private static boolean verificarConflitoHorario(Festa festa) {
        try {
            EntityManager manager = EntityManagerFactory.getInstance();
            TypedQuery<Festa> query = manager.createQuery(
                    "SELECT f FROM models.Festa f WHERE f.dataInicio < :horaTermino AND f.dataFim > :horaInicio\r\n" + //
                            "",
                    Festa.class);
            query.setParameter("horaTermino", festa.getDataFim());
            query.setParameter("horaInicio", festa.getDataInicio());
            List<Festa> festas = query.getResultList();

            return !festas.isEmpty();
        } catch (Exception e) {
            e.printStackTrace();
            return true; // Se ocorrer um erro na consulta, considere como conflito de horário
        }
    }

    public static void adicionarFuncionariosAutomaticamente(Festa festa) {
        int numGarcons = festa.getNumeroConvidados() / 15;
        int numMonitores = festa.getNumeroCriancas() / 10;

        EntityManager manager = EntityManagerFactory.getInstance();
        TypedQuery<Funcionario> queryGarcom = manager.createQuery(
                "SELECT f FROM Funcionario f WHERE f.garcom = true", Funcionario.class);
        queryGarcom.setMaxResults(numGarcons);
        List<Funcionario> garcons = queryGarcom.getResultList();

        TypedQuery<Funcionario> queryMonitor = manager.createQuery(
                "SELECT f FROM Funcionario f WHERE f.monitor = true", Funcionario.class);
        queryMonitor.setMaxResults(numMonitores);
        List<Funcionario> monitores = queryMonitor.getResultList();

        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.addAll(garcons);
        funcionarios.addAll(monitores);

        festa.setFuncionarios(funcionarios);
    }

    public static double calcularPrecoFesta(Festa festa) {
        double precoFuncionarios = calcularPrecoFuncionarios(festa);
        double precoCardapio = calcularPrecoCardapio(festa);
        double precoDecoracao = calcularPrecoDecoracao(festa);
        double precoConvidados = 80 * festa.getNumeroConvidados();

        return precoFuncionarios + precoCardapio + precoDecoracao + precoConvidados;
    }

    private static double calcularPrecoFuncionarios(Festa festa) {
        double precoGarcom = 0.0;
        double precoMonitor = 0.0;

        for (Funcionario funcionario : festa.getFuncionarios()) {
            if (funcionario.isGarcom()) {
                precoGarcom += funcionario.getValorHora() * getDuracaoFestaEmHoras(festa);
            } else if (funcionario.isMonitor()) {
                precoMonitor += funcionario.getValorHora() * getDuracaoFestaEmHoras(festa);
            }
        }

        return precoGarcom + precoMonitor;
    }

    private static double calcularPrecoCardapio(Festa festa) {
        double precoCardapio = 0.0;

        for (Cardapio itemCardapio : festa.getCardapio()) {
            precoCardapio += itemCardapio.getPreco();
        }

        return precoCardapio;
    }

    private static double calcularPrecoDecoracao(Festa festa) {
        if (festa.getDecoracao() != null) {
            return festa.getDecoracao().getPreco();
        }
        return 0.0;
    }

    private static int getDuracaoFestaEmHoras(Festa festa) {
        LocalDateTime dataHoraInicio = festa.getDataInicio();
        LocalDateTime dataHoraFim = festa.getDataFim();
        Duration duracao = Duration.between(dataHoraInicio, dataHoraFim);
        return (int) duracao.toHours();
    }

}
