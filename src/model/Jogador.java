package model;

import java.time.LocalDate;
import java.util.Objects;

public class Jogador {

    private String cpf;
    private String nome;
    private LocalDate nascimento;
    private String time;
    private String posicao;
    private double valor;

    public Jogador(String cpf, String nome, LocalDate nascimento, String time, String posicao, double valor) {
        this.cpf = cpf;
        this.nome = nome;
        this.nascimento = nascimento;
        this.time = time;
        this.posicao = posicao;
        this.valor = valor;
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

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Jogador{" +
                "cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", nascimento=" + nascimento +
                ", time='" + time + '\'' +
                ", posicao='" + posicao + '\'' +
                ", valor=" + valor +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Jogador jogador)) return false;
        return Objects.equals(cpf, jogador.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cpf);
    }
}
