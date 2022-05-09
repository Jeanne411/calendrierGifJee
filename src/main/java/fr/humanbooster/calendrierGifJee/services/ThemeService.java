package fr.humanbooster.calendrierGifJee.services;

import java.util.ArrayList;

import fr.humanbooster.calendrierGifJee.business.Theme;

// Interface implémentée par la classe ThemeServiceImpl
public interface ThemeService {

	// Méthode pour ajouter un thème à la liste de thèmes
	public Theme ajouterTheme (String nom);
	
	// Méthode pour récupérer la liste de thèmes
	public ArrayList<Theme> recupererTheme ();
	// Méthode pour récupérer un thème grâce à son nom
	public Theme recupererTheme (String nom);
	// Méthode pour récupérer un thème grâce à son id
	public Theme recupererTheme (Long id);
	
}
