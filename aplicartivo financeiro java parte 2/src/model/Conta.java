package src.model;

import java.util.ArrayList;
import java.util.List;

public class Conta {
    private String numeroConta;
    private double saldo;
    private String tipoConta;
    private CartaoCredito cartaoCredito;
    private List<Investimento> investimentos;
    private List<Transacao> transacoes;

    public Conta(String numeroConta, double saldo, String tipoConta) {
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        this.tipoConta = tipoConta;
        this.investimentos = new ArrayList<>();
        this.transacoes = new ArrayList<>();
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void depositar(double valor) {
        saldo += valor;
        transacoes.add(new Transacao(valor, "entrada"));
    }

    public void sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            transacoes.add(new Transacao(valor, "saída"));
        } else {
            System.out.println("Saldo insuficiente para saque.");
        }
    }

    public void associarCartaoCredito(CartaoCredito cartaoCredito) {
        this.cartaoCredito = cartaoCredito;
    }

    public CartaoCredito getCartaoCredito() {
        return cartaoCredito;
    }

    public void adicionarInvestimento(Investimento investimento) {
        investimentos.add(investimento);
    }

    public List<Investimento> getInvestimentos() {
        return investimentos;
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }
}
