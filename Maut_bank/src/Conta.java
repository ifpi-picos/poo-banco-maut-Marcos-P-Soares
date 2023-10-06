//Um conta no banco Maut tem número da agência, número da conta, saldo e um Cliente vinculado;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Conta {
    private String agencia;
    private String numeroConta;
    private double saldo;
    private Cliente cliente;
    private List<Receita> receitas;
    private List<Despesa> despesas;

    public Conta (String agencia, String numeroConta, double saldo, Cliente cliente) {
        this.agencia = agencia;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        this.cliente = cliente;
        this.receitas = new ArrayList<>();
        this.despesas = new ArrayList<>();
    }

    public String getAgencia() {
        return agencia;
    }
    
    public String getNumeroConta (){
        return numeroConta;
    }
    
    public Cliente getCliente () {
        return cliente;
    }

    public double consultarSaldo() {
        return this.saldo;
    }

    public void depositar (double valor, String descricao) {
        if (valor > 0) {
            this.saldo += valor;
            Receita transacao = new Receita(new Date(), descricao, valor);
            this.receitas.add(transacao);
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }

    public void sacar (double valor, String descricao) {
        if (valor > 0) {
            this.saldo += valor;
            Despesa transacao = new Despesa (new Date(), descricao, valor);
            this.despesas.add(transacao);
        } else {
            System.out.println("Valor de saque inválido ou saldo insuficiente.");
        }
    }

    public void transferir ( double valor, Conta contaDestino, String descricao){
        if(valor > 0 && this.saldo >= valor){
            this.saldo -= valor;
            Despesa transacao = new Despesa(new Date(), descricao, valor);
            this.despesas.add(transacao);
            // contaDestino.despositar(valor, descricao);
        }else{
            System.out.println("Transferência inválida: valor invalido ou saldo insuficiente");
        }
    }
    
    public void listarDespesas (){
        System.out.println("Lista de Despesas:");
        int index = 1;
        for(Despesa despesas: this.despesas){
            System.out.println(index + ". Data: "+ despesas.getData() + "\nDescrição: "+ despesas.getDescricao() + "\nValor: " + despesas.getValor());
            index++;
        }
    }
    
    public void listarReceitas (){
        System.out.println("Lista de Receitas:");
        int index = 1;
        for(Receita receitas: this.receitas){
            System.out.println(index + ". Data: "+ receitas.getData() + "\nDescrição: "+ receitas.getDescricao() + "\nValor: " + receitas.getValor());
            index++;
        }

    }

    public void gerarExtrato (){
        System.out.println("Extrato:"); 
        System.out.println("Receitas:"); 
        int index = 1;
        for(Receita receitas: this.receitas){
            System.out.println(index + ". Data: "+ receitas.getData() + "\nDescrição: "+ receitas.getDescricao() + "\nValor: " + receitas.getValor());
            index++;
        }
        System.out.println("Despesas:"); 
        index = 1;
        for(Despesa despesas: this.despesas){
            System.out.println(index + ". Data: "+ despesas.getData() + "\nDescrição: "+ despesas.getDescricao() + "\nValor: " + despesas.getValor());
            index++;
        }
    }
     
}
