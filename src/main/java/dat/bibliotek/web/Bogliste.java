package dat.bibliotek.web;

import dat.bibliotek.config.ApplicationStart;
import dat.bibliotek.dtos.BogListeDTO;
import dat.bibliotek.exceptions.DatabaseException;
import dat.bibliotek.persistence.BiblioteksMapper;
import java.io.*;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import dat.bibliotek.persistence.ConnectionPool;

@WebServlet(name = "bogliste", urlPatterns = {"/bogliste"} )
public class Bogliste extends HttpServlet
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
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        response.setContentType("text/html");

        BiblioteksMapper biblioteksMapper = new BiblioteksMapper(connectionPool);
        List<BogListeDTO> bogListeDTOList = null;
        try
        {
            bogListeDTOList = biblioteksMapper.hentAlleBoegerOgDeresForfattere();
        }
        catch (DatabaseException e)
        {
            Logger.getLogger("web").log(Level.SEVERE, e.getMessage());
            request.setAttribute("fejlbesked", e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
        request.setAttribute("bogliste", bogListeDTOList);
        request.getRequestDispatcher("WEB-INF/bogliste.jsp").forward(request, response);
    }

    public void destroy()
    {

    }
}