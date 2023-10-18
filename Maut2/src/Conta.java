import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Conta {
    protected final int agencia;
    protected final int conta;  
    protected double saldo;
    private Cliente cliente;
    private List<Transacao> transacoes;
    private static int contador = 0;
    
    protected Conta(Cliente cliente) {
        this.cliente = cliente;
        this.saldo = 0;
        this.conta = contador;
        this.agencia = gerarAgenciaAleatoria();
        contador++;
        this.transacoes = new ArrayList<>();
    }

    //Gera um numero de conta 
    private int gerarAgenciaAleatoria() {
        Random random = new Random();
        int agencia = random.nextInt(10000);
        return agencia;
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

    public void depositar(double valor, String descricao) {
        if (valor > 0) {
            this.saldo += valor;
            Transacao transacao = new Transacao (descricao, valor);
            this.transacoes.add(transacao);
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }

    public void sacar(double valor, String descricao) {
        if (valor > 0) {
            this.saldo += valor;
            Transacao transacao = new Transacao (descricao, valor);
            this.transacoes.add(transacao);
        } else {
            System.out.println("Valor de saque inválido ou saldo insuficiente.");
        }
    }

    public void transferir(Conta destino, double valor, String descricao) {
        if(valor > 0 && this.saldo >= valor){
            this.saldo -= valor;
            Transacao transacao = new Transacao (descricao, valor);
            this.transacoes.add(transacao);
            // contaDestino.despositar(valor, descricao);
        }else{
            System.out.println("Transferência inválida: valor invalido ou saldo insuficiente");
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