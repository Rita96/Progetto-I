package elementi;

/**
 * In Scelta carico i dati dal file "ScelteOggetto.txt"
 * ed Ã¨ strutturato cosÃ¬:
 * - codice(identificatore univoco della scelta)
 * - testo (testo della scelta)
 * 
 * @author Gabriele Guazzardi, Francesco Giudice
 */
public class Scelta
{
    private String codice;
    private String testo;
    
    public Scelta(String codice, String testo)
    {
        this.codice = codice;
        this.testo = testo;
    }
    
    public String getCodice()
    {
        return codice;
    }
    
    public String mostra()
    {
        return testo;
    }
    
    /**
    * Metodo che controlla se una stringa è uguale al codice della scelta:
    * se è uguale, il metodo restituisce true, altrimenti false
    * @param codice: String
    * @return boolean
    */
    public boolean controllo(String codice)
    {
        return this.codice.equals(codice);
    }
}
