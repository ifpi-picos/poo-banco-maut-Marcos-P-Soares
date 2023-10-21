package entidades;
import java.util.Scanner;

public class ContaCorrente extends Conta {
    private double chequeEspecial; //Conferir a lógica do cheque especial
    private int transferenciasGratuitas;

    public ContaCorrente(Cliente clienteVinculado) {
        super(clienteVinculado);
        this.transferenciasGratuitas = 2;
        this.chequeEspecial = this.saldo * 0.10;
    }

    @Override
    public void transferir(Conta destino, double valor, String descricao) {
        if (valor > 0) {
            if (this.transferenciasGratuitas > 0 || (this.saldo >= valor)) {
                double taxa = 0.10; // Taxa de transferência
                if (this.transferenciasGratuitas > 0) {
                    taxa = 0.0; // Primeiras 2 transferências são gratuitas
                    this.transferenciasGratuitas--;
                }
                double valorComTaxa = valor * (1 + taxa);

                if (this.saldo >= valorComTaxa) {
                    this.saldo -= valorComTaxa;
                    Transacao transacao = new Transacao(descricao, valorComTaxa);
                    this.transacoes.add(transacao);
                    destino.depositar(valor, descricao);
                } else {
                    System.out.println("Transferência inválida: saldo insuficiente.");
                }
            } else {
                System.out.println("Transferência inválida: limite de transferências gratuitas excedido.");
            }
        } else {
            System.out.println("Transferência inválida: valor inválido.");
        }
    }
    @Override
    public void sacar(double valor, String descricao) {
        if (valor > 0) {
            double saldoTotal = this.saldo + this.chequeEspecial;
            if (saldoTotal >= valor) {
                if (this.saldo >= valor) {
                    this.saldo -= valor;
                } else {
                    // O valor a ser sacado é maior que o saldo, oferecer a opção de usar o cheque especial
                    System.out.println("Saldo insuficiente. Saldo: " + this.saldo + " - Cheque Especial: " + this.chequeEspecial);
                    try (Scanner scanner = new Scanner(System.in)) {
                        System.out.print("Deseja usar o cheque especial (S/N)? ");
                        String resposta = scanner.next().toUpperCase();
                        if (resposta.equals("S")) {
                            double valorDoChequeEspecial = valor - this.saldo;
                            this.saldo = 0;
                            this.chequeEspecial -= valorDoChequeEspecial;
                        } else {
                            System.out.println("Operação cancelada.");
                        }
                    }
                }
                Transacao transacao = new Transacao(descricao, valor);
                this.transacoes.add(transacao);
            } else {
                System.out.println("Saque inválido: saldo insuficiente, incluindo o cheque especial.");
            }
        } else {
            System.out.println("Saque inválido: valor inválido.");
        }
    }
}

