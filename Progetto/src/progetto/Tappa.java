package progetto;

public class Tappa
{   //gli oggetti di tipo risposta tengono in memoria la risposta (selezione) data ad una determinata domanda da parte dell'utente
    //nella classe progetto infatti c'è un attributo che tiene in memoria l'intero percorso
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
    
    public Scelta getScelta(){
        return scelta;
    }

    public void setScelta(Scelta scelta){
        this.scelta=scelta;
    }
}
