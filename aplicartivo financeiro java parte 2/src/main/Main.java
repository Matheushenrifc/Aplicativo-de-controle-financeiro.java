package src.main;

import src.service.GerenciadorUsuarios;
import src.service.GerenciadorContas;
import src.model.Usuario;
import src.model.Conta;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    private GerenciadorUsuarios gerenciadorUsuarios = new GerenciadorUsuarios();
    private GerenciadorContas gerenciadorContas = new GerenciadorContas();

    private JTextField usernameField = new JTextField(20);
    private JPasswordField senhaField = new JPasswordField(20);
    private JTextField numeroContaField = new JTextField(20);
    private JTextField saldoField = new JTextField(20);
    private JTextField tipoContaField = new JTextField(20);
    private JTextField valorField = new JTextField(20);
    private JTextArea outputArea = new JTextArea(10, 30);

    public Main() {
        setTitle("Sistema de Controle Financeiro");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(7, 2));
        inputPanel.add(new JLabel("Nome de Usuário:"));
        inputPanel.add(usernameField);
        inputPanel.add(new JLabel("Senha:"));
        inputPanel.add(senhaField);
        inputPanel.add(new JLabel("Número da Conta:"));
        inputPanel.add(numeroContaField);
        inputPanel.add(new JLabel("Saldo:"));
        inputPanel.add(saldoField);
        inputPanel.add(new JLabel("Tipo de Conta:"));
        inputPanel.add(tipoContaField);
        inputPanel.add(new JLabel("Valor:"));
        inputPanel.add(valorField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 6));

        JButton criarContaButton = new JButton("Criar Conta");
        JButton verSaldoButton = new JButton("Ver Saldo");
        JButton depositarButton = new JButton("Depositar");
        JButton sacarButton = new JButton("Sacar");
        JButton excluirContaButton = new JButton("Excluir Conta");
        JButton sairButton = new JButton("Sair");

        criarContaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                criarConta();
            }
        });

        verSaldoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verSaldo();
            }
        });

        depositarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                depositar();
            }
        });

        sacarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sacar();
            }
        });

        excluirContaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                excluirConta();
            }
        });

        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        buttonPanel.add(criarContaButton);
        buttonPanel.add(verSaldoButton);
        buttonPanel.add(depositarButton);
        buttonPanel.add(sacarButton);
        buttonPanel.add(excluirContaButton);
        buttonPanel.add(sairButton);

        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(new JScrollPane(outputArea), BorderLayout.SOUTH);
    }

    private void criarConta() {
        String username = usernameField.getText();
        String senha = new String(senhaField.getPassword());
        String numeroConta = numeroContaField.getText();
        double saldo = Double.parseDouble(saldoField.getText());
        String tipoConta = tipoContaField.getText();

        Usuario usuario = new Usuario(username, senha);
        Conta conta = new Conta(numeroConta, saldo, tipoConta);

        usuario.adicionarConta(conta);
        gerenciadorUsuarios.adicionarUsuario(usuario);
        gerenciadorContas.adicionarConta(conta);

        outputArea.append("Conta criada com sucesso!\n");
    }

    private void verSaldo() {
        String numeroConta = numeroContaField.getText();
        Conta conta = encontrarConta(numeroConta);
        if (conta != null) {
            outputArea.append("Saldo da conta " + conta.getNumeroConta() + ": R$" + conta.getSaldo() + "\n");
        } else {
            outputArea.append("Conta não encontrada.\n");
        }
    }

    private void depositar() {
        String numeroConta = numeroContaField.getText();
        double valor = Double.parseDouble(valorField.getText());
        Conta conta = encontrarConta(numeroConta);
        if (conta != null) {
            conta.depositar(valor);
            outputArea.append("Depósito realizado com sucesso!\n");
        } else {
            outputArea.append("Conta não encontrada.\n");
        }
    }

    private void sacar() {
        String numeroConta = numeroContaField.getText();
        double valor = Double.parseDouble(valorField.getText());
        Conta conta = encontrarConta(numeroConta);
        if (conta != null) {
            conta.sacar(valor);
            outputArea.append("Saque realizado com sucesso!\n");
        } else {
            outputArea.append("Conta não encontrada.\n");
        }
    }

    private void excluirConta() {
        String numeroConta = numeroContaField.getText();
        Conta conta = encontrarConta(numeroConta);
        if (conta != null) {
            gerenciadorContas.removerConta(conta);
            for (Usuario usuario : gerenciadorUsuarios.getUsuarios()) {
                usuario.removerConta(conta);
            }
            outputArea.append("Conta excluída com sucesso!\n");
        } else {
            outputArea.append("Conta não encontrada.\n");
        }
    }

    private Conta encontrarConta(String numeroConta) {
        for (Conta conta : gerenciadorContas.getContas()) {
            if (conta.getNumeroConta().equals(numeroConta)) {
                return conta;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main mainFrame = new Main();
            mainFrame.setVisible(true);
        });
    }
}
