package control;

import datastore.DB_Connector;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Panier;

import java.io.IOException;

import java.util.List;

//lien qui sera utilise pour afficher le panier
@WebServlet("/afficherPanier")
public class AfficherPanierServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Panier panier = (Panier) session.getAttribute("panier");

        // Si le panier est null, initialiser un panier vide
        if (panier == null) {
            panier = new Panier();
        }

        request.setAttribute("panier", panier.getAnimauxQuantites()); // Assurez-vous de passer un type approprié (Map ou List)
        request.getRequestDispatcher("/afficherPanier.jsp").forward(request, response);
    }
}
