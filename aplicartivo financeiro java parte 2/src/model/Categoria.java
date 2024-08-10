package src.model;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
    private String nome;
    private List<Transacao> transacoes;

    public Categoria(String nome) {
        this.nome = nome;
        this.transacoes = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void adicionarTransacao(Transacao transacao) {
        transacoes.add(transacao);
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }
}
