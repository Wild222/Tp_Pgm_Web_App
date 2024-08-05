//package control;
//
//import jakarta.servlet.RequestDispatcher;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//import model.ProduitAnimal;
//import persistence.ProduitAnimalDAO_JDBC;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//
//public class AfficherProduitServlet extends HttpServlet {
//
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//
//        HttpSession session = request.getSession();
//        List<ProduitAnimal> shoppingCart = (List<ProduitAnimal>) session.getAttribute("shoppingcart");
//        if (shoppingCart == null) {
//            shoppingCart = new ArrayList<>();
//            session.setAttribute("shoppingcart", shoppingCart);
//        }
//        String action = request.getParameter("action");
//        if ("ADD".equals(action)) {
//            String produitId = request.getParameter("produitId");
//            int qty = Integer.parseInt(request.getParameter("qty"));
//            ProduitAnimalDAO_JDBC produitAnimalDAO = new ProduitAnimalDAO_JDBC();
//            ProduitAnimal produit = produitAnimalDAO.getProduitById(Integer.parseInt(produitId));
//            if (produit != null) {
//                for (int i = 0; i < qty; i++) {
//                    shoppingCart.add(produit);
//                }
//            }
//        } else if ("DELETE".equals(action)) {
//            int delIndex = Integer.parseInt(request.getParameter("delindex"));
//            shoppingCart.remove(delIndex);
//        }
//
//        ProduitAnimalDAO_JDBC produitAnimalDAO = new ProduitAnimalDAO_JDBC();
//        List<ProduitAnimal> produits = produitAnimalDAO.afficherProduitAnimal();
//        request.setAttribute("produits", produits);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/afficherProduit.jsp");
//        dispatcher.forward(request, response);
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }
//}
