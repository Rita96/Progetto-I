package progetto;

import java.util.ArrayList;

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
    
    public String getCodiceStato()
    {
        return stato.getCodice();
    }
    
    public String mostraStato()
    {
        return stato.mostra();
    }
    
    public Scelta getScelta()
    {
        return scelta;
    }
    
    public String getCodiceScelta()
    {
        return scelta.getCodice();
    }
    
    public String mostraScelta()
    {
        return scelta.mostra();
    }
    
    public void setScelta(Scelta scelta)
    {
        this.scelta = scelta;
    }
    
    public int scelteStatoSize()
    {
        return stato.scelteSize();
    }
    
    public ArrayList<Scelta> getScelteStato()
    {
        return stato.getScelte();
    }
    
    public String mostraSceltaStato(int i)
    {
        return stato.mostraScelta(i);
    }
    
    @Override
    public String toString()
    {
        return stato.mostra();
    }
}
