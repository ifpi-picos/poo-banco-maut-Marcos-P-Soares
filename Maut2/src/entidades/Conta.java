package entidades;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import notificacoes.Notificacao;

public abstract class Conta {
    protected final int agencia;
    protected final int conta;  
    protected double saldo;
    protected Cliente cliente;
    protected List<Transacao> transacoes;
    protected static int contador = 0;
    protected double taxaTransferencia = 0.10;
    protected Notificacao notificacao;
    
    protected Conta(Cliente cliente, Notificacao notificacao) {
        this.cliente = cliente;
        this.saldo = 0;
        this.conta = contador;
        this.agencia = gerarAgenciaAleatoria();
        contador++;
        this.transacoes = new ArrayList<>();
        this.notificacao = notificacao;
    }

        
    public Cliente getCliente() {
        return cliente;
    }
    //Gera um numero de conta 
    private int gerarAgenciaAleatoria() {
        Random random = new Random();
        int agencia = random.nextInt(10000);
        return agencia;
    }

    public void setNotificacao(Notificacao notificacao) {
        this.notificacao = notificacao;
    }

    public String getNumeroConta() {
        return String.format("%06d", conta);
    }
    
    public int getConta() {
        return conta;
    }

    public int getAgencia() {
        return agencia;
    }    

    public double getSaldo() {
        return saldo;
    }


    public void depositar(double valor, String descricao) {
        if (valor > 0) {
            this.saldo += valor;
            Transacao transacao = new Transacao (descricao, valor);
            this.transacoes.add(transacao);
            this.notificacao.enviaNotificacao("Deposito de R$", valor);
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }

    public void sacar(double valor, String descricao) {
        if (valor > 0) {
            this.saldo -= valor;
            Transacao transacao = new Transacao (descricao, valor);
            this.transacoes.add(transacao);
            this.notificacao.enviaNotificacao("Saque de R$", valor);
        } else {
            System.out.println("Valor de saque inválido ou saldo insuficiente.");
        }
    }


    public void transferir(Conta destino, double valor, String descricao) {
        if (valor > 0 && (this.saldo +(this.saldo*this.taxaTransferencia)) >= valor) {
            this.saldo -= valor * (1 + this.taxaTransferencia);
            Transacao transacao = new Transacao(descricao, valor);
            this.transacoes.add(transacao);
            destino.depositar(valor, descricao);
            this.notificacao.enviaNotificacao("Transferência de R$", valor);
        }else {
            System.out.println("Transferência inválida: valor inválido ou saldo insuficiente.");
        }
    }


    public void exibirExtrato() {
        System.out.println("Extrato:");
        int index = 1;
        for(Transacao transacoes: this.transacoes){
            System.out.println(index + "-" +transacoes.toString());
            index++;
        }
    }
}