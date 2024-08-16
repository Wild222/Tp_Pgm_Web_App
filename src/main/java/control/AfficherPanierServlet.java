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

@WebServlet("/afficherPanier")
public class AfficherPanierServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Connection connection = null;
        try {
            DB_Connector dbConnector = new DB_Connector();
            connection = dbConnector.getConnection();

            List<PanierItem> panier = (List<PanierItem>) session.getAttribute("panier");
            if (panier == null) {
                panier = new ArrayList<>();
                session.setAttribute("panier", panier);
            }

            // Récupérer les détails des animaux du panier
            TypeAnimalDAO_JDBC typeAnimalDAO = new TypeAnimalDAO_JDBC(connection);
            List<TypeAnimal> animaux = new ArrayList<>();
            for (PanierItem item : panier) {
                TypeAnimal animal = typeAnimalDAO.getTypeAnimalById(item.getId());
                if (animal != null) {
                    animal.setQuantite(item.getQuantite());
                    animaux.add(animal);
                }
            }
            //supprimer un animal du panier (ligne)
            String animalIdStr = request.getParameter("animalId");

            if (animalIdStr != null && !animalIdStr.isEmpty()) {
                try {
                    // Parse the animalId string to an integer
                    int animalId = Integer.parseInt(animalIdStr);

                    // Get the session and the cart (panier) from the session
                     session = request.getSession();

                    if (panier != null) {
                        // Remove the animal with the specified ID from the cart
                        panier.removeIf(item -> item.getId() == animalId);

                        // Update the cart in the session
                        session.setAttribute("panier", panier);
                    } else {
                        // Handle the case where the cart is not found in the session
                        System.out.println("Cart not found in session.");
                    }
                } catch (NumberFormatException e) {
                    // Handle the case where animalIdStr is not a valid integer
                    System.out.println("Invalid animal ID format: " + animalIdStr);
                }
            } else {
                // Handle the case where the animalId parameter is missing or empty
                System.out.println("Animal ID parameter is missing or empty.");
            }
            request.setAttribute("animaux", animaux);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/afficherPanier.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            throw new ServletException("Erreur lors de l'affichage du panier", e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
