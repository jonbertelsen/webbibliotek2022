package dat.bibliotek.entities;

import java.util.Objects;

public class Bruger
{
    private String email;
    private String kodeord;
    private String rolle;
    private int laanerId;

    public int getLaanerId()
    {
        return laanerId;
    }

    public void setLaanerId(int laanerId)
    {
        this.laanerId = laanerId;
    }

    public Bruger(String email, String kodeord, String rolle, int laanerId)
    {
        this.email = email;
        this.kodeord = kodeord;
        this.rolle = rolle;
        this.laanerId = laanerId;
    }

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
                "email='" + email + '\'' +
                ", kodeord='" + kodeord + '\'' +
                ", rolle='" + rolle + '\'' +
                ", laanerId=" + laanerId +
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

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Bruger)) return false;
        Bruger bruger = (Bruger) o;
        return getLaanerId() == bruger.getLaanerId() && getEmail().equals(bruger.getEmail()) && getKodeord().equals(bruger.getKodeord()) && getRolle().equals(bruger.getRolle());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getEmail(), getKodeord(), getRolle(), getLaanerId());
    }
}
