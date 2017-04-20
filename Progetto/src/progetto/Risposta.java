package progetto;

public class Risposta
{   //gli oggetti di tipo risposta tengono in memoria la risposta (selezione) data ad una determinata domanda da parte dell'utente
    //nella classe progetto infatti c'è un attributo che tiene in memoria l'intero percorso
    private Domanda domanda;
    private Scelta scelta;

    public Risposta(Domanda domanda, Scelta scelta)
    {
        this.domanda = domanda;
        this.scelta = scelta;
    }
    
    public Domanda getDomanda()
    {
        return domanda;
    }
    
    public Scelta getScelta(){
        return scelta;
    }

    public void setPreferenza(Scelta scelta){
        this.scelta=scelta;
    }
}
