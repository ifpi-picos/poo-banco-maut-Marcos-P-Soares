import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
//Para que um cliente abra uma conta no banco Maut, ele deve informar os seguintes dados: nome, CPF, data de nascimento e endereço completo;

public class Cliente {
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private Endereco endereco;
    private List<Conta> contas;

    public Cliente(String nome, String cpf, LocalDate dataNascimento, Endereco endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.contas = new ArrayList<>();
    }

    public String getNome () {
        return nome;
    }
    
    public String getCpf() {
        return cpf;
    }

    public Endereco getEndereco () {
        return endereco;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

}
