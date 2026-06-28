package br.com.marvin.screenmatch.service;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import io.github.cdimascio.dotenv.Dotenv;

public class ConsultaGemini {
    public static String obterTraducao(String texto) {
        Dotenv dotenv = Dotenv.load();
        String apiKey = dotenv.get("GEMINI_API_KEY");

        Client client = Client.builder()
                .apiKey(apiKey)
                .build();

        GenerateContentResponse resposta = client.models.generateContent(
                "gemini-2.5-flash",
                "Traduza para o português o texto: " + texto,
                null
        );

      return resposta.text();
    }
}
