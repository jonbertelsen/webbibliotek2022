package dat.bibliotek.services;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import dat.bibliotek.entities.Bruger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AccessService
{
    public static boolean isRoleAllowed(String rolle, HttpServletRequest request)
    {
        Bruger bruger = (Bruger) request.getSession().getAttribute("bruger");
        if (bruger != null)
        {
            if (bruger.getRolle().equals(rolle))
            {
                return true;
            }
        }
        return false;
    }

}
