package services;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import data.DataCardapio;
import data.DataCliente;
import data.DataFesta;
import data.DataFuncionario;
import data.EntityManagerFactory;
import models.Cardapio;
import models.Cliente;
import models.Festa;
import models.Funcionario;
import util.Console;
import util.LocalDateTimeReader;

public class FestaService {

    public static void cadastrarCliente(Cliente cliente) {
        System.out.println("Cliente não cadastrado, vamos cadastrá-lo:");
        cliente.setNome(Console.readString("Nome do cliente: "));
        cliente.setTelefone(Console.readString("Informe o telefone do cliente: "));
        cliente.setEmail(Console.readString("Informe o email do cliente: "));
        cliente.setEndereco(Console.readString("Informe o endereço do cliente: "));
        DataCliente.incluir(cliente);
    }

    public static void lerDataInicioFim(Festa festa) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe a data de início (no formato dd/MM/yyyy HH:mm): ");
        festa.setDataInicio(LocalDateTimeReader.readLocalDateTimeFromInput(scanner));
        System.out.println("Informe a data do fim (no formato dd/MM/yyyy HH:mm): ");
        festa.setDataFim(LocalDateTimeReader.readLocalDateTimeFromInput(scanner));
    }

    public static void adicionarCardapio(Festa festa) {
        System.out.println("Escolha o prato para o cardápio da festa: ");
        DataCardapio.listarPratosCardapio();
        Cardapio cardapio = null;
        while (cardapio == null) {
            cardapio = DataCardapio.buscarPratoCardapio(Console.readInt("Informe o Id do prato escolhido: "));
            if (cardapio != null) {
                List<Cardapio> cardapioList = festa.getCardapio();
                if (cardapioList == null) {
                    cardapioList = new ArrayList<>();
                    festa.setCardapio(cardapioList);
                }
                cardapioList.add(cardapio);
            } else {
                System.out.println("\nEste id não corresponde a nenhum prato do cardápio.");
            }
        }
        String adicionarMaisPrato = Console.readString("Deseja adicionar mais um prato? (s/n): ");

        while (adicionarMaisPrato.equalsIgnoreCase("s")) {
            System.out.println("Escolha o próximo prato para o cardápio da festa: ");
            DataCardapio.listarPratosCardapio();
            Cardapio proximoPrato = null;

            while (proximoPrato == null) {
                int idPratoEscolhido = Console.readInt("Informe o Id do prato escolhido: ");
                proximoPrato = DataCardapio.buscarPratoCardapio(idPratoEscolhido);

                if (proximoPrato != null) {
                    boolean pratoJaExistente = false;

                    for (Cardapio prato : festa.getCardapio()) {
                        if (prato.getId() == idPratoEscolhido) {
                            pratoJaExistente = true;
                            break;
                        }
                    }

                    if (!pratoJaExistente) {
                        List<Cardapio> cardapioList = festa.getCardapio();
                        if (cardapioList == null) {
                            cardapioList = new ArrayList<>();
                            festa.setCardapio(cardapioList);
                        }
                        cardapioList.add(proximoPrato);
                    } else {
                        System.out.println("\nPrato já cadastrado nesta festa.");
                    }
                } else {
                    System.out.println("\nEste id não corresponde a nenhum prato do cardápio.");
                }
            }

            adicionarMaisPrato = Console.readString("Deseja adicionar mais um prato? (s/n): ");
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

    public static void exibirDetalhesFesta(Festa festa) {
        System.out.println("\n---------------------------------");
        System.out.println("Festa Id " + festa.getIdFesta() + " do cliente " + festa.getCliente().getNome() + ":");
        System.out.println("Data de início: " + festa.getDataInicio());
        System.out.println("Data do fim: " + festa.getDataFim());
        System.out.println("Número de convidados: " + festa.getNumeroConvidados());
        System.out.println("Número de crianças: " + festa.getNumeroCriancas());
        System.out.println("Tema da decoração: " + festa.getDecoracao().getTema());
        System.out.println("\nPratos da festa:");
        for (Cardapio item : festa.getCardapio()) {
            System.out.println("Prato: " + item.getNome() + "   Preço: " + item.getPreco());
        }
        System.out.println("\nFuncionários da festa:");
        for (Funcionario item : festa.getFuncionarios()) {
            System.out.println("Id: " + item.getId() + "   Nome: " + item.getNome());
        }
        exibirRelatórioFinanceiroFesta(festa.getIdFesta());
        System.out.println("---------------------------------");
    }

    public static boolean verificarConflitoHorario(Festa festa) {
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

    private static double calcularLucroFesta(int idFesta) {
        Festa festa = DataFesta.buscarFestaPorId(idFesta);
        if (festa != null) {
            double valorFesta = festa.getValorFesta();
            double despesasTotais = calcularDespesasTotaisFesta(festa);
            double lucro = valorFesta - despesasTotais;
            return lucro;
        } else {
            return 0.0;
        }
    }

    private static double calcularDespesasTotaisFesta(Festa festa) {
        double valorDecoracao = festa.getDecoracao().getPreco();
        double valorPratos = 0.0;
        for (Cardapio cardapio : festa.getCardapio()) {
            valorPratos += cardapio.getPreco();
        }
        double valorFuncionarios = 0.0;
        for (Funcionario funcionario : festa.getFuncionarios()) {
            double valorHora = funcionario.getValorHora();
            double duracaoFesta = festa.getDataFim().getHour() - festa.getDataInicio().getHour();
            valorFuncionarios += valorHora * duracaoFesta;
        }
        double despesasTotais = valorDecoracao + valorPratos + valorFuncionarios;
        return despesasTotais;
    }

    private static void exibirRelatórioFinanceiroFesta(int idFesta) {
        Festa festa = DataFesta.buscarFestaPorId(idFesta);
        if (festa != null) {
            double valorFesta = festa.getValorFesta();
            double despesasTotais = calcularDespesasTotaisFesta(festa);
            double lucro = calcularLucroFesta(idFesta);

            System.out.println("\nRelatório Financeiro da Festa");
            System.out.println(" -Valor da Festa: R$" + valorFesta);
            System.out.println(" -Despesas Totais: R$" + despesasTotais);
            System.out.println(" -Lucro: R$" + lucro);
        } else {
            System.out.println("Festa não encontrada.");
        }
    }

    public static void exibirFaturamentoFestas(LocalDateTime dataInicio, LocalDateTime dataFim) {
        EntityManager manager = EntityManagerFactory.getInstance();
        TypedQuery<Festa> consulta = manager.createQuery(
                "SELECT f FROM Festa f WHERE f.dataInicio >= :dataInicio AND f.dataFim <= :dataFim", Festa.class);
        consulta.setParameter("dataInicio", dataInicio);
        consulta.setParameter("dataFim", dataFim);
        List<Festa> festas = consulta.getResultList();

        if (!festas.isEmpty()) {
            double totalValorFestas = 0;
            double totalDespesasTotais = 0;
            double totalLucro = 0;

            for (Festa festa : festas) {
                totalValorFestas += festa.getValorFesta();
                totalDespesasTotais += calcularDespesasTotaisFesta(festa);
                totalLucro += calcularLucroFesta(festa.getIdFesta());
            }

            System.out.println("\nFaturamento das Festas");
            System.out.println("----------------------");
            System.out.println("Período: " + dataInicio + " a " + dataFim);
            System.out.println("Total de Festas: " + festas.size());
            System.out.println("Total do Valor das Festas: R$ " + totalValorFestas);
            System.out.println("Total das Despesas Totais: R$ " + totalDespesasTotais);
            System.out.println("Total do Lucro: R$ " + totalLucro);
            System.out.println("----------------------");
        } else {
            System.out.println("Não há festas no período especificado.");
        }
    }

    public static void exibirFaturamentoTotal() {
        EntityManager manager = EntityManagerFactory.getInstance();
        TypedQuery<Festa> consulta = manager.createQuery("SELECT f FROM Festa f", Festa.class);
        List<Festa> festas = consulta.getResultList();

        if (!festas.isEmpty()) {
            double totalValorFestas = 0;
            double totalDespesasTotais = 0;
            double totalLucro = 0;
            LocalDateTime primeiraData = festas.get(0).getDataInicio();
            LocalDateTime dataAtual = LocalDateTime.now();
            long intervaloDias = ChronoUnit.DAYS.between(primeiraData, dataAtual);

            for (Festa festa : festas) {
                totalValorFestas += festa.getValorFesta();
                totalDespesasTotais += calcularDespesasTotaisFesta(festa);
                totalLucro += calcularLucroFesta(festa.getIdFesta());
            }

            System.out.println("Faturamento Total das Festas");
            System.out.println("---------------------------");
            System.out.println("Total de Festas: " + festas.size());
            System.out.println("Total do Faturamento das Festas: R$" + totalValorFestas);

            if (intervaloDias >= 30) {
                double despesasMensais = calcularDespesasMensais();
                totalDespesasTotais += despesasMensais;
                System.out.println("Total das Despesas Mensais: R$" + despesasMensais);
            }

            System.out.println("Total das Despesas das festas: R$ " + totalDespesasTotais);
            System.out.println("Total do Lucro: R$ " + totalLucro);
            System.out.println("Balanço Geral: R$" + (totalValorFestas - totalDespesasTotais));
            System.out.println("---------------------------");

        } else {
            System.out.println("Não há festas cadastradas.");
        }
    }

    public static double calcularDespesasMensais() {
        return 6200 + DataFuncionario.somarSalarioFuncionarios();
    }
}