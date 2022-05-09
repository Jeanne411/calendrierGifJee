package fr.humanbooster.calendrierGifJee.services.impl;

import java.util.ArrayList;

import fr.humanbooster.calendrierGifJee.business.Emotion;
import fr.humanbooster.calendrierGifJee.services.EmotionService;

public class EmotionServiceImpl implements EmotionService {

	private static ArrayList<Emotion> emotions = new ArrayList<>();

	// On crée une méthode pour ajouter une émotion à la liste d'émotions
	@Override
	public Emotion ajouterEmotion(String nom, String code) {
		Emotion emotion = new Emotion(nom, code);
		emotions.add(emotion);
		return emotion;
	}

	// Méthode pour récupérer la liste des émotions
	@Override
	public ArrayList<Emotion> recupererEmotions() {
		return emotions;
	}

	// Méthode pour récupérer une émotion avec son nom et son code
	@Override
	public Emotion recupererEmotion(String nom, String code) {
		for (Emotion emotion : emotions) {
			if (emotion.getNom().equals(nom)) {
				return emotion;
			}
		}
		return null;
	}
	
    //Méthode pour récupérer une émotion avec son id
	@Override
	public Emotion recupererEmotion(Long id) {
		for (Emotion emotion : emotions) {
			if (emotion.getId().equals(id)) {
				return emotion;
			}
		}
		return null;
	}
	// Méthode pour modifier le nom d'une émotion
	@Override
	public Emotion modifierEmotion(String nom) {
		for (Emotion emotion : emotions) {
			emotion.getNom().replace(nom, nom);
			return emotion;
		}
		return null;
	}
	// Méthode pour supprimer une émotion avec son nom
	@Override
	public void supprimerEmotion(String nom) {
		for (Emotion emotion : emotions) {
			if (emotion.getNom().equals(nom)) {
				emotion = null;

			}

		}

	}
	// Méthode pour supprimer une émotion grâce à son id
	@Override
	public void supprimerEmotion(Long id) {
		for (Emotion emotion : emotions) {
			if (emotion.getId().equals(id)) {
				emotions.remove(emotion);
			}
		}

	}
}
