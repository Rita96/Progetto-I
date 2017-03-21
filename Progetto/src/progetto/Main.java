package progetto;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) 
    {
        LetturaOggetti lo=new LetturaOggetti();
        ArrayList<Oggetto> oggetti=new ArrayList<>();
        ArrayList<Scelta> scelte=new ArrayList<>();
        ArrayList<Domanda> domande=new ArrayList<>();
        oggetti=lo.lettura();
        
        LetturaScelte sc=new LetturaScelte(oggetti.get(0).getFileScelte());
        scelte=sc.lettura();
        
        LetturaDomande dm=new LetturaDomande(oggetti.get(0).getFileDomande());
        domande=dm.lettura(scelte);
        
        LetturaAdiacenze ad=new LetturaAdiacenze(oggetti.get(0).getFileAdiacenze());
        ad.lettura(domande);
        
        for(Domanda d:domande)
        {
            for(Scelta s: scelte)
            {
                if(d.getCodD().equals(s.getCodS()))
                {
                    d.addScelta(s);
                }
            }
        }
        
        oggetti.get(0).addDomande(domande);
        
        for(Oggetto o:oggetti)
        {
            System.out.println("OGGETTO: "+o.getNome()+" "+o.getAttributo());
            for(Domanda d:o.getDomande())
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
        }
        
    }
}
