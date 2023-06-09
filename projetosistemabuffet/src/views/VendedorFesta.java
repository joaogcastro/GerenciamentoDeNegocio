package views;

import data.DataCliente;
import models.Cliente;
import models.Festa;
import util.Console;
import util.LocalDateTimeReader;
import util.CPFUtils;

public class VendedorFesta {
    public static void venderFesta() {
        System.out.println("\nNova festa:");
        Cliente cliente = new Cliente();
        cliente.setCpf(Console.readString("Informe o cpf do cliente: "));
        if (CPFUtils.validarCPF(cliente.getCpf()) == true) {
            if (DataCliente.buscarCPF(cliente) == null) {
                System.out.println("Cliente não cadastrado, ");
                cliente.setNome(Console.readString("Nome do cliente: "));
                cliente.setTelefone(Console.readString("Informe o telefone do cliente: "));
                cliente.setEmail(Console.readString("Informe o email do cliente: "));
                cliente.setEndereco(Console.readString("Informe o endereço do cliente: "));
                DataCliente.incluir(cliente);
            }
            cliente = DataCliente.buscarCPF(cliente);
            Festa festa = new Festa();
            festa.setCliente(cliente);
            festa.setDataInicio(
                    LocalDateTimeReader.readLocalDateTime("Informe a data de início (no formato dd/MM/yyyy HH:mm): "));
            festa.setDataFim(
                    LocalDateTimeReader.readLocalDateTime("Informe a data do fim (no formato dd/MM/yyyy HH:mm): "));

            // VERIFICAR SE NÃO HÁ NENHUMA FESTA NO HORARIO

            festa.setNumeroConvidados(Console.readInt("Informe o número de convidados para a festa: "));
            festa.setDecoracao(null);
            festa.setCardapio(null);
            // Boa pergunta festa.setFuncionarios(null);
            // AUTOMATICO festa.setValorFesta(0);
        } else {
            System.out.println("Esse cpf não é válido.");
        }
    }
}
