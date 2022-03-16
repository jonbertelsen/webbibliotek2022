package dat.bibliotek.entities;

public class Bruger
{
    private String email;
    private String kodeord;
    private String rolle;

    public Bruger(String brugerNavn, String kodeord, String rolle)
    {
        this.email = brugerNavn;
        this.kodeord = kodeord;
        this.rolle = rolle;
    }

    @Override
    public String toString()
    {
        return "Bruger{" +
                "brugerNavn='" + email + '\'' +
                ", kodeord='" + kodeord + '\'' +
                ", rolle='" + rolle + '\'' +
                '}';
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getKodeord()
    {
        return kodeord;
    }

    public void setKodeord(String kodeord)
    {
        this.kodeord = kodeord;
    }

    public String getRolle()
    {
        return rolle;
    }

    public void setRolle(String rolle)
    {
        this.rolle = rolle;
    }
}
