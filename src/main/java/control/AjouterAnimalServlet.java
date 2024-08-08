package control;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Panier;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/AjouterAnimalServlet")
public class AjouterAnimalServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupérer l'ID de l'animal depuis le formulaire
        int animalId = Integer.parseInt(request.getParameter("animalId"));

        // Récupérer le panier depuis la session, ou créer un nouveau panier si aucun panier n'existe
        HttpSession session = request.getSession();
        Panier panier = (Panier) session.getAttribute("panier");
        if (panier == null) {
            panier = new Panier();
            session.setAttribute("panier", panier);
        }

        // Ajouter l'animal au panier (avec une quantité par défaut de 1)
        panier.ajouterAnimal(animalId, 1);

        // Rediriger vers la même page
        response.sendRedirect(request.getHeader("referer"));
    }
}

