package progetto;

import java.util.ArrayList;

public class Domanda {

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

    public String getCodice()
    {
        return codice;
    }

    public String getTesto() 
    {
        return testo;
    }
    /**
    * Metodo che controlla se una stringa è uguale al codice della Domanda
    * @param codice: String
    */    
    public boolean controllo(String codice)
    {
        return this.codice.equals(codice);
    }

    public void addScelta(Scelta s)
    {
        scelte.add(s);
    }

    public void addScelte(ArrayList<Scelta> s)
    {
        scelte.addAll(s);
    }

    public void addAdiacenza(Domanda d)
    {
        adiacenze.add(d);
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
    public String toString()
    {
        String string="DOMANDA: "+testo;
        string+="\nSCELTE: ";
        for(Scelta s:scelte)
        {
            string+="\n"+s.toString();
        }
        return string;
    }
}
