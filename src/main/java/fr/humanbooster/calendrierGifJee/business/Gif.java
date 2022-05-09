package fr.humanbooster.calendrierGifJee.business;

import java.time.LocalDateTime;
import java.util.*;

/**
 * classe mère des classes GifDistant et GifTeleverse, les gifs sont postés par
 * les utilisateurs il ne peut y avoir qu'un gif par jour tous les utilisateurs
 * peuvent réagir aux gifs du calendrier gif
 *
 */

public abstract class Gif {

	protected Long id;

	protected LocalDateTime dateHeureAjout;

	protected String legende;

	protected Jour jour;

	private Utilisateur utilisateur;

	private List<Reaction> reactions;

	private static Long counter = 0L;

	public Gif() {
		id = ++counter;
		this.dateHeureAjout = LocalDateTime.now();
		this.reactions = new ArrayList<>();
	}

	public Gif(String legende, Jour jour, Utilisateur utilisateur) {
		this();
		this.legende = legende;
		this.jour = jour;
		this.utilisateur = utilisateur;
		/**
		 * on affecte l'objet en cours de création (gif) au jour et à l'utilisateur
		 * donnés en paramètres
		 */
		jour.setGif(this);
		utilisateur.getGifs().add(this);
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public LocalDateTime getDateHeureAjout() {
		return dateHeureAjout;
	}
	
	public void setDateHeureAjout(LocalDateTime dateHeureAjout) {
		this.dateHeureAjout = dateHeureAjout;
	}
	
	public String getLegende() {
		return legende;
	}
	
	public void setLegende(String legende) {
		this.legende = legende;
	}
	
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	public List<Reaction> getReactions() {
		return reactions;
	}
	
	public void setReactions(List<Reaction> reactions) {
		this.reactions = reactions;
	}
	
	public Jour getJour() {
		return jour;
	}
	
	public void setJour(Jour jour) {
		this.jour = jour;
	}
	
	/**
	 * La méthode toString() a été modifiée pour obtenir en console seulement ce
	 * qu'on a besoin de voir et ne pas appeler les toString() des classes Reaction
	 * et Jour
	 */
	
	@Override
	public String toString() {
		return "Gif [dateHeureAjout=" + dateHeureAjout + ", legende=" + legende + ", reactions=" + getReactions()
		+ ", jour=" + getJour() + "]";
	}
	
}
