package formation.sopra.exo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Commit;

import formation.sopra.exo.entity.Role;
import formation.sopra.exo.entity.Utilisateur;
import formation.sopra.exo.repositories.UtilisateurRepository;

@SpringBootTest
class ExoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UtilisateurRepository utilisateurRepo;

	@Test
	@Transactional
	@Commit
	void createAdmin() {
		Utilisateur u = new Utilisateur("admin", passwordEncoder.encode("admin"),
				new HashSet<Role>(Arrays.asList(Role.ROLE_ADMIN, Role.ROLE_USER)));
		utilisateurRepo.save(u);
	}

}
