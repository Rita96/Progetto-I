package elementi;

import java.util.ArrayList;

/**
 * La classe Tappa tiene traccia del percorso (stato  + scelta) che fa l'utente
 * mentre esegue il programma.
 * 
 * scelta = risposta data dall'utente alla domanda.
 * stato = domanda fatta all'utente.
 * 
 * @author Gabriele Guazzardi, Francesco Giudice, Daniele Tavazzi, Andrea Pompa
 */
public class Tappa
{   
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
