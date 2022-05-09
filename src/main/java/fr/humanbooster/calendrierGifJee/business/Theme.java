package fr.humanbooster.calendrierGifJee.business;

// les themes permettront d'avoir plusieurs possibilitées de thèmes pour le calendrier 
public class Theme {

	private Long id;

	private String nom;

	private static Long counter = 0L;

	public Theme() {
		id = ++counter;
	}

	public Theme(String nom) {
		this();
		this.nom = nom;
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

	@Override
	public String toString() {
		return " id=" + id + ", theme nom= " + nom + "]";
	}

}