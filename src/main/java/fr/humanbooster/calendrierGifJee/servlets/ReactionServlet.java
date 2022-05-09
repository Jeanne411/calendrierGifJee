package fr.humanbooster.calendrierGifJee.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.humanbooster.calendrierGifJee.business.Utilisateur;
import fr.humanbooster.calendrierGifJee.services.EmotionService;
import fr.humanbooster.calendrierGifJee.services.GifService;
import fr.humanbooster.calendrierGifJee.services.ReactionService;
import fr.humanbooster.calendrierGifJee.services.impl.EmotionServiceImpl;
import fr.humanbooster.calendrierGifJee.services.impl.GifServiceImpl;
import fr.humanbooster.calendrierGifJee.services.impl.ReactionServiceImpl;

/**
 * Servlet implementation class ReactionServlet
 */
//URL Mapping
@WebServlet("/reaction")
public class ReactionServlet extends HttpServlet {
	/**
	 * On crée les objets des interfaces services pour utiliser les méthodes des
	 * classes serviceImpl
	 */
	ReactionService reactionService = new ReactionServiceImpl();
	EmotionService emotionService = new EmotionServiceImpl();
	GifService gifService = new GifServiceImpl();
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReactionServlet() {
		super();
	}

	/**
	 * Affichage du passage dans la fonction Init dans la console. Si on n'a pas
	 * démotions stockées, on ajoute les émotions suivantes.
	 */
	public void init() throws ServletException {
		super.init();

		if (emotionService.recupererEmotions().isEmpty()) {
			emotionService.ajouterEmotion("Souriant", "&#x1F600;");
			emotionService.ajouterEmotion("Monocle", "&#x1F9D0;");
			emotionService.ajouterEmotion("Bisous", "&#x1F618;");
			emotionService.ajouterEmotion("Coeur", "&#x1F60D;");
			emotionService.ajouterEmotion("PTDR", "&#x1F923;");
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * On récupère le gif auquel l'utilisateur veut réagir pour l'afficher
		 * 
		 * On récupère les émotions pour les afficher dans le formulaire
		 */
		Long id = Long.parseLong(request.getParameter("gif"));
		request.setAttribute("gif", gifService.recupererGif(id));
		request.setAttribute("emotions", emotionService.recupererEmotions());
		// On redirige la requète vers une autre URL, ici ce sera notre JSP reaction.jsp
		request.getRequestDispatcher("WEB-INF/reaction.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// On récupère le gif grâce à son id
		Long gifId = Long.parseLong(request.getParameter("gif"));
		System.out.println(gifId);
		// On récupère l'utilisateur en session
		Utilisateur utilisateur = (Utilisateur) request.getSession().getAttribute("utilisateur");
		System.out.println(utilisateur);
		Long emotion = Long.parseLong(request.getParameter("emotion_id"));
        System.out.println(emotion);
		
		// On ajoute une réaction avec les paramètres saisis et récupérés
		reactionService.ajouterReaction(gifService.recupererGif(gifId), utilisateur,
				emotionService.recupererEmotion(emotion));
		System.out.println(reactionService.recupererReactions());
		// redirection vers la page calendrier
		response.sendRedirect("calendrier");
	}

}
