import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cadastro {
    private Scanner scanner;
    private List<Conta> contas;

    public Cadastro(Scanner scanner) {
        this.scanner = scanner;
        this.contas = new ArrayList<>();
    }

    public void cadastrarCliente() {
        System.out.println("Para criar sua conta forneça os dados solicitados abaixo: \n");
        System.out.println("Informe seu Nome: ");
        String nome = scanner.next(); // Lê até encontrar um espaço em branco

        System.out.println("Informe seu CPF: ");
        String cpf = scanner.next();

        System.out.println("Informe sua Data de Nascimento (no formato YYYY-MM-DD): ");
        String dataNascimentoStr = scanner.next();
        LocalDate dataNascimento = LocalDate.parse(dataNascimentoStr);

        System.out.println("Informe seu País: ");
        String pais = scanner.next();

        System.out.println("Informe seu Estado: ");
        String estado = scanner.next();

        System.out.println("Informe sua Cidade: ");
        String cidade = scanner.next();

        System.out.println("Informe seu Bairro: ");
        String bairro = scanner.next();

        System.out.println("Informe sua Rua: ");
        String rua = scanner.next();

        System.out.println("Informe seu CEP: ");
        String cep = scanner.next();

        System.out.println("Informe uma Referência para seu endereço: ");
        String referencia = scanner.next();

        // Cria um objeto Endereco com os dados fornecidos
        Endereco endereco = new Endereco(pais, estado, cidade, bairro, rua, cep, referencia);

        // Cria um objeto Cliente com os dados fornecidos
        Cliente cliente = new Cliente(nome, cpf, dataNascimento, endereco);

        // Cria uma nova conta para o cliente com números únicos
        Conta novaConta = Conta.setConta(cliente);

        // Adicione a conta à lista de contas
        contas.add(novaConta);

        System.out.println("Conta criada com sucesso!\n");

        // Volte para o menu principal
    }

    public Cadastro acessarConta() {
        System.out.println("BANCO MAUT\n");
        System.out.println("Para acessar, informe seu número de conta: ");
        int numeroConta = scanner.nextInt();
        System.out.println("Informe seu CPF para confirmação:");
        String cpf = scanner.next();

        Cliente clienteAutenticado = autenticarCliente(numeroConta, cpf);

        if (clienteAutenticado != null) {
            System.out.println("Acesso permitido. Bem-vindo, " + clienteAutenticado.getNome() + "!\n");
            // Implemente a lógica de acesso à conta aqui
        } else {
            System.out.println("Acesso negado. Verifique o número da conta e o CPF.\n");
            return acessarConta();
        }
    }

    // Método para autenticar um cliente com base no número da conta e no CPF
    public Cliente autenticarCliente(int numeroConta, String cpf) {
        for (Conta conta : contas) {
            if (conta.getNumeroConta().equals(String.valueOf(numeroConta)) && conta.getCliente().getCPF().equals(cpf)) {
                return conta.getCliente(); // Autenticação bem-sucedida, retorna o cliente
            }
        }
        return null; // Não encontrou a conta correspondente
    }
}