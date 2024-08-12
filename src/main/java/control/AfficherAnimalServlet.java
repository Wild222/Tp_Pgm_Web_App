package control;

import datastore.DB_Connector;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.TypeAnimal;
import persistence.TypeAnimalDAO_JDBC;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class AfficherAnimalServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection connection = null;
        try {
            // Créer une nouvelle instance de DB_Connector
            DB_Connector dbConnector = new DB_Connector();
            connection = dbConnector.getConnection();

            TypeAnimalDAO_JDBC afficherAnimal = new TypeAnimalDAO_JDBC(connection);
            List<TypeAnimal> listeAnimaux = afficherAnimal.afficherTypeAnimal();

            // Ajouter la liste d'animaux au contexte HTTP
            request.setAttribute("listeAnimaux", listeAnimaux);
            request.setAttribute("animaux", listeAnimaux);
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
