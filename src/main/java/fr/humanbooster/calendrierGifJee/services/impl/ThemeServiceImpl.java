package fr.humanbooster.calendrierGifJee.services.impl;

import java.util.ArrayList;

import fr.humanbooster.calendrierGifJee.business.Theme;
import fr.humanbooster.calendrierGifJee.services.ThemeService;

public class ThemeServiceImpl implements ThemeService {

	ArrayList<Theme> themes = new ArrayList<>();

	// Méthode pour ajouter un thème à la liste de thèmes
	@Override
	public Theme ajouterTheme(String nom) {
		Theme theme = new Theme(nom);
		themes.add(theme);
		return theme;

	}
	// Méthode pour récupérer la liste de thèmes
	@Override
	public ArrayList<Theme> recupererTheme() {
		return themes;
	}
    
	// Méthode pour récupérer un thème grâce à son nom
	@Override
	public Theme recupererTheme(String nom) {
		for (Theme theme : themes) {
			if (theme.getNom().equals(nom)) {
				return theme;
			}
		}
		return null;
	}

	// Méthode pour récupérer un thèma grâce à son id
	@Override
	public Theme recupererTheme(Long id) {
		for (Theme theme : themes) {
			if (theme.getId().equals(id)) {
				return theme;
			}
		}
		return null;
	}

}
