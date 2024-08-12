package datastore;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DB_Connector {

    private String DB_HOST = null;
    private String DB_NAME = null;
    private String DB_USER = null;
    private String DB_PASSWORD = null;
    private String DB_URL = null;

    private Connection connection = null;

    public DB_Connector() {
        loadDBProperties();
        try {
            System.out.println("ConnectionString = " + this.DB_URL);
            this.connection = DriverManager.getConnection(this.DB_URL, this.DB_USER, this.DB_PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Erreur de connexion à la base de données", e);
        }
    }

    private void loadDBProperties() {
        Properties props = new Properties();
        String fileName = "db.properties";
        try (InputStream input = getClass().getClassLoader().getResourceAsStream(fileName)) {
            if (input == null) {
                System.out.println("Désolé, impossible de trouver " + fileName);
                return;
            }
            props.load(input);
        } catch (IOException ex) {
            System.out.println(DB_Connector.class.getName() + " - " + ex.getMessage());
        }
        this.DB_HOST = props.getProperty("DB_HOST");
        this.DB_NAME = props.getProperty("DB_NAME");
        this.DB_USER = props.getProperty("DB_USER");
        this.DB_PASSWORD = props.getProperty("DB_PASSWORD");
        this.DB_URL = this.DB_HOST + this.DB_NAME;
    }

    public Connection getConnection() {
        return this.connection;
    }

    // Ajoutez un méthode pour fermer la connexion si nécessaire
    public void close() {
        if (this.connection != null) {
            try {
                this.connection.close();
                this.connection = null;
            } catch (SQLException e) {
                throw new RuntimeException("Erreur lors de la fermeture de la connexion", e);
            }
        }
    }
}
