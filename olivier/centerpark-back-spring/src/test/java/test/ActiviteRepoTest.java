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
	@Commit
	void insertTest() {
		Activite activite = new Aquatique(Meteo.Soleil, LocalDate.of(2022, Month.MARCH, 22), LocalTime.of(17, 0), 100);
		activiteRepository.save(activite);

//		List<Activite> list=new ArrayList<Activite>():
//			list.add(activite)

		List<Activite> activites = Arrays.asList(new Safari(), new Aquatique());
		activiteRepository.saveAll(activites);
	}

	@Test
	@Disabled
	@Transactional
	@Rollback
	void deleteTest() {
		long nbreLigne = activiteRepository.count();
		assertEquals(3, nbreLigne);
		activiteRepository.deleteById(2);
		assertNotEquals(3, activiteRepository.count());
	}

	@Test
	@Disabled
	void selectTest() {
//		assertEquals(3, activiteRepository.findAll().size());
//		activiteRepository.findAll().stream().forEach(activite->{
//			
//		});

		Optional<Activite> opt = activiteRepository.findById(1);
		if (opt.isPresent()) {
			assertNotNull(opt.get());
		}

		assertEquals(Optional.empty(), activiteRepository.findById(100));

		assertNotNull(activiteRepository.findById(1).orElseThrow());
		assertThrows(NoResultException.class, () -> {
			activiteRepository.findById(100).orElseThrow(NoResultException::new);
		});
	}
	
	@Test
	@Disabled
	void selectPaginationTest() {
		int nombreElementParPage=5;
		int numeroDeLaPageARemonter=1;
		Pageable page=PageRequest.of(numeroDeLaPageARemonter, nombreElementParPage);
		
		Page<Activite> resultat= activiteRepository.findAll(page);
		resultat.forEach(a->{
			System.out.println(a.getId());
		});
	
	}
	
	@Test
	@Disabled
	void selectSortTest() {
		System.out.println("-------");
		activiteRepository.findAll(Sort.by("id").descending()).forEach(a->{System.out.println(a.getId());});
		System.out.println("-------");
	}
	
	@Test
	@Disabled
	void equalsTest() {
		Activite activite1= activiteRepository.findById(1).orElseThrow();
		Activite activite2= activiteRepository.findById(1).orElseThrow();
		assertEquals(activite1, activite2);
		//references differentes=>on a 2 object en memoire
		assertFalse(activite1==activite2);
		//les 2 references representent la meme activite en base
		//comparaison fonctionnelle vrai
		assertTrue(activite1.equals(activite2));
		
		
		
	}

}
