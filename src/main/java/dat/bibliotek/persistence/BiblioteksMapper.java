package dat.bibliotek.persistence;

import dat.bibliotek.dtos.BogListeDTO;
import dat.bibliotek.dtos.hentAlleUdlaanDTO;
import dat.bibliotek.entities.Bog;
import dat.bibliotek.entities.Laaner;
import dat.bibliotek.entities.Udlaan;
import dat.bibliotek.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BiblioteksMapper implements IBiblioteksMapper
{
    Connection connection = null;

    public BiblioteksMapper(Connection connection)
    {
        this.connection = connection;
    }

    @Override
    public Laaner hentLaanerUdFraId(int laanerId) throws DatabaseException
    {
        Laaner laaner = null;

        String sql =  "select * from Laaner inner join postnummer using(postnr) " +
                        "where laaner_id = ?";

            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setInt(1, laanerId);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    laanerId = rs.getInt("laaner_id");
                    String navn = rs.getString("navn");
                    String adresse = rs.getString("adresse");
                    int postnummer = rs.getInt("postnr");
                    String by = rs.getString("by");
                    laaner = new Laaner(laanerId, navn, adresse, postnummer, by);
                } else {
                    throw new DatabaseException("Member with id = " + laanerId + " is not found");
                }
            } catch (SQLException ex)
            {
                throw new DatabaseException("Could not find member with id = " + laanerId + " in database");
            }
        return laaner;
    }

    @Override
    public List<Laaner> hentAlleLaanere()
    {
        return null;
    }

    @Override
    public List<BogListeDTO> hentAlleBoegerOgDeresForfattere() throws DatabaseException
    {
        List<BogListeDTO> boglisteDTOList = new ArrayList<>();

        String sql = "SELECT bog.bog_id, bog.titel, bog.udgivelsesaar, f.forfatter_id, f.navn " +
                "FROM bog " +
                "INNER JOIN forfatter f " +
                "USING(forfatter_id)";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int bogId = rs.getInt("bog_id");
                    String titel = rs.getString("titel");
                    int udgivelsesaar = rs.getInt("udgivelsesaar");
                    int forfatterId = rs.getInt("forfatter_id");
                    String forfatterNavn = rs.getString("navn");
                    BogListeDTO dto = new BogListeDTO(bogId, titel, udgivelsesaar, forfatterId, forfatterNavn);
                    boglisteDTOList.add(dto);
                }
            } catch (SQLException throwables) {
                throw new DatabaseException("Could not get all members from database");
            }
        return boglisteDTOList;
    }

    @Override
    public List<hentAlleUdlaanDTO> hentAlleUdlaan()
    {
        return null;
    }

    @Override
    public Laaner opretNyLaaner(Laaner laaner)
    {
        return null;
    }

    @Override
    public boolean opretNytUdlaan(Udlaan udlaan)
    {
        return false;
    }

    @Override
    public boolean fjernUdlaan(int laaner_id, int bog_id)
    {
        return false;
    }

    @Override
    public boolean opdaterBog(Bog bog)
    {
        return false;
    }
}
