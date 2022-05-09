package fr.humanbooster.calendrierGifJee.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import fr.humanbooster.calendrierGifJee.business.Gif;
import fr.humanbooster.calendrierGifJee.business.GifTeleverse;
import fr.humanbooster.calendrierGifJee.business.Utilisateur;
import fr.humanbooster.calendrierGifJee.services.GifService;
import fr.humanbooster.calendrierGifJee.services.JourService;
import fr.humanbooster.calendrierGifJee.services.impl.GifServiceImpl;
import fr.humanbooster.calendrierGifJee.services.impl.JourServiceImpl;

/**
 * Servlet implementation class GifTeleverseServlet
 */
//URL Mapping
@WebServlet("/gifteleverse")
@MultipartConfig()
public class GifTeleverseServlet extends HttpServlet {

	/**
	 * On crée les objets des interfaces services pour utiliser les méthodes des
	 * classes serviceImpl L'objet séparateur aura pour propriété file.separator
	 * afin d'obtenir les séparateurs peu importe leur forme ("/" ou "\" par
	 * exemple)
	 */
	GifService gifService = new GifServiceImpl();
	JourService jourService = new JourServiceImpl();
	String separateur = System.getProperty("file.separator");
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GifTeleverseServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// On redirige la requète vers une autre URL, ici ce sera notre JSP gifTeleverse.jsp
		request.getRequestDispatcher("/WEB-INF/gifTeleverse.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/**
		 * Ici, la méthode request.getParameter() permet de récupérer les données
		 * saisies sur le formulaire HTML de la JSP gifTeleverse.jsp
		 */
		String legende = request.getParameter("legende");
		// On récupère la date présente dans l'URL
		LocalDate date = LocalDate.parse(request.getParameter("date"));
		// On récupère l'objet de Session utilisateur
		Utilisateur utilisateur = (Utilisateur) request.getSession().getAttribute("utilisateur");

		Gif gifTeleverse = gifService.ajouterGifTeleverse(null, legende, jourService.recupererJour(date), utilisateur);

		/**
		 * On met dans une collection le fichier qui sera récupéré dans le formulaire
		 * HTML grâce à la méthode getParts().
		 * 
		 * Le nom du fichier correspondra au nom du fichier donné par l'utilisateur.
		 * 
		 * On définit le chemin dans lequel le fichier sera stocké en mémoire
		 * 
		 * Afin de créer un nom de fichier unique, on rajoute au chemin le nom du
		 * fichier donné par l'utilisateur
		 */
		Collection<Part> parts = request.getParts();
		for (Part part : parts) {
			if (part.getName().equals("nom_fichier_original")) {
				String chemin = request.getSession().getServletContext().getRealPath("/") + "img" + separateur
						+ gifTeleverse.getId() + ".gif";
				part.write(chemin);
				((GifTeleverse) gifTeleverse).setNomFichierOriginal(part.getSubmittedFileName());
			}
		}
		/**
		 * On redirige l'utilisateur vers la JSP calendrier.jsp en gardant, on renvoie
		 * dans l'URL le contexte de l'application gif
		 */
		response.sendRedirect(request.getContextPath() + "/calendrier");
	}
}
