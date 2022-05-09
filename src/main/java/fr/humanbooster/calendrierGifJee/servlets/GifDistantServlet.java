package fr.humanbooster.calendrierGifJee.servlets;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.humanbooster.calendrierGifJee.business.Utilisateur;
import fr.humanbooster.calendrierGifJee.services.GifService;
import fr.humanbooster.calendrierGifJee.services.JourService;
import fr.humanbooster.calendrierGifJee.services.UtilisateurService;
import fr.humanbooster.calendrierGifJee.services.impl.GifServiceImpl;
import fr.humanbooster.calendrierGifJee.services.impl.JourServiceImpl;
import fr.humanbooster.calendrierGifJee.services.impl.UtilisateurServiceImpl;

/**
 * Servlet implementation class GifServlet
 */
// URL Mapping
@WebServlet("/gifdistant")
public class GifDistantServlet extends HttpServlet {

	/**
	 * On crée les objets des interfaces services pour utiliser les méthodes des
	 * classes serviceImpl
	 */
	GifService gifService = new GifServiceImpl();
	JourService jourService = new JourServiceImpl();
	UtilisateurService utilisateurService = new UtilisateurServiceImpl();

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GifDistantServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// On redirige la requète vers une autre URL, ici ce sera notre JSP gifDistant.jsp
		request.getRequestDispatcher("/WEB-INF/gifDistant.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/**
		 * Ici, la méthode request.getParameter() permet de récupérer les données
		 * saisies sur le formulaire HTML de la JSP gifDistant.jsp
		 */
		String url = request.getParameter("url");
		String legende = request.getParameter("legende");
		// On récupère la date dans l'URL
		LocalDate date = LocalDate.parse(request.getParameter("date"));
		// On récupère l'objet de Session utilisateur
		Utilisateur utilisateur = (Utilisateur) request.getSession().getAttribute("utilisateur");

		/**
		 * On ajoute le gifDistant et on redirige l'utilisateur vers une autre
		 * ressource, ici ce sera notre JSP calendrier.jsp
		 */
		gifService.ajouterGifDistant(url, legende, jourService.recupererJour(date), utilisateur);
		System.out.println(gifService.recupererGifs());
		response.sendRedirect("calendrier");

	}

}
