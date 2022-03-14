package dat.bibliotek;

import dat.bibliotek.dtos.BogListeDTO;
import dat.bibliotek.entities.Laaner;
import dat.bibliotek.exceptions.DatabaseException;
import dat.bibliotek.persistence.BiblioteksMapper;
import dat.bibliotek.persistence.Database;

import java.io.*;
import java.sql.Connection;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "index", urlPatterns = {""} )
public class index extends HttpServlet
{
    private static BiblioteksMapper biblioteksMapper;

    public void init()
    {
        ServletContext servletContext = getServletContext();
        Connection connection = (Connection) servletContext.getAttribute("connection");
        biblioteksMapper = new BiblioteksMapper(connection);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        response.setContentType("text/html");
        try
        {
            List<BogListeDTO> bogListeDTOList = biblioteksMapper.hentAlleBoegerOgDeresForfattere();
            request.setAttribute("bogliste", bogListeDTOList);
        }
        catch (DatabaseException e)
        {
            e.printStackTrace();
        }

        request.getRequestDispatcher("WEB-INF/home.jsp").forward(request, response);
    }

    public void destroy()
    {

    }
}