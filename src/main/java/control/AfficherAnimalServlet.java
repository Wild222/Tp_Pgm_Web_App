package control;

import datastore.DB_Connector;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.TypeAnimal;
import persistence.TypeAnimalDAO_JDBC;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AfficherAnimalServlet", value = "/AfficherAnimalServlet")
public class AfficherAnimalServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection connection = null;
        try {
            DB_Connector dbConnector = new DB_Connector();
            connection = dbConnector.getConnection();

            TypeAnimalDAO_JDBC afficherAnimal = new TypeAnimalDAO_JDBC(connection);
            String prixMax = request.getParameter("prixMax");
            List<TypeAnimal> listeAnimaux;

            // Rechercher les animaux par prix maximum
            if (prixMax != null && !prixMax.trim().isEmpty()) {
                try {
                    // Convertir le prix maximum en double
                    double prixMaximum = Double.parseDouble(prixMax);
                    // Rechercher les animaux par prix maximum
                    listeAnimaux = afficherAnimal.rechercherTypeAnimalByPrix(prixMaximum);
                    // Afficher les animaux
                    request.setAttribute("animaux", listeAnimaux);

                } catch (NumberFormatException e) {
                    request.setAttribute("error", "Le prix maximum doit être un nombre valide.");
                }
            } else {
                // Sinon afficher tous les animaux
                listeAnimaux = afficherAnimal.afficherTypeAnimal();
                request.setAttribute("animaux", listeAnimaux);
            }

            RequestDispatcher dispatcher = request.getRequestDispatcher("/afficherAnimal.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            throw new ServletException("Erreur lors de l'affichage des animaux", e);
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
