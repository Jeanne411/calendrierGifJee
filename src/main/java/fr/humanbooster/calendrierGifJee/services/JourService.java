package fr.humanbooster.calendrierGifJee.services;

import java.time.LocalDate;
import java.util.List;

import fr.humanbooster.calendrierGifJee.business.Jour;

// Interface implémentée par la classe JourServiceImpl
public interface JourService {
	
	// Méthode pour ajouter un jour à la liste de jours
	Jour ajouterJour(LocalDate date);

	// Méthode pour récupérer la liste de jours
	List<Jour> recupererJours();
	// Méthode pour récupérer un jour grâce à sa date
	Jour recupererJour (LocalDate date);

}
