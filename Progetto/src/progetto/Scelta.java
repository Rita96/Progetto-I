package progetto;

/**
 * L'elemento Scelta prende i propri dati dal file ScelteOggetto[i].txt (dove i è l'indice dell'Oggetto) ed è strutturato così:
 * codice(identificatore univoco della scelta)
 * testo (testo della scelta)
 */
public class Scelta
{
    private String codice;
    private String testo;
    
    public Scelta(String codice, String testo)
    {
        this.codice=codice;
        this.testo=testo;
    }
    
    public String getCodice() {
        return codice;
    }
    
    public String getTesto()
    {
        return testo;
    }
    
    /**
    * Metodo che controlla se una stringa è uguale al codice della scelta:
    * se è uguale, il metodo restituisce true, latrimenti false
    * @param codice: String
    * @return boolean
    */  
    public boolean controllo(String codice)
    {
        return this.codice.equals(codice);
    }
}
