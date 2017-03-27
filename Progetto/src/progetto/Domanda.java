package progetto;

import java.util.ArrayList;

public class Domanda
{
    private String codice;
    private String testo;
    private ArrayList<Domanda> adiacenze;
    private ArrayList<Scelta> scelte;

    public Domanda(String codice, String testo)
    {
        this.codice=codice;
        this.testo=testo;
        adiacenze=new ArrayList<>();
        scelte=new ArrayList<>();
    }
    
    /**
    * Metodo che controlla se una stringa è uguale al codice della domanda:
    * se è uguale, il metodo restituisce true, latrimenti false
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

    public void addAdiacenze(ArrayList<Domanda> d)
    {
        adiacenze.addAll(d);
    }

    public ArrayList<Scelta> getScelte()
    {
        return scelte;
    }

    public ArrayList<Domanda> getAdiacenze()
    {
        return adiacenze;
    }

    @Override
    public String toString() {
        String stringa = testo;
        for(Scelta s:scelte)
        {
            stringa+="\n"+s.toString();
        }
        return stringa;
    }
}
