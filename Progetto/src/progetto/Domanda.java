package progetto;

import java.util.ArrayList;

public class Domanda {

    private String codD;
    private String testoD;
    private ArrayList<Domanda> adiacenzeD;
    private ArrayList<Scelta> scelteD;

    public Domanda(String id, String text) {
        this.codD = id;
        this.testoD = text;
        adiacenzeD=new ArrayList<>();
        scelteD=new ArrayList<>();
    }

    public String getCodD() {
        return codD;
    }

    public String getTestoD() {
        return testoD;
    }
    
    public boolean controllo(String cod)
    {
        if(cod.equals(codD))
            return true;
        else
            return false;
    }
    
    public void addScelta(Scelta s)
    {
        scelteD.add(s);
    }
    
    public void addAdiacenza(Domanda d)
    {
        adiacenzeD.add(d);
    }
    
    public ArrayList<Scelta> getScelteD()
    {
        return scelteD;
    }
}
