package data;

import models.Cardapio;
import models.Cliente;
import models.Decoracao;
import models.Fornecedor;
import models.Funcionario;
import models.Ingrediente;
import data.DataCliente;

public class ExemplosDB {
     public static void main(String[] args) 
    {
    
    Cliente cliente1 = new Cliente();
        cliente1.setNome("Claudio");
        cliente1.setId(1);
        cliente1.setCpf("541.273.109-37");
        cliente1.setEmail("claudioF@gmail.com");
        cliente1.setEndereco("alto da XV");
        cliente1.setTelefone("41 990876453");

        Cliente cliente2 = new Cliente();
        cliente2.setNome("Jorge");
        cliente2.setId(2);
        cliente2.setCpf("979.824.750-78");
        cliente2.setEmail("jorgeP@gmail.com");
        cliente2.setEndereco("Ecoville");
        cliente2.setTelefone("41 998542136");

        Cliente cliente3 = new Cliente();
        cliente3.setNome("Felipe");
        cliente3.setId(3);
        cliente3.setCpf("136.597.610-60");
        cliente3.setEmail("Felipe07@hotmail.com");
        cliente3.setEndereco("Santa Quitéria");
        cliente3.setTelefone("41 997865712");

        Cliente cliente4 = new Cliente();
        cliente4.setNome("Peter");
        cliente4.setId(4);
        cliente4.setCpf("635.330.150-25");
        cliente4.setEmail("PeterP@gmail.com");
        cliente4.setEndereco("Campo Comprido");
        cliente4.setTelefone("41 990605890");

        Cliente cliente5 = new Cliente();
        cliente5.setNome("Geraldo");
        cliente5.setId(5);
        cliente5.setCpf("523.675.920-04");
        cliente5.setEmail("Gerald0@hotmail.com");
        cliente5.setEndereco("Santa Felicidade");
        cliente5.setTelefone("41 998060598");

        Cliente cliente6 = new Cliente();
        cliente6.setNome("Eduardo");
        cliente6.setId(6);
        cliente6.setCpf("028.902.550-85");
        cliente6.setEmail("EduM@hotmail.com");
        cliente6.setEndereco("Cristo Rei");
        cliente6.setTelefone("41 990786850");

        Cliente cliente7 = new Cliente();
        cliente7.setNome("Jonas");
        cliente7.setId(7);
        cliente7.setCpf("463.337.590-31");
        cliente7.setEmail("JonasJ@gmail.com");
        cliente7.setEndereco("Campo Comprido");
        cliente7.setTelefone("41 998076039");

        Cardapio item1 = new Cardapio();
        item1.setId(1);
        item1.setNome("Hambúrguer");
        item1.setPreco(25.00);

        Cardapio item2 = new Cardapio();
        item2.setId(2);
        item2.setNome("Batata-frita");
        item2.setPreco(12.90);

        Cardapio item3 = new Cardapio();
        item3.setId(3);
        item3.setNome("Refrigerante");
        item3.setPreco(9.00);

        Cardapio item4 = new Cardapio();
        item4.setId(4);
        item4.setNome("Onion rings");
        item4.setPreco(15.00);

        Cardapio item5 = new Cardapio();
        item5.setId(5);
        item5.setNome("Sorvete");
        item5.setPreco(10.00);

        Cardapio item6= new Cardapio();
        item6.setId(6);
        item6.setNome("mousse");
        item6.setPreco(8.00);

        Decoracao decoracao1 = new Decoracao();
        decoracao1.setFornecedor(null);
        decoracao1.setId(1);
        decoracao1.setTema("Spider-man");
        decoracao1.setPreco(300.00);

        Decoracao decoracao2 = new Decoracao();
        decoracao2.setFornecedor(null);
        decoracao2.setId(2);
        decoracao2.setTema("Avengers");
        decoracao2.setPreco(500.00);

        Decoracao decoracao3 = new Decoracao();
        decoracao3.setFornecedor(null);
        decoracao3.setId(3);
        decoracao3.setTema("Batman");
        decoracao3.setPreco(350.00);

        Decoracao decoracao4 = new Decoracao();
        decoracao4.setFornecedor(null);
        decoracao4.setId(4);
        decoracao4.setTema("Mulher maravilha");
        decoracao4.setPreco(600.00);

        Decoracao decoracao5 = new Decoracao();
        decoracao5.setFornecedor(null);
        decoracao5.setId(5);
        decoracao5.setTema("Sonic");
        decoracao5.setPreco(400.00);

        Fornecedor fornecedor1 = new Fornecedor();
        fornecedor1.setId(1);
        fornecedor1.setNome("Play Party");
        fornecedor1.setTelefone("41 998571235");
        fornecedor1.setCnpj("62.216.000/0001-80");

        Fornecedor fornecedor2 = new Fornecedor();
        fornecedor2.setId(2);
        fornecedor2.setNome("Joy Festas");
        fornecedor2.setTelefone("41 9912357632");
        fornecedor2.setCnpj("98.356.638/0001-64");

        Fornecedor fornecedor3 = new Fornecedor();
        fornecedor3.setId(3);
        fornecedor3.setNome("Bloon baloes");
        fornecedor3.setTelefone("41 996711343");
        fornecedor3.setCnpj("72.544.716/0001-60");

        Fornecedor fornecedor4 = new Fornecedor();
        fornecedor4.setId(4);
        fornecedor4.setNome("Best Party festas");
        fornecedor4.setTelefone("41 990875030");
        fornecedor4.setCnpj("17.693.397/0001-47");

        Fornecedor fornecedor5 = new Fornecedor();
        fornecedor5.setId(5);
        fornecedor5.setNome("Big Festa");
        fornecedor4.setTelefone("41 990879684");
        fornecedor4.setCnpj("22.482.562/0001-51");

        Ingrediente ingrediente1 = new Ingrediente();
        ingrediente1.setIdIngrediente(1);
        ingrediente1.setNomeIngrediente("Carne Hamburguer");
        ingrediente1.setQuantidade(70);
        ingrediente1.setValorUnitario(15);

        Ingrediente ingrediente2 = new Ingrediente();
        ingrediente2.setIdIngrediente(2);
        ingrediente2.setNomeIngrediente("pão brioche");
        ingrediente2.setQuantidade(70);
        ingrediente2.setValorUnitario(0.20);

        Ingrediente ingrediente3 = new Ingrediente();
        ingrediente3.setIdIngrediente(3);
        ingrediente3.setNomeIngrediente("Cebola");
        ingrediente3.setQuantidade(50);
        ingrediente3.setValorUnitario(0.35);

        Ingrediente ingrediente4 = new Ingrediente();
        ingrediente4.setIdIngrediente(4);
        ingrediente4.setNomeIngrediente("Batata");
        ingrediente4.setQuantidade(100);
        ingrediente4.setValorUnitario(0.25);

        Ingrediente ingrediente5 = new Ingrediente();
        ingrediente5.setIdIngrediente(5);
        ingrediente5.setNomeIngrediente("farinha");
        ingrediente5.setQuantidade(10);
        ingrediente5.setValorUnitario(5.00);

        Ingrediente ingrediente6 = new Ingrediente();
        ingrediente6.setIdIngrediente(6);
        ingrediente6.setNomeIngrediente("refrigerante");
        ingrediente6.setQuantidade(40);
        ingrediente6.setValorUnitario(7.50);

        Ingrediente ingrediente7 = new Ingrediente();
        ingrediente7.setIdIngrediente(7);
        ingrediente7.setNomeIngrediente("Massa de sorvete");
        ingrediente7.setQuantidade(15);
        ingrediente7.setValorUnitario(35.00);

        Ingrediente ingrediente8 = new Ingrediente();
        ingrediente8.setIdIngrediente(8);
        ingrediente8.setNomeIngrediente("óleo");
        ingrediente8.setQuantidade(10);
        ingrediente8.setValorUnitario(5.00);

        Ingrediente ingrediente9 = new Ingrediente();
        ingrediente9.setIdIngrediente(9);
        ingrediente9.setNomeIngrediente("ovo");
        ingrediente9.setQuantidade(50);
        ingrediente9.setValorUnitario(0.30);

        Ingrediente ingrediente10 = new Ingrediente();
        ingrediente10.setIdIngrediente(10);
        ingrediente10.setNomeIngrediente("leite condensado");
        ingrediente10.setQuantidade(15);
        ingrediente10.setValorUnitario(7.50);

        Ingrediente ingrediente11 = new Ingrediente();
        ingrediente11.setIdIngrediente(11);
        ingrediente11.setNomeIngrediente("Creme de leite");
        ingrediente11.setQuantidade(15);
        ingrediente11.setValorUnitario(3.50);

        Ingrediente ingrediente12 = new Ingrediente();
        ingrediente12.setIdIngrediente(12);
        ingrediente12.setNomeIngrediente("leite");
        ingrediente12.setQuantidade(24);
        ingrediente12.setValorUnitario(4.00);

        Funcionario funcionario1 = new Funcionario();
        funcionario1.setId(1);
        funcionario1.setNome("Carlos");
        funcionario1.setTelefone("41 990877009");
        funcionario1.setGarcom(true);
        funcionario1.setValorHora(17.00);
        funcionario1.setCpf("240.630.120-69");
        
        Funcionario funcionario2 = new Funcionario();
        funcionario2.setId(2);
        funcionario2.setNome("Pedro");
        funcionario2.setTelefone("41 998675452");
        funcionario2.setGarcom(true);
        funcionario2.setValorHora(17.00);
        funcionario2.setCpf("520.754.970-79");

        Funcionario funcionario3 = new Funcionario();
        funcionario3.setId(3);
        funcionario3.setNome("João");
        funcionario3.setTelefone("41 990674380");
        funcionario3.setGarcom(true);
        funcionario3.setValorHora(17.00);
        funcionario3.setCpf("784.480.730-02");

        Funcionario funcionario4 = new Funcionario();
        funcionario4.setId(4);
        funcionario4.setNome("Paulo");
        funcionario4.setTelefone("41 990604078");
        funcionario4.setGarcom(true);
        funcionario4.setValorHora(17.00);
        funcionario4.setCpf("502.588.680-58");

        Funcionario funcionario5 = new Funcionario();
        funcionario5.setId(5);
        funcionario5.setNome("Vinicius");
        funcionario5.setTelefone("41 995062034");
        funcionario5.setMonitor(true);
        funcionario5.setValorHora(15.00);
        funcionario5.setCpf("525.362.310-89");

        Funcionario funcionario6 = new Funcionario();
        funcionario6.setId(6);
        funcionario6.setNome("Diego");
        funcionario6.setTelefone("41 990078064");
        funcionario6.setMonitor(true);
        funcionario6.setValorHora(15.00);
        funcionario6.setCpf("429.257.960-10");

        Funcionario funcionario7 = new Funcionario();
        funcionario7.setId(7);
        funcionario7.setNome("Maria");
        funcionario7.setTelefone("41 990707248");
        funcionario7.setMonitor(true);
        funcionario7.setValorHora(15.00);
        funcionario7.setCpf("089.778.970-92");

        Funcionario funcionario8 = new Funcionario();
        funcionario8.setId(8);
        funcionario8.setNome("Luiza");
        funcionario8.setTelefone("41 991267010");
        funcionario8.setMonitor(true);
        funcionario8.setValorHora(15.00);
        funcionario8.setCpf("236.296.820-06");

        Funcionario funcionario9 = new Funcionario();
        funcionario9.setId(9);
        funcionario9.setNome("Marry");
        funcionario9.setTelefone("41 995822010");
        funcionario9.setSalario(2500);
        funcionario9.setCpf("045.886.060-34");
        funcionario9.setClt(true);

        Funcionario funcionario10 = new Funcionario();
        funcionario10.setId(10);
        funcionario10.setNome("Rafael");
        funcionario10.setTelefone("41 990562136");
        funcionario10.setSalario(3000);
        funcionario10.setCpf("514.934.660-89");
        funcionario10.setClt(true);
    }
}

            