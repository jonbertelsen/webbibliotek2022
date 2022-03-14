package dat.bibliotek.entities;

import java.time.LocalDate;

public class Udlaan
{
    private int bog_id;
    private int laaner_id;
    private LocalDate dato;

    public Udlaan(int bog_id, int laaner_id, LocalDate dato)
    {
        this.bog_id = bog_id;
        this.laaner_id = laaner_id;
        this.dato = dato;
    }

    public int getBog_id()
    {
        return bog_id;
    }

    public void setBog_id(int bog_id)
    {
        this.bog_id = bog_id;
    }

    public int getLaaner_id()
    {
        return laaner_id;
    }

    public void setLaaner_id(int laaner_id)
    {
        this.laaner_id = laaner_id;
    }

    public LocalDate getDato()
    {
        return dato;
    }

    public void setDato(LocalDate dato)
    {
        this.dato = dato;
    }

    @Override
    public String toString()
    {
        return "Udlaan{" +
                "bog_id=" + bog_id +
                ", laaner_id=" + laaner_id +
                ", dato=" + dato +
                '}';
    }
}
