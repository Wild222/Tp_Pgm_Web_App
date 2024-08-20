package persistence;

import model.ProduitAnimal;
import model.TypeAnimal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProduitAnimalDAO_JDBC implements IProduitAnimalDAO{
    private Connection connection;

    public ProduitAnimalDAO_JDBC(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }

    @Override
    public ProduitAnimal getProduitById(int id) {
        return null;

    }

    @Override
    public List<ProduitAnimal> afficherProduitAnimal() {
        List<ProduitAnimal> listeProduit = new ArrayList<>();
        try (PreparedStatement pst = connection.prepareStatement(SQL_BOX.AFFICHER_TOUT_PRODUIT_ANIMAL);
             ResultSet resultSet = pst.executeQuery()) {
            while (resultSet.next()) {
                ProduitAnimal produit = new ProduitAnimal();
                produit.setId(resultSet.getInt("id"));
                produit.setNom(resultSet.getString("nom"));
                produit.setDescription(resultSet.getString("description"));
                produit.setQuantiteDisponible(resultSet.getInt("quantiteDisponible"));
                produit.setPrix(resultSet.getDouble("prix"));
                produit.setImageUrl(resultSet.getString("imageUrl"));
                listeProduit.add(produit);
                System.out.println("Item récupéré : " + produit);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de la récupération des animaux", e);
        }
        return listeProduit;
    }

    @Override
    public ProduitAnimal rechercherProduitAnimal(int id) {
        return null;
    }

    @Override
    public void ajouterProduitAnimal(ProduitAnimal produitAnimal) {

    }

    @Override
    public void supprimerProduitAnimal(int id) {

    }

    @Override
    public void modifierProduitAnimal(ProduitAnimal produitAnimal) {

    }
}
