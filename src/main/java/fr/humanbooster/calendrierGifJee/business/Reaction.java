package fr.humanbooster.calendrierGifJee.business;

import java.time.LocalDateTime;

// Les utilisateurs pourrot réagir aux gifs grâce à des émotions 
public class Reaction {

	private Long id;

	private LocalDateTime dateHeure;

	private Gif gif;

	private Utilisateur utilisateur;

	private Emotion emotion;

	private static Long counter = 0L;

	public Reaction() {
		id = ++counter;
		this.dateHeure = LocalDateTime.now();
	}

	public Reaction(Gif gif, Utilisateur utilisateur, Emotion emotion) {
		this();
		this.gif = gif;
		this.utilisateur = utilisateur;
		this.emotion = emotion;
		// on attribue la réaction aux gifs
		gif.getReactions().add(this);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDateHeure() {
		return dateHeure;
	}

	public void setDateHeure(LocalDateTime dateHeure) {
		this.dateHeure = dateHeure;
	}

	public Gif getGif() {
		return gif;
	}

	public void setGif(Gif gif) {
		this.gif = gif;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Emotion getEmotion() {
		return emotion;
	}

	public void setEmotion(Emotion emotion) {
		this.emotion = emotion;
	}

	/**
	 * La méthode toString() a été modifiée pour obtenir en console seulement ce
	 * qu'on a besoin de voir et ne pas appeler les toString() des classes Emotion,
	 * Utilisateur et Gif
	 */
	@Override
	public String toString() {
		return "Reaction [dateHeure=" + dateHeure + ", gif=" + gif.getId() + ", utilisateur=" + utilisateur.getPrenom()
				+ ", emotion=" + emotion.getNom() + "]";
	}

}