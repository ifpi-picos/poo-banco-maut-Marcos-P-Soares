import java.util.Scanner;

public class App {
    private static Scanner scanner = new Scanner(System.in);
    private static Cadastro cadastro = new Cadastro(scanner);

    public static void main(String[] args) {
        exibirMenuPrincipal();
    }

    private static void exibirMenuPrincipal() {
        System.out.println("Bem-vindo ao Banco MAUT \n \n");
        System.out.println("Se você deseja abrir uma conta - Insira 1 \n");
        System.out.println("Se você já tem uma conta e deseja acessar - Insira 2 \n");
        System.out.println("Para sair - Insira 3 \n");

        int escolha = scanner.nextInt();

        switch (escolha) {
            case 1:
                cadastro.cadastrarCliente();
                exibirMenuPrincipal();
                break;
            case 2:
                Conta conta = cadastro.acessarConta();
                if (conta != null) {
                    menuConta(conta);
                } else {
                    exibirMenuPrincipal();
                }
                break;
            case 3:
                System.out.println("Saindo do programa...");
                scanner.close();
                System.exit(0);
            default:
                System.out.println("Opção inválida. Tente novamente.");
                exibirMenuPrincipal(); // Chamada recursiva em caso de opção inválida
        }
    }

    private static void menuConta(Conta conta) {
        System.out.println("Insira o número correspondente a operação que deseja realizar:\n");
        System.out.println("1 - VERIFICAR SALDO\n");
        System.out.println("2 - DEPOSITAR \n");
        System.out.println("3 - SACAR\n");
        System.out.println("4 - TRANSFERIR \n");
        System.out.println("5 - GERAR EXTRATO\n");
        System.out.println("6 - VOLTAR AO MENU PRINCIPAL\n");

        int escolha = scanner.nextInt();

        switch (escolha) {
            case 1:
                double saldo = conta.consultarSaldo();
                System.out.println("Saldo atual: " + saldo);
                menuConta(conta);
                break;
            case 2:
                System.out.println("Digite o valor a ser depositado: ");
                double valorDeposito = scanner.nextDouble();
                System.out.println("Digite uma descrição para o depósito: ");
                String descricaoDeposito = scanner.next();
                conta.depositar(valorDeposito, descricaoDeposito);
                menuConta(conta);
                break;
            case 3:
                System.out.println("Digite o valor a ser sacado: ");
                double valorSaque = scanner.nextDouble();
                System.out.println("Digite uma descrição para o saque: ");
                String descricaoSaque = scanner.next();
                conta.sacar(valorSaque, descricaoSaque);
                menuConta(conta);
                break;
            case 4:
                System.out.println("Digite o número da conta de destino: ");
                String numeroContaDestino = scanner.next();
                Conta contaDestino = cadastro.getContaPorNumero(numeroContaDestino);
                if (contaDestino != null) {
                    System.out.println("Digite o valor a ser transferido: ");
                    double valorTransferencia = scanner.nextDouble();
                    System.out.println("Digite uma descrição para a transferência: ");
                    String descricaoTransferencia = scanner.next();
                    conta.transferir(valorTransferencia, contaDestino, descricaoTransferencia);
                } else {
                    System.out.println("Conta de destino não encontrada.");
                }

                break;
            case 5:
                System.out.println("Escolha a opção desejada:\n");
                System.out.println("1 - Lista de receitas.");
                System.out.println("2 - Lista de despesas.");
                System.out.println("3 - Extrato geral.");
                escolha = scanner.nextInt();

                switch (escolha) {
                    case 1:
                        conta.listarReceitas();
                        break;
                    case 2:
                        conta.listarDespesas();
                        break;
                    case 3:
                        conta.gerarExtrato();
                        break;
                    default:
                        System.out.println("Opção inválida, retornando para o menu da Conta...");
                        menuConta(conta);
                        break;
                }
                break;
            case 6:
                scanner.close();
                exibirMenuPrincipal();
            default:
                System.out.println("Opção inválida. Tente novamente.");
                menuConta(conta);
        }
    }
}