package main.principal;

import main.modelo.Endereco;
import main.modelo.EnderecoViaCep;
import main.servico.ConsultaViaCep;

import main.servico.GeradorJson;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {

            ConsultaViaCep consultaViaCep = new ConsultaViaCep();
            consultaViaCep.recebeCep();
            ArrayList<Endereco> listaEnderecos = new ArrayList<>();

            Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

            while (!consultaViaCep.getCep().equalsIgnoreCase("Sair")) {
                try {
                    EnderecoViaCep enderecoPesquisado = consultaViaCep.busca(consultaViaCep.getCep());
                    System.out.println(enderecoPesquisado);

                    Endereco enderecoConsultado = new Endereco(enderecoPesquisado);
                    System.out.println(enderecoConsultado);
                    listaEnderecos.add(enderecoConsultado);

                    GeradorJson geradorJson = new GeradorJson();
                    geradorJson.geraJson(gson, listaEnderecos);
                    consultaViaCep.recebeCep();
                } catch (RuntimeException | IOException e) {
                    System.out.println(e.getMessage());
                    consultaViaCep.recebeCep();
                }
            }
    }
}

