import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import entidades.Cliente;
import entidades.Conta;
import entidades.ContaCorrente;
import entidades.ContaPoupanca;
import entidades.SistemaBancario;
import notificacoes.Notificacao;
import notificacoes.NotificacaoEmail;
import notificacoes.NotificacaoSMS;

public class Main {
    public static void main(String[] args) throws Exception {
        SistemaBancario sistema = new SistemaBancario();
        Scanner scanner = new Scanner(System.in);

        //2 Contas Correntes para fins de teste
        Cliente cliente1 = new Cliente("João da Silva", "123.456.789-01", LocalDate.of(1990, 5, 15));
        ContaCorrente contaCorrente1 = new ContaCorrente(cliente1, new NotificacaoSMS());
        sistema.criarConta(contaCorrente1);
        contaCorrente1.depositar(1000.0, "Depósito inicial"); // Adicionando saldo de R$1000.0

        // Cliente cliente2 = new Cliente("Maria Oliveira", "987.654.321-09", LocalDate.of(1985, 8, 20));
        // ContaCorrente contaCorrente2 = new ContaCorrente(cliente2, new NotificacaoEmail());
        // sistema.criarConta(contaCorrente2);
        // contaCorrente2.depositar(1500.0, "Depósito inicial"); // Adicionando saldo de R$1500.0
        System.out.println();
        //2 Contas Poupança para fins de teste
        Cliente cliente3 = new Cliente("Pedro Santos", "456.789.123-04", LocalDate.of(1982, 11, 10));
        ContaPoupanca contaPoupanca1 = new ContaPoupanca(cliente3, new NotificacaoSMS());
        sistema.criarConta(contaPoupanca1);
        contaPoupanca1.depositar(2000.0, "Depósito inicial"); // Adicionando saldo de R$2000.0

        // Cliente cliente4 = new Cliente("Ana Rodrigues", "789.123.456-07", LocalDate.of(1995, 3, 25));
        // ContaPoupanca contaPoupanca2 = new ContaPoupanca(cliente4, new NotificacaoEmail());
        // sistema.criarConta(contaPoupanca2);
        // contaPoupanca2.depositar(2500.0, "Depósito inicial"); // Adicionando saldo de R$2500.0
        System.out.println("\n");

        while (true) {
            System.out.println("Menu Inicial:");
            System.out.println("1 - Criar Conta");
            System.out.println("2 - Entrar na Conta");
            System.out.println("3 - Sair");

            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    criarConta(sistema, scanner);
                    break;
                case 2:
                    entrarNaConta(sistema, scanner);
                    break;
                case 3:
                    System.out.println("Saindo do sistema.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void entrarNaConta(SistemaBancario sistema, Scanner scanner) {
        System.out.print("Número da conta: ");
        int numeroConta = scanner.nextInt();
        System.out.print("Agência: ");
        int agencia = scanner.nextInt();

        Conta conta = sistema.autenticarConta(numeroConta, agencia);

        if (conta != null) {
            System.out.println("Login bem-sucedido.\n");
            sistema.exibirMenuOperacoes();
        } else {
            System.out.println("Conta não encontrada. Tente novamente.\n");
        }
    }

    private static void criarConta(SistemaBancario sistema, Scanner scanner) {

        System.out.print("Nome do cliente: ");
        scanner.nextLine();
        String nome = scanner.nextLine();

        System.out.print("CPF do cliente: ");
        String cpf = scanner.nextLine();

        System.out.print("Data de nascimento (dd/MM/yyyy): ");
        String dataNascimentoStr = scanner.nextLine();

        LocalDate dataNascimento = LocalDate.parse(dataNascimentoStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        Cliente cliente = new Cliente(nome, cpf, dataNascimento);

        System.out.println("Escolha o tipo de conta:");
        System.out.println("1 - Conta Corrente");
        System.out.println("2 - Conta Poupança");
        System.out.print("Escolha uma opção: ");
        int opcaoConta = scanner.nextInt();

        while (opcaoConta != 1 && opcaoConta != 2) {
            System.out.println("Opção inválida, tente novamente!");
            opcaoConta = scanner.nextInt();
        }

        String tipoConta = (opcaoConta == 1) ? "Conta Corrente" : "Conta Poupança";

        System.out.println("Escolha o tipo de notificação:");
        System.out.println("1 - SMS");
        System.out.println("2 - Email");
        System.out.print("Escolha uma opção: ");
        int opcaoNotificacao = scanner.nextInt();

        Notificacao notificacao;
        if (opcaoNotificacao == 1) {
            notificacao = new NotificacaoSMS();
        } else {
            notificacao = new NotificacaoEmail();
        }

        Conta novaConta;
        if (tipoConta.equals("Conta Corrente")) {
            novaConta = new ContaCorrente(cliente, notificacao);
        } else {
            novaConta = new ContaPoupanca(cliente, notificacao);
        }

        sistema.criarConta(novaConta);

        System.out.println("Conta criada com sucesso! \n");
    }
}
