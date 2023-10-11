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
        LocalDate dataNascimento = null;

        System.out.println("Para criar sua conta forneça os dados solicitados abaixo: \n");
        System.out.println("Informe seu Nome: |*Campo Obrigatório");
        String nome = scanner.next(); // Lê até encontrar um espaço em branco

        System.out.println("Informe seu CPF:  | *Campo obrigatório" );
        String cpf = scanner.next();
        
        scanner.nextLine();
        
        System.out.println("Informe sua Data de Nascimento (no formato YYYY-MM-DD):");
        String dataNascimentoStr = scanner.nextLine();
        if (dataNascimentoStr.isEmpty()) {
            dataNascimentoStr = null;
        } else {
            dataNascimento = LocalDate.parse(dataNascimentoStr);
        }

        // Cria um objeto Cliente com os dados fornecidos
        Cliente cliente = new Cliente(nome, cpf);

        if(dataNascimentoStr != null){
            cliente.setDataNascimento(dataNascimento);
        }

        System.out.println("Deseja cadastrar um endereço?");
        System.out.println("1 - sim || 2 - não");
        int escolha = scanner.nextInt();

        if(escolha == 1){
            cliente.setEndereco(cadastraEndereco());
        }

        // Cria uma nova conta para o cliente com números únicos
        Conta novaConta = Conta.setConta(cliente);

        // Adicione a conta à lista de contas
        contas.add(novaConta);

        System.out.println("Conta criada com sucesso!\n");
        System.out.println("Número da Conta: " + novaConta.getNumeroConta());
        System.out.println("Agência: " + novaConta.getAgencia() + "\n");

        // Volta para o menu principal
    }

    public Conta acessarConta() {
        System.out.println("BANCO MAUT\n");
        System.out.println("Para acessar, informe seu número de conta: ");
        String numeroConta = scanner.next();
        System.out.println("Informe seu CPF para confirmação:");
        String cpf = scanner.next();
    
        Conta conta = autenticarConta(numeroConta, cpf);
    
        if (conta != null) {
            System.out.println("Acesso permitido. Bem-vindo à conta " + conta.getCliente().getNome() + "!\n");
            return conta; // Retorna a conta autenticada
        } else {
            System.out.println("Acesso negado. Verifique o número da conta e o CPF.\n");
            System.out.println("Retornando ao menu principal.\n");
            return null; // Retorna null em caso de falha na autenticação
        }
    }

    public Endereco cadastraEndereco(){

        System.out.println("Informe seu País: ");
        String pais = scanner.next();
        scanner.nextLine();
        
        System.out.println("Informe seu Estado: ");
        String estado = scanner.nextLine();

        System.out.println("Informe sua Cidade: ");
        String cidade = scanner.nextLine();

        System.out.println("Informe seu Bairro: ");
        String bairro = scanner.nextLine();

        System.out.println("Informe sua Rua: ");
        String rua = scanner.nextLine();

        System.out.println("Informe seu CEP: ");
        String cep = scanner.nextLine();

        System.out.println("Informe uma Referência para seu endereço: ");
        String referencia = scanner.nextLine();

        // Cria um objeto Endereco com os dados fornecidos
        Endereco endereco = new Endereco(pais, estado, cidade, bairro, rua, cep, referencia);
        
        return endereco;
    }


    // Método para autenticar um cliente com base no número da conta e no CPF
    public Conta autenticarConta(String numeroConta, String cpf) {
        for (Conta conta : contas) {
            if (conta.getNumeroConta().equals(String.valueOf(numeroConta)) && conta.getCliente().getCPF().equals(cpf)) {
                return conta; // Autenticação bem-sucedida, retorna a conta
            }
        }
        return null; // Não encontrou a conta correspondente
    }

    public Conta getContaPorNumero(String numeroConta) {
        for (Conta conta : contas) {
            if (conta.getNumeroConta().equals(String.valueOf(numeroConta))) {
                return conta;
            }
        }
        return null; // Retorna null se a conta não for encontrada
    }
}