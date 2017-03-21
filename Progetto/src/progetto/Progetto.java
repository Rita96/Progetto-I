package progetto;

import java.util.ArrayList;

public class Progetto 
{
    private Oggetto oggetto;

    public Progetto(Oggetto o)
    {
        oggetto=o;
    }

    public Oggetto getOggetto()
    {
        return oggetto;
    }

    @Override
    public String toString()
    {
        String string=null;
        int i=0;
        System.out.println("OGGETTO: "+oggetto.getNome()+" "+oggetto.getAttributo());
        System.out.println();
        for(Domanda d:oggetto.getDomande())
        {
            System.out.println("DOMANDA "+(i+1)+": "+d.getCodD()+" "+d.getTestoD());
            for(Scelta s:d.getScelteD())
            {
                System.out.println("SCELTA: "+s.getCodS()+" "+s.getTestoS());
            }
            for(Domanda adiacenza:d.getAdiacenzeD())
            {
                System.out.println("ADIACENZA: "+adiacenza.getCodD());
            }
            System.out.println();
            i++;
        }
        return string;
    }
    
}
