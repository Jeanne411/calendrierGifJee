package fr.humanbooster.calendrierGifJee.services.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.humanbooster.calendrierGifJee.business.Jour;
import fr.humanbooster.calendrierGifJee.services.JourService;

public class JourServiceImpl implements JourService{
	
	private static List<Jour> jours = new ArrayList<>();

	// Méthode pour ajouter un jour à la liste de jours
	@Override
	public Jour ajouterJour(LocalDate date) {
		Jour jour = new Jour(date);
		jours.add(jour);
		return jour;
	}

	// Méthode pour récupérer la liste de jours
	@Override
    public List<Jour> recupererJours() {
        	return jours;
    }
    
	// Méthode pour récupérer un jour grâce à sa date
	@Override
    public Jour recupererJour(LocalDate date) {
    	for (Jour jour : jours) {
			if (jour.getDate().equals(date)) {
				return jour;
			}
		}
    	return null;
    }
}

