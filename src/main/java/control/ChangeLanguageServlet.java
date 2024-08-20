package control;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(name = "ChangeLanguageServlet", value = "/change-language")
public class ChangeLanguageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Recherche de la langue dans les paramètres de la requête
        String lang = request.getParameter("lang");
        if (lang != null) {
            if ("fr_CA".equals(lang) || "en_US".equals(lang)) {
                request.getSession().setAttribute("lang", lang);
            }
        }
        // Redirection vers la page ou la demande est faite
        String referer = request.getHeader("referer");
        if (referer != null) {
            response.sendRedirect(referer);
        } else {
            response.sendRedirect("acceuil.jsp");
        }
    }
}
