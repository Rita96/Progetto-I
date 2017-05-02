package progetto;

public class Tappa
{   
    /* scelta tiene traccia della risposta data ad una domanda da parte dell'utente.
       Nella classe Progetto un attributo tiene in memoria dell'intero percorso.
    */
    private Stato stato;
    private Scelta scelta;
    
    public Tappa(Stato stato, Scelta scelta)
    {
        this.stato = stato;
        this.scelta = scelta;
    }
    
    public Stato getStato()
    {
        return stato;
    }
    
    public Scelta getScelta()
    {
        return scelta;
    }
    
    public void setScelta(Scelta scelta)
    {
        this.scelta = scelta;
    }
}
