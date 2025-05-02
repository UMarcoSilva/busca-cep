package main.servico;

import main.modelo.EnderecoViaCep;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ConsultaViaCep {
    private String cep;

    public String getCep() {
        return cep;
    }

    public void recebeCep(){
        Scanner leitor = new Scanner(System.in);
        System.out.println("Digite o cep: ");
        cep = leitor.nextLine();
    }

    public EnderecoViaCep busca(String cep) throws IOException {
        URI endereco = URI.create("https://viacep.com.br/ws/" + cep + "/json/");

        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();

        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), EnderecoViaCep.class);
        } catch (Exception e) {
            throw new RuntimeException("Não consegui obter o endereço a partir desse CEP.");
        }
    }
}
