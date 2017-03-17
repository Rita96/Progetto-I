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

    @Override
    public String toString() {
        return testoD;
    }
    
    public boolean controllo(String cod)
    {
        if(cod==codD)
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
}
