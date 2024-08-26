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
    @WebServlet(name = "UpdateBBDServlet", value = "/UpdateBBDServlet")
    public class UpdateBBDServlet extends HttpServlet {

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
            Connection connection = null;
            DB_Connector dbConnector = new DB_Connector();
            connection = dbConnector.getConnection();

            TypeAnimalDAO_JDBC animalDAO = new TypeAnimalDAO_JDBC(connection);

            /*
            Met à jour la quantité disponible d'un animal dans le panier et
            dans la base de données lorsque l'utilisateur appuie sur payer votre commande
             */
            HttpSession session = request.getSession();
            List<PanierItem> panier = (List<PanierItem>) session.getAttribute("panier");

            if (panier != null) {
                for (PanierItem item : panier) {
                    // Recherche de l'ID de l'animal dans le formulaire
                    String animalIdParam = "qty_" + item.getId();
                    // Recherche de la quantité dans le panier et avec l'Id de l'animal
                    String qtyParam = request.getParameter(animalIdParam);

                    if (qtyParam != null) {
                        int quantite = Integer.parseInt(qtyParam);

                        // Récupérer l'animal par ID et met à jour la quantité
                        TypeAnimal typeAnimal = animalDAO.getTypeAnimalById(item.getId());

                        if (typeAnimal != null) {
                            int quantiteDisponible = typeAnimal.getQuantiteDisponible();
                            int nouvelleQuantiteDisponible = quantiteDisponible - quantite;

                            if (nouvelleQuantiteDisponible < 0) {
                                // Quantité demandée dépasse la quantité disponible
                                System.out.println("Quantité demandée dépasse la quantité disponible pour l'animal ID: " + item.getId());

                            }
                            // Mettre à jour la quantité
                            typeAnimal.setQuantiteDisponible(nouvelleQuantiteDisponible);
                            animalDAO.updateTypeAnimalQuantiterParId(typeAnimal, nouvelleQuantiteDisponible);
                        }
                    }
                }
            }

            // Récupérer le montant total de taxe a payer
            String totalParam = request.getParameter("total");
            double totauxApTaxe = Double.parseDouble(totalParam);


            // Rediriger vers la page de checkout avec le montant total
            response.sendRedirect("checkout.jsp");
            // Invalider la session
            request.getSession().invalidate();
        }
    }


