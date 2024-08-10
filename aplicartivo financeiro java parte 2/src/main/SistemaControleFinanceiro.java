package src.main;

import java.util.ArrayList;
import java.util.List;
import src.model.Categoria;
import src.model.Conta;
import src.model.Investimento;
import src.model.Transacao;
import src.model.Usuario;
import src.service.GerenciadorContas;
import src.service.GerenciadorUsuarios;
import src.service.Relatorio;

public class SistemaControleFinanceiro {
    public static void main(String[] args) {
        // Criando um usuário
        Usuario usuario1 = new Usuario("user123", "senha123");

        // Criando contas para o usuário
        Conta conta1 = new Conta("12345-6", 1000.0, "corrente");
        Conta conta2 = new Conta("54321-0", 500.0, "poupança");

        // Adicionando investimentos à conta2
        Investimento investimento1 = new Investimento("Tesouro Direto", 500.0);
        conta2.adicionarInvestimento(investimento1);

        // Adicionando as contas ao usuário
        usuario1.adicionarConta(conta1);
        usuario1.adicionarConta(conta2);

        // Definindo metas financeiras para o usuário
        usuario1.definirMetasFinanceiras(10000.0, 2000.0);

        // Realizando depósitos e saques nas contas
        usuario1.depositarEmConta("12345-6", 500.0);
        usuario1.sacarDaConta("12345-6", 200.0);
        usuario1.depositarEmConta("54321-0", 300.0);

        // Gerenciando usuários e contas
        GerenciadorUsuarios gerenciadorUsuarios = new GerenciadorUsuarios();
        gerenciadorUsuarios.adicionarUsuario(usuario1);

        GerenciadorContas gerenciadorContas = new GerenciadorContas();
        gerenciadorContas.adicionarConta(conta1);
        gerenciadorContas.adicionarConta(conta2);

       

        // Criando uma categoria e adicionando transações
        Categoria categoriaAlimentacao = new Categoria("Alimentação");
        Transacao transacao1 = new Transacao(150.0, "saída");
        Transacao transacao2 = new Transacao(200.0, "saída");
        categoriaAlimentacao.adicionarTransacao(transacao1);
        categoriaAlimentacao.adicionarTransacao(transacao2);

        // Criando um relatório de transações
        List<Transacao> todasTransacoes = new ArrayList<>();
        todasTransacoes.addAll(conta1.getTransacoes());
        todasTransacoes.addAll(conta2.getTransacoes());
        todasTransacoes.add(transacao1);
        todasTransacoes.add(transacao2);

        Relatorio relatorio = new Relatorio(todasTransacoes);
        relatorio.gerarRelatorio();

        // Exibir saldo das contas
        System.out.println("Saldo da conta " + conta1.getNumeroConta() + ": " + conta1.getSaldo());
        System.out.println("Saldo da conta " + conta2.getNumeroConta() + ": " + conta2.getSaldo());

        // Exibir transações da categoria
        System.out.println("Categoria: " + categoriaAlimentacao.getNome());
        for (Transacao transacao : categoriaAlimentacao.getTransacoes()) {
            System.out.println("Transação - Valor: " + transacao.getValor() + ", Tipo: " + transacao.getTipo());
        }

        // Exibir informações do usuário e suas metas financeiras
        System.out.println("Usuário: " + usuario1.getUsername());
        System.out.println(
                "Metas financeiras: Objetivo de economia - R$" + usuario1.getMetasFinanceiras().getObjetivoEconomia() +
                        ", Objetivo de despesas - R$" + usuario1.getMetasFinanceiras().getObjetivoDespesas());
    }
}
