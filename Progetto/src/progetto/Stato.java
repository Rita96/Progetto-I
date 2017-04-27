package progetto;

import java.util.ArrayList;

public class Stato //testo + dimanda della domanda da porre
{
    private String codice;
    private String testo;
    private ArrayList<Stato> adiacenze;
    private ArrayList<Scelta> scelte;

    public Stato(String codice, String testo)
    {
        this.codice=codice;
        this.testo=testo;
        adiacenze=new ArrayList<>();
        scelte=new ArrayList<>();
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

    public ArrayList<Scelta> getScelte()
    {
        return scelte;
    }

    public ArrayList<Stato> getAdiacenze()
    {
        return adiacenze;
    }
    
    public Stato getProssimaAdiacenza(int n) {
        return adiacenze.get(n);
    }
    
    public String getCodice()
    {
        return codice;
    }
    
    public String getTesto()
    {
        return testo;
    }
    
    public String mostraScelta(int i)
    {
            return scelte.get(i).getTesto();
    }
}
