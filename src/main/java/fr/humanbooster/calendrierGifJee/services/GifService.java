package fr.humanbooster.calendrierGifJee.services;

import java.util.List;

import fr.humanbooster.calendrierGifJee.business.Gif;
import fr.humanbooster.calendrierGifJee.business.Utilisateur;
import fr.humanbooster.calendrierGifJee.business.Jour;

//Interface implémentée par la classe GifServiceImpl
public interface GifService {
	
	// Méthode pour ajouter un GifDistant à la liste de gifs
	Gif ajouterGifDistant(String url, String legende, Jour jour, Utilisateur utilisateur);
	// Méthode pour ajouter un GifTeleverse à la liste de gifs
	Gif ajouterGifTeleverse(String nomFichierOriginal, String legende, Jour jour, Utilisateur utilisateur);
	
	// Méthode pour récupérer la liste de gifs
	List<Gif> recupererGifs();
	// Méthode pour récupérer un gif grâce à son id
	Gif recupererGif(Long id);
}
