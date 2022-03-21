package musicienXml;

public class Guitariste implements Musicien {

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
