package control;

import datastore.DB_Connector;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.TypeAnimal;
import org.mariadb.jdbc.Connection;
import persistence.TypeAnimalDAO_JDBC;  // Assurez-vous que cette classe existe pour interagir avec la base de données

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
/*
Logique de la Servlet AfficherPanierServlet

Récupérer le panier :
Si vous utilisez une session, récupérez le panier depuis la session de l'utilisateur.
Sinon, vous pourriez avoir un mécanisme de stockage du panier côté client (cookies, stockage local) ou dans une base de données avec un identifiant unique.
Préparer les données :
Calculez le total du panier.
Formatez les informations sur les produits (nom, prix, quantité, image éventuellement) pour l'affichage.
Envoyer les données à la JSP :
Utilisez un objet request.setAttribute() pour stocker les données du panier.
Utilisez request.getRequestDispatcher("afficherPanier.jsp").forward(request, response); pour transférer le contrôle à la JSP.
 */
@WebServlet("/AfficherPanierServlet")
public class AfficherPanierServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupérer la liste du panier depuis la session
        HttpSession session = request.getSession();
        List<String> panier = (List<String>) session.getAttribute("panier");
        if (panier == null) {
            panier = new ArrayList<>();
        }

        // Passer la liste du panier à la JSP
        request.setAttribute("panier", panier);
        RequestDispatcher dispatcher = request.getRequestDispatcher("afficherPanier.jsp");
        dispatcher.forward(request, response);
    }
}
