package models;

import java.time.LocalDate;
import java.util.ArrayList;

public class Festa {
    private int idFesta;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Cliente cliente;
    private Decoracao decoracao;
    private Cardapio cardapio;
    private ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>(); //Funcionario CLT e taxa
    private double valorFesta;
    private boolean pagamentoRealizado;

    public int getIdFesta() {
        return idFesta;
    }
    public void setIdFesta(int idFesta) {
        this.idFesta = idFesta;
    }
    public LocalDate getDataInicio() {
        return dataInicio;
    }
    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }
    public LocalDate getDataFim() {
        return dataFim;
    }
    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public Decoracao getDecoracao() {
        return decoracao;
    }
    public void setDecoracao(Decoracao decoracao) {
        this.decoracao = decoracao;
    }
    public Cardapio getCardapio() {
        return cardapio;
    }
    public void setCardapio(Cardapio cardapio) {
        this.cardapio = cardapio;
    }
    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }
    public void setFuncionarios(ArrayList<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }
    public double getValorFesta() {
        return valorFesta;
    }
    public void setValorFesta(double valorFesta) {
        this.valorFesta = valorFesta;
    }
    public boolean isPagamentoRealizado() {
        return pagamentoRealizado;
    }
    public void setPagamentoRealizado(boolean pagamentoRealizado) {
        this.pagamentoRealizado = pagamentoRealizado;
    }
}