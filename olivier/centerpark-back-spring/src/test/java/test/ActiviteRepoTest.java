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
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import centerpark.config.AppConfig;
import centerpark.model.Activite;
import centerpark.model.Aquatique;
import centerpark.model.Meteo;
import centerpark.model.Safari;
import centerpark.repositories.ActiviteRepository;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { AppConfig.class })
class ActiviteRepoTest {

	@Autowired
	ActiviteRepository activiteRepository;

	@Test
	void injectionTest() {
		assertNotNull(activiteRepository);
	}

	@Test
	@Disabled
	@Transactional
	@Rollback
	void insertTest() {
		Activite activite = new Aquatique(Meteo.Soleil, LocalDate.of(2022, Month.MARCH, 22), LocalTime.of(17, 0), 100);
		activiteRepository.save(activite);

//		List<Activite> list=new ArrayList<Activite>():
//			list.add(activite)

		List<Activite> activites = Arrays.asList(new Safari(), new Aquatique());
		activiteRepository.saveAll(activites);
	}

	@Test
	@Transactional
	@Rollback
	void deleteTest() {
		long nbreLigne = activiteRepository.count();
		assertEquals(3, nbreLigne);
		activiteRepository.deleteById(2);
		assertNotEquals(3, activiteRepository.count());
	}

	@Test
	void selectTest() {
		assertEquals(3, activiteRepository.findAll().size());
//		activiteRepository.findAll().stream().forEach(activite->{
//			
//		});

		Optional<Activite> opt = activiteRepository.findById(1);
		if(opt.isPresent()) {
			assertNotNull(opt.get());
		}
		
		assertEquals(Optional.empty(), activiteRepository.findById(100));
		
		assertNotNull(activiteRepository.findById(1).orElseThrow());
		assertThrows(NoResultException.class,()->{
			activiteRepository.findById(1).orElseThrow(NoResultException::new);
		});
	}

}
