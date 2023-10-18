import java.util.List;
import java.util.Random;

public class Conta {
    private final String agencia;
    private final String conta;  
    private double saldo;
    private Cliente clienteVinculado;
    private static int contador = 0;
    
    public Conta(Cliente clienteVinculado) {
        this.clienteVinculado = clienteVinculado;
        this.saldo = 0;
        this.conta = gerarNumeroContaIncremental();
        this.agencia = gerarAgenciaAleatoria();
    }

    private String gerarAgenciaAleatoria() {
        Random random = new Random();
        int agenciaInt = random.nextInt(10000); // Números aleatórios de 0 a 9999
        return String.format("%04d", agenciaInt); // Formata com 4 casas decimais
    }

    private String gerarNumeroContaIncremental() {
        contador++;
        return String.format("%06d", contador); // Formata com 6 casas decimais
    }
    
    public String getConta() {
        return conta;
    }

    public String getAgencia() {
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