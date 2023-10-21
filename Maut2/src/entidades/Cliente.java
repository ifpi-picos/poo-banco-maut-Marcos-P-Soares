package entidades;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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

    public String getDataNascimento() {
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dataNascimento.format(formatoData);
    }
    
    public String getEndereco(){
        return endereco.toString();
    }

    public void setEndereco(Endereco endereco){
        this.endereco = endereco;
    }

}