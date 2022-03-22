package pikomonMasterSpring;

import static org.junit.jupiter.api.Assertions.*;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import pikomon.config.SpringConfig;
import pikomon.dao.IDAOVille;
import pikomon.model.Ville;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { SpringConfig.class })
@Transactional
@Rollback
class DaoVilleTest {

	@Autowired
	IDAOVille daoVille;

	@Test
	void insertTest() {
		Ville ville = new Ville();
		ville.setNom("ville testffffff");
		daoVille.save(ville);
		assertNotNull(daoVille.findById(ville.getId()));
	}

	@Test
	@Commit
	void insertAvecCommit() {
		Ville ville = new Ville();
		ville.setNom("celui la je le garde");
		daoVille.save(ville);
	}

}
