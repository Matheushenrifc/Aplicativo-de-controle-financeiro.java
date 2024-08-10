package src.model;

public abstract class CartaoCredito {
    private String numero;
    private double limite;
    private double saldoAtual;

    public CartaoCredito(String numero, double limite) {
        this.numero = numero;
        this.limite = limite;
        this.saldoAtual = limite;
    }

    public String getNumero() {
        return numero;
    }

    public double getLimite() {
        return limite;
    }

    public double getSaldoAtual() {
        return saldoAtual;
    }

    public void realizarCompra(double valor) {
        if (saldoAtual >= valor) {
            saldoAtual -= valor;
            notificarCompra(valor);
        } else {
            System.out.println("Limite insuficiente para a compra.");
        }
    }

    // Método abstrato que deve ser implementado pelas subclasses
    public abstract void notificarCompra(double valor);
}