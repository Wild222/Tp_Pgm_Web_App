package control;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.TypeAnimal;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/AjouterAnimalServlet")
public class AjouterAnimalServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Récupere le paramètre 'animalId' dans la jsp afficher animal
        String produitId = request.getParameter("animalId");

        //Récupere la quantité de la page afficher animal
        String quantite = request.getParameter("qty") ;



        if (produitId == null || produitId.isEmpty()) {
            throw new ServletException("Le paramètre 'id' est requis.");
        }

        int id;
        try {
            id = Integer.parseInt(produitId);
        } catch (NumberFormatException e) {
            throw new ServletException("Le paramètre 'id' doit être un nombre entier.", e);
        }

        HttpSession session = request.getSession();
        List<Integer> panier = (List<Integer>) session.getAttribute("panier");
        if (panier == null) {
            panier = new ArrayList<>();
            session.setAttribute("panier", panier);
        }

        // Ajouter l'ID de l'animal à la liste du panier
        panier.add(id);


        // Rediriger vers la même page
        response.sendRedirect(request.getHeader("referer"));
    }
}

/*
    {

            //on récupère l'item à la position i
            CD cd = (CD) buylist.elementAt(i);

            // si on trouve l'item dans le panier
            if (cd.getAlbum().equals(aCD.getAlbum())) {

               //on va modifier la quantité en lui ajoutantant la
               // nouvelle quantité
              cd.setQuantity(cd.getQuantity()+aCD.getQuantity());

              //on replace l'item dans le panier
              buylist.setElementAt(cd,i);

              //on active la variable qui montre qu'on a trouvé l'item
              //dans le panier
              match = true;
            } //end of if name matches
          } // end of for

 */
