package fr.humanbooster.calendrierGifJee.business;

//La classe nous permettra d'obtenir des emotes qui nous serviront à réagir aux gifs
public class Emotion {

	private Long id;

	private String nom;

	private String code;

	private static Long counter = 0L;

	public Emotion() {
		id = ++counter;
	}

	public Emotion(String nom, String code) {
		this();
		this.nom = nom;
		this.code = code;
		
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "Emotion: " + "id: " + id + ", nom: " + nom + ", code: " + code + ".";
	}

}