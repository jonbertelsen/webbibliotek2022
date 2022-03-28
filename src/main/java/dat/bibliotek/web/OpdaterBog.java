package dat.bibliotek.web;

import dat.bibliotek.config.ApplicationStart;
import dat.bibliotek.entities.Bog;
import dat.bibliotek.exceptions.DatabaseException;
import dat.bibliotek.persistence.BiblioteksMapper;
import dat.bibliotek.persistence.ConnectionPool;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "OpdaterBog", urlPatterns = {"/opdaterbog"} )
public class OpdaterBog extends HttpServlet
{
    private ConnectionPool connectionPool;

    @Override
    public void init() throws ServletException
    {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String idString = request.getParameter("id");
        int bogId = Integer.parseInt(idString);
        String titel = request.getParameter("titel");
        int udgivelsesaar = Integer.parseInt(request.getParameter("aar"));
        int forfatter_id = Integer.parseInt(request.getParameter("forfatter_id"));

        Bog bog = new Bog(bogId, titel, udgivelsesaar, forfatter_id);
        BiblioteksMapper biblioteksMapper = new BiblioteksMapper(connectionPool);
        try
        {
            boolean result = biblioteksMapper.opdaterBog(bog);
        }
        catch (DatabaseException e)
        {
            Logger.getLogger("web").log(Level.SEVERE, e.getMessage());
            request.setAttribute("fejlbesked", e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
        request.getRequestDispatcher("bogliste").forward(request, response);
    }
}
