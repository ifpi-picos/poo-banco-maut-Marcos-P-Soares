import java.time.LocalDate;

public class Cliente {
    private String nome;
    private String cpf;
    private LocalDate data_nascimento;
    private Endereco endereco;

    public Cliente(String nome, String cpf, LocalDate data_nascimento, Endereco endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.data_nascimento = data_nascimento;
        this.endereco = endereco;
    }
}
