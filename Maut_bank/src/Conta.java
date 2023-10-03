//Um conta no banco Maut tem número da agência, número da conta, saldo e um Cliente vinculado;


public class Conta {
    private String agencia;
    private String numero_conta;
    private double saldo;

    public Conta (String agencia, String numero_conta, double saldo, String id_cliente) {
        this.agencia = agencia;
        this.numero_conta = numero_conta;
        this.saldo = saldo;
    }

    public String getAgencia() {
        return agencia;
    }
    
    public String getNumeroConta (){
        return this.numero_conta;
    }

    public double consultarSaldo() {
        return this.saldo;
    }


     
}
