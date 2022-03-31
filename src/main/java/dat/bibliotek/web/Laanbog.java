package dat.bibliotek.web;

import dat.bibliotek.config.ApplicationStart;
import dat.bibliotek.entities.Bog;
import dat.bibliotek.entities.Bruger;
import dat.bibliotek.entities.Udlaan;
import dat.bibliotek.exceptions.DatabaseException;
import dat.bibliotek.persistence.BiblioteksMapper;
import dat.bibliotek.persistence.ConnectionPool;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "Laanbog", value = "/laanbog")
public class Laanbog extends HttpServlet
{
    private ConnectionPool connectionPool;

    @Override
    public void init() throws ServletException
    {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession(); // hent session objekt
        Bruger bruger = (Bruger) session.getAttribute("bruger");  // hent brugerobjekt ud fra session scope
        if (bruger != null)  // er brugeren overhovedet logget på?
        {
            int bogId = Integer.parseInt(request.getParameter("bogid"));
            // Todo: gem udlånet (laaner_id, bogid, dato)
            Date dagsdato = new java.sql.Date(System.currentTimeMillis());  // giv os dags dato i java.sql.Date format
            Udlaan udlaan = new Udlaan(bogId, bruger.getLaanerId(), dagsdato);
            BiblioteksMapper biblioteksMapper = new BiblioteksMapper(connectionPool);

            try
            {
                biblioteksMapper.opretNytUdlaan(udlaan);
                Bog bog = biblioteksMapper.hentBogUdFraId(bogId);
                request.setAttribute("bog", bog);
                request.getRequestDispatcher("WEB-INF/udlaankvittering.jsp").forward(request, response);
            }
            catch (DatabaseException e)
            {
                Logger.getLogger("web").log(Level.SEVERE, e.getMessage());
                request.setAttribute("fejlbesked", e.getMessage());
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
        } else
        {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
