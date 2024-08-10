package src.model;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String username;
    private String senha;
    private List<Conta> contas;
    private MetasFinanceiras metasFinanceiras;

    public Usuario(String username, String senha) {
        this.username = username;
        this.senha = senha;
        this.contas = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public String getSenha() {
        return senha;
    }

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public void removerConta(Conta conta) {
        contas.remove(conta);
    }

    public void definirMetasFinanceiras(double objetivoEconomia, double objetivoDespesas) {
        this.metasFinanceiras = new MetasFinanceiras(objetivoEconomia, objetivoDespesas);
    }

    public MetasFinanceiras getMetasFinanceiras() {
        return metasFinanceiras;
    }

    public void depositarEmConta(String numeroConta, double valor) {
        for (Conta conta : contas) {
            if (conta.getNumeroConta().equals(numeroConta)) {
                conta.depositar(valor);
                return;
            }
        }
        System.out.println("Conta não encontrada.");
    }

    public void sacarDaConta(String numeroConta, double valor) {
        for (Conta conta : contas) {
            if (conta.getNumeroConta().equals(numeroConta)) {
                conta.sacar(valor);
                return;
            }
        }
        System.out.println("Conta não encontrada.");
    }
}
