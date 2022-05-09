package fr.humanbooster.calendrierGifJee.services;

import java.util.List;

import fr.humanbooster.calendrierGifJee.business.Emotion;
import fr.humanbooster.calendrierGifJee.business.Gif;
import fr.humanbooster.calendrierGifJee.business.Reaction;
import fr.humanbooster.calendrierGifJee.business.Utilisateur;

// Interface implémentée par la classe ReactionServiceImpl
public interface ReactionService {

	// Méthode pour ajouter une réaction à la liste de réactions
	Reaction ajouterReaction(Gif gif, Utilisateur utilisateur, Emotion emotion);

	// Méthode pour récupérer la liste de réactions
	List<Reaction> recupererReactions();
	// Méthode pour récupérer une réaction grâce à son id
	Reaction recupererReaction(Long id);
	
}