package models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Festa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFesta;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private int numeroConvidados;
    @ManyToOne
    private Cliente cliente;
    @OneToOne
    private Decoracao decoracao;
    @OneToOne
    private Cardapio cardapio;
    @OneToMany
    private List<Funcionario> funcionarios = new ArrayList<Funcionario>();
    private double valorFesta;
    private boolean pagamentoRealizado;

    public int getIdFesta() {
        return idFesta;
    }
    public void setIdFesta(int idFesta) {
        this.idFesta = idFesta;
    }
    public LocalDateTime getDataInicio() {
        return dataInicio;
    }
    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }
    public LocalDateTime getDataFim() {
        return dataFim;
    }
    public void setDataFim(LocalDateTime dataFim) {
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
    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }
    public void setFuncionarios(List<Funcionario> funcionarios) {
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
    public int getNumeroConvidados() {
        return numeroConvidados;
    }
    public void setNumeroConvidados(int numeroConvidados) {
        this.numeroConvidados = numeroConvidados;
    }
}