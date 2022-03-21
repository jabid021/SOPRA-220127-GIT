package musicien.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Guitariste implements Musicien {

	@Autowired
	@Qualifier("guitare")
	private Instrument instrument;

	@Override
	public void perform() {
		System.out.println("le guirariste joue de son instrument, " + this.instrument.jouer());
	}

	public Instrument getInstrument() {
		return instrument;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

}
