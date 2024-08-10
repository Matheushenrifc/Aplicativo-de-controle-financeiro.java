package src.service;

import src.model.Transacao;

import java.util.List;

public class Relatorio {
    private List<Transacao> transacoes;

    public Relatorio(List<Transacao> transacoes) {
        this.transacoes = transacoes;
    }

    public void gerarRelatorio() {
        System.out.println("Relatório de Transações:");
        for (Transacao transacao : transacoes) {
            System.out.println("Transação - Valor: " + transacao.getValor() + ", Tipo: " + transacao.getTipo());
        }
    }
}
