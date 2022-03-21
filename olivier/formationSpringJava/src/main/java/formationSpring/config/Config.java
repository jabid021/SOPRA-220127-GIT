package formationSpring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import formationSpring.Poste;

@Configuration
@ComponentScan({"formationSpring"})
public class Config {

	@Bean
	public Poste direction() {
		Poste manager= new Poste();
		manager.setNom("direction");
		return manager;
	}
}
