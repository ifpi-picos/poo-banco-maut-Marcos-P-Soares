import java.time.LocalDate;

public class Cliente {
    private String nome;
    private final String cpf;
    private LocalDate dataNascimento;
    private Endereco endereco;

    public Cliente(String nome, String cpf, LocalDate dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    public String getNome () {
        return nome;
    }
    
    public String getCPF() {
        return cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    
    public String getEndereco(){
        return endereco.toString();
    }

    public void setEndereco(Endereco endereco){
        this.endereco = endereco;
    }

}