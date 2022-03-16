package dat.bibliotek.persistence;

import dat.bibliotek.entities.Bruger;
import dat.bibliotek.entities.Laaner;
import dat.bibliotek.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BrugerMapper implements IBrugerMapper
{
    ConnectionPool connectionPool;

    public BrugerMapper(ConnectionPool connectionPool)
    {
        this.connectionPool = connectionPool;
    }

    @Override
    public Bruger login(String email, String kodeord) throws DatabaseException
    {
        Logger.getLogger("web").log(Level.INFO, "");

        Bruger bruger = null;

        String sql = "SELECT * FROM bruger WHERE email = ? AND kodeord = ?";

        try (Connection connection = connectionPool.getConnection())
        {
            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setString(1, email);
                ps.setString(2, kodeord);
                ResultSet rs = ps.executeQuery();
                if (rs.next())
                {
                    String rolle = rs.getString("rolle");
                    bruger = new Bruger(email, kodeord, rolle);
                } else
                {
                    throw new DatabaseException("Fejl i brugernavn eller kodeord");
                }
            }
        } catch (SQLException ex)
        {
            throw new DatabaseException(ex, "Fejl under indlogning. Der er noget galt med databasen");
        }
        return bruger;
    }

    @Override
    public void opretBruger(String email, String kodeord, String rolle) throws DatabaseException
    {
        // TODO: skal kodes
    }


}
