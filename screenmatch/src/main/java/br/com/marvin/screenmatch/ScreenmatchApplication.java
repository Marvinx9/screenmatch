package br.com.marvin.screenmatch;

import br.com.marvin.screenmatch.model.DadosSerie;
import br.com.marvin.screenmatch.service.ConsumoApi;
import br.com.marvin.screenmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String endereco = "https://www.omdbapi.com/?t=gilmore+girls&apikey=54771532&";

		var consumoApi = new ConsumoApi();
		var json = consumoApi.obterDados(endereco);
		System.out.println(json);
		ConverteDados conversor = new ConverteDados();
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dados);
	}
}
