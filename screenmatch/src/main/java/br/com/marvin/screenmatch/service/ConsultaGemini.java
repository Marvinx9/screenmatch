package br.com.marvin.screenmatch.service;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;

public class ConsultaGemini {
    public static String obterTraducao(String texto) {
        Client client = Client.builder()
                .apiKey(System.getenv("GEMINI_API_KEY"))
                .build();

        GenerateContentResponse resposta = client.models.generateContent(
                System.getenv("MODEL"),
                "Traduza para o português o texto: " + texto,
                null
        );

      return resposta.text();
    }
}
