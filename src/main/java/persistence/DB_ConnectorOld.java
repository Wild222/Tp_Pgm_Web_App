package persistence;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

//Singleton design pattern
public class DB_ConnectorOld {

    public static DB_ConnectorOld settings = null;

    protected String DB_HOST = null;
    protected String DB_NAME = null;
    protected String DB_USER = null;
    protected String DB_PASSWORD = null;
    protected String DB_URL = null;

    protected Connection connection = null;

    private DB_ConnectorOld() {
        loadDBProperties();
        try {
            System.out.println("ConnectionString = "+this.DB_URL);
            this.connection = DriverManager.getConnection(this.DB_URL, this.DB_USER, this.DB_PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static DB_ConnectorOld getInstance() {
        if (DB_ConnectorOld.settings == null)
            DB_ConnectorOld.settings = new DB_ConnectorOld();
        return DB_ConnectorOld.settings;

    }

    public void Close() {
        try {
            this.connection.close();
            this.connection = null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadDBProperties() {
        Properties props = new Properties();
        String fileName = "src/main/java/datastore/db.properties";
        try (FileInputStream fis = new FileInputStream(fileName)) {
            props.load(fis);
        } catch (IOException ex) {
            System.out.println(DB_ConnectorOld.class.getName());
            System.out.println(ex.getMessage());
        }
        this.DB_HOST = props.getProperty("DB_HOST");
        this.DB_NAME = props.getProperty("DB_NAME");
        this.DB_USER = props.getProperty("DB_USER");
        this.DB_PASSWORD = props.getProperty("DB_PASSWORD");
        this.DB_URL = this.DB_HOST + this.DB_NAME;
    }//loadDBProperties


    public Connection getConnection() {
        return this.connection;
    }
}//class DB_Connector


