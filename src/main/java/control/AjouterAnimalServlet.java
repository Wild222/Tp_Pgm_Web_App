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

//
//package control;
//
//import jakarta.servlet.RequestDispatcher;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//import model.PanierItem;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//@WebServlet("/AjouterAnimalServlet")
//public class AjouterAnimalServlet extends HttpServlet {
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // Récupère le paramètre animalId
//        // Retrieve the animalId parameter
//        String produitId = request.getParameter("animalId");
//        if (produitId == null || produitId.isEmpty()) {
//            throw new ServletException("Le paramètre 'animalId' est requis.");
//        }
//
//        // Retrieve and parse the quantity parameter
//        int quantityToAdd;
//        try {
//            quantityToAdd = Integer.parseInt(request.getParameter("qty"));
//        } catch (NumberFormatException e) {
//            quantityToAdd = 1; // Default to 1 if there's an error
//        }
//
//        // Retrieve the session
//        HttpSession session = request.getSession();
//
//        // Retrieve or initialize the cart
//        List<PanierItem> panier = (List<PanierItem>) session.getAttribute("panier");
//        if (panier == null) {
//            panier = new ArrayList<>();
//            session.setAttribute("panier", panier);
//        }
//
//        // Regarder si l'article est déjà dans le panier
//        boolean found = false;
//        for (PanierItem item : panier) {
//            if (item.getId() == Integer.parseInt(produitId)) {
//                // Si l'article est dans le panier, ajoute la quantité
//                item.setQuantite(item.getQuantite() + quantityToAdd);
//                found = true;
//                break;
//            }
//        }
//
//        // si l'article n'est pas dans le panier, l'ajoute au panier
//        if (!found) {
//            panier.add(new PanierItem(Integer.parseInt(produitId), quantityToAdd));
//        }
//
//        // recalculer la quantité
//        Integer currentQuantity = (Integer) session.getAttribute("quantite");
//        if (currentQuantity == null) {
//            currentQuantity = 0;
//        }
//        currentQuantity += quantityToAdd;
//        session.setAttribute("quantite", currentQuantity);
//
//        // Redirect to the referring page or a default page
//        String referer = request.getHeader("referer");
//        if (referer != null) {
//            response.sendRedirect(referer);
//        } else {
//            response.sendRedirect(request.getContextPath() + "/afficherAnimal.jsp");
//        }
//    }
//}
@WebServlet("/AjouterAnimalServlet")
public class AjouterAnimalServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String produitId = request.getParameter("animalId");
        if (produitId == null || produitId.isEmpty()) {
            throw new ServletException("Le paramètre 'animalId' est requis.");
        }

        // Vérifier si c'est une action de suppression
        boolean isSupprimer = request.getParameter("supprimer") != null;

        int quantiteAjoutOuSupp;
        try {
            quantiteAjoutOuSupp = Integer.parseInt(request.getParameter("qty"));
        } catch (NumberFormatException e) {
            quantiteAjoutOuSupp = 1; // Défaut à 1 si l'utilisateur n'a pas spécifié de quantité
        }

        if (isSupprimer) {
            quantiteAjoutOuSupp = -quantiteAjoutOuSupp; // Rend la quantité négative si on supprime
        }

        HttpSession session = request.getSession();

        // initialiser le panier
        List<PanierItem> panier = (List<PanierItem>) session.getAttribute("panier");
        if (panier == null) {
            panier = new ArrayList<>();
            session.setAttribute("panier", panier);
        }

        // Regarder si l'article est déjà dans le panier
        boolean found = false;
        for (PanierItem item : panier) {
            if (item.getId() == Integer.parseInt(produitId)) {
                int newQuantity = item.getQuantite() + quantiteAjoutOuSupp;
                if (newQuantity <= 0) {
                    panier.remove(item); // Retirer l'article si la quantité tombe à 0 ou moins
                } else {
                    item.setQuantite(newQuantity);
                }
                found = true;
                break;
            }
        }

        // Ajouter l'article si il n'est pas dans le panier
        if (!found && !isSupprimer) {
            panier.add(new PanierItem(Integer.parseInt(produitId), quantiteAjoutOuSupp));
        }

        // recalculer la quantité
        Integer currentQuantity = (Integer) session.getAttribute("quantite");
        if (currentQuantity == null) {
            currentQuantity = 0;
        }
        // Ajouter ou retirer la quantité
        currentQuantity += quantiteAjoutOuSupp;
        session.setAttribute("quantite", currentQuantity);

        response.sendRedirect(request.getHeader("referer"));
    }
}
