package control;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/AjouterAnimalServlet")
public class AjouterAnimalServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String produitId = request.getParameter("animalId");
        //AutoIncrémenter la quantiter lors de lappeui sur ajouter panier
         int quantite = 0;




        if (produitId == null || produitId.isEmpty()) {
            throw new ServletException("Le paramètre 'id' est requis.");
        }

        int id;
        try {
            id = Integer.parseInt(produitId);
        } catch (NumberFormatException e) {
            throw new ServletException("Le paramètre 'id' doit être un nombre entier.", e);
        }

        HttpSession session = request.getSession();
        List<Integer> panier = (List<Integer>) session.getAttribute("panier");
        if (panier == null) {
            panier = new ArrayList<>();
            session.setAttribute("panier", panier);
        }

        // Ajouter l'ID de l'animal à la liste du panier
        panier.add(id);



        // Rediriger vers la même page
        response.sendRedirect(request.getHeader("referer"));
    }
}

