package dat.bibliotek.web;

import dat.bibliotek.persistence.ConnectionPool;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "OpretBogForm", urlPatterns = {"/opretbogform"} )
public class OpretBogForm extends HttpServlet
{
    private ConnectionPool connectionPool;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.getRequestDispatcher("WEB-INF/opretbog.jsp").forward(request, response);
    }
}
