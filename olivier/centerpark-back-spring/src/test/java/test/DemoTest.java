package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import centerpark.config.AppConfig;
import centerpark.exception.ClientException;
import centerpark.model.Activite;
import centerpark.model.Aquatique;
import centerpark.model.Client;
import centerpark.model.Meteo;
import centerpark.model.Safari;
import centerpark.repositories.ActiviteRepository;
import centerpark.services.ClientService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { AppConfig.class })
class DemoTest {

	@Autowired
	ClientService clientService;
	
	@Test
	void echecCreationClientTest() {
		assertThrows(ClientException.class, ()->{ clientService.create(new Client());});
	}
	
	@Test
	@Transactional
	@Rollback
	void creationClientTest() {
		Client c=new Client("olivier@olivier.fr", "olivier", "111111", "11", "rue xxx", "cxxxx", "1111");
		clientService.create(c);
		assertNotNull(c.getNumero());
	}
	
	@Test
	@Transactional
	@Commit
	void deleteClientTest() {
		clientService.deleteByNumero(2);
	}
}
