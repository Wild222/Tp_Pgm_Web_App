package persistence;

import model.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClientDAO_JDBC {
    private Connection connection;

    public ClientDAO_JDBC(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }

    public void ajouterClient(Client client) {
        try (PreparedStatement pst = connection.prepareStatement(SQL_BOX.AJOUTER_CLIENT)) {
            pst.setString(1, client.getNom());
            pst.setString(2, client.getPrenom());
            pst.setString(3, client.getCourriel());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de l'ajout du client", e);
        }
    }
}
