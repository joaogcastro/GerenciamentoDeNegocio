package views;

import data.DataCliente;
import data.DataDecoracao;
import data.DataFesta;
import models.Cliente;
import models.Decoracao;
import models.Festa;
import services.FestaService;
import util.Console;
import util.CPFUtils;

public class VendedorFesta {

    public static void venderFesta() {
        System.out.println("\nNova festa:");
        Cliente cliente = new Cliente();
        cliente.setCpf(Console.readString("Informe o cpf do cliente: "));
        if (CPFUtils.validarCPF(cliente.getCpf()) == true) {
            if (DataCliente.buscarCPF(cliente) == null) {
                FestaService.cadastrarCliente(cliente);
            }

            cliente = DataCliente.buscarCPF(cliente);
            Festa festa = new Festa();
            festa.setCliente(cliente);
            FestaService.lerDataInicioFim(festa);

            if (!FestaService.verificarConflitoHorario(festa)) {
                festa.setNumeroConvidados(Console.readInt("Informe o número de convidados para a festa: "));
                festa.setNumeroCriancas(Console.readInt("Informe o número de crianças na festa: "));

                System.out.println("Escolha a decoração:");
                DataDecoracao.listarDecoracoes();
                Decoracao decoracao = new Decoracao();
                decoracao = DataDecoracao.buscarDecoracaoPorId(
                        Console.readInt("Informe o Id da decoração escolhida: "));
                festa.setDecoracao(decoracao);

                FestaService.adicionarCardapio(festa);

                FestaService.adicionarFuncionariosAutomaticamente(festa);

                festa.setValorFesta(FestaService.calcularPrecoFesta(festa));

                System.out.println("O preço da festa é de: " + festa.getValorFesta());
                System.out.println("Solicite o pagamento para o cliente.");

                if (DataFesta.incluir(festa)) {
                    System.out.println("Festa cadastrada com sucesso.");
                } else {
                    System.out.println("Houve um erro ao adicionar a festa.");
                }

            } else {
                System.out.println("O horário selecionado não está disponível. Por favor, escolha outro horário.");
                return;

            }
        } else {
            System.out.println("Esse cpf não é válido.");
        }
    }

    public static void buscarFestas() {
        System.out.println("\nBuscar festas:");
        System.out.println("1- Listar todas as festas.");
        System.out.println("2- Buscar festas por cliente");
        int opcBuscar = Console.readInt("Informe a opção: ");

        switch (opcBuscar) {
            case 1:
                System.out.println("\nLista de festas:");
                DataFesta.listarFestas();
                break;

            case 2:
                System.out.println("\nBuscar festas por nome do cliente:");
                DataFesta.buscarFestaPorCliente(Console.readString("Informe o nome do cliente: "));
                break;

            default:
                System.out.println("\nOpção inválida.");
                break;
        }
    }

    public static void exibirResumoDaFesta() {
        Festa festa;
        System.out.println("Detalhes da festa:");
        festa = new Festa();
        festa = DataFesta.buscarFestaPorId(Console.readInt("Informe o id da festa: "));
        if (festa != null) {
            FestaService.exibirDetalhesFesta(festa);
        } else {
            System.out.println("\nEste id não corresponde a nenhuma festa.");
        }
    }

    public static void cancelarFesta() {
        System.out.println("\nCancelar Festa:");
        Festa festa = DataFesta.buscarFestaPorId(Console.readInt("Informe o ID da festa que deseja excluir: "));
        if (festa != null) {
            if (DataFesta.excluir(festa)) {
                System.out.println(
                        "\nFesta cancelada com sucesso. \nLembre-se de fazer o extorno do pagamento ao cliente caso a festa tenha sido paga com antecedência.");
            } else {
                System.out.println("\nHouve um erro ao excluir a festa.");
            }
        } else {
            System.out.println("\nO ID informado não corresponde à nenhuma festa.");
        }
    }
}