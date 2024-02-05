package es.dsw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="es.dsw")
public class PasteleriaReservaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PasteleriaReservaApplication.class, args);
	}

}
