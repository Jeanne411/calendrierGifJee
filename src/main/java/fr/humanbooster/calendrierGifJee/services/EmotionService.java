package fr.humanbooster.calendrierGifJee.services;

import java.util.ArrayList;

import fr.humanbooster.calendrierGifJee.business.Emotion;

// Interface implémentée par la classe EmotionServiceImpl
public interface EmotionService {

	// On crée une méthode pour ajouter une émotion à la liste d'émotions
	public Emotion ajouterEmotion(String nom, String code);

	// Méthode pour récupérer la liste des émotions
	public ArrayList<Emotion> recupererEmotions();

	// Méthode pour récupérer une émotion avec son nom et son code
	public Emotion recupererEmotion(String nom, String code);
    // Méthode pour récupérer une émotion avec son id
	public Emotion recupererEmotion(Long id);

	// Méthode pour modifier le nom d'une émotion
	public Emotion modifierEmotion(String nom);

	// Méthode pour supprimer une émotion grâce à son nom
	public void supprimerEmotion(String nom);
	// Méthode pour supprimer une émotion grâce à son id
	public void supprimerEmotion(Long id);

}
