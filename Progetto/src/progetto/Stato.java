package progetto;

import java.util.ArrayList;

/**
 * Stato legge dati dal file DomandeOggetto[i].txt (i = indice dell'Oggetto)
 * ed è strutturato così:
 * - codice(identificatore univoco dello stato)
 * - testo (testo della domanda o della possibile soluzione)
 * - adiacenze (stati successivi a cui si passa dopo aver effettuato una scelta)
 * - scelte (possibili risposte ad un quesito)
 */

public class Stato
{
    private String codice;
    private String testo;
    private ArrayList<Stato> adiacenze;
    private ArrayList<Scelta> scelte;
    
    public Stato(String codice, String testo)
    {
        this.codice = codice;
        this.testo = testo;
        this.adiacenze = new ArrayList<>();
        this.scelte = new ArrayList<>();
    }
    
    public String getCodice()
    {
        return codice;
    }
    
    public String mostra()
    {
        return testo;
    }
    
    public ArrayList<Stato> getAdiacenze()
    {
        return adiacenze;
    }
    
    public ArrayList<Scelta> getScelte()
    {
        return scelte;
    }
    
    public Scelta getScelta(int n)
    {
        return scelte.get(n);
    }
    
    public Stato getAdiacenza(int n)
    {
        return adiacenze.get(n);
    }
    
    /**
    * Metodo che controlla se una stringa è uguale al codice della domanda:
    * se è uguale, il metodo restituisce true, altrimenti false
    * @param codice: String
    * @return boolean
    */
    public boolean controllo(String codice)
    {
        return this.codice.equals(codice);
    }
    
    public void addScelta(Scelta s)
    {
        scelte.add(s);
    }
    
    public void addAdiacenze(ArrayList<Stato> d)
    {
        adiacenze.addAll(d);
    }
    
    public String mostraScelta(int i)
    {
        return scelte.get(i).mostra();
    }
    
    public int scelteSize()
    {
        return scelte.size();
    }
    
    public int adiacenzeSize()
    {
        return adiacenze.size();
    }
    
    public boolean scelteEmpty()
    {
        return scelte.isEmpty();
    }
    
    public boolean adiacenzeEmpty()
    {
        return adiacenze.isEmpty();
    }
    
}
