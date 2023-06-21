package data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import models.Cardapio;
import models.Cliente;
import models.Decoracao;
import models.Fornecedor;
import models.Funcionario;
import models.Ingrediente;
import util.CNPJUtils;
import util.CPFUtils;
import util.TelefoneUtils;

public class ExemplosDB {

    private static boolean verificarDBIniciado() {
        EntityManager manager = EntityManagerFactory.getInstance();
        TypedQuery<Cliente> consulta = manager.createQuery("SELECT c FROM Cliente c",
        Cliente.class);
        List<Cliente> clientes = consulta.getResultList();
        if (clientes.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public static void adicionarExemplos() {

        if (verificarDBIniciado() == false) {

            Cliente cliente1 = new Cliente();
            cliente1.setNome("Claudio");
            cliente1.setCpf("541.273.109-37");
            cliente1.setEmail("claudioF@gmail.com");
            cliente1.setEndereco("alto da XV");
            cliente1.setTelefone("41 990876453");
            String cpfFormatado = CPFUtils.formatarCPF(cliente1.getCpf());
            cliente1.setCpf(cpfFormatado);
            String telefoneFormatado = TelefoneUtils.formatarTelefone(cliente1.getTelefone());
            cliente1.setTelefone(telefoneFormatado);
            if (DataCliente.incluir(cliente1)) {
                System.out.println("Exemplos incluídos no banco de dados.");
            }

            Cliente cliente2 = new Cliente();
            cliente2.setNome("Jorge");
            cliente2.setCpf("979.824.750-78");
            cliente2.setEmail("jorgeP@gmail.com");
            cliente2.setEndereco("Ecoville");
            cliente2.setTelefone("41 998542136");
            cpfFormatado = CPFUtils.formatarCPF(cliente2.getCpf());
            cliente2.setCpf(cpfFormatado);
            telefoneFormatado = TelefoneUtils.formatarTelefone(cliente2.getTelefone());
            cliente2.setTelefone(telefoneFormatado);
            DataCliente.incluir(cliente2);

            Cliente cliente3 = new Cliente();
            cliente3.setNome("Felipe");
            cliente3.setCpf("136.597.610-60");
            cliente3.setEmail("Felipe07@hotmail.com");
            cliente3.setEndereco("Santa Quitéria");
            cliente3.setTelefone("41 997865712");
            cpfFormatado = CPFUtils.formatarCPF(cliente3.getCpf());
            cliente3.setCpf(cpfFormatado);
            telefoneFormatado = TelefoneUtils.formatarTelefone(cliente3.getTelefone());
            cliente3.setTelefone(telefoneFormatado);
            DataCliente.incluir(cliente3);

            Cliente cliente4 = new Cliente();
            cliente4.setNome("Peter");
            cliente4.setCpf("635.330.150-25");
            cliente4.setEmail("PeterP@gmail.com");
            cliente4.setEndereco("Campo Comprido");
            cliente4.setTelefone("41 990605890");
            cpfFormatado = CPFUtils.formatarCPF(cliente4.getCpf());
            cliente4.setCpf(cpfFormatado);
            telefoneFormatado = TelefoneUtils.formatarTelefone(cliente4.getTelefone());
            cliente4.setTelefone(telefoneFormatado);
            DataCliente.incluir(cliente4);

            Cliente cliente5 = new Cliente();
            cliente5.setNome("Geraldo");
            cliente5.setCpf("523.675.920-04");
            cliente5.setEmail("Gerald0@hotmail.com");
            cliente5.setEndereco("Santa Felicidade");
            cliente5.setTelefone("41 998060598");
            cpfFormatado = CPFUtils.formatarCPF(cliente5.getCpf());
            cliente5.setCpf(cpfFormatado);
            telefoneFormatado = TelefoneUtils.formatarTelefone(cliente5.getTelefone());
            cliente5.setTelefone(telefoneFormatado);
            DataCliente.incluir(cliente5);

            Cliente cliente6 = new Cliente();
            cliente6.setNome("Eduardo");
            cliente6.setCpf("028.902.550-85");
            cliente6.setEmail("EduM@hotmail.com");
            cliente6.setEndereco("Cristo Rei");
            cliente6.setTelefone("41 990786850");
            cpfFormatado = CPFUtils.formatarCPF(cliente6.getCpf());
            cliente6.setCpf(cpfFormatado);
            telefoneFormatado = TelefoneUtils.formatarTelefone(cliente6.getTelefone());
            cliente6.setTelefone(telefoneFormatado);
            DataCliente.incluir(cliente6);

            Cliente cliente7 = new Cliente();
            cliente7.setNome("Jonas");
            cliente7.setCpf("463.337.590-31");
            cliente7.setEmail("JonasJ@gmail.com");
            cliente7.setEndereco("Campo Comprido");
            cliente7.setTelefone("41 998076039");
            cpfFormatado = CPFUtils.formatarCPF(cliente7.getCpf());
            cliente7.setCpf(cpfFormatado);
            telefoneFormatado = TelefoneUtils.formatarTelefone(cliente7.getTelefone());
            cliente7.setTelefone(telefoneFormatado);
            DataCliente.incluir(cliente7);

            Cardapio item1 = new Cardapio();
            item1.setNome("Hambúrguer");
            item1.setPreco(800.00);
            DataCardapio.incluir(item1);

            Cardapio item2 = new Cardapio();
            item2.setNome("Batata-frita");
            item2.setPreco(400.90);
            DataCardapio.incluir(item2);

            Cardapio item3 = new Cardapio();
            item3.setNome("Refrigerante");
            item3.setPreco(299.99);
            DataCardapio.incluir(item3);

            Cardapio item4 = new Cardapio();
            item4.setNome("Onion rings");
            item4.setPreco(449.99);
            DataCardapio.incluir(item4);

            Cardapio item5 = new Cardapio();
            item5.setNome("Sorvete");
            item5.setPreco(300.00);
            DataCardapio.incluir(item5);

            Cardapio item6 = new Cardapio();
            item6.setNome("mousse");
            item6.setPreco(459.00);
            DataCardapio.incluir(item6);

            Fornecedor fornecedor1 = new Fornecedor();
            fornecedor1.setNome("Play Party");
            fornecedor1.setTelefone("41 998571235");
            fornecedor1.setCnpj("62.216.000/0001-80");
            String cnpjFormatado = CNPJUtils.formatarCNPJ(fornecedor1.getCnpj());
            fornecedor1.setCnpj(cnpjFormatado);
            telefoneFormatado = TelefoneUtils.formatarTelefone(fornecedor1.getTelefone());
            fornecedor1.setTelefone(telefoneFormatado);
            DataFornecedor.incluir(fornecedor1);

            Fornecedor fornecedor2 = new Fornecedor();
            fornecedor2.setNome("Joy Festas");
            fornecedor2.setTelefone("41991235763");
            fornecedor2.setCnpj("98.356.638/0001-64");
            cnpjFormatado = CNPJUtils.formatarCNPJ(fornecedor2.getCnpj());
            fornecedor2.setCnpj(cnpjFormatado);
            telefoneFormatado = TelefoneUtils.formatarTelefone(fornecedor2.getTelefone());
            fornecedor2.setTelefone(telefoneFormatado);
            DataFornecedor.incluir(fornecedor2);

            Fornecedor fornecedor3 = new Fornecedor();
            fornecedor3.setNome("Bloon baloes");
            fornecedor3.setTelefone("41 996711343");
            fornecedor3.setCnpj("72.544.716/0001-60");
            cnpjFormatado = CNPJUtils.formatarCNPJ(fornecedor3.getCnpj());
            fornecedor3.setCnpj(cnpjFormatado);
            telefoneFormatado = TelefoneUtils.formatarTelefone(fornecedor3.getTelefone());
            fornecedor3.setTelefone(telefoneFormatado);
            DataFornecedor.incluir(fornecedor3);

            Fornecedor fornecedor4 = new Fornecedor();
            fornecedor4.setNome("Best Party festas");
            fornecedor4.setTelefone("41 990875030");
            fornecedor4.setCnpj("17.693.397/0001-47");
            cnpjFormatado = CNPJUtils.formatarCNPJ(fornecedor4.getCnpj());
            fornecedor4.setCnpj(cnpjFormatado);
            telefoneFormatado = TelefoneUtils.formatarTelefone(fornecedor4.getTelefone());
            fornecedor4.setTelefone(telefoneFormatado);
            DataFornecedor.incluir(fornecedor4);

            Fornecedor fornecedor5 = new Fornecedor();
            fornecedor5.setNome("Big Festa");
            fornecedor5.setTelefone("41 990879684");
            fornecedor5.setCnpj("22.482.562/0001-51");
            cnpjFormatado = CNPJUtils.formatarCNPJ(fornecedor5.getCnpj());
            fornecedor5.setCnpj(cnpjFormatado);
            telefoneFormatado = TelefoneUtils.formatarTelefone(fornecedor5.getTelefone());
            fornecedor5.setTelefone(telefoneFormatado);
            DataFornecedor.incluir(fornecedor5);

            Decoracao decoracao1 = new Decoracao();
            decoracao1.setFornecedor(fornecedor5);
            decoracao1.setTema("Spider-man");
            decoracao1.setPreco(300.00);
            DataDecoracao.incluir(decoracao1);

            Decoracao decoracao2 = new Decoracao();
            decoracao2.setFornecedor(fornecedor2);
            decoracao2.setTema("Avengers");
            decoracao2.setPreco(500.00);
            DataDecoracao.incluir(decoracao2);

            Decoracao decoracao3 = new Decoracao();
            decoracao3.setFornecedor(fornecedor4);
            decoracao3.setTema("Batman");
            decoracao3.setPreco(350.00);
            DataDecoracao.incluir(decoracao3);

            Decoracao decoracao4 = new Decoracao();
            decoracao4.setFornecedor(fornecedor3);
            decoracao4.setTema("Mulher maravilha");
            decoracao4.setPreco(600.00);
            DataDecoracao.incluir(decoracao4);

            Decoracao decoracao5 = new Decoracao();
            decoracao5.setFornecedor(fornecedor1);
            decoracao5.setTema("Sonic");
            decoracao5.setPreco(400.00);
            DataDecoracao.incluir(decoracao5);

            Ingrediente ingrediente1 = new Ingrediente();
            ingrediente1.setNomeIngrediente("Carne Hamburguer");
            ingrediente1.setQuantidade(70);
            ingrediente1.setValorUnitario(15);
            DataIngrediente.incluir(ingrediente1);

            Ingrediente ingrediente2 = new Ingrediente();
            ingrediente2.setNomeIngrediente("pão brioche");
            ingrediente2.setQuantidade(70);
            ingrediente2.setValorUnitario(0.20);
            DataIngrediente.incluir(ingrediente2);

            Ingrediente ingrediente3 = new Ingrediente();
            ingrediente3.setNomeIngrediente("Cebola");
            ingrediente3.setQuantidade(50);
            ingrediente3.setValorUnitario(0.35);
            DataIngrediente.incluir(ingrediente3);

            Ingrediente ingrediente4 = new Ingrediente();
            ingrediente4.setNomeIngrediente("Batata");
            ingrediente4.setQuantidade(100);
            ingrediente4.setValorUnitario(0.25);
            DataIngrediente.incluir(ingrediente4);

            Ingrediente ingrediente5 = new Ingrediente();
            ingrediente5.setNomeIngrediente("farinha");
            ingrediente5.setQuantidade(10);
            ingrediente5.setValorUnitario(5.00);
            DataIngrediente.incluir(ingrediente5);

            Ingrediente ingrediente6 = new Ingrediente();
            ingrediente6.setNomeIngrediente("refrigerante");
            ingrediente6.setQuantidade(40);
            ingrediente6.setValorUnitario(7.50);
            DataIngrediente.incluir(ingrediente6);

            Ingrediente ingrediente7 = new Ingrediente();
            ingrediente7.setNomeIngrediente("Massa de sorvete");
            ingrediente7.setQuantidade(15);
            ingrediente7.setValorUnitario(35.00);
            DataIngrediente.incluir(ingrediente7);

            Ingrediente ingrediente8 = new Ingrediente();
            ingrediente8.setNomeIngrediente("óleo");
            ingrediente8.setQuantidade(10);
            ingrediente8.setValorUnitario(5.00);
            DataIngrediente.incluir(ingrediente8);

            Ingrediente ingrediente9 = new Ingrediente();
            ingrediente9.setNomeIngrediente("ovo");
            ingrediente9.setQuantidade(50);
            ingrediente9.setValorUnitario(0.30);
            DataIngrediente.incluir(ingrediente9);

            Ingrediente ingrediente10 = new Ingrediente();
            ingrediente10.setNomeIngrediente("leite condensado");
            ingrediente10.setQuantidade(15);
            ingrediente10.setValorUnitario(7.50);
            DataIngrediente.incluir(ingrediente10);

            Ingrediente ingrediente11 = new Ingrediente();
            ingrediente11.setNomeIngrediente("Creme de leite");
            ingrediente11.setQuantidade(15);
            ingrediente11.setValorUnitario(3.50);
            DataIngrediente.incluir(ingrediente11);

            Ingrediente ingrediente12 = new Ingrediente();
            ingrediente12.setNomeIngrediente("leite");
            ingrediente12.setQuantidade(24);
            ingrediente12.setValorUnitario(4.00);
            DataIngrediente.incluir(ingrediente12);

            Funcionario funcionario1 = new Funcionario();
            funcionario1.setNome("Carlos");
            funcionario1.setTelefone("41 990877009");
            funcionario1.setGarcom(true);
            funcionario1.setValorHora(17.00);
            funcionario1.setCpf("240.630.120-69");
            cpfFormatado = CPFUtils.formatarCPF(funcionario1.getCpf());
            funcionario1.setCpf(cpfFormatado);
            telefoneFormatado = TelefoneUtils.formatarTelefone(funcionario1.getTelefone());
            funcionario1.setTelefone(telefoneFormatado);
            DataFuncionario.incluir(funcionario1);

            Funcionario funcionario2 = new Funcionario();
            funcionario2.setNome("Pedro");
            funcionario2.setTelefone("41 998675452");
            funcionario2.setGarcom(true);
            funcionario2.setValorHora(17.00);
            funcionario2.setCpf("520.754.970-79");
            cpfFormatado = CPFUtils.formatarCPF(funcionario2.getCpf());
            funcionario2.setCpf(cpfFormatado);
            telefoneFormatado = TelefoneUtils.formatarTelefone(funcionario2.getTelefone());
            funcionario2.setTelefone(telefoneFormatado);
            DataFuncionario.incluir(funcionario2);

            Funcionario funcionario3 = new Funcionario();
            funcionario3.setNome("João");
            funcionario3.setTelefone("41 990674380");
            funcionario3.setGarcom(true);
            funcionario3.setValorHora(17.00);
            funcionario3.setCpf("784.480.730-02");
            cpfFormatado = CPFUtils.formatarCPF(funcionario3.getCpf());
            funcionario3.setCpf(cpfFormatado);
            telefoneFormatado = TelefoneUtils.formatarTelefone(funcionario3.getTelefone());
            funcionario3.setTelefone(telefoneFormatado);
            DataFuncionario.incluir(funcionario3);

            Funcionario funcionario4 = new Funcionario();
            funcionario4.setNome("Paulo");
            funcionario4.setTelefone("41 990604078");
            funcionario4.setGarcom(true);
            funcionario4.setValorHora(17.00);
            funcionario4.setCpf("502.588.680-58");
            cpfFormatado = CPFUtils.formatarCPF(funcionario4.getCpf());
            funcionario4.setCpf(cpfFormatado);
            telefoneFormatado = TelefoneUtils.formatarTelefone(funcionario4.getTelefone());
            funcionario4.setTelefone(telefoneFormatado);
            DataFuncionario.incluir(funcionario4);

            Funcionario funcionario5 = new Funcionario();
            funcionario5.setNome("Vinicius");
            funcionario5.setTelefone("41 995062034");
            funcionario5.setMonitor(true);
            funcionario5.setValorHora(15.00);
            funcionario5.setCpf("525.362.310-89");
            cpfFormatado = CPFUtils.formatarCPF(funcionario5.getCpf());
            funcionario5.setCpf(cpfFormatado);
            telefoneFormatado = TelefoneUtils.formatarTelefone(funcionario5.getTelefone());
            funcionario5.setTelefone(telefoneFormatado);
            DataFuncionario.incluir(funcionario5);

            Funcionario funcionario6 = new Funcionario();
            funcionario6.setNome("Diego");
            funcionario6.setTelefone("41 990078064");
            funcionario6.setMonitor(true);
            funcionario6.setValorHora(15.00);
            funcionario6.setCpf("429.257.960-10");
            cpfFormatado = CPFUtils.formatarCPF(funcionario6.getCpf());
            funcionario6.setCpf(cpfFormatado);
            telefoneFormatado = TelefoneUtils.formatarTelefone(funcionario6.getTelefone());
            funcionario6.setTelefone(telefoneFormatado);
            DataFuncionario.incluir(funcionario6);

            Funcionario funcionario7 = new Funcionario();
            funcionario7.setNome("Maria");
            funcionario7.setTelefone("41 990707248");
            funcionario7.setMonitor(true);
            funcionario7.setValorHora(15.00);
            funcionario7.setCpf("089.778.970-92");
            cpfFormatado = CPFUtils.formatarCPF(funcionario7.getCpf());
            funcionario7.setCpf(cpfFormatado);
            telefoneFormatado = TelefoneUtils.formatarTelefone(funcionario7.getTelefone());
            funcionario7.setTelefone(telefoneFormatado);
            DataFuncionario.incluir(funcionario7);

            Funcionario funcionario8 = new Funcionario();
            funcionario8.setNome("Luiza");
            funcionario8.setTelefone("41 991267010");
            funcionario8.setMonitor(true);
            funcionario8.setValorHora(15.00);
            funcionario8.setCpf("236.296.820-06");
            cpfFormatado = CPFUtils.formatarCPF(funcionario8.getCpf());
            funcionario8.setCpf(cpfFormatado);
            telefoneFormatado = TelefoneUtils.formatarTelefone(funcionario8.getTelefone());
            funcionario8.setTelefone(telefoneFormatado);
            DataFuncionario.incluir(funcionario8);

            Funcionario funcionario9 = new Funcionario();
            funcionario9.setNome("Marry");
            funcionario9.setTelefone("41 995822010");
            funcionario9.setSalario(2500);
            funcionario9.setCpf("045.886.060-34");
            funcionario9.setClt(true);
            funcionario9.setFuncao("Cozinheiro");
            cpfFormatado = CPFUtils.formatarCPF(funcionario9.getCpf());
            funcionario9.setCpf(cpfFormatado);
            telefoneFormatado = TelefoneUtils.formatarTelefone(funcionario9.getTelefone());
            funcionario9.setTelefone(telefoneFormatado);
            DataFuncionario.incluir(funcionario9);

            Funcionario funcionario10 = new Funcionario();
            funcionario10.setNome("Rafael");
            funcionario10.setTelefone("41 990562136");
            funcionario10.setSalario(3000);
            funcionario10.setCpf("514.934.660-89");
            funcionario10.setClt(true);
            funcionario10.setFuncao("Vendedor");
            cpfFormatado = CPFUtils.formatarCPF(funcionario10.getCpf());
            funcionario10.setCpf(cpfFormatado);
            telefoneFormatado = TelefoneUtils.formatarTelefone(funcionario10.getTelefone());
            funcionario10.setTelefone(telefoneFormatado);
            DataFuncionario.incluir(funcionario10);
        
        }else{
            return;
        }
    }
}