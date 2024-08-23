package control;

import datastore.DB_Connector;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Client;
import persistence.ClientDAO_JDBC;

import java.io.IOException;
import java.sql.Connection;

@WebServlet(name = "AjouterClientServlet", urlPatterns = "/AjouterClientServlet")
public class AjouterClientServlet extends HttpServlet {
     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         // Récuperer les donners du formulaire
         String nom = request.getParameter("nom");
         String prenom = request.getParameter("prenom");
         String courriel = request.getParameter("courriel");
         //Créer le client
         Client client = new Client(nom, prenom, courriel);

         DB_Connector dbConnector = new DB_Connector();
         Connection connection = dbConnector.getConnection();
         ClientDAO_JDBC clientDAO = new ClientDAO_JDBC(connection);

         //Ajouter le client a la base de donnée
         clientDAO.ajouterClient(client);

         response.sendRedirect("AuRevoir.jsp");
          // Invalider la session
          request.getSession().invalidate();





     }

}
