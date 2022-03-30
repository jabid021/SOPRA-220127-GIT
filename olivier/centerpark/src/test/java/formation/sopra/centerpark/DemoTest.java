package formation.sopra.centerpark;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;

import formation.sopra.centerpark.exception.ClientException;
import formation.sopra.centerpark.model.Client;
import formation.sopra.centerpark.model.Staff;
import formation.sopra.centerpark.repositories.CompteRepository;
import formation.sopra.centerpark.services.ClientService;

@SpringBootTest
class DemoTest {

	@Autowired
	ClientService clientService;
	
	@Autowired
	CompteRepository compteRepo;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Test
	void echecCreationClientTest() {
		assertThrows(ClientException.class, ()->{ clientService.create(new Client());});
	}
	
	@Disabled
	@Test
	@Transactional
	@Commit
	void creationClientTest() {
		Client c=new Client("olivier@olivier.fr", passwordEncoder.encode("olivier"), "111111", "11", "rue xxx", "cxxxx", "1111");
		clientService.create(c);
		assertNotNull(c.getNumero());
		
		compteRepo.save(new Staff("staff@staff.fr",passwordEncoder.encode("staff"), "metier"));
		
	}
	@Disabled
	@Test
	@Transactional
	@Commit
	void deleteClientTest() {
		clientService.deleteByNumero(2);
	}
}
