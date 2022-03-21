package musicien;

import org.springframework.beans.factory.annotation.Autowired;

import musicien.bean.Musicien;

public class AppSpring {

	@Autowired
	Musicien musicien;
	
	public void run(String ...args) {
		musicien.perform();
	}
}
