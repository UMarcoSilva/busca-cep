package main.servico;

import main.modelo.Endereco;
import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GeradorJson {
    public void geraJson(Gson gson, ArrayList<Endereco> listaEnderecos) {
        try (FileWriter escritor = new FileWriter("endereco.json")) {
            escritor.write(gson.toJson(listaEnderecos));
        } catch (IOException e) {
            throw new RuntimeException("Erro ao gerar o arquivo JSON", e);
        }
    }
}
