import java.time.LocalDate;

public class Receita {
    private LocalDate data;
    private String descricao;
    private double valor;

    public Receita(String descricao, double valor) {
        this.data = LocalDate.now();
        this.descricao = descricao;
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

}
