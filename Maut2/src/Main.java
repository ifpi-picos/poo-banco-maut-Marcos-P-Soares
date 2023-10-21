import java.time.LocalDate;
import java.time.Month;

import entidades.Cliente;
import entidades.ContaCorrente;
import entidades.ContaPoupanca;

public class Main {
    public static void main(String[] args) throws Exception {
       // Criando clientes fictícios
        Cliente cliente1 = new Cliente("Cliente 1", "123.456.789-01", LocalDate.of(1990, Month.JANUARY, 15));
        Cliente cliente2 = new Cliente("Cliente 2", "987.654.321-02", LocalDate.of(1985, Month.FEBRUARY, 20));
        Cliente cliente3 = new Cliente("Cliente 3", "555.555.555-03", LocalDate.of(2000, Month.MARCH, 10));
        Cliente cliente4 = new Cliente("Cliente 4", "999.999.999-04", LocalDate.of(1995, Month.APRIL, 5));

        // Criando contas fictícias
        ContaCorrente contaCorrente1 = new ContaCorrente(cliente1);
        ContaCorrente contaCorrente2 = new ContaCorrente(cliente2);
        ContaPoupanca contaPoupanca1 = new ContaPoupanca(cliente3);
        ContaPoupanca contaPoupanca2 = new ContaPoupanca(cliente4);

        // Realizando operações fictícias nas contas
        contaCorrente1.depositar(1000.0, "Depósito inicial na conta corrente 1");
        contaCorrente2.depositar(1500.0, "Depósito inicial na conta corrente 2");
        contaPoupanca1.depositar(500.0, "Depósito inicial na conta poupança 1");
        contaPoupanca2.depositar(800.0, "Depósito inicial na conta poupança 2");

        contaCorrente1.transferir(contaCorrente2, 200.0, "Transferência entre contas correntes");
        contaPoupanca1.transferir(contaPoupanca2, 100.0, "Transferência entre contas poupança");
        // Exibindo saldos após transferências
        System.out.println("Saldo da conta corrente 1 após transferência: " + contaCorrente1.getSaldo());
        System.out.println("Saldo da conta corrente 2 após transferência: " + contaCorrente2.getSaldo());
        System.out.println("Saldo da conta poupança 1 após transferência: " + contaPoupanca1.getSaldo());
        System.out.println("Saldo da conta poupança 2 após transferência: " + contaPoupanca2.getSaldo());

        // Print's de test para operações
        contaCorrente1.exibirExtrato();
        System.out.println();
        contaCorrente2.exibirExtrato();
        System.out.println();
        contaPoupanca1.exibirExtrato();
        System.out.println();
        contaPoupanca2.exibirExtrato();

        
        //Print's de test para classe CLiente
        System.out.println("Nome: " + cliente1.getNome());
        System.out.println("CPF: " + cliente1.getCPF());
        System.out.println("Data de Nascimento: " + cliente1.getDataNascimento());
        System.out.println("Nome: " + cliente2.getNome());
        System.out.println("CPF: " + cliente2.getCPF());
        System.out.println("Data de Nascimento: " + cliente2.getDataNascimento());
    }
}
