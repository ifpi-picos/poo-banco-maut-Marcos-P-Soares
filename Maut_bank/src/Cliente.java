import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
//Para que um cliente abra uma conta no banco Maut, ele deve informar os seguintes dados: nome, CPF, data de nascimento e endereço completo;

public class Cliente {
    private String nome;
    private String cpf;
    private LocalDate data_nascimento;
    private Endereco endereco;
    private List<Conta> contas;

    public Cliente(String nome, String cpf, LocalDate data_nascimento, Endereco endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.data_nascimento = data_nascimento;
        this.endereco = endereco;
        this.contas = new ArrayList<>();
    }

    

}
