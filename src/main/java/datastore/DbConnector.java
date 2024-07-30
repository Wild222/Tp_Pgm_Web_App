package datastore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector
{

    public static DbConnector datastore = null;
    //instead of using static to create an unique value that is shared,
    //we can use a singleton.

    //protected  final String DB_HOST = "142.182.15.235:3306 ";
    protected  final String DB_HOST = "jdbc:mariadb://mysql-bil.alwaysdata.net:3306/";
    protected  final String DB_NAME =  "bil_animaux";
    protected  final String DB_USER =  "bil_bel";
    protected  final String DB_PASSWORD =  "cricket123456**";
    protected  final String DB_URL = DB_HOST + DB_NAME;

    public Connection connection = null;

    private DbConnector() {
        //fourni par ajav classe connection
        //PE ETABLEIR CONNEXION AVEC LA BD
        //ELLE LANCE EXCPETION

        try {
            this.connection = DriverManager.getConnection(this.DB_URL, this.DB_USER, this.DB_PASSWORD);
        }catch(SQLException e){
            throw new RuntimeException (e);
        }
    }
    //driver maria db non trouvé pom.xml ajouter dependances, aller sur maven page cherger pour maria-db
    //singleton: cache l,objet dans las classe, settings est la connection

    public static DbConnector getInstance(){

        if(DbConnector.datastore ==null) {
            DbConnector.datastore = new DbConnector();
        }
        return DbConnector.datastore;
    }
}




