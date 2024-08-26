package persistence;

import datastore.DB_Connector;
import model.TypeAnimal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class TypeAnimalDAO_JDBC implements ITypeAnimalDAO {
    DB_Connector dbConnector = new DB_Connector();

    private Connection connection;

    public TypeAnimalDAO_JDBC(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }

    @Override//Servlet AfficherAnimal
    public List<TypeAnimal> afficherTypeAnimal() {
        List<TypeAnimal> listeAnimaux = new ArrayList<>();
        try (PreparedStatement pst = connection.prepareStatement(SQL_BOX.AFFICHER_TOUT_TYPE_ANIMAL);
             ResultSet resultSet = pst.executeQuery()) {
            while (resultSet.next()) {
                TypeAnimal animal = new TypeAnimal();
                animal.setId(resultSet.getInt("id"));
                animal.setNom(resultSet.getString("nom"));
                animal.setSexe(resultSet.getString("description"));
                animal.setQuantiteDisponible(resultSet.getInt("quantiteDisponible"));
                animal.setPrixAnimal(resultSet.getDouble("prixAnimal"));
                animal.setImageUrl(resultSet.getString("imageUrl"));
                animal.setType(resultSet.getString("type"));
                listeAnimaux.add(animal);
                System.out.println("Animal récupéré : " + animal);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de la récupération des animaux", e);
        }
        return listeAnimaux;
    }

    @Override
    public List<TypeAnimal> rechercherTypeAnimalByPrix(double prixMaximum) {
       List<TypeAnimal> typeAnimal = new ArrayList<>();
        try {
            PreparedStatement pst = this.connection.prepareStatement(SQL_BOX.RECHERCHER_TYPE_ANIMAL_PAR_PRIX);
            pst.setDouble(1, prixMaximum);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                TypeAnimal animal = new TypeAnimal();
                animal.setId(rs.getInt("id"));
                animal.setNom(rs.getString("nom"));
                animal.setSexe(rs.getString("description"));
                animal.setQuantiteDisponible(rs.getInt("quantiteDisponible"));
                animal.setPrixAnimal(rs.getDouble("prixAnimal"));
                animal.setImageUrl(rs.getString("imageUrl"));
                animal.setType(rs.getString("type"));
                typeAnimal.add(animal);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return typeAnimal;
    }

    @Override//Servlet AfficherPanier
    public TypeAnimal getTypeAnimalById(int i) {
        try {
            PreparedStatement pst = this.connection.prepareStatement(SQL_BOX.RECHERCHER_TYPE_ANIMAL_PAR_ID);
            pst.setInt(1, i);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                TypeAnimal animal = new TypeAnimal();
                animal.setId(rs.getInt("id"));
                animal.setNom(rs.getString("nom"));
                animal.setSexe(rs.getString("description"));
                animal.setQuantiteDisponible(rs.getInt("quantiteDisponible"));
                animal.setPrixAnimal(rs.getDouble("prixAnimal"));
                animal.setImageUrl(rs.getString("imageUrl"));
                animal.setType(rs.getString("type"));
                return animal;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
    }
    @Override//Servlet UpdateBBDServlet
    public TypeAnimal getQuantiterDisponibleById(int i) {
        TypeAnimal typeAnimal = null;
        try {
            PreparedStatement pst = this.connection.prepareStatement(SQL_BOX.GET_QUANTITER_DISPONIBLE_BY_ID);
            pst.setInt(1, i);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                typeAnimal = new TypeAnimal();
                typeAnimal.setQuantiteDisponible(rs.getInt("quantiteDisponible"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return typeAnimal;
    }


    @Override//Servlet UpdateBBDServlet
    public void updateTypeAnimalQuantiterParId(TypeAnimal typeAnimal, int i) {
        try {
            PreparedStatement pst = this.connection.prepareStatement(SQL_BOX.UPDATE_TYPE_ANIMAL_QUANTITER_BY_ID);
            pst.setInt(1, typeAnimal.getQuantiteDisponible());
            pst.setInt(2, typeAnimal.getId());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
