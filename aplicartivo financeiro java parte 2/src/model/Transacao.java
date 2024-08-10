package src.model;

public class Transacao {
    private double valor;
    private String tipo; 

    public Transacao(double valor, String tipo) {
        this.valor = valor;
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public String getTipo() {
        return tipo;
    }
}
