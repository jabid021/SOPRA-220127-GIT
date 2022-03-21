package musicien.bean;

import org.springframework.stereotype.Component;

@Component
public class Guitare implements Instrument{

	@Override
	public String jouer() {
		return "le son de la guitare";
	}

}
