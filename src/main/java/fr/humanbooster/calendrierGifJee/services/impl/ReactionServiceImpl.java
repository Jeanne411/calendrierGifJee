package fr.humanbooster.calendrierGifJee.services.impl;

import java.util.ArrayList;
import java.util.List;

import fr.humanbooster.calendrierGifJee.business.Emotion;
import fr.humanbooster.calendrierGifJee.business.Gif;
import fr.humanbooster.calendrierGifJee.business.Reaction;
import fr.humanbooster.calendrierGifJee.business.Utilisateur;
import fr.humanbooster.calendrierGifJee.services.ReactionService;

public class ReactionServiceImpl implements ReactionService {

	private static List<Reaction> reactions = new ArrayList<>();

	// Méthode pour ajouter une réaction à la liste de réactions
	@Override
	public Reaction ajouterReaction(Gif gif, Utilisateur utilisateur, Emotion emotion) {
		Reaction reaction = new Reaction(gif, utilisateur, emotion);
		reactions.add(reaction);
		return reaction;
	}
	
	// Méthode pour récupérer la liste de réactions
	@Override
	public List<Reaction> recupererReactions() {
		return reactions;
	}

	// Méthode pour récupérer une réaction grâce à son id
	@Override
	public Reaction recupererReaction(Long id) {
		for (Reaction reaction : reactions) {
			if (reaction.getId().equals(id)) {
				return reaction;
			}
		}
		return null;
	}

}