package fr.humanbooster.calendrierGifJee.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.humanbooster.calendrierGifJee.services.ThemeService;
import fr.humanbooster.calendrierGifJee.services.UtilisateurService;
import fr.humanbooster.calendrierGifJee.services.impl.ThemeServiceImpl;
import fr.humanbooster.calendrierGifJee.services.impl.UtilisateurServiceImpl;

/**
 * Servlet implementation class InscriptionServlet
 */
@WebServlet("/inscription")
public class InscriptionServlet extends HttpServlet {
	
	/**
	 *  On crée les objets des interfaces services pour utiliser les méthodes
	 *  des classes serviceImpl 
	 */
	ThemeService themeService = new ThemeServiceImpl();
	UtilisateurService utilisateurService = new UtilisateurServiceImpl();
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InscriptionServlet() {
        super();
    }
    
    // Ici on ajoute les thèmes s'ils ne sont pas en mémoire
	public void init() throws ServletException {
		super.init();
		
		if (themeService.recupererTheme().isEmpty()) {
			themeService.ajouterTheme("Dark");
			themeService.ajouterTheme("Bachata");

		}
	}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// On ajoute à l'objet requète les objets thèmes en récupérant la liste de thèmes
    	request.setAttribute("themes",themeService.recupererTheme());
    	// On redirige la requète vers l'URL de notre JSP inscription.jsp
        request.getRequestDispatcher("/WEB-INF/inscription.jsp").forward(request, response);
        
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		/**
		 *  Ici, la méthode request.getParameter() permet de récupérer les données saisies sur le 
		 *  formulaire HTML de la JSP inscription.jsp
		 */
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String email = request.getParameter("email");
        String motDePasse = request.getParameter("mot_de_passe");
        Long theme = Long.parseLong(request.getParameter("theme_id"));

            // On ajoute un nouvel utilisateur en lui attribuant les données saisies
        	utilisateurService.ajouterUtilisateur(nom, prenom, email, motDePasse, themeService.recupererTheme(theme));
        	// On redirige vers la page de connexion
        	request.getRequestDispatcher("connexion").forward(request, response);
        }
    }