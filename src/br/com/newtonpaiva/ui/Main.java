package br.com.newtonpaiva.ui;

import br.com.newtonpaiva.dominio.Banco;
import br.com.newtonpaiva.dominio.Cliente;
import br.com.newtonpaiva.dominio.Conta;

import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        String nomeCliente = JOptionPane.showInputDialog("Digite seu nome :");
        Cliente cliente = new Cliente(nomeCliente);

        List<Conta> contas = new ArrayList<>();
        BufferedReader leitor = null;
        String linha = leitor.readLine();
        leitor = new BufferedReader(new FileReader("Contas.txt"));

        while (linha != null) {
            String[] partes = linha.split(",");
            String agencia = partes[0];
            String numero = partes[1];
            double saldo = Double.parseDouble(partes[2]);
            Conta conta = new Conta(agencia, numero, saldo);
            contas.add(conta);
            linha = leitor.readLine();
        }
        leitor.close();


        String nomeBanco = JOptionPane.showInputDialog("Escreva o nome do banco:");
        Banco banco = new Banco(nomeBanco);
        for (Conta conta : contas) {
            banco.adicionarConta(conta);
        }

        double saldoTotal = banco.calcularSaldoTotal();

        String saldoTotalFormatado = String.format("R$ %.2f", saldoTotal);

        BufferedWriter writer = new BufferedWriter(new FileWriter("TarefaBanco.txt"));
        writer.write("Banco " + banco.getNome() + " possui o saldo geral de contas de: " + saldoTotalFormatado);
        writer.close();
    }
}