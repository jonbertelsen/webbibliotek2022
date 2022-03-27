package dat.bibliotek.web;

import dat.bibliotek.config.ApplicationStart;
import dat.bibliotek.entities.Laaner;
import dat.bibliotek.exceptions.DatabaseException;
import dat.bibliotek.persistence.BiblioteksMapper;
import dat.bibliotek.persistence.ConnectionPool;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "laaner", urlPatterns = {"/laaner"} )
public class laaner extends HttpServlet
{
    private ConnectionPool connectionPool;
    private BiblioteksMapper biblioteksMapper;

    @Override
    public void init() throws ServletException
    {
        this.connectionPool = ApplicationStart.getConnectionPool();
        biblioteksMapper = new BiblioteksMapper(connectionPool);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String command = request.getParameter("command");
        switch (command)
        {
            case "opretlaanerside":
                request.getRequestDispatcher("WEB-INF/opretlaaner.jsp").forward(request, response);
                break;
            case "opret":
                String navn= request.getParameter("navn");
                String adresse = request.getParameter("adresse");
                int postnr = Integer.parseInt(request.getParameter("postnr"));
                Laaner nyLaaner = new Laaner(navn, adresse, postnr);
                try
                {
                    biblioteksMapper.opretNyLaaner(nyLaaner);
                }
                catch (DatabaseException e)
                {
                    Logger.getLogger("web").log(Level.SEVERE, e.getMessage());
                    request.setAttribute("fejlbesked", e.getMessage());
                    request.getRequestDispatcher("error.jsp").forward(request, response);
                }
                doGet(request, response);
                break;
            case "fjernrediger":
                if (request.getParameter("fjern") != null)
                {
                    int laanerId = Integer.parseInt(request.getParameter("fjern"));
                    // Todo: fjernLaaner
                    Logger.getLogger("web").log(Level.WARNING, "Fjern: " + laanerId);
                    doGet(request, response);
                } else if (request.getParameter("rediger") != null)
                {
                    int laanerId = Integer.parseInt(request.getParameter("rediger"));
                    // Todo: fjernLaaner
                    Logger.getLogger("web").log(Level.WARNING, "Rediger: " + laanerId);
                    try
                    {
                        Laaner laaner = biblioteksMapper.hentLaanerUdFraId(laanerId);
                        request.setAttribute("laaner", laaner);
                        request.getRequestDispatcher("WEB-INF/redigerlaaner.jsp").forward(request, response);

                    }
                    catch (DatabaseException e)
                    {
                        e.printStackTrace();
                    }

                }
                break;
            case "opdater":
                int id = Integer.parseInt(request.getParameter("id"));
                navn= request.getParameter("navn");
                adresse = request.getParameter("adresse");
                postnr = Integer.parseInt(request.getParameter("postnr"));
                Laaner laaner = new Laaner(id, navn, adresse, postnr, "");
                //Todo: opdaterLaaner(Laaner laaner);
                doGet(request, response);
                break;
            default:
                response.sendRedirect("index.jsp");
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        response.setContentType("text/html");
        List<Laaner> laanerList = null;
        try
        {
            laanerList = biblioteksMapper.hentAlleLaanere();
        }
        catch (DatabaseException e)
        {
            Logger.getLogger("web").log(Level.SEVERE, e.getMessage());
            request.setAttribute("fejlbesked", e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
        request.setAttribute("laanerliste", laanerList);
        request.getRequestDispatcher("WEB-INF/laaner.jsp").forward(request, response);
    }

    public void destroy()
    {

    }
}