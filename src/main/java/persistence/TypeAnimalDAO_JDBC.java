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

    private Connection connection;

    public TypeAnimalDAO_JDBC(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }

    @Override
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
    public TypeAnimal rechercherTypeAnimal(String nom) {
        TypeAnimal typeAnimal = null;
        try {
            PreparedStatement pst = this.connection.prepareStatement(SQL_BOX.RECHERCHER_TYPE_ANIMAL_PAR_NOM);
            pst.setString(1, nom);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                typeAnimal = new TypeAnimal();
                typeAnimal.setNom(rs.getString("nom"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return typeAnimal;
    }

    @Override
    public void ajouterTypeAnimal(TypeAnimal typeAnimal) {
        try {
            PreparedStatement pst = this.connection.prepareStatement(SQL_BOX.AJOUTER_TYPE_ANIMAL);
            pst.setString(1, typeAnimal.getNom());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void supprimerTypeAnimal(String nom) {
        try {
            PreparedStatement pst = this.connection.prepareStatement(SQL_BOX.SUPPRIMER_TYPE_ANIMAL_PAR_NOM);
            pst.setString(1, nom);
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void modifierTypeAnimal(TypeAnimal typeAnimal) {
        try {
            PreparedStatement pst = this.connection.prepareStatement(SQL_BOX.MODIFIER_PRIX_ANIMAL);
            pst.setDouble(1, typeAnimal.getPrixAnimal());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
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

    public void getQuantiterDisponibleById(int i) {
        try {
            PreparedStatement pst = this.connection.prepareStatement(SQL_BOX.GET_QUANTITER_DISPONIBLE_BY_ID);
            pst.setInt(1, i);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                TypeAnimal typeAnimal = new TypeAnimal();
                typeAnimal.setQuantiteDisponible(rs.getInt("quantiteDisponible"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
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
