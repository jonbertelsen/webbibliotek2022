package dat.bibliotek;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

@WebListener
public class BiblioteksContextListener implements ServletContextListener
{
    private final static String USER = "root";
    private final static String PASSWORD = "root";
    private final static String URL = "jdbc:mysql://localhost:3306/bibliotek?serverTimezone=CET&allowPublicKeyRetrieval=true&useSSL=false";
    private static Connection connection;
    static Logger logger = Logger.getLogger(BiblioteksContextListener.class);




    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent)
    {
        System.out.println("Starting up!");
        // Set up a simple configuration that logs on the console.
        BasicConfigurator.configure();
        ServletContext sc = servletContextEvent.getServletContext();
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection =  DriverManager.getConnection(URL, USER, PASSWORD);
            sc.setAttribute("connection", connection);
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent)
    {
        System.out.println("Shutting down!");

        // ... First close any background tasks which may be using the DB ...
        // ... Then close any DB connection pools ...

        // Now deregister JDBC drivers in this context's ClassLoader:
        // Get the webapp's ClassLoader
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        // Loop through all drivers
        Enumeration<Driver> drivers = DriverManager.getDrivers();
        while (drivers.hasMoreElements()) {
            Driver driver = drivers.nextElement();
            if (driver.getClass().getClassLoader() == cl) {
                // This driver was registered by the webapp's ClassLoader, so deregister it:
                try {
                    logger.info("Deregistering JDBC driver {}");
                    DriverManager.deregisterDriver(driver);
                } catch (SQLException ex) {
                    logger.error("Error deregistering JDBC driver {}");
                }
            } else {
                // driver was not registered by the webapp's ClassLoader and may be in use elsewhere
                logger.trace("Not deregistering JDBC driver {} as it does not belong to this webapp's ClassLoader");
            }
    }
    }
}
