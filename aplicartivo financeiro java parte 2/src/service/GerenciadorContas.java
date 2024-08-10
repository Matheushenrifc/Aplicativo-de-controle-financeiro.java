package src.service;

import java.util.ArrayList;

import src.model.Conta;

import java.util.List;

public class GerenciadorContas {
    private List<Conta> contas;

    public GerenciadorContas() {
        this.contas = new ArrayList<>();
    }

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public void removerConta(Conta conta) {
        contas.remove(conta);
    }

    public List<Conta> getContas() {
        return contas;
    }
}
