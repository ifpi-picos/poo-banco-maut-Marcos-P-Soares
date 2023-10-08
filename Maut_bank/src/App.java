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
                cadastro.acessarConta();
                exibirMenuPrincipal();
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
}