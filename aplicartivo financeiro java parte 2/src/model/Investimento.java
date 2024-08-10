package src.model;

public class Investimento {
    private String nome;
    private double valor;

    public Investimento(String nome, double valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }
}
