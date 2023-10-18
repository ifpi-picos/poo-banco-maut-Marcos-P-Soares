public class ContaCorrente extends Conta {

    protected ContaCorrente(Cliente clienteVinculado) {
        super(clienteVinculado);
    }

    @Override
    public void transferir(Conta destino, double valor, String descricao) {
        super.transferir(destino, valor, descricao);
    }
    
}
