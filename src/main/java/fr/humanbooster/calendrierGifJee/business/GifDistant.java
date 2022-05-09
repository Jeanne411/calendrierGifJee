package fr.humanbooster.calendrierGifJee.business;

/**
 * GifDistant hérite de Gif, l'utilisateur poste un gif récupéré sur internet
 * grâce à son url
 *
 */
public class GifDistant extends Gif {

	private String url;

	public GifDistant() {
		super();

	}

	/**
	 * on ajoute les constructeurs de la classe mère pour créer la méthode
	 * ajouterGifDistant(String url, String legende, Jour jour, Utilisateur
	 * utilisateur) dans GifServiceImpl
	 */
	public GifDistant(String url, String legende, Jour jour, Utilisateur utilisateur) {
		super(legende, jour, utilisateur);
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * La méthode toString() a été modifiée pour obtenir en console seulement ce
	 * qu'on a besoin de voir et ne pas appeler les toString() des classes Reaction
	 * et Jour
	 */
	@Override
	public String toString() {
		return "GifDistant" + "[id=" + id + ", url=" + url + ", Legende=" + getLegende() + ", Jour="
				+ getJour().getDate() + ", getReactions()=" + getReactions() + "]";
	}

}
