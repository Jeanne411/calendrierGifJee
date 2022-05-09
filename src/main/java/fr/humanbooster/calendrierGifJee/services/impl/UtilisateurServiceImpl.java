package fr.humanbooster.calendrierGifJee.services.impl;

import java.util.ArrayList;

import fr.humanbooster.calendrierGifJee.business.Theme;
import fr.humanbooster.calendrierGifJee.business.Utilisateur;
import fr.humanbooster.calendrierGifJee.services.UtilisateurService;

public class UtilisateurServiceImpl implements UtilisateurService {

	private static ArrayList<Utilisateur> utilisateurs = new ArrayList<>();

	private Utilisateur utilisateurConnecte = new Utilisateur();

	// Méthode pour ajouter un utilisateur à la liste d'utilisateurs
	@Override
	public Utilisateur ajouterUtilisateur(String nom, String prenom, String email, String motDePasse, Theme theme) {
		Utilisateur utilisateur = new Utilisateur(nom, prenom, email, motDePasse, theme);
		utilisateurs.add(utilisateur);
		return utilisateur;
	}

	// Méthode pour récupérer un utilisateur grâce à son email et son mot de passe
	@Override
	public Utilisateur recupererUtilisateur(String email, String motDePasse) {
		for (Utilisateur utilisateur : utilisateurs) {
			if (utilisateur.getEmail().equals(email) && utilisateur.getMotDePasse().equals(motDePasse)) {
				return utilisateur;
			}
		}
		return null;
	}

	@Override
	// Méthode pour récupérer la liste d'utilisateurs
	public ArrayList<Utilisateur> recupererUtilisateurs() {
		return utilisateurs;
	}

	@Override
	// Méthode pour récupérer un utilisateur grâce à son id
	public Utilisateur recupererUtilisateur(Long id) {
		for (Utilisateur utilisateur : utilisateurs) {
			if (utilisateur.getId().equals(id)) {
				return utilisateur;
			}
		}
		return null;

	}

	@Override
	// Méthode pour récupérer un utilisateur grâce à son prénom
	public Utilisateur recupererUtilisateur(String prenom) {
		for (Utilisateur utilisateur : utilisateurs) {
			if (utilisateur.getPrenom().equals(prenom)) {
				return utilisateur;
			}
		}
		return null;

	}

	 // Méthode pour récupérer un utilisateur connecté
	@Override
	public Utilisateur recupererUtilisateurConnecte() {
		return utilisateurConnecte;
	}

	 // Méthode pour Authentifier un utilisateur (email et mot de passe exacts)
	@Override
	public boolean authentifierUtilisateur(String email, String motDePasse) {
		for (Utilisateur utilisateur : utilisateurs) {
			// Pour une comparaison d'objet, on ne peut pas utiliser !=
			// != est reservée à la comparaison de types primitifs
			// if (utilisateur.getEmail() != (email) || utilisateur.getMotDePasse() !=
			// (motDePasse)) {
			if (!utilisateur.getEmail().equals(email) || !utilisateur.getMotDePasse().equals(motDePasse)) {
				return false;
			} else {
				utilisateur = utilisateurConnecte;

			}
		}
		return true;
	}

}
