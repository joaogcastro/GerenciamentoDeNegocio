package models;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    private int numeroCriancas;
    @OneToOne
    private Cliente cliente;
    @OneToOne
    private Decoracao decoracao;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Cardapio> cardapio;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Funcionario> funcionarios;
    private double valorFesta;
    
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

    public List<Cardapio> getCardapio() {
        return cardapio;
    }

    public void setCardapio(List<Cardapio> cardapio) {
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

    public int getNumeroConvidados() {
        return numeroConvidados;
    }

    public void setNumeroConvidados(int numeroConvidados) {
        this.numeroConvidados = numeroConvidados;
    }

    public int getNumeroCriancas() {
        return numeroCriancas;
    }

    public void setNumeroCriancas(int numeroCriancas) {
        this.numeroCriancas = numeroCriancas;
    }
}
