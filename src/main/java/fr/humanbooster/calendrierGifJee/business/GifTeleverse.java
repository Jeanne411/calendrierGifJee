package fr.humanbooster.calendrierGifJee.business;

//GifTeleverse hérite de Gif 
public class GifTeleverse extends Gif {

	private String nomFichierOriginal;

	/**
	 * on ajoute les constructeurs de la classe mère Gif afi de créer la méthode
	 * ajouterGifTeleverse(String nomFichierOriginal, String legende, Jour jour,
	 * Utilisateur utilisateur) dans la classe GifServiceImpl
	 */

	public GifTeleverse(String nomFichierOriginal, String legende, Jour jour, Utilisateur utilisateur) {
		super(legende, jour, utilisateur);
		this.nomFichierOriginal = nomFichierOriginal;
	}

	public String getNomFichierOriginal() {
		return nomFichierOriginal;
	}

	public void setNomFichierOriginal(String nomFichierOriginal) {
		this.nomFichierOriginal = nomFichierOriginal;
	}

	@Override
	public String toString() {
		return "GifTeleverse [nomFichierOriginal=" + nomFichierOriginal + "]";
	}

}