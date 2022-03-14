package dat.bibliotek.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database
{
    private static Database instance;
    private static String user;
    private static  String password;
    private static String url;

    //Private Constructor to ensure Singleton
    private Database(){}

    public static Database getInstance(String _user, String _password, String _url) throws ClassNotFoundException
    {
        if (instance == null)
        {
            user = _user;
            password = _password;
            url = _url;

            instance = new Database();
        }
       return instance;
    }

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

}
