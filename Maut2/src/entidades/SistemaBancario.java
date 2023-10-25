package entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// import notificacoes.Notificacao;

public class SistemaBancario {

    private List<Conta> contas;
    private Conta contaLogada;

    public SistemaBancario() {
        this.contas = new ArrayList<>();
    }

    public void criarConta(Conta conta) {
        contas.add(conta);
        System.out.println("Conta criada com sucesso.\n Agência: " + conta.getAgencia() + " - Conta: " + conta.getNumeroConta());
    }

    public Conta autenticarConta(int numeroConta, int agencia) {
        for (Conta conta : contas) {
            if (conta.getConta() == numeroConta && conta.getAgencia() == agencia) {
                contaLogada = conta;
                return conta;
            }
        }
        return null;
    }

    private Conta encontrarContaPorNumero(int numeroConta) {
        for (Conta conta : contas) {
            if (conta.getConta() == numeroConta) {
                return conta;
            }
        }
        return null;
    }

    private Endereco cadastrarNovoEndereco(Scanner scanner) {
        System.out.println("Cadastro de Endereço:");
        System.out.println();
        System.out.print("Estado: ");
        String estado = scanner.nextLine();
        System.out.println();
        System.out.print("Cidade: ");
        String cidade = scanner.nextLine();
        System.out.println();

        System.out.print("Bairro: ");
        String bairro = scanner.nextLine();
        System.out.println();

        System.out.print("Rua: ");
        String rua = scanner.nextLine();
        System.out.println();

        System.out.print("Número: ");
        int numero = scanner.nextInt();

        Endereco endereco = new Endereco(estado, cidade, bairro, rua, numero);
        return endereco;
    }

    public void exibirMenuOperacoes() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        while (true) {
            System.out.println("===========================================");
            System.out.println("           MENU DE OPERAÇÕES");
            System.out.println("===========================================");
            System.out.println("Saldo: R$" + contaLogada.getSaldo());
            System.out.println("===========================================");
            System.out.println("1 - Depositar");
            System.out.println("2 - Sacar");
            System.out.println("3 - Transferir");
            System.out.println("4 - Consultar Extrato");
            System.out.println("5 - Consultar Dados da Conta");
            System.out.println("6 - Sair");
            System.out.println("===========================================");

            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Informe o valor a ser depositado: ");
                    double valorDeposito = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Descrição: ");
                    String descricaoDeposito = scanner.nextLine();
                    contaLogada.depositar(valorDeposito, descricaoDeposito);
                    break;
                case 2:
                    System.out.print("Informe o valor a ser sacado: ");
                    double valorSaque = scanner.nextDouble();
                    scanner.nextLine(); 
                    System.out.print("Descrição: ");
                    String descricaoSaque = scanner.nextLine();
                    contaLogada.sacar(valorSaque, descricaoSaque);
                    break;
                case 3:
                    System.out.print("Informe o número da conta de destino: ");
                    int numeroContaDestino = scanner.nextInt();
                    System.out.print("Informe o valor a ser transferido: ");
                    double valorTransferencia = scanner.nextDouble();
                    scanner.nextLine(); 
                    System.out.print("Descrição: ");
                    String descricaoTransferencia = scanner.nextLine();
                    Conta contaDestino = encontrarContaPorNumero(numeroContaDestino);
                    if (contaDestino != null) {
                        contaLogada.transferir(contaDestino, valorTransferencia, descricaoTransferencia);
                    } else {
                        System.out.println("Conta de destino não encontrada.");
                    }
                    break;
                case 4:
                    contaLogada.exibirExtrato();
                    break;
                case 5:
                    Cliente cliente = contaLogada.getCliente();
                    if (cliente != null) {
                        System.out.println("===========================================");
                        System.out.println("            DADOS DA CONTA");
                        System.out.println("===========================================");
                        System.out.println("Nome: " + cliente.getNome());
                        System.out.println("CPF: " + cliente.getCPF());
                        System.out.println("Data de Nascimento: " + cliente.getDataNascimento());
                        Endereco endereco = cliente.getEndereco();
                        if (endereco == null) {
                            System.out.println("Endereço não cadastrado.");
                            System.out.print("Deseja cadastrar um endereço? (S/N): ");
                            String opcaoEndereco = scanner.next();
                            if (opcaoEndereco.equalsIgnoreCase("S")) {
                                endereco = cadastrarNovoEndereco(scanner); 
                                cliente.setEndereco(endereco);
                                System.out.println("Endereço cadastrado com sucesso.");
                            }
                        } else {
                            System.out.println("Endereço:");
                            System.out.println(endereco.toString());
                        }
                        // Resto do código...
                        System.out.println("===========================================");
                    } else {
                        System.out.println("Dados do cliente não encontrados.");
                    }
                    break;
                    
                case 6:
                    System.out.println("Saindo do menu de operações.");
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    exibirMenuOperacoes();
            }
        }
    }
}
    
