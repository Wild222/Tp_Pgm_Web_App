package persistence;

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

    @Override
    public List<TypeAnimal> afficherTypeAnimal() {
        List<TypeAnimal> listeTypeAnimal = new ArrayList<>();
        try {
        PreparedStatement pst = this.connection.prepareStatement(SQL_BOX.AFFICHER_TOUT_TYPE_ANIMAL);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                TypeAnimal typeAnimal = new TypeAnimal();
                typeAnimal.setNom(rs.getString("nom"));
                listeTypeAnimal.add(typeAnimal);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listeTypeAnimal;
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
}
