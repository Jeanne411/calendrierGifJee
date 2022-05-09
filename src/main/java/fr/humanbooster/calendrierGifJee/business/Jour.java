package fr.humanbooster.calendrierGifJee.business;

import java.time.LocalDate;
import java.util.Random;

/**
 * Le calendrier gif permettra de poster un gif par jour Les gifs sont attribués
 * aux jours dans la classe Gif
 */
public class Jour {

	private LocalDate date;

	private int nbPoints;

	private Gif gif;

	private static Random random = new Random();

	public Jour() {
		date = LocalDate.now();
		nbPoints = 20 + random.nextInt(31);
	}

	public Jour(LocalDate date) {
		this();
		this.date = date;
	}

	public Jour(int nbPoints, Gif gif) {
		this();
		this.nbPoints = nbPoints;
		this.gif = gif;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getNbPoints() {
		return nbPoints;
	}

	public void setNbPoints(int nbPoints) {
		this.nbPoints = nbPoints;
	}

	public Gif getGif() {
		return gif;
	}

	public void setGif(Gif gif) {
		this.gif = gif;
	}

	@Override
	public String toString() {
		return date.getDayOfMonth() + "/" + date.getMonthValue();
	}

}
