import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Conta {
    private final String agencia;
    private final String numeroConta;
    private double saldo;
    private Cliente cliente;
    private List<Receita> receitas;
    private List<Despesa> despesas;
    private static final String CARACTERES_VALIDOS = "ABCDEF0123456789";

    public Conta (String agencia, String numeroConta, double saldo, Cliente cliente) {
        this.agencia = agencia;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        this.cliente = cliente;
        this.receitas = new ArrayList<>();
        this.despesas = new ArrayList<>();
    }

    // Método para gerar um número único de conta
    private static String gerarNumeroConta() {
        Random random = new Random();
        StringBuilder numeroConta = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            numeroConta.append(CARACTERES_VALIDOS.charAt(random.nextInt(CARACTERES_VALIDOS.length())));
        }

        // Adiciona um caractere, letra ou dígito ao final
        numeroConta.append(CARACTERES_VALIDOS.charAt(random.nextInt(CARACTERES_VALIDOS.length())));

        return numeroConta.toString();
    }

    // Método para gerar um número único de agência
    private static String gerarNumeroAgencia() {
        Random random = new Random();
        StringBuilder numeroAgencia = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            numeroAgencia.append(CARACTERES_VALIDOS.charAt(random.nextInt(CARACTERES_VALIDOS.length())));
        }

        // Adiciona um caractere, letra ou dígito ao final
        numeroAgencia.append(CARACTERES_VALIDOS.charAt(random.nextInt(CARACTERES_VALIDOS.length())));

        return numeroAgencia.toString();
    }

    // Método para criar uma nova conta com números únicos
    public static Conta setConta(Cliente cliente) {
        String numeroAgencia = gerarNumeroAgencia();
        String numeroConta = gerarNumeroConta();
        double saldoInicial = 0.0; 

        return new Conta(numeroAgencia, numeroConta, saldoInicial, cliente);
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
            Receita transacao = new Receita(descricao, valor);
            this.receitas.add(transacao);
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }

    public void sacar (double valor, String descricao) {
        if (valor > 0) {
            this.saldo += valor;
            Despesa transacao = new Despesa (descricao, valor);
            this.despesas.add(transacao);
        } else {
            System.out.println("Valor de saque inválido ou saldo insuficiente.");
        }
    }

    public void transferir ( double valor, Conta contaDestino, String descricao){
        if(valor > 0 && this.saldo >= valor){
            this.saldo -= valor;
            Despesa transacao = new Despesa(descricao, valor);
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
