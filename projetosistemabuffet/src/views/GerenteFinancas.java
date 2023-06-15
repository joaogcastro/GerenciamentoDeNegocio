package views;

import java.time.LocalDateTime;
import java.util.Scanner;

import data.DataFuncionario;
import data.DataIngrediente;
import services.FestaService;
import util.Console;
import util.LocalDateTimeReader;

public class GerenteFinancas {

    public static void exibirRelatorioFinanceiro() {
        int opc;
        do {    
            System.out.println("\nRelatório financeiro do Buffet:");
            System.out.println("1- Balanço Geral total."); //Faturamento de todas as festas no banco. (Exibir faturamento, despesas das festas, despesas mensais e lucro)
            System.out.println("2- Faturamento das festas.");
            System.out.println("3- Detalhar Despesas Mensais.");
            System.out.println("4- Valor do estoque.");
            System.out.println("5- Voltar ao menu.");
            opc = Console.readInt("Informe a opção: ");

            switch (opc) {
                case 1:
                    FestaService.exibirFaturamentoTotal();
                    break;

                case 2:
                    exibirFaturamentoFestas();
                    break;

                case 3:
                    detalharDespesasMensais();
                    break;

                case 4:
                    DataIngrediente.calcularValorTotalEstoque();
                    break;

                case 5:
                    System.out.println("\nVoltando ao menu.");
                    break;

                default:
                    System.out.println("Esta opção não é válida.");
                    break;
            }

        } while (opc != 5);
    }

    private static void exibirFaturamentoFestas() {
        System.out.println("\nFaturamento das festas de um período:");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe a data de início da busca(no formato dd/MM/yyyy HH:mm): ");
        LocalDateTime dataInicio = LocalDateTimeReader.readLocalDateTimeFromInput(scanner);
        System.out.println("Informe a data de fim da busca(no formato dd/MM/yyyy HH:mm): ");
        LocalDateTime dataFim = LocalDateTimeReader.readLocalDateTimeFromInput(scanner);
        FestaService.exibirFaturamentoFestas(dataInicio, dataFim);
    }

    private static void detalharDespesasMensais() {
        System.out.println("\nDetalhamento das Despesas Mensais:");
        System.out.println(" Aluguel: R$3000.00");
        System.out.println(" Energia: R$1000.00");
        System.out.println(" Água: R$600.00");
        System.out.println(" Comunicação: R$400.00");
        System.out.println(" Limpeza: R$1200.00");
        System.out.println(" Salários dos funcionários CLT: R$"+DataFuncionario.somarSalarioFuncionarios());
        System.out.println("Total: R$"+FestaService.calcularDespesasMensais());
    }
}