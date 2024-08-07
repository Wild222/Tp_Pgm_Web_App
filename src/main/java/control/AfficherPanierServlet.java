package control;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.ProduitAnimal;
import model.TypeAnimal;
import persistence.TypeAnimalDAO_JDBC;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class AfficherPanierServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        List<TypeAnimal> shoppingCart = (List<TypeAnimal>) session.getAttribute("shoppingcart");
        if (shoppingCart == null) {
            shoppingCart = new ArrayList<>();
            session.setAttribute("shoppingcart", shoppingCart);
        }
        String action = request.getParameter("action");
        if ("ADD".equals(action)) {
            String produitId = request.getParameter("id");
            int qty = Integer.parseInt(request.getParameter("qty"));
            Connection connection=null;
            TypeAnimalDAO_JDBC typeAnimalDAO = new TypeAnimalDAO_JDBC(null);
            TypeAnimal typeAnimal = typeAnimalDAO.getProduitById(Integer.parseInt(produitId));
            if (typeAnimal != null) {
                for (int i = 0; i < qty; i++) {
                    shoppingCart.add(typeAnimal);
                }
            }
        } else if ("DELETE".equals(action)) {
            int delIndex = Integer.parseInt(request.getParameter("delindex"));
            shoppingCart.remove(delIndex);
        }
//        TypeAnimalDAO_JDBC typeAnimalDAO = new TypeAnimalDAO_JDBC();
//        List<TypeAnimal> types = typeAnimalDAO.afficherTypeAnimal();
//        request.setAttribute("types", types);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/afficherPanier.jsp");
//        dispatcher.forward(request, response);
    }
}
