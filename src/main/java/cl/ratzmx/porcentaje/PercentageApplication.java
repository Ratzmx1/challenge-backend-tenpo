package cl.ratzmx.porcentaje;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableFeignClients
public class PercentageApplication {

	public static void main(String[] args) {
		SpringApplication.run(PercentageApplication.class, args);
	}

}
