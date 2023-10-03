//Um conta no banco Maut tem número da agência, número da conta, saldo e um Cliente vinculado;


public class Conta {
    private String agencia;
    private String numeroConta;
    private double saldo;

    public Conta (String agencia, String numeroConta, double saldo, String id_cliente) {
        this.agencia = agencia;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
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


     
}
