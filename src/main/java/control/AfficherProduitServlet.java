//package control;
//
//import datastore.DB_Connector;
//import jakarta.servlet.RequestDispatcher;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import model.ProduitAnimal;
//import persistence.ProduitAnimalDAO_JDBC;
//
//
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.util.List;
//
//@WebServlet(name = "AfficherProduitServlet", value = "/AfficherProduitServlet")
//public class AfficherProduitServlet extends HttpServlet {
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Connection connection = null;
//        try {
//            // Créer une nouvelle instance de DB_Connector
//            DB_Connector dbConnector = new DB_Connector();
//            connection = dbConnector.getConnection();
//
//
//            // Lire les animaux depuis la base de données
//            ProduitAnimalDAO_JDBC afficherProduit = new ProduitAnimalDAO_JDBC(connection);
//            List<ProduitAnimal> listeProduit = afficherProduit.afficherProduitAnimal();
//
//            // Ajouter la liste d'animaux au contexte HTTP
//            request.setAttribute("listeProduit", listeProduit);
//            request.setAttribute("produits", listeProduit);
//            RequestDispatcher dispatcher = request.getRequestDispatcher("afficherProduit.jsp");
//            dispatcher.forward(request, response);
//        } catch (Exception e) {
//            throw new ServletException("Erreur lors de l'affichage des produits", e);
//        } finally {
//            if (connection != null) {
//                try {
//                    connection.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doGet(request, response);
//    }
//}