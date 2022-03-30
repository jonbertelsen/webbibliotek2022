package dat.bibliotek.web;

import dat.bibliotek.persistence.ConnectionPool;
import dat.bibliotek.services.AccessService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "OpretBogForm", urlPatterns = {"/opretbogform"} )
public class OpretBogForm extends HttpServlet
{
    private ConnectionPool connectionPool;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
       doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        if (AccessService.isRoleAllowed("admin", request))
        {
            request.getRequestDispatcher("WEB-INF/opretbog.jsp").forward(request, response);
        } else
        {
            String msg = "Du har ikke admin rolle og  vil have adgang til OpretBogForm";
            Logger.getLogger("web").log(Level.SEVERE, msg);
            request.setAttribute("fejlbesked", msg);
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
        }
}
