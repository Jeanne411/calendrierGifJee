package fr.humanbooster.calendrierGifJee.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.humanbooster.calendrierGifJee.business.Theme;
import fr.humanbooster.calendrierGifJee.services.ThemeService;
import fr.humanbooster.calendrierGifJee.services.impl.ThemeServiceImpl;

/**
 * Servlet implementation class ThemesServlet
 */
@WebServlet("/themes")
public class ThemesServlet extends HttpServlet {

	/**
	 * On crée les objets des interfaces services pour utiliser les méthodes des
	 * classes serviceImpl
	 */
	private static ThemeService themeService = new ThemeServiceImpl();
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ThemesServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init() throws ServletException {
		super.init();
		// affichage du passage dans la fonction Init dans la console
		System.out.println("C'est reparti !!");
		if (themeService.recupererTheme().isEmpty()) {
			themeService.ajouterTheme("Dark");
			themeService.ajouterTheme("Bachata");

		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.getWriter().append("<!DOCTYPE html><html><body>\n");
		// Récupération des émotions via emotionServices
		for (Theme theme : themeService.recupererTheme()) {
			// Récupéartion du code de chaque Emotion
			response.getWriter().append(theme.getId() + ":" + theme.getNom() + "<br>\n");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
