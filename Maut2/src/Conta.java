import java.util.List;
import java.util.Random;

public abstract class Conta {
    protected final int agencia;
    protected final int conta;  
    protected double saldo;
    private Cliente clienteVinculado;
    private static int contador = 0;
    
    protected Conta(Cliente clienteVinculado) {
        this.clienteVinculado = clienteVinculado;
        this.saldo = 0;
        this.conta = contador;
        this.agencia = gerarAgenciaAleatoria();
        contador++;
    }

    //Gera uma conta 
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

    public void depositar(double valor) {
        // Implementação do depósito
    }

    public void sacar(double valor) {
        // Implementação do saque
    }

    public void transferir(Conta destino, double valor) {
        // Implementação da transferência
    }

    public void exibirExtrato() {
        // Implementação para mostrar o extrato
    }
}