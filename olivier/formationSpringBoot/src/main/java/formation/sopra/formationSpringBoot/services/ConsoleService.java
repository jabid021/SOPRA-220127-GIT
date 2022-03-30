package formation.sopra.formationSpringBoot.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class ConsoleService implements CommandLineRunner{

	private static final Logger LOGGER=LoggerFactory.getLogger(ConsoleService.class);
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("hello world");
		LOGGER.trace("trace");
		LOGGER.debug("debug");
		LOGGER.info("info");
		int i=10;
		LOGGER.warn("warn "+i);
		LOGGER.error("error");
	}
	//trace
	//debug
	//info
	//warn
	//error

}
