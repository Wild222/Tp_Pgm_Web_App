package control;

import datastore.DB_Connector;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.PanierItem;
import model.TypeAnimal;
import persistence.TypeAnimalDAO_JDBC;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//@WebServlet("/UpdateBBDServlet")
//public class UpdateBBDServlet extends HttpServlet {

    //    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//
//        Connection connection = null;
//        DB_Connector dbConnector = new DB_Connector();
//        connection = dbConnector.getConnection();
//
//        // Récupération de la quantité disponible depuis la base de données
//        TypeAnimalDAO_JDBC animal = new TypeAnimalDAO_JDBC(connection);
//        TypeAnimal typeAnimalId = animal.getTypeAnimalById(Integer.parseInt(produitId));
//        int quantiteDisponible = typeAnimalId.getQuantiteDisponible();
//
//        // Calcul de la nouvelle quantité disponible
//        int nouvelleQuantiteDisponible = quantiteDisponible - quantite;
//        typeAnimalId.setQuantiteDisponible(nouvelleQuantiteDisponible);
//
//        // Mise à jour de la quantité disponible dans la base de données
//        animal.updateTypeAnimalQuantiterParId(typeAnimalId, nouvelleQuantiteDisponible);
//    }
//}
    @WebServlet("/UpdateBBDServlet")
    public class UpdateBBDServlet extends HttpServlet {

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
            Connection connection = null;
            DB_Connector dbConnector = new DB_Connector();
            connection = dbConnector.getConnection();

            TypeAnimalDAO_JDBC animalDAO = new TypeAnimalDAO_JDBC(connection);

            // Récupération des paramètres du formulaire
            HttpSession session = request.getSession();
            List<PanierItem> panier = (List<PanierItem>) session.getAttribute("panier");

            if (panier != null) {
                for (PanierItem item : panier) {
                    // Recherche de l'ID de l'animal dans le formulaire
                    String animalIdParam = "qty_" + item.getId();
                    // Recherche de la quantité dans le formulaire
                    String qtyParam = request.getParameter(animalIdParam);

                    if (qtyParam != null) {
                        int quantite = Integer.parseInt(qtyParam);

                        // Récupérer l'animal par ID et mettre à jour la quantité
                        TypeAnimal typeAnimal = animalDAO.getTypeAnimalById(item.getId());
                        if (typeAnimal != null) {
                            int quantiteDisponible = typeAnimal.getQuantiteDisponible();
                            int nouvelleQuantiteDisponible = quantiteDisponible - quantite;

                            if (nouvelleQuantiteDisponible < 0) {
                                // Quantité demandée dépasse la quantité disponible
                                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Quantité demandée dépasse la quantité disponible pour l'animal ID: " + item.getId());
                                return;
                            }

                            typeAnimal.setQuantiteDisponible(nouvelleQuantiteDisponible);
                            animalDAO.updateTypeAnimalQuantiterParId(typeAnimal, nouvelleQuantiteDisponible);
                        }
                    }
                }
            }

            // Rediriger vers la page de checkout
            response.sendRedirect("checkout.jsp");
        }
    }


