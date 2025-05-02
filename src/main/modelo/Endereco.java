package main.modelo;

public class Endereco {
    private String rua;
    private String bairro;
    private String cidade;
    private String estado;

    public Endereco(EnderecoViaCep meuEndereco) {
        this.rua = meuEndereco.logradouro();
        this.bairro = String.valueOf(meuEndereco.bairro());
        this.cidade = String.valueOf(meuEndereco.localidade());
        this.estado = String.valueOf(meuEndereco.estado());
    }

    @Override
    public String toString() {
        return "Rua: " + rua + ", Bairro: " + bairro + ", Cidade: " + cidade + ", Estado: " + estado;
    }
}
