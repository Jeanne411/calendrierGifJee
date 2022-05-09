package fr.humanbooster.calendrierGifJee.services;

import java.util.ArrayList;

import fr.humanbooster.calendrierGifJee.business.Theme;
import fr.humanbooster.calendrierGifJee.business.Utilisateur;

public interface UtilisateurService {

	 // Méthode pour ajouter un utilisateur à la liste d'utilisateurs
	 Utilisateur ajouterUtilisateur(String nom, String prenom, String email, String motDePasse, Theme theme);
	 
	 // Méthode pour récupérer la liste d'utilisateurs
	 ArrayList<Utilisateur> recupererUtilisateurs();
	 // Méthode pour récupérer un utilisateur grâce à son email et son mot de passe
	 Utilisateur recupererUtilisateur(String email, String motDePasse);
	 // Méthode pour récupérer un utilisateur grâce à son id
	 Utilisateur recupererUtilisateur(Long id);
	 // Méthode pour récupérer un utilisateur grâce à son prénom
	 Utilisateur recupererUtilisateur(String prenom);
	 // Méthode pour récupérer un utilisateur connecté
	 Utilisateur recupererUtilisateurConnecte();
	 
	 // Méthode pour Authentifier un utilisateur (email et mot de passe exacts)
	 boolean authentifierUtilisateur(String email, String motDepasse);
}
