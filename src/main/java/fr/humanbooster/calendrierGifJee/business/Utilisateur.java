package fr.humanbooster.calendrierGifJee.business;

import java.time.LocalDateTime;
import java.util.*;

/**
 * l'utilisateur pourra poster des gifs sur le calendrier il partira d'uN solde
 * de 500 points et ses points diminueront en fonction des gifs qu'il postera
 */

public class Utilisateur {

	private static final int NB_POINTS_INITIAL = 500;

	private Long id;

	private String nom;

	private String prenom;

	private String email;

	private String motDePasse;

	private int nbPoints;

	private LocalDateTime dateHeureInscription;

	private Theme theme;

	private List<Gif> gifs;

	private static Long counter = 0L;

	public Utilisateur() {
		id = ++counter;
		this.nbPoints = NB_POINTS_INITIAL;
		this.dateHeureInscription = LocalDateTime.now();
		this.gifs = new ArrayList<Gif>();
	}

	public Utilisateur(String nom, String prenom, String email, String motDePasse, Theme theme) {
		this();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.motDePasse = motDePasse;
		this.theme = theme;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public int getNbPoints() {
		return nbPoints;
	}

	public void setNbPoints(int nbPoints) {
		this.nbPoints = nbPoints;
	}

	public LocalDateTime getDateHeureInscription() {
		return dateHeureInscription;
	}

	public void setDateHeureInscription(LocalDateTime dateHeureInscription) {
		this.dateHeureInscription = dateHeureInscription;
	}

	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

	public List<Gif> getGifs() {
		return gifs;
	}

	public void setGifs(List<Gif> gifs) {
		this.gifs = gifs;
	}

	public static int getNbPointsInitial() {
		return NB_POINTS_INITIAL;
	}

	/**
	 * La méthode toString() a été modifiée pour obtenir en console seulement ce
	 * qu'on a besoin de voir et ne pas appeler les toString() des classes Theme et
	 * Gif
	 */

	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", motDePasse="
				+ motDePasse + ", nbPoints=" + nbPoints + ", dateHeureInscription=" + dateHeureInscription + ", theme="
				+ getTheme() + ", gifs=" + getGifs() + "]";
	}

}