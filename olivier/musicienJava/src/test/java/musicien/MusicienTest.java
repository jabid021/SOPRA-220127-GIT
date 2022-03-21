package musicien;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import musicien.bean.Musicien;
import musicien.config.AppConfig;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {AppConfig.class})
class MusicienTest {

	@Autowired
	Musicien musicien;
	
	@Test
	void test() {
		assertNotNull(musicien);
	}

}
