package entidades;
import java.time.LocalDate;

public class Transacao {
    private LocalDate data;
    private String descricao;
    private double valor;

    public Transacao(String descricao, double valor) {
        this.data = LocalDate.now();
        this.descricao = descricao;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Transacao [data=" + data + ", descricao=" + descricao + ", valor=" + valor + "]";
    }

}
