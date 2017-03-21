package progetto;

import java.util.ArrayList;

public class Progetto 
{
    
    private Oggetto oggetto;
    private ArrayList<Scelta> scelte;
    private ArrayList<Domanda> domande;

    public Progetto(Oggetto o)
    {
        oggetto=o;
        domande=new ArrayList<>();
        scelte=new ArrayList<>();
    }
    
    public void letture()
    {
        
        LetturaScelte sc=new LetturaScelte(oggetto.getFileScelte());
        scelte=sc.lettura();

        LetturaDomande dm=new LetturaDomande(oggetto.getFileDomande());
        domande=dm.lettura(scelte);

        LetturaAdiacenze ad=new LetturaAdiacenze(oggetto.getFileAdiacenze());
        ad.lettura(domande);

        oggetto.addDomande(domande);
    }
    
    public Oggetto getOggetto()
    {
        return oggetto;
    }
    
    @Override
    public String toString() {
        
        String string=null;
        
        System.out.println("OGGETTO: "+oggetto.getNome()+" "+oggetto.getAttributo());
        System.out.println();
        for(Domanda d:oggetto.getDomande())
        {
            System.out.println("DOMANDA: "+d.getCodD()+" "+d.getTestoD());
            for(Scelta s:d.getScelteD())
            {
                System.out.println("SCELTA: "+s.getCodS()+" "+s.getTestoS());
            }
            for(Domanda adiacenza:d.getAdiacenzeD())
            {
                System.out.println("ADIACENZA: "+adiacenza.getCodD());
            }
            System.out.println();
        }
        return string;
    }
    
}
