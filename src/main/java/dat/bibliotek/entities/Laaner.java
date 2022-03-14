package dat.bibliotek.entities;

public class Laaner
{
    private int laaner_id;
    private String navn;
    private String adresse;
    private int postnummer;
    private String by;

    public Laaner(int laaner_id, String navn, String adresse, int postnummer, String by)
    {
        this.laaner_id = laaner_id;
        this.navn = navn;
        this.adresse = adresse;
        this.postnummer = postnummer;
        this.by = by;
    }

    public Laaner(String navn, String adresse, int postnummer, String by)
    {
        this.navn = navn;
        this.adresse = adresse;
        this.postnummer = postnummer;
        this.by = by;
    }

    public int getLaaner_id()
    {
        return laaner_id;
    }

    public void setLaaner_id(int laaner_id)
    {
        this.laaner_id = laaner_id;
    }

    public String getNavn()
    {
        return navn;
    }

    public void setNavn(String navn)
    {
        this.navn = navn;
    }

    public String getAdresse()
    {
        return adresse;
    }

    public void setAdresse(String adresse)
    {
        this.adresse = adresse;
    }

    public int getPostnummer()
    {
        return postnummer;
    }

    public void setPostnummer(int postnummer)
    {
        this.postnummer = postnummer;
    }

    @Override
    public String toString()
    {
        return "Laaner{" +
                "laaner_id=" + laaner_id +
                ", navn='" + navn + '\'' +
                ", adresse='" + adresse + '\'' +
                ", postnummer=" + postnummer +
                ", by='" + by + '\'' +
                '}';
    }

    public String getBy()
    {
        return by;
    }

    public void setBy(String by)
    {
        this.by = by;
    }
}
