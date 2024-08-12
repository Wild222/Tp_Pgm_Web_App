package control;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.PanierItem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/AjouterAnimalServlet")
public class AjouterAnimalServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupère le paramètre animalId
        String produitId = request.getParameter("animalId");
        // Récupère le paramètre qty
        String quantite = request.getParameter("qty");
        // Vérifier si les paramètres sont vides
        if (quantite == null || quantite.isEmpty()) {
            quantite = "1";
        }

        //
        System.out.println("Produit ID: " + produitId);
        System.out.println("Quantité: " + quantite);

        // Vérifier si les paramètres sont vides
        if (produitId == null || produitId.isEmpty()) {
            throw new ServletException("Le paramètre 'animalId' est requis.");
        }


        int id;
        int qty;

        //Convertir les paramètres en nombres entiers
        try {
            id = Integer.parseInt(produitId);
            qty = Integer.parseInt(quantite);
        } catch (NumberFormatException e) {
            throw new ServletException("Les paramètres 'animalId' et 'qty' doivent être des nombres entiers.", e);
        }

        //Récupere la session
        HttpSession session = request.getSession();
        // Vérifier si le panier existe de déjà si non le creer
        List<PanierItem> panier = (List<PanierItem>) session.getAttribute("panier");
        if (panier == null) {
            panier = new ArrayList<>();
            session.setAttribute("panier", panier);
        }

        // Vérifier si l'article est déjà dans le panier
        boolean found = false;
        for (PanierItem item : panier) {
            if (item.getId() == id) {
                // Si l'article est dans le panie, incrémente la quantité
                item.setQuantite(item.getQuantite() + qty);
                found = true;
                break;
            }
        }

        // Si l'article est pas dans le panier, l'ajoute au panier
        if (!found) {
            panier.add(new PanierItem(id, qty));
        }

        // Rediriger vers la même page
        response.sendRedirect(request.getHeader("referer"));
    }
}
