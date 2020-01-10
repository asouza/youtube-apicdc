package br.com.deveficiente.youtubeapicdc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(enableDefaultTransactions = false)
public class ApiCasaDoCodigoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiCasaDoCodigoApplication.class, args);
	}

}
