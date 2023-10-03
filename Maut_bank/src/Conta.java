//Um conta no banco Maut tem número da agência, número da conta, saldo e um Cliente vinculado;


public class Conta {
    private String agencia;
    private String numeroConta;
    private double saldo;
    private Cliente cliente;

    public Conta (String agencia, String numeroConta, double saldo, Cliente cliente) {
        this.agencia = agencia;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        this.cliente = cliente;
    }

    public String getAgencia() {
        return agencia;
    }
    
    public String getNumeroConta (){
        return numeroConta;
    }

    public double consultarSaldo() {
        return this.saldo;
    }

    public Cliente getCliente () {
        return cliente;
    }


     
}
