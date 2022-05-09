package fr.humanbooster.calendrierGifJee.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.humanbooster.calendrierGifJee.business.Utilisateur;
import fr.humanbooster.calendrierGifJee.services.UtilisateurService;
import fr.humanbooster.calendrierGifJee.services.impl.UtilisateurServiceImpl;

/**
 * Servlet implementation class ConnexionServlet
 */
//URL Mapping
@WebServlet("/connexion")
public class ConnexionServlet extends HttpServlet {
	/**
	 * On crée l' objet de l'interface serviceUtilisateur pour utiliser les méthodes
	 * de la classe UtilisateurServiceImpl
	 */
	UtilisateurService utilisateurService = new UtilisateurServiceImpl();

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConnexionServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// On redirige la requète vers une autre URL, ici ce sera notre JSP connexion.jsp
		request.getRequestDispatcher("/WEB-INF/connexion.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * Ici, la méthode request.getParameter() permet de récupérer les données
		 * saisies sur le formulaire HTML de la JSP connexion.jsp
		 */
		String email = request.getParameter("EMAIL");
		String motDePasse = request.getParameter("MOT_DE_PASSE");
		// On vérifie que l'utilisateur soit valide (email et mot de passe exacts)
		boolean estUtilisateurValide = utilisateurService.authentifierUtilisateur(email, motDePasse);

		/**
		 * Si l'email et le mot de passe correspondent, on récupère ses données afin de
		 * placer l'utilisateur en session: L'objet utilisateur devient un attribut de
		 * la session. L'utilisateur étant validé et en session, on peut le renvoyer sur
		 * la calendrier gif.
		 * 
		 * Sinon, on ne lui permet pas l'accès au calendrier et celui-ci reste sur la
		 * page de connexion.
		 */

		utilisateurService.authentifierUtilisateur(email, motDePasse);
		if (estUtilisateurValide) {
			Utilisateur utilisateur = utilisateurService.recupererUtilisateur(email, motDePasse);
			request.getSession().setAttribute("utilisateur", utilisateur);
			response.sendRedirect("calendrier");
		} else {
			response.sendRedirect("connexion");
		}
	}

}
