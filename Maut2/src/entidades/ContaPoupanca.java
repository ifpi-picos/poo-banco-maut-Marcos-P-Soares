package entidades;

import notificacoes.Notificacao;

public class ContaPoupanca extends Conta{
    private double taxaSaque = 0.05;
    private double rendimento;

    public ContaPoupanca(Cliente cliente, Notificacao notificacao) {
        super(cliente, notificacao);
    }
    
    public void getTaxaSaque(double valor){
            System.out.println("Você deseja realizar um saque de "+ valor + "reais.");
            System.out.println("A taxa será:" + (valor*this.taxaSaque) + "deseja continuar?");
    }

    @Override
    public void sacar(double valor, String descricao) {
        if (valor > 0 && this.saldo >= valor) {
            this.saldo -= valor;
            Transacao transacao = new Transacao(descricao, valor);
            this.transacoes.add(transacao);
            this.saldo -= valor * this.taxaSaque;
        } else {
            System.out.println("Valor de saque inválido ou saldo insuficiente.");
        }
    }

    @Override
    public void depositar(double valor, String descricao) {
        if (valor > 0) {
            this.saldo += valor;
            this.saldo += valor * this.rendimento;
            Transacao transacao = new Transacao(descricao, valor);
            this.transacoes.add(transacao);
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }
}
