package fr.humanbooster.calendrierGifJee.servlets;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.humanbooster.calendrierGifJee.services.GifService;
import fr.humanbooster.calendrierGifJee.services.JourService;
import fr.humanbooster.calendrierGifJee.services.UtilisateurService;
import fr.humanbooster.calendrierGifJee.services.impl.GifServiceImpl;
import fr.humanbooster.calendrierGifJee.services.impl.JourServiceImpl;
import fr.humanbooster.calendrierGifJee.services.impl.UtilisateurServiceImpl;

/**
 * Servlet implementation class CalendrierServlet
 */
// URL Mapping
@WebServlet("/calendrier")
public class CalendrierServlet extends HttpServlet {
	/**
	 *  On crée les objets des interfaces services pour utiliser les méthodes 
	 *  des classes serviceImpl
	 */
	JourService jourService = new JourServiceImpl();
	GifService gifService = new GifServiceImpl();
	UtilisateurService utilisateurService = new UtilisateurServiceImpl();
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CalendrierServlet() {
		super();
	}
    
	/**
	 *  On crée ici une méthode pour obtenir une date au format année - mois - jour.
	 *  
	 *  Dans la boucle on ajoute +1 à la valeur du jour pour chaque jour
	 *   jusqu'à la fin du mois en cours.
	 */
	public void init() throws ServletException {
		super.init();
		int anneeEnCours = LocalDate.now().getYear();
		int moisEnCours = LocalDate.now().getMonthValue();
		LocalDate localDate = LocalDate.of(anneeEnCours, moisEnCours, 1);
		int nbJoursDuMoisEnCours = localDate.lengthOfMonth();
		for (int i = 1; i <= nbJoursDuMoisEnCours; i++) {
			jourService.ajouterJour(localDate);
			localDate = localDate.plusDays(1);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// On enrichit l'objet request de la liste de jours
		request.setAttribute("jours", jourService.recupererJours());
		// On redirige la requète vers une autre URL, ici ce sera notre JSP calendrier.jsp
		request.getRequestDispatcher("/WEB-INF/calendrier.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Pour pouvoir se déconnecter, on redirige sur la servlet DeconnexionServlet
		response.sendRedirect(request.getContextPath() + "/deconnexion");

	}

}
