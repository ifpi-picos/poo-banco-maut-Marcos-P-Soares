public class Endereco {
    private String pais;
    private String estado;
    private String cidade;
    private String bairro;
    private String rua;
    private String cep;
    private String referencia;


    public Endereco(String pais, String estado, String cidade, String bairro, String rua, String cep, String referencia) {
        this.pais = pais;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.cep = cep;
        this.referencia = referencia;
    }

    public String getCep() {
        return cep;
    }

    public String getPais() {
        return pais;
    }

    public String getEstado() {
        return estado;
    }

    public String getCidade() {
        return cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public  String getRua() {
        return rua;
    }
    public String getReferencia() {
        return referencia;
    }

    @Override
    public String toString() {
        return "Endereco [pais=" + pais + ", estado=" + estado + ", cidade=" + cidade + ", bairro=" + bairro + ", rua="
                + rua + ", cep=" + cep + ", referencia=" + referencia + "]";
    }

    
    


}
