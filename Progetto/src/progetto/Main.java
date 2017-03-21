package progetto;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) 
    {
        ArrayList<Scelta> scelte=new ArrayList<>();
        ArrayList<Domanda> domande=new ArrayList<>();
        
        LetturaOggetti lo=new LetturaOggetti();
        ArrayList<Oggetto> oggetti=new ArrayList<>();
        
        oggetti=lo.lettura();
        Oggetto oggetto=oggetti.get(0);
        
        LetturaScelte sc=new LetturaScelte(oggetto.getFileScelte());
        scelte=sc.lettura();

        LetturaDomande dm=new LetturaDomande(oggetto.getFileDomande());
        domande=dm.lettura(scelte);

        LetturaAdiacenze ad=new LetturaAdiacenze(oggetto.getFileAdiacenze());
        ad.lettura(domande);

        oggetto.addDomande(domande);
        
        Progetto p = new Progetto(oggetto,domande,scelte);
        p.toString();  
    }
}
