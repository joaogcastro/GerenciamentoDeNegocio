package models;

import java.util.ArrayList;

public class Cliente {
    private int id;
    private String cpf;
    private String nome;
    private String email;
    private String telefone;
    private String endereco;
    private static ArrayList<Festa> historicoFestas = new ArrayList<Festa>();

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public static ArrayList<Festa> getHistoricoFestas() {
        return historicoFestas;
    }
    public static void setHistoricoFestas(ArrayList<Festa> historicoFestas) {
        Cliente.historicoFestas = historicoFestas;
    }
}